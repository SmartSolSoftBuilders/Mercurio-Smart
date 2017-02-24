/*
 * PolizaBusiness.java
 *
 * Created on 25 de septiembre de 2007, 10:28 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package mx.com.seguros.business.poliza;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import mx.com.seguros.business.reporte.ReporteBusiness;
import mx.com.seguros.business.reporte.ReportesPDF;
import mx.com.seguros.data.dao.EstatusPolizaPagosDao;
import mx.com.seguros.data.dao.EstatusPolizaSeguimientoDao;
import mx.com.seguros.data.dao.IAseguradoDao;
import mx.com.seguros.data.dao.IMovimientosDependenciaDAO;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.data.dao.IHistorialDao;
import mx.com.seguros.data.dao.IProductosInburnominaDao;
import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.data.dao.TramitePolizaDao;
import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.CalendarioEnvioMovimientosDependencias;
import mx.com.seguros.model.Contratante;
import mx.com.seguros.model.EstatusPolizaGeneral;
import mx.com.seguros.model.EstatusPolizaPagos;
import mx.com.seguros.model.EstatusPolizaSeguimiento;
import mx.com.seguros.model.HistorialMovimientosContratante;
import mx.com.seguros.model.HistoricoTarifa;
import mx.com.seguros.model.Oficina;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.ProductosInburnomina;
import mx.com.seguros.model.Retenedor;
import mx.com.seguros.model.Solicitante;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.model.TipoTramite;
import mx.com.seguros.model.TramitePoliza;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.web.poliza.RegistroPolizaCommand;
import mx.com.seguros.web.poliza.ConsultaPolizaCommand;
import mx.com.seguros.web.poliza.GenerarEntregaPolizaCommand;
import mx.com.seguros.web.poliza.GenerarFormatoDescuentoCommand;
import mx.com.seguros.web.poliza.GenerarFormatoAplicDescCommand;
import mx.com.seguros.web.poliza.CancelarPolizaCommand;
import mx.com.seguros.web.poliza.AutofinanciarPolizaCancelCommand;

/**
 *
 * @author Cesar
 */
public class PolizaBusiness implements IPolizaBusiness {

    private IPolizaDao polizaDao;
    private IAseguradoDao aseguradoDao;
    private IHistorialDao historialDao;
    private ISolicitudDao solicitudDao;
    private IMovimientosDependenciaDAO movimientosDependenciaDAO;
    private ReporteBusiness reporteBusiness;
    private EstatusPolizaSeguimientoDao estatusPolizaSeguimientoDao;
    private EstatusPolizaPagosDao estatusPolizaPagosDao;
    private TramitePolizaDao tramitePolizaDao;
    /**
	 * DAO para las operaciones de los productos de inburnomina integral
	 */
	private IProductosInburnominaDao productosInburnominaDao = null;
	@Override
    public List obtenerEstatusPoliza() {
        return getPolizaDao().obtenerEstatusPoliza();
    }

    @Override
    public void actualizarPoliza(CancelarPolizaCommand datosPoliza) {
        PolizaIndividual polizaIndividual = datosPoliza.getPolizaIndividual();
        int numPoliza = polizaIndividual.getNumPoliza();
        int numConsignatario = polizaIndividual.getNumConsignatario();
        polizaIndividual.setNumPoliza(numPoliza);
        polizaIndividual.setNumConsignatario(numConsignatario);
        polizaIndividual.setFechaCancelacion(new Date());
        polizaIndividual.setTipoMovimientoPoliza("B");
        RegistroPolizaCommand registroPoliza = new RegistroPolizaCommand();
        registroPoliza.setPolizaIndividual(polizaIndividual);
        this.registrarPoliza(registroPoliza);
        getPolizaDao().cancelarPoliza(polizaIndividual);
    }

    @Override
    public void autofinanciarPoliza(AutofinanciarPolizaCancelCommand datosPoliza) {
        PolizaIndividual polizaIndividual = datosPoliza.getPolizaIndividual();
        int numPoliza = polizaIndividual.getNumPoliza();
        int numConsignatario = polizaIndividual.getNumConsignatario();
        polizaIndividual.setNumPoliza(numPoliza);
        polizaIndividual.setNumConsignatario(numConsignatario);
        polizaIndividual.setFechaCancelacion(new Date());
        getPolizaDao().autofinarciarPolizaCancel(polizaIndividual);
    }

    @Override
    public void registrarPoliza(RegistroPolizaCommand datosPoliza) {

        HistorialMovimientosContratante historial = new HistorialMovimientosContratante();
        historial.setIndicadorEnvioArchivo(1);
        int folioSolicitud = 0;
        String formatoSolicitud = null;
        //Bajar command a generico Poliza
        PolizaIndividual poliza = datosPoliza.getPolizaIndividual();
        //Obtener folioSolicitud de la poliza y numNominaContratante del historial
        if (poliza.getTipoMovimientoPoliza().equals("B")) {
            PolizaIndividual polizaBaja = (PolizaIndividual) polizaDao.obtenerPolizaNumPolizaNumConsignatario(poliza);
            
            folioSolicitud = polizaBaja.getFolioSolicitud();
            formatoSolicitud = polizaBaja.getFormatoSolicitud();
            /**
             * Mantenimieto: Smart Solutions Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
             */
            Solicitud solicitudBaja = (Solicitud) getSolicitudDao().obtenSolicitudPorFolioSolicitud(folioSolicitud,formatoSolicitud);
            String numNominaContratanteBaja = solicitudBaja.getNumNominaContratante();
            historial.setNumNominaContratante(numNominaContratanteBaja);
        } else {
            Solicitud solicitud = poliza.getSolicitud();
            folioSolicitud = solicitud.getFolioSolicitud();
            formatoSolicitud = solicitud.getFormatoSolicitud();
            /**
             * Mantenimieto: Smart Solutions Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
             */
            historial.setNumNominaContratante(datosPoliza.getPolizaIndividual().getSolicitud().getContratante().getNumNominaContratante());
            poliza.setIdEstatusPolizaSeguimiento(1);
            poliza.setIdEstatusPagosPoliza(1);
            poliza.setIndicadorPagoComisionEntregaPoliza(0);
            poliza.setIndicadorDescuentoComision(0);
            //Estatus general inicial            
            poliza.setIdEstatusPolizaGeneral(ConstantesGenerales.ESTATUS_POLIZA_GENERAL_CANCELADA);
        }
        /**
         * Mantenimieto: Smart Solutions Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
         */
        poliza.setFolioSolicitud(folioSolicitud);
        poliza.setFormatoSolicitud(formatoSolicitud);
    
        //Calcular qnaProgramadaMovimientoPoliza//
        Calendar fechaActual = Calendar.getInstance();
        Integer anioQuincenaDescuento;
        Integer numQnaDescuento;
        Calendar fechaBase = Calendar.getInstance();
        String qnaProgEnvioMvtoPoliza = new String();
        int diaFechaActual = fechaActual.get(Calendar.DATE);
        int mesFechaActual = fechaActual.get(Calendar.MONTH);
        int anioFechaActual = fechaActual.get(Calendar.YEAR);
        Retenedor retenedor = new Retenedor();
        /**
         * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
         */
        retenedor = getPolizaDao().obtenerRetenedor(folioSolicitud,formatoSolicitud);

        

        CalendarioEnvioMovimientosDependencias calendarioEnvio = new CalendarioEnvioMovimientosDependencias();
        mesFechaActual = mesFechaActual + 1;
        calendarioEnvio.setFechaBusqueda(anioFechaActual + "-" + mesFechaActual + "-%");
        calendarioEnvio.setCveRetenedor(retenedor.getCveRetenedor());
        List listaFechasBusqueda = getPolizaDao().buscarFechaCalendario(calendarioEnvio);
        for (int i = 0; i < listaFechasBusqueda.size(); i++) {
            CalendarioEnvioMovimientosDependencias elemento = ((CalendarioEnvioMovimientosDependencias) listaFechasBusqueda.get(i));
            fechaBase.setTime(elemento.getInicioVigencia());
            if (diaFechaActual <= fechaBase.get(Calendar.DATE)) {
                anioQuincenaDescuento = elemento.getAnioQuincenaDescuento();
                numQnaDescuento = elemento.getNumQnaDescuento();
                qnaProgEnvioMvtoPoliza = new String(anioQuincenaDescuento.toString() + numQnaDescuento.toString());
                break;
            }
        }
        if (qnaProgEnvioMvtoPoliza.isEmpty()) {
            mesFechaActual = mesFechaActual + 1;
            CalendarioEnvioMovimientosDependencias elemento = new CalendarioEnvioMovimientosDependencias();
            for (int i = 0; i < listaFechasBusqueda.size(); i++) {
                elemento = ((CalendarioEnvioMovimientosDependencias) listaFechasBusqueda.get(i));
                fechaBase.setTime(elemento.getInicioVigencia());
                if (diaFechaActual <= fechaBase.get(Calendar.DATE)) {
                    anioQuincenaDescuento = elemento.getAnioQuincenaDescuento();
                    numQnaDescuento = elemento.getNumQnaDescuento();
                    qnaProgEnvioMvtoPoliza = new String(anioQuincenaDescuento.toString() + numQnaDescuento.toString());
                    break;
                }
            }
        }
        if (qnaProgEnvioMvtoPoliza.length() == 5) {
            qnaProgEnvioMvtoPoliza = qnaProgEnvioMvtoPoliza.substring(0, 4) + "0" + qnaProgEnvioMvtoPoliza.substring(4, 5);
        }
        poliza.setQnaProgEnvioMvtoPoliza(qnaProgEnvioMvtoPoliza);

        //Obtener campos para el registro en Historial de movimientos excepto numNominaContratante (Ver arriba)//

        String numNominaContratante = historial.getNumNominaContratante();
        String qnaProgramadaEnvio = poliza.getQnaProgEnvioMvtoPoliza();
        historial.setQnaProgramadaEnvioMovimientoHistorial(qnaProgramadaEnvio);
        /**
         * Mantenimieto: Smart Solutions Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
         */
        String cveDescuento = polizaDao.consultarClaveDescuentoPorSolicitud(poliza.getFolioSolicitud(),poliza.getFormatoSolicitud());
        historial.setCveDescuento(cveDescuento);
        /*        PolizaAux polizaAux = new PolizaAux();
        polizaAux.setNumNominaContratante(numNominaContratante);
        polizaAux.setQnaProgramadaEnvio(qnaProgramadaEnvio);
        double montoPolizasMovimientoQnaCliente = 0.0;
        double montoPolizasVigentes = 0.0;
        double importeMovimientoBaja = 0.0;
        double importeMovimiento = 0.0; */

        //---Para obtener el importe tarifa de la poliza por registrar---//
        Solicitud solicitudAux;
        /**
         * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
         */
        solicitudAux = (Solicitud) getSolicitudDao().obtenSolicitudPorFolioSolicitud(poliza.getFolioSolicitud(),poliza.getFormatoSolicitud());
        int cveTarifa = solicitudAux.getCveTarifa();
        TarifaAportMensual tarifa = (TarifaAportMensual) getSolicitudDao().obtenTarifaMensualPorClaveTarifa(cveTarifa);


        //--Contador de polizas existentes por cliente
        int contadorPolizasExistentesContratante = getPolizaDao().obtenerPolizasPorNumNominaContratante(numNominaContratante);
        System.out.print("contador polizas " + contadorPolizasExistentesContratante);


        if (contadorPolizasExistentesContratante == 0) {
            //*** Registro altas para cliente nuevo***
            historial.setTipoMovimientoEnvio("A");
           
            historial.setCveDescuento(retenedor.getCveDescuento());
           
            if (retenedor.getCveDescuento().equals("78")) {
                historial.setTotalImporteMovimiento(tarifa.getImporteTarifa() * 2);
            } else {
                historial.setTotalImporteMovimiento(tarifa.getImporteTarifa());
            }
           
        //****
        } else {

            if (poliza.getTipoMovimientoPoliza().equals("C")) {
                //*** Actualizacion poliza por cambio
                polizaDao.actualizaPolizaCambio(poliza);
            //***
            }

            int contadorPolizasVigentes = getPolizaDao().consultaContadorPolizasVigentes(numNominaContratante);
           

            if (contadorPolizasVigentes == 0) {
                if (poliza.getTipoMovimientoPoliza().equals("A")) {
                    //***Registro altas para clientes con polizas existentes y no vigentes (bajas anteriores o remplazos por cambio)
                    historial.setTipoMovimientoEnvio("A");
                
                    if (retenedor.getCveDescuento().equals("78")) {
                        historial.setTotalImporteMovimiento(tarifa.getImporteTarifa() * 2);
                    } else {
                        historial.setTotalImporteMovimiento(tarifa.getImporteTarifa());
                    }
                    
                //***
                }

                if (poliza.getTipoMovimientoPoliza().equals("C")) {
                    //***Registro de cambio de tarifa a poliza unica
                    historial.setTipoMovimientoEnvio("C");
                    if (retenedor.getCveDescuento().equals("78")) {
                        historial.setTotalImporteMovimiento(tarifa.getImporteTarifa() * 2);
                    } else {
                        historial.setTotalImporteMovimiento(tarifa.getImporteTarifa());
                    }
                }

            } else {
                if (contadorPolizasVigentes == 1 && poliza.getTipoMovimientoPoliza().equals("C")) {
                    List polizasVigentes = polizaDao.consultaPolizasVigentes(numNominaContratante);
                    PolizaIndividual elemento = (PolizaIndividual) polizasVigentes.get(0);
                    /**
                     * Mantenimieto: Smart Solutions Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                     */
                    Solicitud solicitudPolizaVigente = (Solicitud) getSolicitudDao().
                    		obtenSolicitudPorFolioSolicitud(elemento.getFolioSolicitud(),elemento.getFormatoSolicitud());
                    int cveTarifaPolizaVigente = solicitudPolizaVigente.getCveTarifa();
                    TarifaAportMensual tarifaPolizaVigente = (TarifaAportMensual) getSolicitudDao().obtenTarifaMensualPorClaveTarifa(cveTarifaPolizaVigente);
                    historial.setTipoMovimientoEnvio("C");
                    if (retenedor.getCveDescuento().equals("78")) {
                        historial.setTotalImporteMovimiento((tarifa.getImporteTarifa() + tarifaPolizaVigente.getImporteTarifa()) * 2);
                    } else {
                        historial.setTotalImporteMovimiento(tarifa.getImporteTarifa() + tarifaPolizaVigente.getImporteTarifa());
                    }
                }

                if (contadorPolizasVigentes > 1 && poliza.getTipoMovimientoPoliza().equals("C")) {
                    List polizasVigentes = polizaDao.consultaPolizasVigentes(numNominaContratante);
                    PolizaIndividual elemento = new PolizaIndividual();
                    Solicitud solicitudPolizaVigente = new Solicitud();
                    int cveTarifaPolizaVigente = 0;
                    TarifaAportMensual tarifaPolizaVigente = new TarifaAportMensual();
                    double acumImporteMovimientoEnvio = 0.00;
                    double importeMovimiento = 0.0;
                    for (int i = 0; i < polizasVigentes.size(); i++) {
                        elemento = (PolizaIndividual) polizasVigentes.get(i);
                        /**
                         * Mantenimieto: Smart Solutions Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                         */
                        solicitudPolizaVigente = (Solicitud) getSolicitudDao().
                        		obtenSolicitudPorFolioSolicitud(elemento.getFolioSolicitud(),elemento.getFormatoSolicitud());
                        cveTarifaPolizaVigente = solicitudPolizaVigente.getCveTarifa();
                        tarifaPolizaVigente = (TarifaAportMensual) getSolicitudDao().obtenTarifaMensualPorClaveTarifa(cveTarifaPolizaVigente);
                        acumImporteMovimientoEnvio = acumImporteMovimientoEnvio + tarifaPolizaVigente.getImporteTarifa();
                    }
                    importeMovimiento = acumImporteMovimientoEnvio + tarifa.getImporteTarifa();
                    historial.setTipoMovimientoEnvio("C");
                    if (retenedor.getCveDescuento().equals("78")) {
                        historial.setTotalImporteMovimiento((importeMovimiento) * 2);
                    } else {
                        historial.setTotalImporteMovimiento(importeMovimiento);
                    }
                }



                if (contadorPolizasVigentes == 1 && poliza.getTipoMovimientoPoliza().equals("B")) {
                    //***Registro de bajas
                    polizaDao.actualizarQnaProgEnvioPoliza(poliza);
                    int contadorPolizasMvtoQnaCliente = getPolizaDao().consultaContadorPolizasMvtoQnaCliente(historial);
                     if (contadorPolizasMvtoQnaCliente >= 1) {
                        double montoPolizasMovimientoQnaCliente = 0.0;
                        double importeMovimientoBaja = 0.0;
                        List polizasMvtoQnaCliente = polizaDao.consultaPolizasMvtoQnaCliente(historial);
                        for (int i = 0; i < polizasMvtoQnaCliente.size(); i++) {
                            PolizaIndividual elemento = (PolizaIndividual) polizasMvtoQnaCliente.get(i);
                            /**
                             * Mantenimieto: Smart Sol Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                             */
                            Solicitud solicitudConsultaBajas = (Solicitud) getSolicitudDao().
                            		obtenSolicitudPorFolioSolicitud(elemento.getFolioSolicitud(),elemento.getFormatoSolicitud());
                            int cveTarifaSolConsultaBajas = solicitudConsultaBajas.getCveTarifa();
                            TarifaAportMensual tarifaSolConsultaBajas = (TarifaAportMensual) getSolicitudDao().obtenTarifaMensualPorClaveTarifa(cveTarifaSolConsultaBajas);
                            montoPolizasMovimientoQnaCliente = montoPolizasMovimientoQnaCliente + (tarifaSolConsultaBajas.getImporteTarifa());
                           
                        }
                        importeMovimientoBaja = montoPolizasMovimientoQnaCliente + tarifa.getImporteTarifa();
                        if (retenedor.getCveDescuento().equals("78")) {
                            historial.setTotalImporteMovimiento(importeMovimientoBaja * 2);
                        } else {
                            historial.setTotalImporteMovimiento(importeMovimientoBaja);
                        }
                        historial.setTipoMovimientoEnvio("B");
                       
                    } else {
                        historial.setTipoMovimientoEnvio("B");
                        if (retenedor.getCveDescuento().equals("78")) {
                            historial.setTotalImporteMovimiento(tarifa.getImporteTarifa() * 2);
                        } else {
                            historial.setTotalImporteMovimiento(tarifa.getImporteTarifa());
                        }
                    }
                }

                if (contadorPolizasVigentes > 1 && poliza.getTipoMovimientoPoliza().equals("B")) {
                    polizaDao.actualizarQnaProgEnvioPoliza(poliza);
                    double importeBajaConPolizaVigente = 0.0;
                    /**
                     * Mantenimieto: Smart Sol Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                     */
                    Solicitud solicitudConsultaBajas = (Solicitud) getSolicitudDao().
                    		obtenSolicitudPorFolioSolicitud(poliza.getFolioSolicitud(),poliza.getFormatoSolicitud());
                    List listaPolizasVigentes = getPolizaDao().consultaPolizasVigentes(solicitudConsultaBajas.getNumNominaContratante());
                    for (int i = 0; i < listaPolizasVigentes.size(); i++) {
                        PolizaIndividual elemento = (PolizaIndividual) listaPolizasVigentes.get(i);
                        /**
                         * Mantenimieto: Smart Sol Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                         */
                        Solicitud solicitudConsultaElementosPolizasVigentes = (Solicitud) getSolicitudDao().
                        		obtenSolicitudPorFolioSolicitud(elemento.getFolioSolicitud(),elemento.getFormatoSolicitud());
                        int cveTarifaSolConsultaElementosPolizasVigentes = solicitudConsultaElementosPolizasVigentes.getCveTarifa();
                        TarifaAportMensual tarifaSolConsultaElementosPolizasVigentes = (TarifaAportMensual) getSolicitudDao().obtenTarifaMensualPorClaveTarifa(cveTarifaSolConsultaElementosPolizasVigentes);
                        if (elemento.getNumPoliza() != poliza.getNumPoliza() && elemento.getNumConsignatario() == poliza.getNumConsignatario()) {
                            importeBajaConPolizaVigente = importeBajaConPolizaVigente + tarifaSolConsultaElementosPolizasVigentes.getImporteTarifa();
                        }
                    }
                    if (retenedor.getCveDescuento().equals("78")) {
                        historial.setTotalImporteMovimiento(importeBajaConPolizaVigente * 2);
                    } else {
                        historial.setTotalImporteMovimiento(importeBajaConPolizaVigente);
                    }
                    historial.setTipoMovimientoEnvio("C");
                }

                if (contadorPolizasVigentes == 1 && poliza.getTipoMovimientoPoliza().equals("A")) {
                    //**Registro de altas consecutivas para poliza unica
                    List polizasVigentes = polizaDao.consultaPolizasVigentes(numNominaContratante);
                    PolizaIndividual elemento = (PolizaIndividual) polizasVigentes.get(0);
                    /**
                     * Mantenimieto: Smart Sol Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                     */
                    Solicitud solicitudPolizaVigente = (Solicitud) getSolicitudDao().
                    		obtenSolicitudPorFolioSolicitud(elemento.getFolioSolicitud(),elemento.getFormatoSolicitud());
                    int cveTarifaPolizaVigente = solicitudPolizaVigente.getCveTarifa();
                    TarifaAportMensual tarifaPolizaVigente = (TarifaAportMensual) getSolicitudDao().obtenTarifaMensualPorClaveTarifa(cveTarifaPolizaVigente);
                     if (elemento.getQnaProgEnvioMvtoPoliza()!=null && elemento.getQnaProgEnvioMvtoPoliza().equals(poliza.getQnaProgEnvioMvtoPoliza())) {
                        //**Cuando ambas polizas tienen la misma qnaProgramadaEnvio
                        historial.setTipoMovimientoEnvio("A");
                        if (retenedor.getCveDescuento().equals("78")) {
                            historial.setTotalImporteMovimiento((tarifa.getImporteTarifa() + tarifaPolizaVigente.getImporteTarifa()) * 2);
                        } else {
                            historial.setTotalImporteMovimiento(tarifa.getImporteTarifa() + tarifaPolizaVigente.getImporteTarifa());
                        }
                    //**
                    } else {
                        //** Cuando ambas polizas no tienen la misma qnaProgramadaEnvio
                        historial.setTipoMovimientoEnvio("C");
                        if (retenedor.getCveDescuento().equals("78")) {
                            historial.setTotalImporteMovimiento((tarifa.getImporteTarifa() + tarifaPolizaVigente.getImporteTarifa()) * 2);
                        } else {
                            historial.setTotalImporteMovimiento(tarifa.getImporteTarifa() + tarifaPolizaVigente.getImporteTarifa());
                        }
                    //**
                    }
                }

                if (contadorPolizasVigentes > 1 && poliza.getTipoMovimientoPoliza().equals("A")) {
                    //**Registro de altas consecutivas para poliza multiples
                    List polizasVigentes = polizaDao.consultaPolizasVigentes(numNominaContratante);
                    PolizaIndividual elemento = new PolizaIndividual();
                    Solicitud solicitudPolizaVigente = new Solicitud();
                    int cveTarifaPolizaVigente = 0;
                    TarifaAportMensual tarifaPolizaVigente = new TarifaAportMensual();
                    double acumImporteMovimientoEnvio = 0.00;
                    boolean banderaTipoMovimientoAlta = true;
                    double importeMovimiento = 0.0;
                    for (int i = 0; i < polizasVigentes.size(); i++) {
                        elemento = (PolizaIndividual) polizasVigentes.get(i);
                        /**
                         * Mantenimieto: Smart Sol Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                         */
                        solicitudPolizaVigente = (Solicitud) getSolicitudDao().
                        		obtenSolicitudPorFolioSolicitud(elemento.getFolioSolicitud(),elemento.getFormatoSolicitud());
                        cveTarifaPolizaVigente = solicitudPolizaVigente.getCveTarifa();
                        tarifaPolizaVigente = (TarifaAportMensual) getSolicitudDao().obtenTarifaMensualPorClaveTarifa(cveTarifaPolizaVigente);
                        acumImporteMovimientoEnvio = acumImporteMovimientoEnvio + tarifaPolizaVigente.getImporteTarifa();
                        if (elemento.getQnaProgEnvioMvtoPoliza()!= null && !elemento.getQnaProgEnvioMvtoPoliza().equals(poliza.getQnaProgEnvioMvtoPoliza())) {
                            banderaTipoMovimientoAlta = false;
                        }
                    }
                    importeMovimiento = acumImporteMovimientoEnvio + tarifa.getImporteTarifa();
                    if (banderaTipoMovimientoAlta = true) {
                        //**Cuando todas polizas tienen la misma qnaProgramadaEnvio
                        historial.setTipoMovimientoEnvio("A");
                        if (retenedor.getCveDescuento().equals("78")) {
                            historial.setTotalImporteMovimiento((tarifa.getImporteTarifa() + acumImporteMovimientoEnvio) * 2);
                        } else {
                            historial.setTotalImporteMovimiento(tarifa.getImporteTarifa() + acumImporteMovimientoEnvio);
                        }
                    } else {
                        //** Cuando las polizas no tienen la misma qnaProgramadaEnvio
                        historial.setTipoMovimientoEnvio("C");
                        if (retenedor.getCveDescuento().equals("78")) {
                            historial.setTotalImporteMovimiento((tarifa.getImporteTarifa() + acumImporteMovimientoEnvio) * 2);
                        } else {
                            historial.setTotalImporteMovimiento(tarifa.getImporteTarifa() + acumImporteMovimientoEnvio);
                        }
                    }
                }
            }
        }
       
        //int contadorPolizaIndicadorEnvioArchivo = getMovimientosDependenciaDAO().obtenerContadorPolizaConIndicadorEnvioArchivo(historial);
        int contadorPolizaIndicadorEnvioArchivo = movimientosDependenciaDAO.obtenerContadorPolizaConIndicadorEnvioArchivo(historial);
        if (contadorPolizaIndicadorEnvioArchivo > 0) {
            HistorialMovimientosContratante historialIndicadorEnvio = (HistorialMovimientosContratante) getMovimientosDependenciaDAO().obtenerPolizaConIndicadorEnvioArchivo(historial);
            getMovimientosDependenciaDAO().actualizarIndicadorEnvioArchivo(historialIndicadorEnvio);
        }
        if (poliza.getTipoMovimientoPoliza().equals("A") || poliza.getTipoMovimientoPoliza().equals("C")) {
            polizaDao.insertarPoliza(poliza);
            /**
             * Mantenimieto Smart Solutions: Febrero 20120 registrar los beneficios adicionales desde la primera captura
             */
            List<BeneficioAdicionalPoliza> listaBeneficios = new ArrayList<BeneficioAdicionalPoliza>();
            for(BeneficioAdicionalPoliza benef:datosPoliza.getBeneficiosPoliza()){
            	if(//benef.getSumaBeneficio() != null && benef.getSumaBeneficio()>0 &&
            			benef.getMontoCobertura() != null && benef.getMontoCobertura() > 0){
            		listaBeneficios.add(benef);
            	}
            }
            System.out.println("listaBeneficios "+listaBeneficios);
            poliza.setBeneficiosAdicionales(listaBeneficios);
             guardarBeneficiosAdicionales(poliza);
            
            
            /**
             * Mantenimieto: Smart Sol Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
             */
            polizaDao.actualizarSolicitud(folioSolicitud,formatoSolicitud);
            polizaDao.insertarHistorial(historial);

        } else {
            if (poliza.getTipoMovimientoPoliza().equals("B")) {
                polizaDao.insertarHistorial(historial);
            }
        }
    }

    @Override
    public void registrarAsegurado(RegistroPolizaCommand datosPoliza) {
        PolizaIndividual poliza = datosPoliza.getPolizaIndividual();
        Solicitud solicitud = poliza.getSolicitud();
        Solicitante solicitante = solicitud.getSolicitante();
        System.out.println("La colonia: "+solicitante.getColonia());
        Contratante contratante = solicitud.getContratante();
        getAseguradoDao().insertarAsegurado(solicitante, contratante, poliza);
    }

    @Override
    public void generarReportes(RegistroPolizaCommand datosPoliza) {
        PolizaIndividual poliza = datosPoliza.getPolizaIndividual();
        Solicitud solicitud = poliza.getSolicitud();
        int folioSolicitud = solicitud.getFolioSolicitud();
        String formatoSolicitud = solicitud.getFormatoSolicitud();
        int numCertificado = solicitud.getCertificadoindividual().getNumCertificado();
        int numPoliza = poliza.getNumPoliza();
        /**
         * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
         */
        String cvePlaza = getPolizaDao().obtenerPlaza(folioSolicitud,formatoSolicitud);
        
        /*Se suspende generacion del PDF certificado individual por cambio de producto 29/04/2010 ***CGB***
         String rutaReporteCertInd = reporteBusiness.generarReporteCertificadoIndividual(folioSolicitud, numPoliza, numCertificado, cvePlaza);*/
        //System.out.println("ruta rep cert: "+rutaReporteCertInd);
        String rutaReporteCartaRes = reporteBusiness.generarReporteCartaResumenPoliza(numCertificado, numPoliza, cvePlaza);
        //System.out.println("ruta rep carta res: "+rutaReporteCartaRes);
        String rutaReporteAcuse = reporteBusiness.generarReporteAcuseReciboPoliza(numCertificado, numPoliza, cvePlaza);
        //System.out.println("ruta rep acuse: "+rutaReporteAcuse);
        ReportesPDF reporteGenerado = new ReportesPDF();
        //reporteGenerado.setRutaReporteCertInd(rutaReporteCertInd);
        reporteGenerado.setRutaReporteCartaResumen(rutaReporteCartaRes);
        reporteGenerado.setRutaReporteAcuseRecibo(rutaReporteAcuse);
        datosPoliza.setReportesGenerados(reporteGenerado);
    }

    @Override
    public String generarReportes2(GenerarEntregaPolizaCommand datosPoliza) {
        PolizaIndividual poliza = datosPoliza.getPolizaIndividual();
        Solicitud solicitud = poliza.getSolicitud();
        int idEstatusPolizaSeguimiento = poliza.getIdEstatusPolizaSeguimiento();
        int cveAgente = solicitud.getCveAgente();
        
        String rutaReportePolizasEmitidas = reporteBusiness.generarReportePolizasEmitidas(cveAgente, idEstatusPolizaSeguimiento);
        ReportesPDF reporteGenerado = new ReportesPDF();
        reporteGenerado.setRutaReportePolizasEmitidas(rutaReportePolizasEmitidas);
        datosPoliza.setReportesGenerados2(reporteGenerado);
        return rutaReportePolizasEmitidas;
    }

    @Override
    public String generarReportes3(GenerarFormatoDescuentoCommand datosPoliza) {
    	String rutaFormatoDescuentoAsegurados = 
                reporteBusiness.
                    generarFormatoDescuentoAsegurados(
                        datosPoliza.getPolizaIndividual());
        ReportesPDF reporteGenerado = new ReportesPDF();
        reporteGenerado.setRutaFormatoDescuentoAsegurados(rutaFormatoDescuentoAsegurados);
        datosPoliza.setReportesGenerados3(reporteGenerado);
        return rutaFormatoDescuentoAsegurados;
    }

    @Override
    public String generarReportes4(GenerarFormatoAplicDescCommand datosPoliza) {
        PolizaIndividual poliza = datosPoliza.getPolizaIndividual();
        Solicitud solicitud = poliza.getSolicitud();
        int numPoliza = poliza.getNumPoliza();
        int numConsignatario = poliza.getNumConsignatario();
        
        String rutaFormatoAplicacionDescuentos = reporteBusiness.generarFormatoAplicacionDescuentos2(numPoliza,numConsignatario);
        ReportesPDF reporteGenerado = new ReportesPDF();
        reporteGenerado.setRutaFormatoAplicacionDescuentos(rutaFormatoAplicacionDescuentos);
        datosPoliza.setReportesGenerados4(reporteGenerado);
        return rutaFormatoAplicacionDescuentos;
    }

    @Override
    public String generarReportes5(ConsultaPolizaCommand datosPoliza) {
        PolizaIndividual poliza = datosPoliza.getPolizaIndividual();
        
        int numPoliza = poliza.getNumPoliza();
        int numConsignatario = poliza.getNumConsignatario();
        
        String rutaFormatoAplicacionDescuentos2 = reporteBusiness.generarFormatoAplicacionDescuentos2(numPoliza, numConsignatario);
        ReportesPDF reporteGenerado = new ReportesPDF();
        reporteGenerado.setRutaFormatoAplicacionDescuentos2(rutaFormatoAplicacionDescuentos2);
        datosPoliza.setReportesGenerados5(reporteGenerado);
        return rutaFormatoAplicacionDescuentos2;
    }

    //HEFS Consulta de polizas emitidas entregadas a los agenstes
    @Override
    public List obtenerPolizaEntregadaEmitidaAgente(String agente) {
        return getPolizaDao().obtenerPolizaEntregadaEmitidaAgente(agente);
    }

    @Override
    public Object obtenerPolizasPorFolioSolicitudNoCancelada(int folioSolicitud,String formatoSolicitud) {
        return(Object)polizaDao.obtenerPolizasPorFolioSolicitudNoCancelada(folioSolicitud,formatoSolicitud);
    }

   

    @Override
    public void actualizaEstatusPoliza(int poliza,int numConsignatario, int estatus) {
        PolizaIndividual polizaIndividual = new PolizaIndividual();
        polizaIndividual.setNumPoliza(poliza);
        polizaIndividual.setNumConsignatario(numConsignatario);
        polizaIndividual.setIdEstatusPolizaSeguimiento(estatus);
        polizaIndividual.setFechaEntregaAgente(new Date());
        getPolizaDao().actualizaEstatusPoliza(polizaIndividual);
    }

    @Override
    public void actualizaPolizaEntregadaAsegurado(int poliza,int numConsignatario, int estatus, String nombreReceptor, Date fechaRecepcion) {
        PolizaIndividual polizaIndividual = new PolizaIndividual();
        polizaIndividual.setNumPoliza(poliza);
        polizaIndividual.setNumConsignatario(numConsignatario);
        polizaIndividual.setIdEstatusPolizaSeguimiento(estatus);
        polizaIndividual.setNombrePersonaRecibe(nombreReceptor);
        polizaIndividual.setFechaRecepcionPoliza(fechaRecepcion);
        getPolizaDao().actualizaEstatusPoliza(polizaIndividual);
    }

    @Override
    public List obtenerPolizasPorEntregarAsegurado(String agente) {
        return getPolizaDao().obtenerPolizasPorEntregarAsegurado(agente);
    }

    @Override
    public ReportesPDF obtenerReportesGenerados(RegistroPolizaCommand datosPoliza) {
        return datosPoliza.getReportesGenerados();
    }

    @Override
    public ReportesPDF obtenerReportesGenerados2(GenerarEntregaPolizaCommand datosPoliza) {
        return datosPoliza.getReportesGenerados2();
    }

    @Override
    public ReportesPDF obtenerReportesGenerados3(GenerarFormatoDescuentoCommand datosPoliza) {
        return datosPoliza.getReportesGenerados3();
    }

    @Override
    public ReportesPDF obtenerReportesGenerados4(GenerarFormatoAplicDescCommand datosPoliza) {
        return datosPoliza.getReportesGenerados4();
    }

    @Override
    public ReportesPDF obtenerReportesGenerados5(ConsultaPolizaCommand datosPoliza) {
        return datosPoliza.getReportesGenerados5();
    }

    public void setPolizaDao(IPolizaDao polizaDao) {
        this.polizaDao = polizaDao;
    }

    public IPolizaDao getPolizaDao() {
        return polizaDao;
    }

    public IAseguradoDao getAseguradoDao() {
        return aseguradoDao;
    }

    public void setAseguradoDao(IAseguradoDao aseguradoDao) {
        this.aseguradoDao = aseguradoDao;
    }

    private String tipoSeguro(int cveTipoSeguro) {
        switch (cveTipoSeguro) {
            case 1:
                return "OV";
            case 2:
                return "T20";
            case 3:
                return "T20B";
            case 4:
                return "OV-SEVI";
            default:
                return "error en captura de tipo";
        }
    }

    private String estatusPoliza(int estatusPoliza) {
        switch (estatusPoliza) {
            case 1:
                return "Capturadas";
            case 2:
                return "Entregadas al agente";
            case 3:
                return "Entregadas al asegurado";
            case 4:
                return "En correcci&oacute;n";
            case 5:
                return "Suspendida por falta de pago";
            case 6:
                return "Cancelada";
            case 7:
                return "Autofinanciada";
            default:
                return "error en captura de tipo";
        }

    }

    @Override
    public void actualizaEstatusPolizaPago(int poliza,int numConsignatario, int estatus) {
        PolizaIndividual polizaIndividual = new PolizaIndividual();
        polizaIndividual.setNumPoliza(poliza);
        polizaIndividual.setNumConsignatario(numConsignatario);
        polizaIndividual.setIdEstatusPagosPoliza(estatus);
        getPolizaDao().actualizaEstatusPolizaPago(polizaIndividual);
        getPolizaDao().actualizarEstatusPolizaGeneral(poliza, numConsignatario, obtenerEstatusPolizaGeneral(estatus));
    }

    @Override
    public void actualizaEstatusPolizaSeguimiento(int poliza,int numConsignatario, int estatus) {
        PolizaIndividual polizaIndividual = new PolizaIndividual();
        polizaIndividual.setNumPoliza(poliza);
        polizaIndividual.setNumConsignatario(numConsignatario);
        polizaIndividual.setIdEstatusPolizaSeguimiento(estatus);
        getPolizaDao().actualizaEstatusPolizaSeguimiento(polizaIndividual);
    }

    @Override
    public void actualizaEstatusPolizaAmbos(int poliza,int numConsignatario, int estatusPago, int estatusSeguimiento) {
        PolizaIndividual polizaIndividual = new PolizaIndividual();
        polizaIndividual.setNumPoliza(poliza);
        polizaIndividual.setNumConsignatario(numConsignatario);
        polizaIndividual.setIdEstatusPolizaSeguimiento(estatusSeguimiento);
        polizaIndividual.setIdEstatusPagosPoliza(estatusPago);
        getPolizaDao().actualizaEstatusPolizaAmbos(polizaIndividual);
    }

    public IHistorialDao getHistorialDao() {
        return historialDao;
    }

    public void setHistorialDao(IHistorialDao historialDao) {
        this.historialDao = historialDao;
    }

    public ISolicitudDao getSolicitudDao() {
        return solicitudDao;
    }

    public void setSolicitudDao(ISolicitudDao solicitudDao) {
        this.solicitudDao = solicitudDao;
    }

    public IMovimientosDependenciaDAO getMovimientosDependenciaDAO() {
        return movimientosDependenciaDAO;
    }

    public void setMovimientosDependenciaDAO(IMovimientosDependenciaDAO movimientosDependenciaDAO) {
        this.movimientosDependenciaDAO = movimientosDependenciaDAO;
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.business.poliza.IPolizaBusiness#obtenerDetallePolizaPorNumero(int, int)
     */
    @Override
    public PolizaIndividual obtenerDetallePolizaPorNumero(int numPoliza,int emisor) {
    	PolizaIndividual poliza = polizaDao.obtenerDetallePolizaPorNumero(numPoliza,emisor);
    	if(poliza != null){
    		poliza.setBeneficiosAdicionales(
    				polizaDao.consultarBeneficiosAdicionalesDePoliza(numPoliza, emisor)
    				);
    	}
    
    	
        return poliza;
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.business.poliza.IPolizaBusiness#actualizarPolizaIndividual(mx.com.seguros.model.PolizaIndividual)
     */
	@Override
	public void actualizarPolizaIndividual(PolizaIndividual poliza) {
		
		polizaDao.actuzalizarPoliza(poliza);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#consultarCatalogoBeneficiosAdicionales()
	 */
	@Override
	public List<BeneficioAdicional> consultarCatalogoBeneficiosAdicionales() {
		return polizaDao.consultarCatalogoBeneficiosAdicionales();
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#consultarBeneficiosAdicionalesDePoliza(int, int)
	 */
	@Override
	public List<BeneficioAdicionalPoliza> consultarBeneficiosAdicionalesDePoliza(
			int numPoliza, int numConsignatario) {
		return polizaDao.consultarBeneficiosAdicionalesDePoliza(numPoliza, numConsignatario);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#eliminarBeneficiosAdicionalesDePoliza(int, int)
	 */
	@Override
	public void eliminarBeneficiosAdicionalesDePoliza(int numPoliza,
			int numConsignatario) {
		polizaDao.eliminarBeneficiosAdicionalesDePoliza(numPoliza, numConsignatario);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#guardarBeneficiosAdicionales(mx.com.seguros.model.PolizaIndividual)
	 */
	@Override
	public void guardarBeneficiosAdicionales(PolizaIndividual poliza) {
		double totalCosto = 0;
		double totalCobertura = 0;
		//System.out.println("poliza.getBeneficiosAdicionales: "+poliza.getBeneficiosAdicionales());
		for(BeneficioAdicionalPoliza beneficio:poliza.getBeneficiosAdicionales()){
			beneficio.setNumPoliza(poliza.getNumPoliza());
			beneficio.setNumConsignatario(poliza.getNumConsignatario());
			//totalCosto+=beneficio.getSumaBeneficio();
			totalCobertura+=beneficio.getMontoCobertura();
		}
		polizaDao.eliminarBeneficiosAdicionalesDePoliza(poliza.getNumPoliza(), poliza.getNumConsignatario());
		polizaDao.guardarBeneficiosAdicionales(poliza.getBeneficiosAdicionales());
		//actualizar total de tarifa y total suma asegurada
		
		
		Solicitud solicitud = (Solicitud)solicitudDao.obtenSolicitudPorFolioSolicitud(poliza.getFolioSolicitud(), poliza.getFormatoSolicitud());
		TarifaAportMensual tarifa = (TarifaAportMensual)solicitudDao.obtenTarifaMensualPorClaveTarifa(solicitud.getCveTarifa());
		//solicitud.setTarifa();
		solicitud.setTarifaTotal(totalCosto + tarifa.getImporteTarifa());
		solicitudDao.actualizarTarifaTotal(solicitud);
		
		//actualización del total de proteccion:
		/*
		 * Formato: F-278-2  = sumaAseguradaIndividual + suma asegurada colectiva + beneficios adicionales
		 * Formato: F-2111-1 = sumaAseguradaIndividual + SEVI + Gastos Funerarios + BAF + Beneficios Adicionales
		 */
		if(Solicitud.FORMATOS_SOLICITUD[0].equals(poliza.getFormatoSolicitud())){
			poliza.setSumaAseguradaTotal(
						poliza.getSumaAseguradaIndividual() + 
						(solicitud.getTarifa()!=null && solicitud.getTarifa().getPrimaMensualSeguroColectivo() != null ?
								solicitud.getTarifa().getPrimaMensualSeguroColectivo().getSumaAseguradaColectiva():0.0) +
						totalCobertura
					);
		}else{
			poliza.setSumaAseguradaTotal(
					poliza.getSumaAseguradaIndividual() + 
					poliza.getSumaSEVI() + poliza.getSumaGastosFunerarios() + 
					(poliza.getSumaBAF() != null ?poliza.getSumaBAF():0.0) 
					+ totalCobertura
				);
		}
		polizaDao.actualizarSumaAseguradaTotal(poliza);
	}
	/**
	 * @return the reporteBusiness
	 */
	public ReporteBusiness getReporteBusiness() {
		return reporteBusiness;
	}

	/**
	 * @param reporteBusiness the reporteBusiness to set
	 */
	public void setReporteBusiness(ReporteBusiness reporteBusiness) {
		this.reporteBusiness = reporteBusiness;
	}
	
	//Smart Solutions dciembre 2011
	//Integración del módulo de pagos
	public PolizaIndividual findPolizaById(PolizaIndividual poliza) {
        Integer numPoliza;
        Integer numConsignatario;

        numPoliza = poliza.getNumPoliza();
        numConsignatario = poliza.getNumConsignatario();

        return findPolizaById(numPoliza, numConsignatario);
    }
	
	public PolizaIndividual findPolizaById(Integer numPoliza, Integer numConsignatario) {
        PolizaIndividual poliza;
        poliza = new PolizaIndividual();
        poliza.setNumPoliza(numPoliza);
        poliza.setNumConsignatario(numConsignatario);
        poliza = polizaDao.obtenerPolizaById(poliza);
        if (poliza == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No se ha encontrado la p\u00F3liza con numPoliza = ");
            sb.append(numPoliza);
            sb.append(" y numConsignatario = ");
            sb.append(numConsignatario);
            throw new PolizaBusinessException(sb.toString());
        }
        return poliza;

    }
	
	@Override
    public List<PolizaIndividual> obtenerPolizasVigentesContratante(String numNominaContratante, Date fechaLimiteCarga) {
            	List<PolizaIndividual> polizasVigentes;
		polizasVigentes = polizaDao
				.consultaPolizasVigentesNew(numNominaContratante, fechaLimiteCarga);
		return polizasVigentes;

    }
	@Override
    public void insertarFechaPrimerIntentoPago(PolizaIndividual poliza, Integer qnaPrimerIntentoPago) {
        polizaDao.insertarQnaPrimerIntentoPago(poliza, qnaPrimerIntentoPago);
    }
	@Override
    public Integer recuperarQnaPrimerIntentoPago(PolizaIndividual poliza) {
        return polizaDao.recuperarQnaPrimerIntentoPago(poliza);
    }
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#consultarEstatusPolizaSeguimiento()
	 */
	@Override
	public List<EstatusPolizaSeguimiento> consultarEstatusPolizaSeguimiento() {
		return estatusPolizaSeguimientoDao.consultarEstatusPolizaSeguimiento();
	}

	/**
	 * @param estatusPolizaSeguimientoDao the estatusPolizaSeguimientoDao to set
	 */
	public void setEstatusPolizaSeguimientoDao(
			EstatusPolizaSeguimientoDao estatusPolizaSeguimientoDao) {
		this.estatusPolizaSeguimientoDao = estatusPolizaSeguimientoDao;
	}

	/**
	 * @param estatusPolizaPagosDao the estatusPolizaPagosDao to set
	 */
	public void setEstatusPolizaPagosDao(EstatusPolizaPagosDao estatusPolizaPagosDao) {
		this.estatusPolizaPagosDao = estatusPolizaPagosDao;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#consultarEstatusPolizaPagos()
	 */
	@Override
	public List<EstatusPolizaPagos> consultarEstatusPolizaPagos() {
		return estatusPolizaPagosDao.consultarEstatusPolizaPagos();
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#registrarPolizaCompleto(mx.com.seguros.web.poliza.RegistroPolizaCommand)
	 */
	@Override
	public void registrarPolizaCompleto(RegistroPolizaCommand datosPoliza) {
		 registrarPoliza(datosPoliza);
	     registrarAsegurado(datosPoliza);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#obtenerCatalogTipoTramite()
	 */
	@Override
	public List<TipoTramite> obtenerCatalogTipoTramite() {
		return tramitePolizaDao.obtenerCatalogTipoTramite();
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#obtenerTipoTramitePorId(java.lang.Integer)
	 */
	@Override
	public TipoTramite obtenerTipoTramitePorId(Integer idTipoTramite) {
		return tramitePolizaDao.obtenerTipoTramitePorId(idTipoTramite);
	}	
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#obtenerTramitesDePoliza(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<TramitePoliza> obtenerTramitesDePoliza(Integer numPoliza,Integer numConsignatario) {
		return tramitePolizaDao.obtenerTramitesDePoliza(numPoliza, numConsignatario);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#insertarTramitePoliza(mx.com.seguros.model.TramitePoliza)
	 */
	@Override
	public void insertarTramitePoliza(TramitePoliza tramite) {
		tramitePolizaDao.insertarTramitePoliza(tramite);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#obtenerCatalogOficinas()
	 */
	@Override
	public List<Oficina> obtenerCatalogOficinas() {
		return tramitePolizaDao.obtenerCatalogOficinas();
	}

	/**
	 * @param tramitePolizaDao the tramitePolizaDao to set
	 */
	public void setTramitePolizaDao(TramitePolizaDao tramitePolizaDao) {
		this.tramitePolizaDao = tramitePolizaDao;
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#actualizarTarifaTotalPoliza(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public double actualizarTarifaTotalPoliza(Integer numPoliza,Integer numConsignatario,String cveUsuario) {
		
		PolizaIndividual pol = new PolizaIndividual(numPoliza,numConsignatario); 
		Solicitud solBD = null;
		double tarifaTotalAnt = 0;
		double tarifaTotal = 0;
		double totalBeneficios = 0;
        double totalTarifaBeneficio = 0;
		pol = polizaDao.obtenerPolizaById(pol);
		if(pol != null){
			solBD = solicitudDao.obtenerDetalleSolicitudPorFolio(pol.getFolioSolicitud(), pol.getFormatoSolicitud());
		}
		if(pol != null && solBD != null){
			//Tarifa base
			tarifaTotal = solBD.getTarifa().getImporteTarifa();
			//Beneficios adicionales
			List<BeneficioAdicionalPoliza> beneficios = polizaDao.consultarBeneficiosAdicionalesDePoliza(numPoliza,numConsignatario);
            if(beneficios!= null){
            	for(BeneficioAdicionalPoliza benef:beneficios){
                	totalBeneficios+=benef.getMontoCobertura()!=null?benef.getMontoCobertura():0;
                	totalTarifaBeneficio+=benef.getSumaBeneficio()!=null?benef.getSumaBeneficio():0;
                }
            }
            tarifaTotal+=totalTarifaBeneficio;
            
			//productos adicionales
            ProductosInburnomina productos = productosInburnominaDao.consultarProductosInburnominaDePoliza(numPoliza, numConsignatario);
            if(productos != null){
            	tarifaTotal += productos.getTotalPrimaQuincenal();
            }
            
            tarifaTotalAnt = solBD.getTarifaTotal()!=null?solBD.getTarifaTotal():0;
            solBD.setTarifaTotal(tarifaTotal);
            solicitudDao.actualizarTarifaTotal(solBD);
    		
            if(tarifaTotalAnt != tarifaTotal){
            	//insertar historico
            	HistoricoTarifa historico = new HistoricoTarifa();
    	    	historico.setCveTarifa(solBD.getCveTarifa());
    	    	historico.setFechaFin(new Date());
    	    	historico.setUsuario(cveUsuario);
    	    	historico.setTarifaTotal(tarifaTotalAnt);
    	    	historico.setFolioSolicitud(solBD.getFolioSolicitud());
    	    	historico.setFormatoSolicitud(solBD.getFormatoSolicitud());
    	    	solicitudDao.insertarHistoricoTarifa(historico);
            }
            
    		//actualización del total de proteccion:
    		/*
    		 * Formato: F-278-2  = sumaAseguradaIndividual + suma asegurada colectiva + beneficios adicionales
    		 * Formato: F-2111-1 = sumaAseguradaIndividual + SEVI + Gastos Funerarios + BAF + Beneficios Adicionales
    		 */
    		if(Solicitud.FORMATOS_SOLICITUD[0].equals(solBD.getFormatoSolicitud())){
    			pol.setSumaAseguradaTotal(
    					pol.getSumaAseguradaIndividual() + 
    						(solBD.getTarifa()!=null && solBD.getTarifa().getPrimaMensualSeguroColectivo() != null ?
    								solBD.getTarifa().getPrimaMensualSeguroColectivo().getSumaAseguradaColectiva():0.0) +
    								totalBeneficios
    					);
    		}else{
    			pol.setSumaAseguradaTotal(
    					pol.getSumaAseguradaIndividual() + 
    					pol.getSumaSEVI() + pol.getSumaGastosFunerarios() + 
    					(pol.getSumaBAF() != null ?pol.getSumaBAF():0.0) 
    					+ totalBeneficios
    				);
    		}
    		polizaDao.actualizarSumaAseguradaTotal(pol);
            
		}
		

		
		return tarifaTotal;
	}

	/**
	 * @param productosInburnominaDao the productosInburnominaDao to set
	 */
	public void setProductosInburnominaDao(
			IProductosInburnominaDao productosInburnominaDao) {
		this.productosInburnominaDao = productosInburnominaDao;
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#obtenerEstatusPolizaGeneral()
	 */
	@Override
	public List<EstatusPolizaGeneral> consultarEstatusPolizaGeneral() {
		return polizaDao.obtenerEstatusPolizaGeneral();
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#actualizarPolizaAtencionClientes(mx.com.seguros.model.PolizaIndividual)
	 */
	@Override
	public void actualizarDatosPolizaAtencionClientes(PolizaIndividual poliza) {
		polizaDao.actualizarDatosPolizaAtencionClientes(poliza);
		poliza.setIdEstatusPolizaGeneral(obtenerEstatusPolizaGeneral(poliza.getIdEstatusPagosPoliza()));
		polizaDao.actualizarEstatusPolizaGeneral(poliza.getNumPoliza(), poliza.getNumConsignatario(), poliza.getIdEstatusPolizaGeneral());
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.poliza.IPolizaBusiness#obtenerEstatusPolizaGeneral(int)
	 */
	@Override
	public Integer obtenerEstatusPolizaGeneral(int idEstatusPolizaPago) {
		Integer estatus = null;
		if(ConstantesGenerales.ESTATUS_PAGOS_POLIZA_SIN_PAGOS_APLICADOS == idEstatusPolizaPago ||
				ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_CLIENTE == idEstatusPolizaPago ||
				ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_FALTA_DE_PAGO == idEstatusPolizaPago ||
				ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_SUSTITUCION == idEstatusPolizaPago){
			estatus = ConstantesGenerales.ESTATUS_POLIZA_GENERAL_CANCELADA;
		}else{
			estatus = ConstantesGenerales.ESTATUs_POLIZA_GENERAL_VIGENTE;
		}
		return estatus;
	}

	@Override
	public List<Plaza> consultarPlazas() {
		return polizaDao.consultarPlazas();
	}

	@Override
	public List<TramitePoliza> obtenerTramitesDePoliza(Date fechaInicial, Date fechaFinal, Integer Oficina) {
		return tramitePolizaDao.obtenerTramitesDePoliza( fechaInicial,  fechaFinal,  Oficina);
	}
	
	
}
