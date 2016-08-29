/*
 * DescuentosBusiness.java
 *
 * Created on 1 de febrero de 2008, 02:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package mx.com.seguros.business.descuentos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.reporte.ReporteBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.data.dao.IDescuetosAplicadosDao;
import mx.com.seguros.model.ArchivosDescuentosCargados;
import mx.com.seguros.model.DescuentosAplicados;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.utils.GeneraXLS;

import mx.com.seguros.utils.DateUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author Capacitacion
 */
public class DescuentosBusiness {

	private static final Logger log  = Logger.getLogger(DescuentosBusiness.class);
    private IPolizaBusiness polizaBusiness;
    private ISolicitudBusiness solicitudBusiness;
    private IDescuetosAplicadosDao descuentosAplicadosDao;
    private int archivoRechazos;
    final int QUINCENA_ARCHIVO = 0;
    final int NUM_NOMINA_CONTRATANTE = 1;
    final int DESCUENTO_APLICADO = 2;
    final int FECHA_DEPOSITO_DEPENDENCIA = 3;
    private String error;
    private ArrayList listaRechazos = new ArrayList();
    //estatus poliza
    final int AUTOFINANCIADA_PAGOS_INSUFICIENTES = 3;
    final int AUTOFINANCIADA_CANCELACION = 4;
    final int PAGOS_SUSPENDIDOS = 7;
    final int CANCELADA_FALTA_PAGOS = 7;
    final int NORMAL = 2;
    final int CANCELADA = 7;
    int valor = 0;
    private int fechDepIncorrecta = 0;

    public void calculoDescuentosAplicadosPorSolicitante(ArrayList fila, ArchivosDescuentosCargados archivo) {
        double impDescuentoAplicadoPoliza = 0;
        double impAhorroReal = 0;
        double impDescuentoAplicadoGlobal = 0;
        double impRealPagoPrima = 0;
        double remanenteDescuentoAplicadoGlobal = 0;
        int diferenciaQuincena = 0;
        int numQuincenaPagada = 0;
        int numPagosNoRegistrados = 0;
        int numQuincenasAtrasadas = 0;
        double importeDescuentoAplicadoGlobalAux = 0;
        double impDescReportado = 0;
        Date fechaDepositoDep = null;
        double ultimoImportePagoPrima = 0.00;

        String numNominaContratante = fila.get(NUM_NOMINA_CONTRATANTE).toString();
        List listaSolicitudes = solicitudBusiness.obtenSolicitudPorEstatusYnumNominaContratante(2, numNominaContratante);
        //si la lista de solicitudes esta vacia evaluamos si tiene solicitudes con cualquier estatus para sabes si no hay capturadas
        if (listaSolicitudes.isEmpty()) {
            //evaluamos si hay solicitudes de cualquier estatus y agregamos el registro a la lista de rechazos
            List listaSolicitudesRechazo = solicitudBusiness.obtenSolicitudPorEstatusYnumNominaContratante(-1, numNominaContratante);
            if (listaSolicitudesRechazo.isEmpty()) {
                registroRechazos(fila.get(QUINCENA_ARCHIVO).toString(), fila.get(NUM_NOMINA_CONTRATANTE).toString(), "No hay solicitudes con el RFC proporcionado");
            } else {
                registroRechazos(fila.get(QUINCENA_ARCHIVO).toString(), fila.get(NUM_NOMINA_CONTRATANTE).toString(), "No existen polizas capturadas para las solicitudes encontradas");
            }
        } else {
            for (int i = 0; i < listaSolicitudes.size(); i++) {
                Solicitud solicitud = (Solicitud) listaSolicitudes.get(i);
                
                PolizaIndividual poliza = (PolizaIndividual) polizaBusiness.obtenerPolizasPorFolioSolicitudNoCancelada(solicitud.getFolioSolicitud(),solicitud.getFormatoSolicitud());
                if (poliza!=null) {
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    TarifaAportMensual tarifa = (TarifaAportMensual) solicitudBusiness.obtenTarifaMensualPorClaveTarifa(solicitud.getCveTarifa());

                    if (remanenteDescuentoAplicadoGlobal > 0) {
                        impDescuentoAplicadoGlobal = remanenteDescuentoAplicadoGlobal;
                    } else {
                        impDescuentoAplicadoGlobal = Double.parseDouble(fila.get(DESCUENTO_APLICADO).toString());
                    }

                    impDescReportado = Double.parseDouble(fila.get(DESCUENTO_APLICADO).toString());
                    numQuincenaPagada = Integer.parseInt(fila.get(QUINCENA_ARCHIVO).toString());
                    try {
                        fechaDepositoDep = df.parse((String) fila.get(FECHA_DEPOSITO_DEPENDENCIA));
                        setFechDepIncorrecta(0);
                    } catch (ParseException ex) {
                        log.error("", ex);
                        setFechDepIncorrecta(1);
                        break;
                    }
                    List listaDescuentos = obtenDescuentosPorPoliza(poliza.getNumPoliza(), poliza.getNumConsignatario());

                    //si no existe el ultimo descuento
                    if (listaDescuentos == null || listaDescuentos.isEmpty()) {
                        impRealPagoPrima = tarifa.getImporteTarifa();
                        impDescuentoAplicadoPoliza = impDescuentoAplicadoGlobal;
                        /*if(impDescuentoAplicadoGlobal<=impRealPagoPrima){
                        impDescuentoAplicadoPoliza=impDescuentoAplicadoGlobal;
                        // } else{
                        impDescuentoAplicadoPoliza=impRealPagoPrima+impDescuentoAplicadoGlobal;
                        }*/

                        impAhorroReal = impDescuentoAplicadoPoliza - tarifa.getImporteTarifa();
                        remanenteDescuentoAplicadoGlobal = impDescuentoAplicadoGlobal - impDescuentoAplicadoPoliza;


                        if (remanenteDescuentoAplicadoGlobal > 0) {
                            if (listaSolicitudes.size() > 1) {
                                impAhorroReal = impDescuentoAplicadoPoliza - tarifa.getImporteTarifa();
                                impDescuentoAplicadoGlobal = remanenteDescuentoAplicadoGlobal;
                            } else if (listaSolicitudes.size() == 1) {
                                impAhorroReal = remanenteDescuentoAplicadoGlobal;
                            }
                        }
                        //insertamos el descuento
                        insertarDescuentoAplicado(poliza.getNumPoliza(),
                                Integer.parseInt(fila.get(QUINCENA_ARCHIVO).toString()),
                                impDescuentoAplicadoPoliza, impRealPagoPrima, impAhorroReal,
                                Integer.parseInt(fila.get(QUINCENA_ARCHIVO).toString()), archivo, impDescReportado, fechaDepositoDep,
                                poliza.getNumConsignatario());

                        actualizaEstatusPoliza(poliza.getNumPoliza(),poliza.getNumConsignatario());
                    } //si existen descuentos
                    else {
                        DescuentosAplicados descuentoAplicado = (DescuentosAplicados) listaDescuentos.get(0);
                        ultimoImportePagoPrima = descuentoAplicado.getImpRealPagoPrima();
                        diferenciaQuincena = numQuincenaPagada - descuentoAplicado.getNumQuincenaPagada();
                        System.out.println("DIFERENCIA QUINCENA" + diferenciaQuincena);
                        System.out.println("numQuincenaPagada" + numQuincenaPagada);
                        System.out.println("Descuento aplicado quincena pagada" + descuentoAplicado.getNumQuincenaPagada());
                        if (diferenciaQuincena > 77) {

                            String numQuincenaUltimoDescString = String.valueOf(descuentoAplicado.getNumQuincenaPagada());
                            String quincenaString = numQuincenaUltimoDescString.substring(4, 6);
                            System.out.println("QUINCENA STRING" + quincenaString);
                            int numQuincenaUltimoDescInt = Integer.parseInt(quincenaString);
                            System.out.println("NUM QUINCENAULTIMO DESCUENTO" + numQuincenaUltimoDescInt);
                            int numQuincenaPagadaAEvaluar1 = 24 - numQuincenaUltimoDescInt;
                            System.out.println("NUM QUINCENA ULTIMO DES A EVALUAR 1" + numQuincenaPagadaAEvaluar1);
                            String numQuincenaPagadaString = String.valueOf(numQuincenaPagada);
                            System.out.println("NUM QUINCENA PAGADA STRING" + numQuincenaPagadaString);
                            int numQuincenaPagadaInt = Integer.parseInt(numQuincenaPagadaString.substring(4, 6));
                            System.out.println("NUM QUINCENA PAGADA INT" + numQuincenaPagadaInt);
                            int numQuincenaPagadaAEvaluar2 = numQuincenaPagadaInt - 1;
                            System.out.println("NUM QUINCENA PAGADA EVALUAR" + numQuincenaPagadaAEvaluar2);
                            diferenciaQuincena = numQuincenaPagadaAEvaluar1 + numQuincenaPagadaAEvaluar2;
                            System.out.println("DIFERENCIA QUINCENA DESPUES DE IF" + diferenciaQuincena);
                        }
                        if (diferenciaQuincena == 1 || diferenciaQuincena == 77) {
                            valor = 0;
                            System.out.println("if diferencia quincena = 1");

                            double importeRealPagoPrimaAux = ultimoImportePagoPrima;
                            double tarifaAux = tarifa.getImporteTarifa();

                            if (importeRealPagoPrimaAux == tarifaAux) {
                                System.out.println("if de descuento aplicado = tarifa");
                                impRealPagoPrima = 0;
                                if (impDescuentoAplicadoGlobal >= tarifaAux) {
                                    System.out.println("if imp desc Aplicado >= a tarifa");
                                    impDescuentoAplicadoPoliza = impDescuentoAplicadoGlobal;
                                } else {
                                    impDescuentoAplicadoPoliza = impDescuentoAplicadoGlobal;
                                }
                            } else {
                                System.out.println("else descuento aplicado = tarifa");
                                impRealPagoPrima = tarifaAux;
                                System.out.println("VALOR EN EL ELSE descuento aplicado = tarifa  " + valor);
                                if (valor == 1) {

                                    impDescuentoAplicadoGlobal = importeDescuentoAplicadoGlobalAux;
                                    System.out.println("DESPUES DE LA ASIGNACION DE VALOR " + impDescuentoAplicadoGlobal);
                                }
                                if (impDescuentoAplicadoGlobal <= tarifaAux) {
                                    System.out.println("DESPUES DE LA ASIGNACION DE VALOR SI != DE 1 " + impDescuentoAplicadoGlobal);
                                    System.out.println("if de impDescuentoAplicadoGlobal < tarifa");
                                    impDescuentoAplicadoPoliza = impDescuentoAplicadoGlobal;
                                } else {
                                    System.out.println("else de impDescuentoAplicadoGlobal <= tarifa");
                                    if (listaSolicitudes.size() > 1 && i < listaSolicitudes.size()) {
                                        impDescuentoAplicadoPoliza = tarifaAux;
                                    } else {
                                        impDescuentoAplicadoPoliza = impDescuentoAplicadoGlobal;
                                    }

                                }
                            }
                            impAhorroReal = impDescuentoAplicadoPoliza - impRealPagoPrima;
                            remanenteDescuentoAplicadoGlobal = impDescuentoAplicadoGlobal - impDescuentoAplicadoPoliza;
                            if (remanenteDescuentoAplicadoGlobal > 0) {
                                System.out.println("if del remanenteDescuentoAplicadoGlobal >0");
                                if (listaSolicitudes.size() > 1 && i < listaSolicitudes.size()) {
                                    System.out.println(" if de lista de solicitudes > 1");
                                    //impAhorroReal = impDescuentoAplicadoPoliza - tarifaAux;
                                    impDescuentoAplicadoGlobal = remanenteDescuentoAplicadoGlobal;
                                } else {
                                    System.out.println(" else de lista de solicitudes > 1");
                                    impAhorroReal = remanenteDescuentoAplicadoGlobal;
                                }
                            }
                            // numQuincenaPagada=archivo.getNumQuincena();
                            insertarDescuentoAplicado(poliza.getNumPoliza(),
                                    Integer.parseInt(fila.get(QUINCENA_ARCHIVO).toString()), impDescuentoAplicadoPoliza,
                                    impRealPagoPrima, impAhorroReal, numQuincenaPagada, archivo, impDescReportado, fechaDepositoDep,
                                    poliza.getNumConsignatario());

                            actualizaEstatusPoliza(poliza.getNumPoliza(),poliza.getNumConsignatario());

                            if (impDescuentoAplicadoGlobal == (impRealPagoPrima + impAhorroReal)) {
                                System.out.println("if de impDescuentoAplicadoGlobal == (impRealPagoPrima+impAhorroReal) ");
                                remanenteDescuentoAplicadoGlobal = 0;
                            }
                        } //Si la quincena es diferente de 0
                        else {
                            System.out.println("else diferencia quincena = 1");
                            double tarifaAux2 = tarifa.getImporteTarifa();
                            numPagosNoRegistrados = diferenciaQuincena;
                            int numQuincenasAtrasadas2 = 0;

                            for (int pagoPendiente = 1; pagoPendiente <= numPagosNoRegistrados; pagoPendiente++) {
                                if (pagoPendiente == 1) {
                                    ultimoImportePagoPrima = descuentoAplicado.getImpRealPagoPrima();
                                    System.out.println("ULTIMO IMPORTE PAGO PRIMA  " + ultimoImportePagoPrima);
                                } else {
                                    System.out.println("ELSE DE PAGO PENDIENTE = 1");
                                    DescuentosAplicados descuentoAplicadoAux = new DescuentosAplicados();
                                    descuentoAplicadoAux.setNumPoliza(poliza.getNumPoliza());
                                    descuentoAplicadoAux.setNumQuincenaPagada(numQuincenasAtrasadas2);
                                    DescuentosAplicados descuentoAux2 = new DescuentosAplicados();
                                    descuentoAux2 = (DescuentosAplicados) descuentosAplicadosDao.obtenerUltimoImporteRealPagoPrima(descuentoAplicadoAux);
                                    ultimoImportePagoPrima = descuentoAux2!=null?descuentoAux2.getImpRealPagoPrima():0.0;
                                }
                                if (ultimoImportePagoPrima == tarifaAux2) {
                                    System.out.println("if ultimoImportePagoPrima == tarifa");
                                    impRealPagoPrima = 0;
                                    if (impDescuentoAplicadoGlobal <= tarifaAux2) {
                                        System.out.println("if impDescuentoAplicadoGlobal <=tarifa");
                                        impDescuentoAplicadoPoliza = impDescuentoAplicadoGlobal;
                                    } else {
                                        System.out.println("else impDescuentoAplicadoGlobal <=tarifa");
                                        impDescuentoAplicadoPoliza = tarifaAux2;
                                    }
                                } else {
                                    System.out.println("else ultimoImportePagoPrima == tarifa");
                                    impRealPagoPrima = tarifaAux2;
                                    if (impDescuentoAplicadoGlobal <= tarifaAux2) {
                                        System.out.println("if impDescuentoAplicadoGlobal <=tarifa");
                                        impDescuentoAplicadoPoliza = impDescuentoAplicadoGlobal;
                                    } else {
                                        System.out.println("else impDescuentoAplicadoGlobal <=tarifa");
                                        impDescuentoAplicadoPoliza = tarifaAux2;
                                    }
                                }
                                impAhorroReal = impDescuentoAplicadoPoliza - impRealPagoPrima;

                                if (poliza.getIdEstatusPagosPoliza() == AUTOFINANCIADA_CANCELACION) {
                                    System.out.println("if de poliza Autofinanciada x cancelacion");
                                    impAhorroReal = impDescuentoAplicadoPoliza;
                                    impRealPagoPrima = 0;
                                }

                                remanenteDescuentoAplicadoGlobal = impDescuentoAplicadoGlobal - impDescuentoAplicadoPoliza;

                                if (remanenteDescuentoAplicadoGlobal == 0) {
                                    impDescuentoAplicadoGlobal = 0;
                                }
                                if (remanenteDescuentoAplicadoGlobal > 0) {
                                    System.out.println("if remanenteDescuentoAplicadoGlobal >0");
                                    //importeAhorroReal=importeDescuentoAplicadoPoliza+remanenteDescuentoAplicadoGlobal;}
                                    if (pagoPendiente == numPagosNoRegistrados) {
                                        System.out.println("if pagoPendiente==numPagosNoRegistrados");
                                        if (listaSolicitudes.size() > 1) {
                                            System.out.println("B if de listaSolicitudes >1");
                                            impAhorroReal = impAhorroReal + (impDescuentoAplicadoPoliza - tarifaAux2);
                                        }
                                        if (listaSolicitudes.size() == 1) {
                                            System.out.println("B if de listaSolicitudes >1");
                                            impAhorroReal = impAhorroReal + remanenteDescuentoAplicadoGlobal;
                                            impDescuentoAplicadoPoliza = impAhorroReal;
                                        }
                                    }
                                    /*  else{
                                    System.out.println("else pagoPendiente==numPagosNoRegistrados");
                                    impAhorroReal=0;
                                    }*/
                                    impDescuentoAplicadoGlobal = remanenteDescuentoAplicadoGlobal;

                                }

                                //suma1=numQuincenasAtrasadas
                                numQuincenasAtrasadas = descuentoAplicado.getNumQuincenaPagada() + pagoPendiente;
                                String numQuincenasAtrasadasString = String.valueOf(numQuincenasAtrasadas);
                                String substringnumQuincenasAtrasadasString = numQuincenasAtrasadasString.substring(4, 6);

                                int substringnumQuincenasAtrasadasInt = Integer.parseInt(substringnumQuincenasAtrasadasString);
                                if (substringnumQuincenasAtrasadasInt > 24) {
                                    int difSubString = substringnumQuincenasAtrasadasInt - 24;
                                    if (difSubString == 1) {
                                        numQuincenasAtrasadas2 = numQuincenasAtrasadas + 76;
                                        System.out.println("NUMQUINCENAS ATRASADAS   " + numQuincenasAtrasadas2);
                                    } else {
                                        numQuincenasAtrasadas2 = numQuincenasAtrasadas2 + 1;
                                    }
                                } else {
                                    numQuincenasAtrasadas2 = numQuincenasAtrasadas;
                                    System.out.println("ELSE DE substringnumQuincenasAtrasadasInt > 24   " + numQuincenasAtrasadas2);
                                }
                                insertarDescuentoAplicado(poliza.getNumPoliza(),
                                        Integer.parseInt(fila.get(QUINCENA_ARCHIVO).toString()), impDescuentoAplicadoPoliza,
                                        impRealPagoPrima, impAhorroReal, numQuincenasAtrasadas2, archivo, impDescReportado, fechaDepositoDep,
                                        poliza.getNumConsignatario());
                                ultimoImportePagoPrima = impRealPagoPrima;
                            }
                            importeDescuentoAplicadoGlobalAux = impDescuentoAplicadoGlobal;
                            //System.out.println("ULTIMO IMPORTE AUXILIAR  " + importeDescuentoAplicadoGlobalAux);
                            valor = 1;
                            //System.out.println("VALOOOOOOOOOOO " + valor);
                            //System.out.println("SE ACABO EL JODIDO FOOOOOOOOOOOOOOORRRRRRRRR  " + numQuincenasAtrasadas2);
                            //if(importeDescuentoAplicadoGlobal==(importeRealPagoPrima+importeAhorroReal))
                            //        remanenteDescuentoAplicadoGlobal=0;
                            actualizaEstatusPoliza(poliza.getNumPoliza(),poliza.getNumConsignatario());
                        }

                    }
                }


            }

        }



    }

    private ArchivosDescuentosCargados obtenDatosArchivo(ArrayList fila) {
        String idArchivo = fila.get(0).toString();
        Calendar calendario = new GregorianCalendar();
        ArchivosDescuentosCargados archivoCargado = new ArchivosDescuentosCargados();
        archivoCargado.setFechaCarga(calendario.getTime());
        Integer numQuincena = Integer.parseInt(idArchivo.substring(0, 6));
        archivoCargado.setNumQuincena(numQuincena);
        //Integer ultimoConsecutivo = obtenUltimoConsecutivoArchivo(numQuincena);
        /*if(ultimoConsecutivo == null){
        ultimoConsecutivo = 1;
        }
        else{
        ultimoConsecutivo = ultimoConsecutivo++;
        }*/
        archivoCargado.setConsecutivoArchivo(obtenUltimoConsecutivoArchivo(numQuincena));
        archivoCargado.setCveRetenedor(idArchivo.substring(6));
        return archivoCargado;
    }

    public void actualizaEstatusPoliza(int idPoliza, int numConsignatario) {
        List listaDescuentosPoliza = obtenDescuentosPorPoliza(idPoliza,numConsignatario);
        double totalAhorroReal = 0;
        double totalPagoPrimaReal = 0;
        int residuoPagosPares = 0;
        int numPagosNoEfectuados = 0;

        for (int i = 0; i < listaDescuentosPoliza.size(); i++) {
            DescuentosAplicados descuentoAplicado = (DescuentosAplicados) listaDescuentosPoliza.get(i);
            if (listaDescuentosPoliza.size() == 1) {
                if (descuentoAplicado.getImpRealAhorro() < 0) {
                    actualizaEstatusPagoAutofinanciada(idPoliza, numConsignatario);
                } else {
                    actualizaEstatusPagoNormal(idPoliza, numConsignatario);
                }
            } else {
                totalAhorroReal = totalAhorroReal + descuentoAplicado.getImpRealAhorro();
                totalPagoPrimaReal = totalPagoPrimaReal + descuentoAplicado.getImpRealPagoPrima();
                //si el descuento aplicado es el ultimo de la lista
                if ((i + 1) == listaDescuentosPoliza.size()) {
                    if (totalAhorroReal != totalPagoPrimaReal) {
                        if (totalAhorroReal < totalPagoPrimaReal) {
                            if (totalAhorroReal >= 0) {
                                residuoPagosPares = listaDescuentosPoliza.size() % 2;
                                if (residuoPagosPares <= 0) {
                                    actualizaEstatusPagoAutofinanciada(idPoliza, numConsignatario);
                                }
                            } else {
                                numPagosNoEfectuados = descuentoAplicado.getNumQuincenaArchivo() - descuentoAplicado.getNumQuincenaPagada();
                                if (numPagosNoEfectuados >= 4) {
                                    actualizaEstatusPagoCanceladaPorPago(idPoliza,numConsignatario);
                                } else {
                                    actualizaEstatusPagoSuspendida(idPoliza,numConsignatario);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean validaArchivo(ArrayList listaFilas) {
        ArrayList fila = (ArrayList) listaFilas.get(0);
        String idArchivo = fila.get(0).toString();
        ArchivosDescuentosCargados archivoCargado = obtenDatosArchivo(fila);
        boolean bandera = true;
        try {
            // int auxiliar = Integer.parseInt(idArchivo);
            if (validaQuincenaArchivo(listaFilas, idArchivo)) {
                if (validaCantidades(listaFilas)) {
                    List archivos = descuentosAplicadosDao.obtenArchivosCargados();
                    for (int i = 0; i < archivos.size(); i++) {
                        ArchivosDescuentosCargados archivo = (ArchivosDescuentosCargados) archivos.get(i);
                        if (idArchivo.equals(archivo.getNumQuincena() + archivo.getCveRetenedor())) {
                            setError("La carga del archivo " 
                                    + idArchivo + " ya fue realizada en "
                                    + "otro momento por lo que no se "
                                    + "realizar\u00E1 nuevamente");
                            log.info(getError());
                            bandera = false;
                            break;
                        }
                    }
                    if (bandera) {
                        try {
                            if (getFechDepIncorrecta() != 1) {
                                insertaDatosArchivo(archivoCargado.getFechaCarga(), archivoCargado.getCveRetenedor(), archivoCargado.getNumQuincena(), archivoCargado.getConsecutivoArchivo());
                            }
                        } catch (Exception er) {
                        }
                    }
                } else {
                    bandera = false;
                }
            } else {
                bandera = false;
            }
        } catch (Exception er) {
            setError("el valor " + idArchivo + " no es un numerico. No se realizar\u00E1 la carga");
            return false;
        }
        log.debug("Resultado de validacion: " + bandera);
        return bandera;
    }

    public boolean validaQuincenaArchivo(ArrayList listaFilas, String idArchivo) {
        String quincena = idArchivo.substring(0, 6);
        boolean bandera = true;
        int quincenaArchivo;
        for (int i = 1; i < listaFilas.size(); i++) {
            ArrayList renglon = (ArrayList) listaFilas.get(i);
            if (renglon.get(QUINCENA_ARCHIVO) == "") {
                break;
            }
            if (!quincena.equals(renglon.get(QUINCENA_ARCHIVO)) && renglon.get(QUINCENA_ARCHIVO) != "") {
                bandera = false;
                setError("La quincena " + quincena + " no es valida para el archivo " + idArchivo + ". No se realizará la carga");
            }
        }
        return bandera;
    }

    public boolean validaCantidades(ArrayList listaFilas) {
        boolean bandera = true;
        for (int i = 1; i < listaFilas.size(); i++) {
            ArrayList renglon = (ArrayList) listaFilas.get(i);
            if (renglon.size() < 2 || !validaRenglonVacio(renglon)) {
                break;
            }
            try {
                int auxiliar = Integer.parseInt(renglon.get(DESCUENTO_APLICADO).toString());
            } catch (Exception er) {
                setError("el valor " + renglon.get(DESCUENTO_APLICADO).toString() + "incluido en el archivo no es un valor numerico. No se realizar\u00E1 la carga");
                bandera = false;
            }
        }
        return bandera;
    }

    public boolean validaRenglonVacio(ArrayList renglon) {
        int aux = 0;
        for (int i = 0; i < renglon.size(); i++) {
            String dato = renglon.get(i).toString();
            if (dato.isEmpty() || dato.equals("")) {
                aux = aux + 1;
            }
        }
        if (aux == (renglon.size())) {
            return false;
        } else {
            return true;
        }
    }

    public void registroRechazos(String numNominaContratante, String numeroQuincena, String motivo) {
        ArrayList rechazo = new ArrayList();
        rechazo.add(numNominaContratante);
        rechazo.add(numeroQuincena);
        //rechazo.add(importeDescuento);
        rechazo.add(motivo);
        listaRechazos.add(rechazo);
    }

    public void insertaDatosArchivo(Date fechaCarga, String cveRetenedor, int numQuincena, int consecutivoArchivo) {
        ArchivosDescuentosCargados archivoCargado = new ArchivosDescuentosCargados();
        archivoCargado.setConsecutivoArchivo(consecutivoArchivo);
        archivoCargado.setFechaCarga(fechaCarga);
        archivoCargado.setCveRetenedor(cveRetenedor);
        archivoCargado.setNumQuincena(numQuincena);
        descuentosAplicadosDao.insertaDatosArchivo(archivoCargado);
    }

    public boolean insertarDescuentoAplicado(int numPoliza, int numQuincenaArchivo, double impDescuentoAplicadoPoliza,
            double impRealPagoPrima, double impRealAhorro, int numQuincenaPagada, ArchivosDescuentosCargados archivo, double impDescReportado, Date fechaDepositoDep, int numConsignatario) {
        DescuentosAplicados descuentos = new DescuentosAplicados();
        descuentos.setImpDescuentoAplicadoPoliza(impDescuentoAplicadoPoliza);
        descuentos.setImpRealAhorro(impRealAhorro);
        descuentos.setImpRealPagoPrima(impRealPagoPrima);
        descuentos.setNumPoliza(numPoliza);
        descuentos.setNumQuincenaArchivo(numQuincenaArchivo);
        descuentos.setNumQuincenaPagada(numQuincenaPagada);
        descuentos.setFechaCalculo(new Date());
        descuentos.setImpDescReportado(impDescReportado);
        String numQuincena = Integer.toString(archivo.getNumQuincena());
        String gpoAseg = archivo.getCveRetenedor();
        String consecArch = Integer.toString(archivo.getConsecutivoArchivo());
        String idArchivo = "" + numQuincena + "" + gpoAseg + "" + consecArch;
        int idArchivo2 = Integer.parseInt(idArchivo.trim());
        descuentos.setIdentificadorArchivo(idArchivo2);
        descuentos.setFechaDepositoDep(fechaDepositoDep);
        descuentos.setNumConsignatario(numConsignatario);
        //descuentos.setConsecutivoCarga(obtenUltimoConsecutivoArchivo());
        //descuentos.setGrupoAsegurado(archivo.getGrupoAsegurado());
        try {
            descuentosAplicadosDao.insertarDescuentoAplicado(descuentos);
            return true;
        } catch (Exception er) {
        	er.printStackTrace();
            return false;
        }
    }

    public List obtenDescuentosPorPoliza(int numPoliza, int numConsignatario) {
        DescuentosAplicados descuento = new DescuentosAplicados();
        descuento.setNumPoliza(numPoliza);
        descuento.setNumConsignatario(numConsignatario);
        //try{
        return (List) getDescuentosAplicadosDao().obtenDescuentosPorPoliza(descuento);
        //}catch(Exception er){
        //    return null;
        //}
    }

    public boolean obtenListaPolizasPorPagar(ArrayList listaFilas, String realPath) {
        ArchivosDescuentosCargados archivo = obtenDatosArchivo((ArrayList) listaFilas.get(0));
        Integer numQuincena = archivo.getNumQuincena();
        boolean rechazos = true;
        for (int i = 1; i < listaFilas.size(); i++) {
            ArrayList fila = (ArrayList) listaFilas.get(i);
            if (!fila.get(0).toString().isEmpty()) {
                calculoDescuentosAplicadosPorSolicitante(fila, archivo);
            } else {
                break;
            }
        }
        //si algun rfc no tiene polizas con estatus de emitida generamos el excel
        if (this.listaRechazos.size() > 0) {
            GeneraXLS generarExcel = new GeneraXLS();
            rechazos = false;
            String nombreArchivo = "ArchivoRechazos_"
                    + ((ArrayList) listaFilas.get(0)).get(0).toString()
                    + (((ArchivosDescuentosCargados) descuentosAplicadosDao.obtenIndiceArchivo(numQuincena)).getConsecutivoArchivo() + 1);
            this.error = "Existe informaci\u00F3n que no se carg\u00F3 en "
                    + "la base de datos. Consulte el archivo " + nombreArchivo + "-" + nombreArchivo;
            try {
                generarExcel.generaLibro(this.listaRechazos, "Rechazos", "Archivos" + ReporteBusiness.FOLDER_SEPARATOR + nombreArchivo , "Archivos");
                this.listaRechazos.clear();
                //  indicadorArchivoRechazos();
            } catch (Exception er) {
                System.err.println(er.getMessage());
            }
        }
        return rechazos;
    }

    /*    public int indicadorArchivoRechazos(){
    setArchivoRechazos(2);
    return getArchivoRechazos();
    }
    
    public int resetearIndicadorArchivoRechazos(){
    setArchivoRechazos(1);
    return getArchivoRechazos();
    }
     */
    public int obtenUltimoConsecutivoArchivo(Integer numQuincena) {
        ArchivosDescuentosCargados archivosAux = (ArchivosDescuentosCargados) descuentosAplicadosDao.obtenIndiceArchivo(numQuincena);
        return archivosAux.getConsecutivoArchivo();
    }

    /*****************************METODOS PARA MANEJO DE ESTATUS******************************/
    public void actualizaEstatusPagoAutofinanciada(int idPoliza, int numConsignatario) {
        polizaBusiness.actualizaEstatusPolizaPago(idPoliza, numConsignatario, AUTOFINANCIADA_PAGOS_INSUFICIENTES);
    }

    public void actualizaEstatusPagoCanceladaPorPago(int idPoliza, int numConsignatario) {
        polizaBusiness.actualizaEstatusPolizaAmbos(idPoliza, numConsignatario, CANCELADA_FALTA_PAGOS, CANCELADA);
    }

    public void actualizaEstatusPagoSuspendida(int idPoliza, int numConsignatario) {
        polizaBusiness.actualizaEstatusPolizaPago(idPoliza, numConsignatario,PAGOS_SUSPENDIDOS);
    }

    public void actualizaEstatusPagoNormal(int idPoliza, int numConsignatario) {
        polizaBusiness.actualizaEstatusPolizaPago(idPoliza, numConsignatario, NORMAL);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List obtenArchivosCargados() {
        return descuentosAplicadosDao.obtenArchivosCargados();
    }

    public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }

    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;

    }

    public ISolicitudBusiness getSolicitudBusiness() {
        return solicitudBusiness;
    }

    public void setSolicitudBusiness(ISolicitudBusiness solicitudBusiness) {
        this.solicitudBusiness = solicitudBusiness;
    }

    public IDescuetosAplicadosDao getDescuentosAplicadosDao() {
        return descuentosAplicadosDao;
    }

    public void setDescuentosAplicadosDao(IDescuetosAplicadosDao descuentosAplicadosDao) {
        this.descuentosAplicadosDao = descuentosAplicadosDao;
    }

    public int getArchivoRechazos() {
        return archivoRechazos;
    }

    public void setArchivoRechazos(int archivoRechazos) {
        this.archivoRechazos = archivoRechazos;
    }

    public int getFechDepIncorrecta() {
        return fechDepIncorrecta;
    }

    public void setFechDepIncorrecta(int fechDepIncorrecta) {
        this.fechDepIncorrecta = fechDepIncorrecta;
    }

    public List<Integer> findQnasPagoReportadoByPoliza(PolizaIndividual poliza) {
        return descuentosAplicadosDao.findQnasPagoReportadoByPoliza(poliza);
    }

    public DescuentosAplicados findDescuentoByPolizaQuincenaReportada(PolizaIndividual poliza, Integer numQnaArchivo) {
        DescuentosAplicados descuentoAplicado;
        descuentoAplicado = descuentosAplicadosDao.findDescuentoByPolizaQuincenaReportada(poliza, numQnaArchivo);
        return descuentoAplicado;

    }

    public List<DescuentosAplicados> findDescuentoPrimaByPolizaQnaArchivo(PolizaIndividual poliza, Integer numQnaArchivo) {
        return descuentosAplicadosDao.findDescuentoPrimaByPolizaQnaArchivo(
                poliza, numQnaArchivo);

    }

    /**
     *
     * @param poliza
     * @return Regresa el numero de la primer quincena de pago a prima para la
     *         poliza en formato 4 digitos para el anio y dos para la quincena,
     *         p. ej 200712. En caso de que no se halla logrado pagar, se
     *         recupera la fecha de primer intento de pago.
     */
    public Integer findFechaPrimerPagoInt(PolizaIndividual poliza) {
        Integer fechaPrimerPagoInt;
        fechaPrimerPagoInt = descuentosAplicadosDao.findFechaPrimerPagoInt(poliza);
        if (fechaPrimerPagoInt == null) {
            fechaPrimerPagoInt = polizaBusiness.recuperarQnaPrimerIntentoPago(poliza);
        }
        return fechaPrimerPagoInt;
    }

    public void insertarDescuentoAplicado(DescuentosAplicados descuento) {
        Integer numQuincenaArchivo = descuento.getNumQuincenaArchivo();
        Integer numQuincenaPagada = descuento.getNumQuincenaPagada();
        String numQuincenaArchivoStr = String.valueOf(numQuincenaArchivo);
        String numQuincenaPagadaStr = String.valueOf(numQuincenaPagada);
        StringBuilder sb = new StringBuilder();
        if (numQuincenaArchivoStr.length() != DateUtils.NUM_POSICIONES_ANIO_QNA) {
            sb.append("El formato del numero de quincena del archivo ");
            sb.append("no es v\u00E1lido, no se ha insertado el descuento. ");
            sb.append(descuento);
            log.error(sb.toString());
        } else if (numQuincenaPagadaStr.length() != DateUtils.NUM_POSICIONES_ANIO_QNA) {
            sb.append("El formato del numero de quincena pagada ");
            sb.append("no es v\u00E1lido, no se ha insertado el descuento. ");
            sb.append(descuento);
            log.error(sb.toString());
        } else {
            descuentosAplicadosDao.insertarDescuentoAplicado(descuento);
        }

    }
}
