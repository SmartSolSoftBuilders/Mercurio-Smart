/*
 * PagosController.java
 *
 * Created on 28 de marzo de 2010, 05:54 PM
 *
 */
package mx.com.seguros.business.pagos.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mx.com.seguros.business.descuentos.DescuentosBusiness;
import mx.com.seguros.business.pagos.CuentaClienteBusiness;
import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.business.pagos.TransaccionCuentaClienteBusiness;
import mx.com.seguros.business.pagos.exception.ArchivoAntesCargadoException;
import mx.com.seguros.business.pagos.exception.PagosBusinessException;
import mx.com.seguros.business.pagos.exception.SaldoNegativoException;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.data.dao.ArchivosAplicacionPagosDao;
import mx.com.seguros.data.dao.CuentaClienteDao;
import mx.com.seguros.data.dao.EstatusPolizaPagosDao;
import mx.com.seguros.data.dao.EstatusPolizaSeguimientoDao;
import mx.com.seguros.data.dao.IContratanteDao;
import mx.com.seguros.data.dao.IDescuetosAplicadosDao;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.data.dao.TarifaAportMensualDao;
import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.model.ArchivosAplicacionCargados;
import mx.com.seguros.model.CifrasControlProcesoAutofinanciar;
import mx.com.seguros.model.Contratante;
import mx.com.seguros.model.CuentaCliente;
import mx.com.seguros.model.DescuentosAplicados;
import mx.com.seguros.model.EstatusPolizaPagos;
import mx.com.seguros.model.EstatusPolizaSeguimiento;
import mx.com.seguros.model.PagoRetenedor;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TipoTransaccionCuentaCliente;
import mx.com.seguros.model.TransaccionCuentaCliente;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.utils.DateUtils;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.utils.GeneraXLS;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *
 * @author Cesar Garcia Mauricio
 */
public class PagosBusinessImpl implements PagosBusiness {

	private static final org.apache.log4j.Logger LOG  = org.apache.log4j.Logger.getLogger(PagosBusinessImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void readPayFile(final ArrayList<List<String>> datosArchivo)
            throws PagosBusinessException {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            if (descuentoBusiness.validaArchivo(datosArchivo)) {
                boolean isFileHeader = true;
                for (List<String> datosArchivoFilaList : datosArchivo) {
                    LOG.info("datosArchivoFilaList: " + datosArchivoFilaList);
                    if (datosArchivoFilaList.size() > 1 && !isFileHeader) {
                        registrarPagoCliente(datosArchivoFilaList);
                    } else {
                        identificadorArchivo = Integer.parseInt(datosArchivoFilaList.get(0));
                    }
                    isFileHeader = false;
                }
                generarArchivoRechazos();
            } else {
                throw new ArchivoAntesCargadoException(descuentoBusiness.getError());
            }
            transactionManager.commit(status);
        } catch (ArchivoAntesCargadoException aace) {
            transactionManager.rollback(status);
            throw aace;
        } catch (PagosBusinessException pbe) {
            // This exit is normal, and is just for show in cases that there
            // exist rejected registers in retenedor's payments file
            transactionManager.commit(status);
            // logPolizasAnomalas();
            throw pbe;
        } catch (Exception e) {
            LOG.error("P\u00F3liza an\u00F3mala: " + e.getMessage());
            if (e instanceof ArchivoAntesCargadoException) {
                throw (ArchivoAntesCargadoException) e;
            } else if (e instanceof PagosBusinessException) {
                throw (PagosBusinessException) e;
            } else {
                transactionManager.rollback(status);
                LOG.error(e.getMessage(), e);
            }
        }
    }

    // XXX Here and just here is where numNominaContratante, numQnaArchivo,
    // importeReportadoOriginal are initialized:
    private void registrarPagoCliente(List<String> datosArchivoFilaList) {
        numNominaContratante = (String) datosArchivoFilaList.get(
                NUM_NOMINA_CONTRATANTE).trim();
        String numQnaStr;
        numQnaStr = (String) datosArchivoFilaList.get(QUINCENA_ARCHIVO);
        numQnaArchivo = Integer.parseInt(numQnaStr);
        String importeReportadoStr;
        importeReportadoStr = (String) datosArchivoFilaList.get(IMPORTE_REPORTADO);
        importeReportadoOriginal = new BigDecimal(importeReportadoStr);
        fechaDepositoDep = (String) datosArchivoFilaList.get(FECHA_DEPOSITO_DEPENDENCIA);
        Contratante contratante;
        contratante = contratanteDao.recuperarContratantePorNumNomina(numNominaContratante);
        String motivoRechazoStr = null;
        // existe RFC en la base de datos?
        if (contratante == null) {
            // Inserta registro rechazado en archivoRechazos:
            motivoRechazoStr = RFC_CONTRATANTE_NO_ENCONTRADO;
            registrarRechazo(motivoRechazoStr);
            // lee siguiente registro del archivo XLS:
        } else {
            intentaRegistrarPagoCliente();
        }
    }

    private void intentaRegistrarPagoCliente() {
        Collection<Solicitud> solicitudColl;
        solicitudColl = solicitudDao.obtenSolicitudCollPorNumNominaContratante(
                numNominaContratante, DateUtils.parseFromQnaToDate(numQnaArchivo));
        // log.debug("Solicitudes pasadas: " + solicitudColl.toString());
        // Existen solicitudes en BD con el RFC del contratante?
        String motivoRechazoStr;
        if (solicitudColl == null || solicitudColl.isEmpty()) {
            // Inserta registro rechazado en archivoRechazos:
            motivoRechazoStr = NO_HAY_SOLICITUDES_CONTRATANTE;
            registrarRechazo(motivoRechazoStr);
        } else {
            registroPagoRecibido(validarRechazoSolicitud(solicitudColl));
        }
    }

    private Boolean validarRechazoSolicitud(Collection<Solicitud> solicitudColl) {
        Boolean realizarRechazo = Boolean.TRUE;
        String motivoRechazoStr = null;
        for (Solicitud solicitud : solicitudColl) {
            realizarRechazo = Boolean.TRUE;
            if (LOG.isTraceEnabled()) {
                LOG.trace("FolioSolicitud: " + solicitud.getFolioSolicitud()
                        + " IdEstatusSolicitud: " + solicitud.getIdEstatusSolicitud());
            }
            switch (solicitud.getIdEstatusSolicitud()) {
                case 1:
                    motivoRechazoStr = POLIZA_NO_CAPTURADA;
                    break;

                case 2:
                    realizarRechazo = Boolean.FALSE;
                    continue;

                case 3:
                    motivoRechazoStr = SOLICITUD_DECLINADA;
                    break;

                case 4:
                    motivoRechazoStr = SOLICITUD_RECHAZADA;
                    break;

                case 5:
                    motivoRechazoStr = REQUERIMIENTO_MEDICO;
                    break;

                default:
                    motivoRechazoStr = "Error de programacion: caso no contemplado";
                    break;
            }
            if (realizarRechazo) {
                registrarRechazo(motivoRechazoStr);
            }
        }
        return realizarRechazo;
    }

    private void registroPagoRecibido(Boolean rechazoRealizado) {
        Long transaccionId;
        transaccionId = registrarPagoRecibido();
        // Se registro el pago del cliente?
        if (transaccionId != null) {
            realizarPagoPolizas(rechazoRealizado);
        }
    }

    /**
     * Corresponde a hacer un deposito en la cuenta del cliente por el monto que
     * se ha reportado en el archivo enviado por el retenedor.
     *
     * @param importePagar
     *            es el monto del deposito.
     * @param {@link CuentaCliente} es la cuenta donde se realiza el deposito.
     * @return el Id de la transaccion si se ha realizado exitosamente el
     *         deposito en la cuenta del cliente, null en otro caso.
     */
    Long registrarPagoRecibido() {
        iniCuentaCliente();
        return transaccionCuentaClienteBusiness.realizarTransaccion(
                importeReportadoOriginal,
                TipoTransaccionCuentaCliente.CVE_TIPO_MOV_DEPOSITO,
                cuentaCliente).getTransaccionId();
    }

    /*
     * XXX Here and just here is where cuentaCliente is initialized: en caso
     * necesario, se creara una cuenta nueva para el cliente.
     */
    private void iniCuentaCliente() {
        cuentaCliente = cuentaClienteBusiness.findById(poliza.getNumPoliza(),poliza.getNumConsignatario());
        if (cuentaCliente == null) {
            // StringBuilder msg = new StringBuilder();
            // msg.append("Se crear\u00E1 una cuenta nueva para el cliente ");
            // msg.append("de RFC ");
            // msg.append(numNominaContratante);
            // log.debug(msg.toString());
            cuentaCliente = cuentaClienteBusiness.createCuentaCliente(poliza.getNumPoliza(),poliza.getNumConsignatario());
        }
    }

    private void realizarPagoPolizas(final Boolean rechazoRealizado) {
        // Seleccionar monto y poliza a pagar:
        List<PolizaIndividual> polizasVigentes;
        polizasVigentes = polizaBusiness.obtenerPolizasVigentesContratante(
                numNominaContratante, DateUtils.parseFromQnaToDate(numQnaArchivo));
        int numPolizasContratante;
        numPolizasContratante = (polizasVigentes == null) ? -1
                : polizasVigentes.size();
        // La lista de polizas vigentes del contratante tiene 1 o mas de 1
        // elementos?
        if (numPolizasContratante > 0) {
            // Este pago puede ser a 1 o a varias polizas.
            realizarPagoPolizasVigentes(polizasVigentes);
        } else if (!rechazoRealizado) {
            // Inserta registro rechazado en archivoRechazos:
            String motivoRechazo = CONTRATANTE_SIN_POLIZAS_EMITIDAS;
            registrarRechazo(motivoRechazo);
        }
    }

    private void realizarPagoPolizasVigentes(
            List<PolizaIndividual> polizasVigentes) {
        for (PolizaIndividual polizaIndividual : polizasVigentes) {
            // Seleccion de la poliza a pagar
            poliza = polizaIndividual;
            quincenaPago = getQuincenaPago();
            LOG.info("quincenaPago: " + quincenaPago);
            realizarPagoPolizaVigente();
        }
    }

    private void realizarPagoPolizaVigente() {
        verificarFechaPrimerIntentoPago();
        tarifaPolizaVigente = tarifaAportMensualDao.findTarifaPoliza(poliza.getFolioSolicitud());
        Integer idEstatusPagosPoliza = estatusPolizaPagosDao.obtenerEstatusPolizaPagosByPoliza(poliza);
        //idEstatusPagosPoliza = poliza.getIdEstatusPagosPoliza();
        LOG.info("numPoliza: " + poliza.getNumPoliza());
        LOG.info("numConsignatario: " + poliza.getNumConsignatario());
        LOG.info("idEstatusPagosPoliza: " + idEstatusPagosPoliza);
        Boolean isFirstPay;
        /*LOG.info("idEstatusPagosPoliza: "+EstatusPolizaPagos.SIN_PAGOS_APLICADOS.getIdEstatusPagosPoliza());
        isFirstPay = idEstatusPagosPoliza.equals(EstatusPolizaPagos.SIN_PAGOS_APLICADOS.getIdEstatusPagosPoliza());
        LOG.info("isFirstPay: "+isFirstPay);*/
        if (idEstatusPagosPoliza == 1 || idEstatusPagosPoliza == 10) {
            isFirstPay = true;
            LOG.info("isFirstPay2: " + isFirstPay);
        } else {
            isFirstPay = false;
            LOG.info("isFirstPay3: " + isFirstPay);
        }

        if (isFirstPay) {
            realizarPrimerPagoPoliza(idEstatusPagosPoliza);
        } else {
            realizarPagoSubsecuente();
        }
    }

    private void verificarFechaPrimerIntentoPago() {
        Integer qnaPrimerIntentoPago;
        qnaPrimerIntentoPago = polizaBusiness.recuperarQnaPrimerIntentoPago(poliza);
        if (qnaPrimerIntentoPago == null) {
            polizaBusiness.insertarFechaPrimerIntentoPago(poliza, numQnaArchivo);
        }
    }

    private void realizarPrimerPagoPoliza(Integer idEstatusPagosPoliza) {
        int saldoVsTarifa = cuentaCliente.getSaldoCuenta().compareTo(
                tarifaPolizaVigente);
        if (saldoVsTarifa < 0) {
            String descripcion;
            descripcion = "POLIZA CON ADEUDOS";
            cambiarEstatusPolizaPagos(descripcion);
            verificarCambioEstatus();
        } else {
            // TODO terminar de probar:
            if (idEstatusPagosPoliza == 10) {
                handlePolizaConAdeudos();
            } else {
                String descripcion;
                descripcion = "NORMAL";
                cambiarEstatusPolizaPagos(descripcion);
                verificarCambioEstatus();
                handlePolizaSinAdeudos();
            }

        }
    }

    private void realizarPagoSubsecuente() {
        realizarPagoPolizaParesQuincenas();
        String descripcionStatusPoliza;
        // En realizarPagoPolizaParesQuincenas() se inicializa y actualiza al
        // numAdeudos
        if (numAdeudos >= 5) {
            descripcionStatusPoliza = "CANCELADA POR PAGOS INSUFICIENTES";
        } else if (numAdeudos > 0) {
            descripcionStatusPoliza = "POLIZA CON ADEUDOS";
        } else {
            /*
             * esto para diferenciar del caso en que la poliza viene al
             * corriente con sus pagos (normal o regular).
             */
            descripcionStatusPoliza = "REHABILITADA";
        }
        cambiarEstatusPolizaPagos(descripcionStatusPoliza);
        verificarCambioEstatus();
    }

    private void verificarCambioEstatus() {
        // TODO Considerar eliminarlo...
    }

    private void realizarPagoPolizaParesQuincenas() {
        Integer numPrimerQnaPagada;
        numPrimerQnaPagada = quincenaPago;
        LOG.info("numPrimerQnaPagada: " + numPrimerQnaPagada);
        Integer numPagosRealizar;
        numPagosRealizar = calcularNumPagosRealizar(numPrimerQnaPagada);
        /*
         * Aqui se realiza el ciclo sobre pares de quincenas a fin de que al
         * final se tenga que numQnaArch = numQnaPagada, algo asi como un
         * procesamiento de quincenas no reportadas.
         */
        // numPago se refiere a pagos alternados a prima y a fondo
        interrumpirCicloPagoQnasAtrasadas = Boolean.FALSE;
        for (int numPago = 0; numPago < numPagosRealizar
                && !interrumpirCicloPagoQnasAtrasadas; numPago++) {
            quincenaPago = getQuincenaPago();
            realizarPagoQuincena();
        }
    }

    private void realizarPagoQuincena() {
        /*numAdeudos =*/ calcularNumAdeudosPoliza();
        // La poliza tiene adeudos?
        if (numAdeudos > 0) {
            handlePolizaConAdeudos();
        } else {
            handlePolizaSinAdeudos();
        }
    }

    private Integer calcularNumPagosRealizar(Integer numQnaPagada) {
        return DateUtils.calcularNumQnas(numQnaPagada, numQnaArchivo);
    }

    /**
     *
     * @return
     */
    Integer calcularNumAdeudosPoliza() {
        int numPagosAplicados;
        numPagosAplicados = descuentosAplicadosDao.obtenerNumeroPagosAplicadosPoliza(poliza);
        Integer numQnasPoliza = calcularAntiguedadPoliza();
        /*startCGB*/
        Integer numPagosPrimaRequeridos;
        if (numQnasPoliza == 1) {
            numPagosPrimaRequeridos = 1;
        } else {
            numPagosPrimaRequeridos = numQnasPoliza / 2;
        }
        /* finCGB*/
        Integer numQnasSinPago = numPagosPrimaRequeridos - numPagosAplicados;
        /*Integer*/ numAdeudos = numQnasSinPago;
        Integer qnaArchivo;
        qnaArchivo = Integer.valueOf(identificadorArchivo.toString().substring(
                0, 6));
        if (!tocaPagarFondo(qnaArchivo)) {
            numAdeudos += 1;
        }
        return numAdeudos;
    }

    /**
     * XXX - Validar con Cesar: La fecha de inicio de vigencia de la poliza no
     * se toma como la asi nombrada en la tabla de PolizaIndividual, sino como
     * la fecha asociada al primer descuento aplicado a la poliza.
     *
     * @return El numero de quincenas contadas desde el primer deposito a prima
     *         de la poliza hasta la fecha indicada en el archivo del retenedor
     *         para ese deposito.
     */
    private Integer calcularAntiguedadPoliza() {
        // numQnaDoc = aaaaqq (fechaArchivoRetenedor)
        // numQnaIni = a'a'a'a'q'q' (fechaPrimerPago)
        // TODO terminar de Implementar y probar este metodo
        Integer fechaPrimerPagoInt;
        Integer fechaArchivoRetenedorInt;

        fechaPrimerPagoInt = descuentoBusiness.findFechaPrimerPagoInt(poliza);
        fechaArchivoRetenedorInt = numQnaArchivo;

        Integer antiguedadPoliza;
        antiguedadPoliza = DateUtils.calcularNumQnas(fechaPrimerPagoInt,
                fechaArchivoRetenedorInt);

        return antiguedadPoliza;
    }

    private void handlePolizaSinAdeudos() {
        BigDecimal importePagoPrima;
        BigDecimal importeFondoAhorro;
        // La poliza tiene al menos un pago aplicado?
        int numPagosAplicados;
        numPagosAplicados = descuentosAplicadosDao.obtenDescuentosPorPoliza(
                poliza).size();
        if (numPagosAplicados > 0) {
            if (tocaPagarFondo(quincenaPago)) {
                importePagoPrima = BigDecimal.ZERO;
                if (numQnaArchivo.equals(/* getQ */quincenaPago)) {
                    importeFondoAhorro = tarifaPolizaVigente;
                } else {
                    importeFondoAhorro = BigDecimal.ZERO;
                }
            } else {
                importePagoPrima = tarifaPolizaVigente;
                importeFondoAhorro = BigDecimal.ZERO;
            }
        } else {
            importePagoPrima = tarifaPolizaVigente;
            importeFondoAhorro = BigDecimal.ZERO;
        }
        realizarPago(importePagoPrima, importeFondoAhorro);
        return;
    }

    private void realizarPago(BigDecimal importePagoPrima,
            BigDecimal importeFondoAhorro) {
        Long transaccionId;
        try {
            if (importeFondoAhorro.equals(BigDecimal.ZERO)) {
                transaccionId = registrarDisposicionPrima(cuentaCliente,
                        importePagoPrima);
            } else {
                transaccionId = registrarDisposicionPrima(cuentaCliente,
                        importeFondoAhorro);
            }
            registrarPagoAplicado(importePagoPrima, importeFondoAhorro,
                    transaccionId);
        } catch (SaldoNegativoException e) {
            if (tocaPagarFondo(quincenaPago)) {
                // Realiza Descuento En Ceros;
                importeFondoAhorro = BigDecimal.ZERO;
                importePagoPrima = BigDecimal.ZERO;
                registrarPagoAplicado(importePagoPrima, importeFondoAhorro,
                        null);
            } else {
                transaccionId = null;
                BigDecimal montoTotalFondoAhorro;
                montoTotalFondoAhorro = descuentosAplicadosDao.obtenerMontoTotalFondoAhorro(poliza);
                intentaAutofinanciarPago(montoTotalFondoAhorro);
            }
        }
    }

    /**
     * Corresponde a hacer un retiro (disposicion) de la cuenta del cliente por
     * el monto indicado.
     * <p>
     * El importe de la disposicion debe pasarse como el valor absoluto de la
     * misma (i. e., como el importe a pagar): el manejo del signo negativo se
     * realiza programaticamente.
     *
     * @param cuentaCliente
     * @param importeDisposicion
     * @return el id de la transaccion realizado si esta fue exitosa, null en
     *         caso contrario.
     */
    Long registrarDisposicionPrima(CuentaCliente cuentaCliente,
            BigDecimal importeDisposicion) {
        /*
         * Esta es la actualizacion de la cuenta del cliente (saldo) por el pago
         * aplicado anteriormente.
         */
        BigDecimal montoDispuesto = importeDisposicion.multiply(MENOS_UNO);
        return transaccionCuentaClienteBusiness.realizarTransaccion(
                montoDispuesto,
                TipoTransaccionCuentaCliente.CVE_TIPO_MOV_DISPOSICION,
                cuentaCliente).getTransaccionId();
    }

    private void registrarPagoAplicado(BigDecimal importePagoPrima,
            BigDecimal importeFondoAhorro, Long transaccionId) {
        DescuentosAplicados descuento;
        descuento = new DescuentosAplicados();
        descuento.setFechaCalculo(new Date());
        descuento.setIdentificadorArchivo(identificadorArchivo);
        // descuento.setImpDescReportado(importeReportado.doubleValue());
        // TODO - To Analize if this change is correct...
        descuento.setImpDescReportado(importeReportadoOriginal.doubleValue());
        descuento.setImpRealAhorro(importeFondoAhorro.doubleValue());
        descuento.setImpRealPagoPrima(importePagoPrima.doubleValue());
        /*
         * Esta pasando el id de la ultima transaccion aplicada, pero presupone
         * que hubo transaccion (i. e. que fue exitosa) y que el id que debe
         * pasarse es el de la disposicion, en caso contario simplemente pasa
         * null, lo cual si esta permitido:
         */
        descuento.setTransaccionId(transaccionId);
        descuento.setNumConsignatario(poliza.getNumConsignatario());
        descuento.setNumPoliza(poliza.getNumPoliza());
        descuento.setNumQuincenaArchivo(numQnaArchivo);
        descuento.setNumQuincenaPagada(/* getQ */quincenaPago);

        Date fechaDepositoDepDate;

        try {
            fechaDepositoDep = fechaDepositoDep.replace(' ', '-');
            fechaDepositoDep = fechaDepositoDep.replace('/', '-');
            SimpleDateFormat dateFormat;
            dateFormat = new SimpleDateFormat("dd-MM-yy");
            // El formato valido de fecha es dd-MM-aaaa
            fechaDepositoDepDate = dateFormat.parse(fechaDepositoDep);
        } catch (ParseException e) {
            fechaDepositoDepDate = null;
            // e.printStackTrace();
        }
        descuento.setFechaDepositoDep(fechaDepositoDepDate);
        // descuento.setFechaDepositoDep(new Date(fechaDepositoDep));
        if (!tocaPagarFondo(quincenaPago)) {
            // Calcula el numero de pago a prima que corresponde:
            Integer fechaPrimerPagoInt;
            fechaPrimerPagoInt = descuentoBusiness.findFechaPrimerPagoInt(poliza);
            // polizaBusiness.recuperarQnaPrimerIntentoPago(poliza);
            Integer numQnas;
            numQnas = DateUtils.calcularNumQnas(fechaPrimerPagoInt,
                    quincenaPago);
            Integer numPagoPrima;
            numPagoPrima = (numQnas + 1) / 2;

            Date fechaInicioVigencia;
            Date fechaInicioCobertura;
            Date fechaFinCobertura;

            fechaInicioVigencia = poliza.getFechaInicioVigencia();
            // fechaIniCobertura = fechaInicioVigencia + (numPago ï¿½ 1) * (1
            // mes)
            fechaInicioCobertura = new DateTime(fechaInicioVigencia).plusMonths(numPagoPrima - 1).toDate();
            fechaFinCobertura = new DateTime(fechaInicioCobertura).plusMonths(1).toDate();
            descuento.setFechaInicioCobertura(fechaInicioCobertura);
            descuento.setFechaFinalCobertura(fechaFinCobertura);
        }
        descuento.setSaldoCuenta(cuentaCliente.getSaldoCuenta());
        descuentoBusiness.insertarDescuentoAplicado(descuento);
    }

    private Integer getQuincenaPago() {
        Integer numQuincenaPago = null;
        Integer numUltimaQuincenaPagada;
        LOG.info("numPoliza: " + poliza.getNumPoliza());
        LOG.info("numConsignatario: " + poliza.getNumConsignatario());
        LOG.info("folioSolicitud: " + poliza.getFolioSolicitud());
        numUltimaQuincenaPagada = descuentosAplicadosDao.obtenerUltimaQuincenaPagadaPoliza(poliza);
        LOG.info("numUltimaQuincenaPagada: " + numUltimaQuincenaPagada);
        if (numUltimaQuincenaPagada == null) {
            /*Integer estatusPagosPoliza;
            estatusPagosPoliza = poliza.getIdEstatusPagosPoliza();
            if (estatusPagosPoliza.equals(
            EstatusPolizaPagos.POLIZA_CON_ADEUDOS.getIdEstatusPagosPoliza())
            || estatusPagosPoliza.equals(
            EstatusPolizaPagos.CANCELADA_PAGOS_INSUFICIENTES.getIdEstatusPagosPoliza())) {
            if (!polizaSinPagosAdeudo.contains(poliza)) {
            polizaSinPagosAdeudo.add(poliza);
            polizaSinPagosAdeudoNueva.add(poliza);
            }*/

            numQuincenaPago = polizaBusiness.recuperarQnaPrimerIntentoPago(poliza);
            if (numQuincenaPago == null) {
                numQuincenaPago = numQnaArchivo;
            }
        } else {
            if (numUltimaQuincenaPagada.toString().endsWith("24")) {
                /*
                 * El 77 es necesario para cambios de anio, debido a que 100 -
                 * 24 = 76, pero los meses los estamos contando desde 1 y no
                 * desde cero, por ello es 77.
                 */
                numQuincenaPago = numUltimaQuincenaPagada + 77;
            } else {
                numQuincenaPago = numUltimaQuincenaPagada + 1;
            }
        }
        return numQuincenaPago;
    }

    private void cambiarEstatusPolizaPagos(String descripcionStatusPoliza) {
        EstatusPolizaPagos estatusPolizaPagosNew;
        estatusPolizaPagosNew = estatusPolizaPagosDao.obtenerEstatusPolizaPagosByDescripcion(descripcionStatusPoliza);




        int statusNuevoId = estatusPolizaPagosNew.getIdEstatusPagosPoliza();
        poliza.setEstatusPolizaPagos(estatusPolizaPagosNew);
        polizaBusiness.actualizaEstatusPolizaPago(poliza.getNumPoliza(), poliza.getNumConsignatario(),
                statusNuevoId);




    }

    private void handlePolizaConAdeudos() {
        BigDecimal importePagoPrima;
        Integer numQuincenaPago;
        //numQuincenaPago = this.getQuincenaPago();
        // CGB;
        if (tocaPagarFondo(quincenaPago)) {
            // Realiza Descuento En Ceros;
            importePagoPrima = BigDecimal.ZERO;
        } else {
            importePagoPrima = tarifaPolizaVigente;
        }
        BigDecimal importeFondoAhorro = BigDecimal.ZERO;
        realizarPago(importePagoPrima, importeFondoAhorro);
    }

    private Boolean tocaPagarFondo(Integer qnaPagoActual) {
        // Toca pago a fondo si la paridad de la primer quincena es la misma que
        // la de la quincena de pago.
        // Integer qnaPagoActual = quincenaPago;
        Integer qnaPagoPrimer;
        qnaPagoPrimer = descuentoBusiness.findFechaPrimerPagoInt(poliza);
        Boolean tocaPagarFondo;
        tocaPagarFondo = (qnaPagoActual + qnaPagoPrimer) % 2 == 1;
        return tocaPagarFondo;
    }

    private void intentaAutofinanciarPago(
            BigDecimal montoTotalFondoAhorro) {
        BigDecimal importeAutofinanciamiento;
        importeAutofinanciamiento = tarifaPolizaVigente;
        // el importe total del fondo de ahorro permite
        // autofinanciar la poliza?
        if (montoTotalFondoAhorro.compareTo(importeAutofinanciamiento) >= 0) {
            autofinanciarPago(importeAutofinanciamiento);
        } else {
            autofinanciamientoFallido();
        }
    }

    private void autofinanciamientoFallido() {
        // La poliza tiene 5 o mas adeudos?
        if (numAdeudos.intValue() >= 5) {
            cancelarPoliza();
        }
        interrumpirCicloPagoQnasAtrasadas = Boolean.TRUE;
    }

    void cancelarPoliza() {
        // Cambio de statusPolizaSeguimiento a
        // 'Cancelada Definitivamente':
        String descripcionEstatusPolizaSeguimiento;
        descripcionEstatusPolizaSeguimiento = "CANCELADA DEFINITIVAMENTE";
        EstatusPolizaSeguimiento estatusPolizaSeguimiento;
        estatusPolizaSeguimiento = estatusPolizaSeguimientoDao.findByDescripcion(descripcionEstatusPolizaSeguimiento);
        poliza.setEstatusPolizaSeguimiento(estatusPolizaSeguimiento);
        int idEstatusPolizaSeguimiento;
        idEstatusPolizaSeguimiento = estatusPolizaSeguimiento.getIdEstatusPolizaSeguimiento();
        poliza.setIdEstatusPolizaSeguimiento(idEstatusPolizaSeguimiento);
        // log.warn("SE REALIZAR\u00C1 UNA CANCELACION POR PAGOS INSUFICIENTES");
        interrumpirCicloPagoQnasAtrasadas = Boolean.TRUE;
    }

    private void autofinanciarPago(BigDecimal importeAutofinanciamiento) {
        BigDecimal importePagoPrima;
        BigDecimal importeFondoAhorro;

        if (tocaPagarFondo(quincenaPago)) {
            importePagoPrima = BigDecimal.ZERO;
            importeFondoAhorro = BigDecimal.ZERO;
       } else {
            importePagoPrima = importeAutofinanciamiento;
            importeFondoAhorro = importeAutofinanciamiento.multiply(MENOS_UNO);
        }
        registrarPagoAplicado(importePagoPrima, importeFondoAhorro, null);
    }

    // TODO probar generacion del archivo de rechazos para los diversos casos de
    // rechazo: ...
    private void generarArchivoRechazos() {
        // listaRechazos.add(new ArrayList<String>());
        if (listaRechazos.size() > 0) {
            /*
             * El error se comunica a capa web en la forma de una exception.
             */
            StringBuilder sb = new StringBuilder();
            sb.append("Excepto por los rechazos indicados, la carga se ");
            sb.append("realiz\u00F3 exitosamente");
            // TODO - To Select error message
            // sb.append("Existe informaci\u00F3n que no se carg\u00F3 en ");
            // sb.append("la base de datos. Consulte el archivo ArchivoRechazos");
            // sb.append(identificadorArchivo);
            // TODO Preguntar si aun se requiere (Falta aniadir num
            // secuencial...)
            // sb
            // .append((((ArchivosDescuentosCargados) descuentosAplicadosDao
            // .obtenIndiceArchivo(numQnaArchivo))
            // .getConsecutivoArchivo() + 1));
            error = sb.toString();




            try {
                // se colocara el archivo de rechazos en carpeta reportes del
                // web ctx...
                // String realPath = "reportes";
                List<PagoRetenedor> pagoRetenedorList = new ArrayList<PagoRetenedor>();




                for (List<String> pagoRetenedorItem : listaRechazos) {
                    pagoRetenedorList.add(new PagoRetenedor(pagoRetenedorItem));




                }
                LOG.info("Numero de registros en archivo de pagos del retenedor rechazados: "
                        + pagoRetenedorList.size());
                // LOG.info("Registros Rechazados: " + pagoRetenedorList);




                new GeneraXLS().generaLibro(
                        (ArrayList<List<String>>) listaRechazos, "Rechazos",
                        "ArchivoRechazos" + identificadorArchivo,
                        GeneraXLS.ARCHIVO_RECHAZOS_DIR);
                listaRechazos.clear();




            } catch (Exception er) {
                LOG.error("Error en generaci\u00F3n de archivo de rechazos.", er);




            }
            throw new PagosBusinessException(error);




        }
    }

    private void registrarRechazo(String motivo) {
        if (LOG.isInfoEnabled()) {
            LOG.info(("Rechazo: " + motivo));




        }
        List<String> rechazo = new ArrayList<String>();
        rechazo.add(numNominaContratante);
        rechazo.add(numQnaArchivo.toString());
        // rechazo.add(importeReportado.toString());
        rechazo.add(importeReportadoOriginal.toString());
        rechazo.add(motivo);
        listaRechazos.add(rechazo);




    }

    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;




    }

    public void setContratanteDao(IContratanteDao contratanteDao) {
        this.contratanteDao = contratanteDao;




    }

    public void setSolicitudDao(ISolicitudDao solicitudDao) {
        this.solicitudDao = solicitudDao;




    }

    public void setEstatusPolizaPagosDao(
            EstatusPolizaPagosDao estatusPolizaPagosDao) {
        this.estatusPolizaPagosDao = estatusPolizaPagosDao;




    }

    public void setDescuentosAplicadosDao(
            IDescuetosAplicadosDao descuentosAplicadosDao) {
        this.descuentosAplicadosDao = descuentosAplicadosDao;




    }

    public void setDescuentoBusiness(DescuentosBusiness descuentoBusiness) {
        this.descuentoBusiness = descuentoBusiness;




    }

    public void setEstatusPolizaSeguimientoDao(
            EstatusPolizaSeguimientoDao estatusPolizaSeguimientoDao) {
        this.estatusPolizaSeguimientoDao = estatusPolizaSeguimientoDao;




    }

    public void setCuentaClienteBusiness(
            CuentaClienteBusiness cuentaClienteBusiness) {
        this.cuentaClienteBusiness = cuentaClienteBusiness;




    }

    public void setTarifaAportMensualDao(
            TarifaAportMensualDao tarifaAportMensualDao) {
        this.tarifaAportMensualDao = tarifaAportMensualDao;




    }

    public void setTransaccionCuentaClienteBusiness(
            TransaccionCuentaClienteBusiness transaccionCuentaClienteBusiness) {
        this.transaccionCuentaClienteBusiness = transaccionCuentaClienteBusiness;




    }

    public void setPolizaDao(IPolizaDao polizaDao) {
        this.polizaDao = polizaDao;




    }

    public void setTransactionManager(
            PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;




    }
    /**
     * Se ha relajado el acceso a fin de poder inicializar los campos en las
     * pruebas unitarias
     */
    CuentaCliente cuentaCliente;
    PolizaIndividual poliza;
    private Boolean interrumpirCicloPagoQnasAtrasadas;
    private String fechaDepositoDep;
    BigDecimal tarifaPolizaVigente;
    private String numNominaContratante;
    Integer numQnaArchivo;
    // BigDecimal importeReportado;
    IPolizaBusiness polizaBusiness;
    IContratanteDao contratanteDao;
    ISolicitudDao solicitudDao;
    ISolicitudBusiness solicitudBusiness;
   
	EstatusPolizaPagosDao estatusPolizaPagosDao;
    IDescuetosAplicadosDao descuentosAplicadosDao;
    private DescuentosBusiness descuentoBusiness;
    EstatusPolizaSeguimientoDao estatusPolizaSeguimientoDao;
    private CuentaClienteBusiness cuentaClienteBusiness;
    TarifaAportMensualDao tarifaAportMensualDao;
    TransaccionCuentaClienteBusiness transaccionCuentaClienteBusiness;
    IPolizaDao polizaDao;
    private Integer numAdeudos;
    Integer identificadorArchivo;
    private List<List<String>> listaRechazos = new ArrayList<List<String>>();
    private BigDecimal importeReportadoOriginal;
    private Integer quincenaPago;
    // private String qnaArchivo;
    // private static final SimpleDateFormat dateFormat;
    private static final int QUINCENA_ARCHIVO = 0;
    private static final int NUM_NOMINA_CONTRATANTE = 1;
    private static final int IMPORTE_REPORTADO = 2;
    private static final int FECHA_DEPOSITO_DEPENDENCIA = 3;
    private static final BigDecimal MENOS_UNO = BigDecimal.valueOf(-1L);
    // TODO pasar tambien la fecha al archivo de rechazados, o no...?
    private static final Set<PolizaIndividual> polizaSinPagosAdeudo;
    private static final Set<PolizaIndividual> polizaSinPagosAdeudoNueva;
    private static final String CONTRATANTE_SIN_POLIZAS_EMITIDAS;
    private static final String NO_HAY_SOLICITUDES_CONTRATANTE;
    private static final String POLIZA_NO_CAPTURADA;
    private static final String SOLICITUD_DECLINADA;
    private static final String SOLICITUD_RECHAZADA;
    private static final String REQUERIMIENTO_MEDICO;
    private static final String RFC_CONTRATANTE_NO_ENCONTRADO;
    private String error;
    private PlatformTransactionManager transactionManager;
    private ArchivosAplicacionPagosDao archivosAplicacionPagosDao;
    
    

	static {
// dateFormat = new SimpleDateFormat("dd-MM-yyyy");
// dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        polizaSinPagosAdeudo = new HashSet<PolizaIndividual>();
        polizaSinPagosAdeudoNueva = new HashSet<PolizaIndividual>();

        CONTRATANTE_SIN_POLIZAS_EMITIDAS = "Contratante sin polizas emitidas";
        NO_HAY_SOLICITUDES_CONTRATANTE = "No existen solicitudes registradas "
                + "para el contratante indicado";
        POLIZA_NO_CAPTURADA = "La poliza no ha sido capturada aun";
        SOLICITUD_DECLINADA = "Solicitud declinada por el cliente";
        SOLICITUD_RECHAZADA = "Solicitud rechazada por el area de seleccion";
        REQUERIMIENTO_MEDICO = "El prospecto requiere examen medico";
        RFC_CONTRATANTE_NO_ENCONTRADO = "RFC no encontrado";




    }

    // public static void main(String[] args) throws Exception {
    // BasicConfigurator.configure();
    // try {
    // PagosBusiness pagosBusiness = getPagosBusiness();
    // String path = "archivoPagosRetenedor.xls";
    // Resource resource = new ClassPathResource(path);
    // File file = resource.getFile();
    // String fileName = file.getAbsolutePath();
    // // log.debug("archivo analizado:" + fileName);
    // InputStream fileInputStream = new FileInputStream(fileName);
    // CargaArchivo cargaArchivo;
    // cargaArchivo = new CargaArchivo();
    // List<List<String>> datosArchivo;
    // datosArchivo = cargaArchivo
    // .cargaInformacionArchivo(fileInputStream);
    // pagosBusiness.readPayFile(datosArchivo);
    // } catch (Exception e) {
    // e.printStackTrace();
    //
    // }
        /*
    PagosBusiness pagosBusiness = getPagosBusiness();
    String path;
    path = "archivos de pagos";
    Resource resource = new ClassPathResource(path);
    File file = resource.getFile();
    if (file.exists() && file.isDirectory()) {
    File[] archPagosArry = file.listFiles();
    Arrays.sort(archPagosArry);
    for (File archPagos : archPagosArry) {
    String fileName = archPagos.getAbsolutePath();
    // LogUtils.getLogger(PagosBusinessImpl.class).info(
    // "archivo analizado " + fileName);
    InputStream fileInputStream;
    fileInputStream = new FileInputStream(fileName);
    CargaArchivo cargaArchivo;
    cargaArchivo = new CargaArchivo();
    List<List<String>> datosArchivo;
    datosArchivo = cargaArchivo.cargaInformacionArchivo(fileInputStream);
    try {
    pagosBusiness.readPayFile(datosArchivo);
    } catch (ArchivoAntesCargadoException aace) {
    } catch (PagosBusinessException pbe) {
    }
    }
    }
     * */
    // }
    private static PagosBusiness getPagosBusiness() {
        ApplicationContext context = iniAppCtx();

        PagosBusiness pagosBusiness;
        pagosBusiness = (PagosBusiness) context.getBean("pagosBusiness");





        return pagosBusiness;




    }

    private static ApplicationContext iniAppCtx() {
        ApplicationContext context;
        context = new ClassPathXmlApplicationContext(new String[]{
                    "applicationContext.xml", "/ibatis-map-dao.xml",
                    "moduloPagosContext.xml"});

        // String[] names = context.getBeanDefinitionNames();
        // Arrays.sort(names);
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < names.length; i++) {
        // sb.append(names[i]);
        // sb.append("\n");
        // }
        // log.trace(sb.toString());




        return context;






    }
    
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.business.pagos.PagosBusiness#cargarArchivoAplicacionPagos(java.util.List)
     */
	@Override
	public void cargarArchivoAplicacionPagos(List<List<String>> datosArchivo, byte[] contenidoArchivo, String usuario, String nombreArchivo) throws Exception {
		
		 StringBuffer log = new StringBuffer();
		 PolizaIndividual polizaActual = null;
		 DescuentosAplicados descuento = null;
		 DescuentosAplicados ultimoDescuentoConVigencia = null;
		 TransactionDefinition def = new DefaultTransactionDefinition();
	     TransactionStatus status = transactionManager.getTransaction(def);

	        try {
	            
	        	
	        	//insertar el registro del archivo cargado
	    		
	    		ArchivosAplicacionCargados nuevoArchivo = new ArchivosAplicacionCargados();
	    		nuevoArchivo.setFechaHoraInicio(new Date());
	    		nuevoArchivo.setFechaHoraFin(new Date());
	    		nuevoArchivo.setIdArchivosAplicacionCargados(0);
	    		int numQuincena = 0;
	    		long descuentosAplicados = 0;
	    		
	    		
	    		List<String> encabezado = null;
	    		if(datosArchivo != null && datosArchivo.size()>1){
	    			encabezado = datosArchivo.get(0);
	    			log.append("Inicio del proceso de carga de archivo de aplicación: "+ nuevoArchivo.getFechaHoraInicio()+"\n");
	    			//Leer la lista de valores y crear los DTO correspondientes
	    			for(int i=1; i < datosArchivo.size();i++){
	    				descuento = cargarDescuentoAplicado(datosArchivo.get(i));
	    				if(nuevoArchivo.getIdArchivosAplicacionCargados() == 0){
	    					//si es primera vuelta
	    					numQuincena = descuento.getNumQuincenaArchivo();
	    					nuevoArchivo.setConsecutivoArchivo(0);
	    	    			nuevoArchivo.setFechaCarga(new Date());
	    	    			nuevoArchivo.setIdPlaza(1);
	    	    			nuevoArchivo.setUsername(usuario);
	    	    			nuevoArchivo.setNumQuincena(numQuincena);
	    	    			nuevoArchivo.setArchivo(contenidoArchivo);
	    	    			nuevoArchivo.setNombreArchivo(nombreArchivo);
	    	    			nuevoArchivo.setNumeroRegistros(datosArchivo.size()-1);
	    	    			archivosAplicacionPagosDao.insertarArchivoAplicacion(nuevoArchivo);
	    	    			log.append("Identificador del archivo: "+ nuevoArchivo.getIdArchivosAplicacionCargados()+"\n");
	    				}
	    				
	    				descuento.setIdentificadorArchivo((int)nuevoArchivo.getIdArchivosAplicacionCargados());
	    				
	    				polizaActual = polizaDao.obtenerDetallePolizaPorNumero(descuento.getNumPoliza(), descuento.getNumConsignatario());
	    				if(polizaActual != null){
	    					
	    					//verificar si el descuento del registro actual no ha sido aplicado en BD
	    					if(descuentosAplicadosDao.existeDescuentoAplicadoPorPolizayQuincenaArchivo(descuento)){
	    						log.append("Ya existe el descuento cargado desde archivo: "+ descuento.getNumPoliza() + ","+ 
	    								descuento.getNumConsignatario()+ ","+descuento.getNumQuincenaArchivo()+"\n");
	    					}else{
	    						ultimoDescuentoConVigencia = descuentosAplicadosDao.obtenUltimoDescuentoConVigenciaPorPoliza(polizaActual);
		    					
		    					//calcular fecha de inicio y  fin de vigencia correspondiente al pago
			    				//y Determinar si el pago es para la vigencia o si es para el ahorro
		    					determinarQuincenaPagada(descuento,ultimoDescuentoConVigencia,polizaActual);
		    					//determinar la tarifa y el resto para ahorro
		    					//se determina la tarifa con la fecha de inicio de vigencia, en el caso de que sea el importe para cubrir vigencia se
		    					//busca la tarifa
		    					if(descuento.getFechaInicioCobertura() != null){
		    						//se consulta la tarifa, el descuento se utilizará para la cobertura
		    						Double tarifa = solicitudBusiness.consultarTarifaEnFecha(polizaActual.getSolicitud(), descuento.getFechaInicioCobertura());
		    						
		    						descuento.setImpRealPagoPrima(tarifa);
		    						descuento.setImpRealAhorro(descuento.getImpDescReportado()-tarifa);
		    					}else{
		    						//ahorro
		    						descuento.setImpRealPagoPrima(0);
		    						descuento.setImpRealAhorro(descuento.getImpDescReportado());
		    					}
		    					//si existe ahorro, aplicarlo a la cuenta del asegurado
		    					CuentaCliente cuentaCliente = actualizarCuentaCliente(descuento,polizaActual);
		    					descuento.setSaldoCuenta(cuentaCliente.getSaldoCuenta());
		    					descuentosAplicadosDao.insertarDescuentoAplicado(descuento);
		    					descuentosAplicados++;
		    					
		    					
		    					//Cambiar estatus de póliza
		    					if(polizaActual.getIdEstatusPagosPoliza() == null){
		    						polizaActual.setIdEstatusPagosPoliza(ConstantesGenerales.ESTATUS_PAGOS_POLIZA_SIN_PAGOS_APLICADOS);
		    					}
		    					int estatusActual = polizaActual.getIdEstatusPagosPoliza().intValue();
		    					//Pasar al estatus normal
		    					if(estatusActual == ConstantesGenerales.ESTATUS_PAGOS_POLIZA_SIN_PAGOS_APLICADOS ||
		    					   estatusActual == ConstantesGenerales.ESTATUS_PAGOS_POLIZA_NORMAL ||
		    					   estatusActual == ConstantesGenerales.ESTATUS_PAGOS_AUTOFINANCIADA_CON_ADEUDO ||
		    					   estatusActual == ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_FALTA_DE_PAGO
		    					  ){
		    						
		    						polizaActual.setIdEstatusPagosPoliza(ConstantesGenerales.ESTATUS_PAGOS_POLIZA_NORMAL);
		    						
		    					}else 
		    						if(
		    						estatusActual == ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_FALTA_DE_PAGO ||
		 		    				estatusActual == ConstantesGenerales.ESTATUS_PAGOS_AUTOFINANCIADA_CON_ADEUDO ||
		 		    				estatusActual == ConstantesGenerales.ESTATUS_PAGOS_POLIZA_SIN_PAGOS_APLICADOS
		    								){
		    						
		    							polizaActual.setIdEstatusPagosPoliza(ConstantesGenerales.ESTATUS_PAGOS_REHABILITADA);
		    							
		    					}
		    					polizaDao.actualizaEstatusPolizaPago(polizaActual);
		    					//Estatus general Vigente
		    					polizaDao.actualizarEstatusPolizaGeneral(polizaActual.getNumPoliza(), polizaActual.getNumConsignatario(), ConstantesGenerales.ESTATUs_POLIZA_GENERAL_VIGENTE);
		    					
	    					}
	    					
	    					
	    				}else{
	    					log.append("Poliza no localizada: "+ descuento.getNumPoliza() + ","+ descuento.getNumConsignatario()+"\n");
	    				}
	    				
	    				
	    				
	    			}
	    			
	    			
	    		}
	        	
	        	
	        	
	            
	            nuevoArchivo.setFechaHoraFin(new Date());
	            log.append("Proceso completado: "+ nuevoArchivo.getFechaHoraFin()+"\n");
	            log.append("Descuentos aplicados: "+ descuentosAplicados+"\n");
	            nuevoArchivo.setLog(log.toString());
	            archivosAplicacionPagosDao.actualizarArchivoAplicacion(nuevoArchivo);
	            transactionManager.commit(status);
	        } catch (Exception e) {
	        	System.out.println(descuento.getNumPoliza() + ","+descuento.getNumConsignatario());
	            transactionManager.rollback(status);
	            throw e;
	        }
	       
		
	}
	
	/**
	 * Actualiza la cuenta cliente del asegurado, en caso de que exista saldo de ahorro
	 * @param descuento
	 * @param polizaActual
	 * @return
	 */
	private CuentaCliente actualizarCuentaCliente(
			DescuentosAplicados descuento, PolizaIndividual polizaActual) {
		//Crear la transacción
		CuentaCliente cuenta = cuentaClienteBusiness.findById(polizaActual.getNumPoliza(),polizaActual.getNumConsignatario());
		if(cuenta == null){
			cuenta = cuentaClienteBusiness.createCuentaCliente(polizaActual.getNumPoliza(),polizaActual.getNumConsignatario());	
		}
			TransaccionCuentaCliente trans = transaccionCuentaClienteBusiness.realizarTransaccion(new BigDecimal(descuento.getImpRealAhorro()), 
					TipoTransaccionCuentaCliente.CVE_TIPO_MOV_DEPOSITO, cuenta);
			descuento.setTransaccionId(trans.getTransaccionId());
		
		return cuenta;
	}

	/**
	 * Determina la quincena real que se cubre con el pago, en caso de que no se tenga vigencia a la fecha de la quincena
	 * entonces se usa para cubrir la prima, en otro caso se asigna a null las fechas de vigencia y el importe
	 * será considerado mas adelante para el ahorro
	 * @param descuento
	 */
	private void determinarQuincenaPagada(DescuentosAplicados descuento, DescuentosAplicados ultimoDescuentoDePoliza, PolizaIndividual poliza) {
		Date fechaInicioVigencia = DateUtils.determinarFechaInicioReal(poliza.getFechaInicioVigencia());
		Integer siguienteQuincena = descuentosAplicadosDao.obtenerUltimaQuincenaPagadaPoliza(poliza);
		//Si la póliza no tiene descuentos aplicados
		if(ultimoDescuentoDePoliza == null){
			//considerar la fecha de inicio de vigencia que viene en el archivo
			
			descuento.setNumQuincenaPagada(DateUtils.getQuincenaFromFecha(fechaInicioVigencia));
			descuento.setFechaInicioCobertura(fechaInicioVigencia);
			descuento.setFechaFinalCobertura(DateUtils.sumar1MesCobertura(fechaInicioVigencia));
			
		}else{
			//si ya tiene descuentos aplicados, determinar la fecha de vigencia de la cobertura del descuento
			Date fechaVigenciaUltimoDescuento = DateUtils.determinarFechaInicioReal(ultimoDescuentoDePoliza.getFechaFinalCobertura());
			//si se termina la vigencia entonces la quincena que se paga es para cubrir vigencia
			Date fechaDescuento = DateUtils.parseFromQnaToDate(descuento.getNumQuincenaArchivo());
			if(fechaDescuento.compareTo(fechaVigenciaUltimoDescuento)>=0){
				//este descuento se usa como vigencia
				descuento.setFechaInicioCobertura(fechaVigenciaUltimoDescuento);
				descuento.setFechaFinalCobertura(DateUtils.sumar1MesCobertura(fechaVigenciaUltimoDescuento));
			}else{
				//se usa como ahorro
				descuento.setFechaInicioCobertura(null);
				descuento.setFechaFinalCobertura(null);
			}
			if(siguienteQuincena == null){
				if(descuento.getFechaInicioCobertura()!=null){
					siguienteQuincena = DateUtils.getQuincenaFromFecha(descuento.getFechaInicioCobertura());
				}else{
					siguienteQuincena = DateUtils.getQuincenaFromFecha(fechaInicioVigencia);
				}
				
			}
			descuento.setNumQuincenaPagada(DateUtils.sumarAQuincena(siguienteQuincena, 1));
		}
		
		
		
	}
	

	/**
	 * Crea un objeto de descuento aplicado en base a los datos de un renglón del archivo de aplicación
	 * @param list Datos de origen
	 * @return Objeto de descuentos aplicados creado
	 */
	private DescuentosAplicados cargarDescuentoAplicado(List<String> renglon) {
		DescuentosAplicados descuento = null;
		if(renglon != null){
			descuento = new DescuentosAplicados();
			try{
				descuento.setNumQuincenaPagada(obtenerQuincenaDeArchivo(renglon.get(ConstantesGenerales.COLUMNA_APLICACION_QUINCENA)));
				descuento.setNumQuincenaArchivo(descuento.getNumQuincenaPagada());
				descuento.setFechaCalculo(new Date());
				descuento.setNumPoliza(Integer.parseInt(renglon.get(ConstantesGenerales.COLUMNA_NUMERO_POLIZA).trim()));
				descuento.setNumConsignatario(Integer.parseInt(renglon.get(ConstantesGenerales.COLUMNA_EMISOR).trim()));
				descuento.setImpDescReportado(Double.parseDouble(renglon.get(ConstantesGenerales.COLUMNA_PAGO).trim()));
				descuento.setFechaInicioCobertura(FormatUtil.stringToDate(renglon.get(ConstantesGenerales.COLUMNA_INICIO_VIGENCIA).trim(), 
						ConstantesGenerales.FORMATO_FECHA_ARCHIVO));
			}catch(Exception ex){
				
			}
			
		}
		return descuento;
	}
	
	/**
	 * Lee el formato de quincena del archivo de la forma
	 * qq yyyy
	 * qq = quincena
	 * yyyy = año
	 * @param string
	 * @return
	 */
	private int obtenerQuincenaDeArchivo(String quincenaArchivo) {
		
		String tmpQuincena = quincenaArchivo.replace("   "," ");
		tmpQuincena = tmpQuincena.replace("  "," ");
		String[] quincenaString = tmpQuincena.split(" ");
		int quincenaCompleta = 0;
		if(quincenaString != null && quincenaString.length == 2){
			int quincena = Integer.parseInt(quincenaString[0].trim());
			int anio = Integer.parseInt(quincenaString[1].trim());
			quincenaCompleta = Integer.parseInt(anio + "" + (quincena<10?"0":"")+quincena);
		}
		return quincenaCompleta;
	}

	public ArchivosAplicacionPagosDao getArchivosAplicacionPagosDao() {
		return archivosAplicacionPagosDao;
	}

	public void setArchivosAplicacionPagosDao(
			ArchivosAplicacionPagosDao archivosAplicacionPagosDao) {
		this.archivosAplicacionPagosDao = archivosAplicacionPagosDao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.pagos.PagosBusiness#consultarArchivosAplicacionCargados(mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO)
	 */
	@Override
	public List<ArchivosAplicacionCargados> consultarArchivosAplicacionCargados(
			CriteriosConsultaArchivosAplicacionCargadosDTO criterio) {
		return archivosAplicacionPagosDao.findArchivosAplicacionCargados(criterio);
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.pagos.PagosBusiness#consultaArcivoAplicacionCargadoPorId(java.lang.Long)
	 */
	@Override
	public ArchivosAplicacionCargados consultaArcivoAplicacionCargadoPorId(
			Long idArchivo) {
		return archivosAplicacionPagosDao.findArchivoAplicacionCargadosPorId(idArchivo);
	}

	/**
	 * @return the solicitudBusiness
	 */
	public ISolicitudBusiness getSolicitudBusiness() {
		return solicitudBusiness;
	}

	/**
	 * @param solicitudBusiness the solicitudBusiness to set
	 */
	public void setSolicitudBusiness(ISolicitudBusiness solicitudBusiness) {
		this.solicitudBusiness = solicitudBusiness;
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.pagos.PagosBusiness#autoFinanciarPolizasAutomaticamente()
	 */
	@Override
	public CifrasControlProcesoAutofinanciar autoFinanciarPolizasAutomaticamente(Integer idPlaza, Integer idEstatusPolizaPagos ) throws Exception{
		CifrasControlProcesoAutofinanciar cifras = new CifrasControlProcesoAutofinanciar();
		cifras.setFechaHoraInicio(new Date());
		ResultadoPaginadoDTO<PolizaIndividual> resultadosAprocesar = new ResultadoPaginadoDTO<PolizaIndividual>();
		resultadosAprocesar.setRegistrosPorPagina(1500);
		double tarifa = 0;
		CuentaCliente cuentaCliente = null;
		DescuentosAplicados ultimoDescuentoVigente = null;
		long totalDescuentosAplicados = 0;
		Integer siguienteQuincena = null;
		StringBuffer log = new StringBuffer();
		log.append("Inicio del proceso: "+ cifras.getFechaHoraInicio()+"\n");
		//Realizar y procesar una consulta paginada de las pólizas que no han sido canceladas por el cliente
		//y cuya fecha de vigencia de su última cobertura está a más de un mes de la fecha actual
		//y que cuenten con saldo positivo en su cuenta de ahorro
		polizaDao.consultarPolizasParaAutofinanciar(resultadosAprocesar,idPlaza, idEstatusPolizaPagos);
		log.append("Pólizas consultadas:"+resultadosAprocesar.getTotalResultados()+"\n");
		
		if(resultadosAprocesar.getTotalResultados()>0){
			TransactionDefinition def = new DefaultTransactionDefinition();
		    TransactionStatus status = transactionManager.getTransaction(def);
			while(resultadosAprocesar.getPaginaActual()<=resultadosAprocesar.getTotalPaginas()){
				log.append("Procesando del registro:" + ((resultadosAprocesar.getPaginaActual()-1)*resultadosAprocesar.getRegistrosPorPagina()) + 
						" al "+ ((resultadosAprocesar.getPaginaActual())*resultadosAprocesar.getRegistrosPorPagina())+"\n");
				
				try{
					//Procesr los registros de la página
					
					for(PolizaIndividual pol:resultadosAprocesar.getResultados()){
						tarifa = pol.getSolicitud().getTarifaTotal()!=null?pol.getSolicitud().getTarifaTotal():pol.getSolicitud().getTarifa().getImporteTarifa();
						cuentaCliente = cuentaClienteBusiness.findById(pol.getNumPoliza(),pol.getNumConsignatario());
						ultimoDescuentoVigente = descuentosAplicadosDao.obtenUltimoDescuentoConVigenciaPorPoliza(pol);
						siguienteQuincena = descuentosAplicadosDao.obtenerUltimaQuincenaPagadaPoliza(pol);
						//mientras existe dinero en su cuenta y sea mayor que la tarifa a pagar
						//y mientras no tenga cobertura al día actual
						while(cuentaCliente.getSaldoCuenta().doubleValue() >= tarifa && 
								ultimoDescuentoVigente.getFechaFinalCobertura().compareTo(new Date())<0){
							//realizar un descuento de la cuenta para pagar una cobertura
							ultimoDescuentoVigente = realizarDescuentoDesdeAhorro(ultimoDescuentoVigente,cuentaCliente, pol,siguienteQuincena,tarifa);
							siguienteQuincena = ultimoDescuentoVigente.getNumQuincenaPagada();
							totalDescuentosAplicados++;
						}
						
						
						//Aplicar ls reglas de negocio para el cambio de estatus
						int estatusActual = pol.getIdEstatusPagosPoliza();
						
    					if(estatusActual == ConstantesGenerales.ESTATUS_PAGOS_POLIZA_NORMAL ||
    					   estatusActual == ConstantesGenerales.ESTATUS_PAGOS_AUTOFINANCIADA_CON_ADEUDO ||
    					   estatusActual == ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_FALTA_DE_PAGO ||
    					   estatusActual == ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_FALTA_DE_PAGO ||
    					   estatusActual == ConstantesGenerales.ESTATUS_PAGOS_TRAMITE_DE_SUSPENSION ||
    					   estatusActual == ConstantesGenerales.ESTATUS_PAGOS_POLIZA_SIN_PAGOS_APLICADOS
    					  ){
    						
    						pol.setIdEstatusPagosPoliza(ConstantesGenerales.ESTATUS_PAGOS_AUTOFINANCIADA_CON_ADEUDO);
    						pol.setIdEstatusPolizaGeneral(ConstantesGenerales.ESTATUs_POLIZA_GENERAL_VIGENTE);
    					}else if(estatusActual == ConstantesGenerales.ESTATUS_PAGOS_AUTOFINANCIADA_POR_CANCELACION){
    						pol.setIdEstatusPagosPoliza(ConstantesGenerales.ESTATUS_PAGOS_AUTOFINANCIADA_POR_CANCELACION);
    						pol.setIdEstatusPolizaGeneral(ConstantesGenerales.ESTATUs_POLIZA_GENERAL_VIGENTE);
    					}
						
						//Si todavía falta cobertura y ya no tiene saldo se pasa a Cancelada por Falta de PAgo
						//RN005
						if(ultimoDescuentoVigente.getFechaFinalCobertura().compareTo(new Date())<0){
							pol.setIdEstatusPagosPoliza(ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_FALTA_DE_PAGO);
							//Estatus general
							pol.setIdEstatusPolizaGeneral(ConstantesGenerales.ESTATUS_POLIZA_GENERAL_CANCELADA);
						}
						
						polizaDao.actualizaEstatusPolizaPago(pol);
						polizaDao.actualizarEstatusPolizaGeneral(pol.getNumPoliza(), pol.getNumConsignatario(),pol.getIdEstatusPolizaGeneral());
					}
			   
			     log.append("Terminado el proceso de los registros:" + ((resultadosAprocesar.getPaginaActual()-1)*resultadosAprocesar.getRegistrosPorPagina()) + 
							" al "+ ((resultadosAprocesar.getPaginaActual())*resultadosAprocesar.getRegistrosPorPagina())+"\n");
		        } catch (Exception e) {
		            transactionManager.rollback(status);
		            e.printStackTrace();
		            StringWriter sw = new StringWriter();
		            PrintWriter pw = new PrintWriter(sw);
		            e.printStackTrace(pw);
		            log.append("Excepción en la página: " + resultadosAprocesar.getPaginaActual() +"\n");
		            log.append(sw.toString());
		        }
				resultadosAprocesar.setPaginaActual(resultadosAprocesar.getPaginaActual()+1);
				polizaDao.consultarPolizasParaAutofinanciar(resultadosAprocesar,idPlaza,idEstatusPolizaPagos);
			}
			transactionManager.commit(status);
		}
		
		cifras.setFechaHoraFin(new Date());
		log.append("Proceso terminado: " + cifras.getFechaHoraFin() +"\n");
		cifras.setTotalRegistrosProcesados(resultadosAprocesar.getTotalResultados());
		cifras.setTotalDescuentosAplicados(totalDescuentosAplicados);
		cifras.setLog(log.toString());
		
		
		try{
			LOG.debug("Insertando nuevo registro de cifras de control");
			descuentosAplicadosDao.insertarCifrasControlProcesoAutofinanciar(cifras);
			
			LOG.debug("Cifras de control insertadas");
		}catch (Exception e) {
			LOG.debug("Error al guardar las cifras de control");
			LOG.error(e);
			throw e;
		}
		
		return cifras;
		
	}
	/**
	 * Realiza un pago de cobertura a partir del saldo de ahorro del asegurado
	 * Retorna el objeto de descuento recién creado e insertado en la BD
	 * @param ultimoDescuentoVigente Ultimo descuento con vigencia reportada
	 * @param cta Cuenta del cliente de donde se descuenta el ahorro
	 * @param siguienteQuincena Objeto para determinar la siguiente quincena
	 * @return
	 */
	private DescuentosAplicados realizarDescuentoDesdeAhorro(
			DescuentosAplicados ultimoDescuentoVigente,
			CuentaCliente cta,PolizaIndividual poliza, Integer siguienteQuincena, Double tarifa) {
		//determinar la fecha de inicio de cobertura del siguiente descuento
		
		
		DescuentosAplicados nuevoDescuento = new DescuentosAplicados();
		nuevoDescuento.setNumQuincenaPagada(DateUtils.sumarAQuincena(siguienteQuincena, 1));
		nuevoDescuento.setNumQuincenaArchivo(nuevoDescuento.getNumQuincenaArchivo());
		nuevoDescuento.setFechaCalculo(new Date());
		nuevoDescuento.setNumPoliza(poliza.getNumPoliza());
		nuevoDescuento.setNumConsignatario(poliza.getNumConsignatario());
		nuevoDescuento.setImpDescReportado(tarifa);
		nuevoDescuento.setFechaInicioCobertura(ultimoDescuentoVigente.getFechaFinalCobertura());
		nuevoDescuento.setFechaFinalCobertura(DateUtils.sumar1MesCobertura(nuevoDescuento.getFechaInicioCobertura()));
		nuevoDescuento.setImpRealAhorro(0);
		nuevoDescuento.setImpRealPagoPrima(tarifa);
		TransaccionCuentaCliente tcc = transaccionCuentaClienteBusiness.realizarTransaccion(new BigDecimal(tarifa*-1), TipoTransaccionCuentaCliente.CVE_TIPO_MOV_DISPOSICION, cta);
		nuevoDescuento.setTransaccionId(tcc.getTransaccionId());
		nuevoDescuento.setSaldoCuenta(cta.getSaldoCuenta());
		descuentosAplicadosDao.insertarDescuentoAplicado(nuevoDescuento);
		return nuevoDescuento;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.pagos.PagosBusiness#validarContenidoArchivoAplicacion(java.util.List)
	 */
	@Override
	public boolean validarContenidoArchivoAplicacion(
			List<List<String>> datosArchivo) {
		boolean valido = true;
		List<DescuentosAplicados> descuentos = null;
		if(datosArchivo != null && datosArchivo.size()>1){
			
			//verificar los primeros 10 registros
			//validación desactivada, se deja esta validación a cada registro al momento de intentar aplicarlo
			/*
			DescuentosAplicados descuento = null;
			for(int i=1; i < datosArchivo.size() && i<=10;i++){
				descuento = cargarDescuentoAplicado(datosArchivo.get(i));
				
				if(descuentosAplicadosDao.existeDescuentoAplicadoPorPolizayQuincenaArchivo(descuento)){
					valido = false;
					break;
				}
			}*/
		}
		return valido;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.pagos.PagosBusiness#revertirArchivoAplicacionCargado(java.lang.Long)
	 */
	@Override
	public boolean revertirArchivoAplicacionCargado(Long idArchivoAplicacion) {
		boolean revertido = false;
		//verificar si el archivo de aplicación ya partició en el cálculo de bono 
		//de agentes entonces no será posible revertirlo
		if(!descuentosAplicadosDao.existenCalculosDeBonoDeArchivoDeAplicacionDePagos(idArchivoAplicacion)){
			//por cada registro en el archivo de aplicación de pagos
			CuentaCliente cuentaClienteActual = null;
			for(DescuentosAplicados descuento:descuentosAplicadosDao.obtenerDescuentosAplicadosDeArchivoDeAplicacion(idArchivoAplicacion)){
				//si el descuento ha sido enviado a ahorro entonces descontar el ahorro de la cuenta del cliente
				if(descuento.getImpRealAhorro()>0){
					cuentaClienteActual = cuentaClienteBusiness.findById(descuento.getNumPoliza(),descuento.getNumConsignatario());
					if(cuentaClienteActual != null){
						cuentaClienteBusiness.updateCuentaCliente(cuentaClienteActual,new BigDecimal( descuento.getImpRealAhorro()*-1));
					}
				}
				//borrar el registo de descuento aplicado
				descuentosAplicadosDao.eliminarDescuentoAplicado(descuento);
			}
			//una vez eliminados todos los descuentos entonces se debe eliminar el registro del archivo de aplicación 
			archivosAplicacionPagosDao.eliminarArchivoAplicacion(idArchivoAplicacion);
			revertido = true;
		}
		return revertido;
	}

	
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.pagos.PagosBusiness#ajustarSaldoActualEnDescuentosAplicados()
	 */
	@Override
	public void ajustarSaldoActualEnDescuentosAplicados() {
		
		//obtener las polizas del sistema con descuentos
		List<String> polizasConDescuentos = descuentosAplicadosDao.obtenerPolizasDescuentosAplicados();
		List<DescuentosAplicados> descuentos = null;
		PolizaIndividual poliza = new PolizaIndividual();
		String []numPolConsig = null;
		double saldo = 0;
		//obtener por cada poliza, los descuentos aplicados ordenados
		for(String polizaCons : polizasConDescuentos){
			System.out.println(polizaCons);
			numPolConsig = polizaCons.split("-");
			poliza.setNumPoliza(Integer.valueOf(numPolConsig[0]));
			poliza.setNumConsignatario(Integer.valueOf(numPolConsig[1]));
			descuentos = descuentosAplicadosDao.obtenDescuentosPorPoliza(poliza);
			saldo = 0;
			for(DescuentosAplicados descuento: descuentos){
				System.out.println(descuento.getNumQuincenaPagada());
				saldo +=  descuento.getIdentificadorArchivo()>0?descuento.getImpRealAhorro():(descuento.getImpRealPagoPrima()*-1);
				descuento.setSaldoCuenta(new BigDecimal(saldo));
				//actualizar descuento
				descuentosAplicadosDao.actualizarSaldoDescuentoAplicado(descuento);
			}
			//Insertar / Actualizar cuenta cliente
			CuentaCliente cuenta = 
					cuentaClienteDao.obtenerCuentaClienteByPoliza(poliza.getNumPoliza(), poliza.getNumConsignatario());
			if(cuenta == null){
				cuenta = new CuentaCliente(poliza.getNumPoliza(), poliza.getNumConsignatario());
				cuenta.setSaldoCuenta(new BigDecimal(saldo));
				cuenta.setFechaCalculoSaldo(new Date());
		        cuentaClienteDao.createCuentaCliente(cuenta);
				
			}else{
				cuenta.setFechaCalculoSaldo(new Date());
				cuenta.setSaldoCuenta(new BigDecimal(saldo));
				cuentaClienteDao.updateCuentaCliente(cuenta);
			}
			
		}
		
		
	}

	private CuentaClienteDao cuentaClienteDao = null;

	/**
	 * @param cuentaClienteDao the cuentaClienteDao to set
	 */
	public void setCuentaClienteDao(CuentaClienteDao cuentaClienteDao) {
		this.cuentaClienteDao = cuentaClienteDao;
	}
}
