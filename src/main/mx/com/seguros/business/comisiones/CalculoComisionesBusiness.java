/*
 * CalculoComisiones.java
 *
 * Created on 17 de marzo de 2008, 03:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.business.comisiones;

import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.util.List;
import mx.com.seguros.data.dao.IAgenteDao;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.ComisionBrutaAgente;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.model.ProduccionQuincenaPuntosAgente;
import mx.com.seguros.model.DetalleComisionSolicitud;



/**
 *
 * @author Alverik
 */
public class CalculoComisionesBusiness {
    
    private IAgenteDao agenteDao;
    private ISolicitudDao solicitudDao;
    private IPolizaDao polizaDao;
    //private Date fechaIncioPeriodoComisiones;
    //private Date fechaFinPeriodoComisiones;
    
    /** Creates a new instance of CalculoComisiones */
    public CalculoComisionesBusiness() {
    }
    
    public boolean calcularComisionesAgentes(Date fechaInicioPeriodoComisiones,Date fechaFinPeriodoComisiones, int numQnaComision){
        System.out.println("Estoy en el metodo calcular comisiones agentes");
        boolean bandera=false;
        final int ESTATUS_EMITIDA=2;
        final int ESTATUS_POLIZA_ENTREGADA=3;
        final int CAPTURADA=1;
        // final int CORRECCION=4;
        //  final int CANCELADA_FALTA_PAGO=7;
        //   final int CANCELADA=5;
        int puntosProduccion=0;
        int totalProduccionPuntos=0;
        
        Double primaAnualIndividual=0.00;
        Double comisionFijaAgente=0.00;
        Double comisionFijaSupervisor=0.00;
        Double comisionFijaGerente=0.00;
        Double reservaBonoTrimestral=0.00;
        
        Double totalComisionAgente=0.00;
        Double totalComisionSupervisor=0.00;
        Double totalComisionGerente=0.00;
        Double aportacionReservaBonoTrimestralAgente=0.00;
        
        Double totalComisionFijaSupervisor= 0.00;
        Double totalComisionFijaAgente= 0.00;
        Double totalComisionFijaGerente= 0.00;
        
  /*      Double retencionISRagente=0.00;
        Double retencionISRsupervisor=0.00;
        Double retencionISRgerente=0.00;
        Double retencionIVAagente=0.00;
        Double retencionIVAsupervisor=0.00;
        Double retencionIVAgerente=0.00;
        Double IVAtrasladadoAgente=0.00;
        Double IVAtrasladadoSupervisor=0.00;
        Double IVAtrasladadoGerente=0.00;*/
        
        Double comisionSolicitudAgente=0.00;
        Double comisionSolicitudSupervisor=0.00;
        Double comisionSolicitudGerente=0.00;
        
        Double comisionPolizaAgente=0.00;
        Double comisionPolizaSupervisor=0.00;
        Double comisionPolizaGerente=0.00;
        
       
        
        
        List listaAgentes=getAgenteDao().obtenTodosAgentes();
        List listaBonos=getAgenteDao().obtenBonoTrimestralAgente();
        
        if(listaBonos.isEmpty()){
            
        } 
        else{
            agenteDao.borraBonoTrimestralAgente();
        }
        for(int i=0;i<listaAgentes.size();i++){
            
            System.out.println("indice todos agentes"+i);
            Agente agente =(Agente)listaAgentes.get(i);
            System.out.println("estoy al inicio del for de agentes");
            totalComisionFijaAgente=0.00;
            System.out.println("totalComisionFijaAgente del final del metodo"+totalComisionFijaAgente);
            totalComisionFijaSupervisor=0.00;
            System.out.println("totalComisionFijaSupervisor del final del metodo"+totalComisionFijaSupervisor);
            totalComisionFijaGerente=0.00;
            System.out.println("totalComisionFijaGerente del final del metodo"+totalComisionFijaGerente);
            aportacionReservaBonoTrimestralAgente=0.00;
            
            DetalleComisionSolicitud detalleComSolic=new DetalleComisionSolicitud();
            ComisionBrutaAgente comisionBrutaAgente=new ComisionBrutaAgente();
            comisionBrutaAgente.setCveAgente(agente.getCveAgente());
            comisionBrutaAgente.setFechaInicioPeriodoComisiones(fechaInicioPeriodoComisiones);
            comisionBrutaAgente.setFechaFinPeriodoComisiones(fechaFinPeriodoComisiones);
            List listaSolicitudes= getSolicitudDao().obtenListaSolicitudesVencidas(comisionBrutaAgente);
            if(listaSolicitudes.isEmpty()){
                System.out.println("*****lista vacia*****");
            } else{
                System.out.println("*****contiene valores*****");
                
                for(int j=0;j<listaSolicitudes.size();j++){
                    System.out.println("indice listas solicitudes vendidas"+j);
                    Solicitud solicitud=(Solicitud)listaSolicitudes.get(j);
                    int cveTarifa=solicitud.getCveTarifa();
                    TarifaAportMensual tarifa=(TarifaAportMensual)solicitudDao.obtenTarifaMensualPorClaveTarifa(cveTarifa);
                    
                    //Fase se calculos
                    primaAnualIndividual=tarifa.getImportePrimaInd()*12;
                    System.out.println("primaAnualIndividual"+primaAnualIndividual);
                    comisionFijaAgente=primaAnualIndividual*0.075;
                    System.out.println("comisionFijaAgente"+comisionFijaAgente);
                    comisionSolicitudAgente=comisionFijaAgente;
                    System.out.println("comisionSolicitudAgente"+comisionSolicitudAgente);
                    comisionFijaSupervisor=primaAnualIndividual * 0.025;
                    System.out.println("comisionFijaSupervisor"+comisionFijaSupervisor);
                    comisionSolicitudSupervisor=comisionFijaSupervisor;
                    System.out.println("comisionSolicitudSupervisor"+comisionSolicitudSupervisor);
                    comisionFijaGerente=primaAnualIndividual * 0.025;
                    System.out.println("comision fija gerente"+comisionFijaGerente);
                    comisionSolicitudGerente=comisionFijaGerente;
                    System.out.println("comisionSolicitudGerente"+comisionSolicitudGerente);
                    reservaBonoTrimestral=primaAnualIndividual*0.05;
                    System.out.println("reservaBonoTrimestral"+reservaBonoTrimestral);
                    
                    
                    
                    if(solicitud.getIdEstatusSolicitud()==ESTATUS_EMITIDA){
                    	/**
                         * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                         */
                        PolizaIndividual poliza=(PolizaIndividual)polizaDao.obtenerPolizaPorSolicitud(solicitud.getFolioSolicitud(),solicitud.getFormatoSolicitud());
                        System.out.println("Folio de Solicitud"+solicitud.getFolioSolicitud());
                        int numPoliza=poliza!=null?poliza.getNumPoliza():0;
                        int numConsignatario=poliza!=null?poliza.getNumConsignatario():0;
                        //int indicadorPagoComisionEntregaPoliza=poliza.getIndicadorPagoComisionEntregaPoliza();
                        PolizaIndividual polizaAux=new PolizaIndividual();
                        
                        if(poliza != null && poliza.getIdEstatusPolizaSeguimiento()==CAPTURADA){
                            
                            polizaAux.setNumPoliza(numPoliza);
                            polizaAux.setNumConsignatario(numConsignatario);
                            polizaAux.setIndicadorPagoComisionEntregaPoliza(2);
                            polizaDao.actualizaIndicadorPagoComisionEntregaPoliza(polizaAux);
                            
                            
                            /**
                             * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                             */
                            detalleComSolic.setFolioSolicitud(solicitud.getFolioSolicitud());
                            detalleComSolic.setFormatoSolicitud(solicitud.getFormatoSolicitud());
                            detalleComSolic.setComisionSolicitudAgente(comisionSolicitudAgente);
                            detalleComSolic.setComisionSolicitudSupervisor(comisionSolicitudSupervisor);
                            detalleComSolic.setComisionSolicitudGerente(comisionSolicitudGerente);
                            detalleComSolic.setComisionPolizaAgente(0);
                            detalleComSolic.setComisionPolizaSupervisor(0);
                            detalleComSolic.setComisionPolizaGerente(0);
                            List listaDetallesComision=getAgenteDao().obtenDetalleComisionSolicitud(solicitud.getFolioSolicitud(), solicitud.getFormatoSolicitud());
                            
                            if(listaDetallesComision.isEmpty()){
                                agenteDao.insertaDetalleComisionSolicitud(detalleComSolic);
                            }
                            
                            else{
                                agenteDao.actualizaDetalleComisionSolicitud(detalleComSolic);
                            }
                            
                        }
                        
                        if(poliza != null && poliza.getIdEstatusPolizaSeguimiento()==ESTATUS_POLIZA_ENTREGADA){
                            System.out.println("estoy en el if de poliza entregada al agente");
                            Date fechaEntregaAgente=poliza.getFechaEntregaAgente();
                            Date fechaCalculoComisiones= new Date();
                            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
                            String fechaInicioString = df.format(fechaEntregaAgente!=null?fechaEntregaAgente:new Date());
                            try {
                                fechaEntregaAgente = df.parse(fechaInicioString);
                            }
                            catch (ParseException ex) {
                            }
                            String fechaFinalString = df.format(fechaCalculoComisiones);
                            try {
                                fechaCalculoComisiones = df.parse(fechaFinalString);
                            }
                            catch (ParseException ex) {
                            }
                            long fechaInicialMs = fechaEntregaAgente.getTime();
                            long fechaFinalMs = fechaCalculoComisiones.getTime();
                            long diferencia = fechaFinalMs - fechaInicialMs;
                            double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
                            System.out.println("dias diferencia: "+dias);
                            
                            /*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            Date $30Dias=null;
                            try {
                                $30Dias = dateFormat.parse("19/02/1986");
                            } catch (ParseException ex) {
                                ex.printStackTrace();
                            }
                            Date fechaActual = new Date(new Date().getTime() - $30Dias.getTime());
                            System.out.println("fechaActual: "+fechaActual);
                            System.out.println("$30Dias: "+$30Dias);*/
                            
                            
                            if(dias > 30){
                                System.out.println("if si la fecha de entrega al agente es mayor a 30 dias");
                                polizaAux.setNumPoliza(numPoliza);
                                polizaAux.setNumConsignatario(numConsignatario);
                                polizaAux.setIndicadorPagoComisionEntregaPoliza(2);
                                polizaDao.actualizaIndicadorPagoComisionEntregaPoliza(polizaAux);
                                /**
                                 * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                                 */
                                detalleComSolic.setFolioSolicitud(solicitud.getFolioSolicitud());
                                detalleComSolic.setFormatoSolicitud(solicitud.getFormatoSolicitud());
                                detalleComSolic.setComisionSolicitudAgente(comisionSolicitudAgente);
                                detalleComSolic.setComisionSolicitudSupervisor(comisionSolicitudSupervisor);
                                detalleComSolic.setComisionSolicitudGerente(comisionSolicitudGerente);
                                detalleComSolic.setComisionPolizaAgente(0);
                                detalleComSolic.setComisionPolizaSupervisor(0);
                                detalleComSolic.setComisionPolizaGerente(0);
                                List listaDetallesComision1=getAgenteDao().obtenDetalleComisionSolicitud(solicitud.getFolioSolicitud(),solicitud.getFormatoSolicitud());
                                if(listaDetallesComision1.isEmpty()){
                                    agenteDao.insertaDetalleComisionSolicitud(detalleComSolic);
                                } else{
                                    agenteDao.actualizaDetalleComisionSolicitud(detalleComSolic);
                                }
                                
                                
                            }
                            
                            else{
                                System.out.println("else de la poliza entregada al agente tiene fecha mayor a 30 dias");
                                comisionFijaAgente = comisionFijaAgente * 2;
                                System.out.println("comisionFijaAgente entrega al agente mayor 30 dias"+comisionFijaAgente);
                                comisionPolizaAgente=comisionSolicitudAgente;
                                System.out.println("comisionPolizaAgente entrega al agente mayor 30 dias"+comisionPolizaAgente);
                                comisionFijaSupervisor = comisionFijaSupervisor * 2;
                                System.out.println("comisionFijaSupervisor entrega al agente mayor 30 dias"+comisionFijaSupervisor);
                                comisionPolizaSupervisor=comisionSolicitudSupervisor;
                                System.out.println("comisionPolizaSupervisor entrega al agente mayor 30 dias"+comisionPolizaSupervisor);
                                comisionFijaGerente = comisionFijaGerente * 2;
                                System.out.println("comisionFijaGerente entrega al agente mayor 30 dias"+comisionFijaGerente);
                                comisionPolizaGerente=comisionSolicitudGerente;
                                System.out.println("comisionPolizaGerente entrega al agente mayor 30 dias"+comisionPolizaGerente);
                                
                                polizaAux.setNumPoliza(numPoliza);
                                polizaAux.setNumConsignatario(numConsignatario);
                                polizaAux.setIndicadorPagoComisionEntregaPoliza(1);
                                polizaDao.actualizaIndicadorPagoComisionEntregaPoliza(polizaAux);
                                /**
                                 * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                                 */
                                detalleComSolic.setFolioSolicitud(solicitud.getFolioSolicitud());
                                detalleComSolic.setFormatoSolicitud(solicitud.getFormatoSolicitud());
                                detalleComSolic.setComisionSolicitudAgente(comisionSolicitudAgente);
                                detalleComSolic.setComisionSolicitudSupervisor(comisionSolicitudSupervisor);
                                detalleComSolic.setComisionSolicitudGerente(comisionSolicitudGerente);
                                detalleComSolic.setComisionPolizaAgente(comisionPolizaAgente);
                                detalleComSolic.setComisionPolizaSupervisor(comisionPolizaSupervisor);
                                detalleComSolic.setComisionPolizaGerente(comisionPolizaGerente);
                                List listaDetallesComision2=getAgenteDao().obtenDetalleComisionSolicitud(solicitud.getFolioSolicitud(),solicitud.getFormatoSolicitud());
                                if(listaDetallesComision2.isEmpty()){
                                    agenteDao.insertaDetalleComisionSolicitud(detalleComSolic);
                                } else{
                                    agenteDao.actualizaDetalleComisionSolicitud(detalleComSolic);
                                }
                            }
                            
                            
                        }
                        
                        
                        else{
                            System.out.println("else de poliza entregada al agente");
                            comisionFijaAgente = comisionFijaAgente * 2;
                            System.out.println("comisionFijaAgente de else de poliza entregada al agente"+comisionFijaAgente);
                            comisionPolizaAgente=comisionSolicitudAgente;
                            System.out.println("comisionPolizaAgente de else de poliza entregada al agente"+comisionPolizaAgente);
                            comisionFijaSupervisor = comisionFijaSupervisor * 2;
                            System.out.println("comisionFijaSupervisor de else de poliza entregada al agente"+comisionFijaSupervisor);
                            comisionPolizaSupervisor=comisionSolicitudSupervisor;
                            System.out.println("comisionPolizaSupervisor de else de poliza entregada al agente"+comisionPolizaSupervisor);
                            comisionFijaGerente = comisionFijaGerente * 2;
                            System.out.println("comisionFijaGerente de else de poliza entregada al agente"+comisionFijaGerente);
                            comisionPolizaGerente=comisionSolicitudGerente;
                            System.out.println("comisionPolizaGerente de else de poliza entregada al agente"+comisionPolizaGerente);
                            
                            polizaAux.setNumPoliza(numPoliza);
                            polizaAux.setNumConsignatario(numConsignatario);
                            polizaAux.setIndicadorPagoComisionEntregaPoliza(1);
                            polizaDao.actualizaIndicadorPagoComisionEntregaPoliza(polizaAux);
                            /**
                             * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                             */
                            detalleComSolic.setFolioSolicitud(solicitud.getFolioSolicitud());
                            detalleComSolic.setFormatoSolicitud(solicitud.getFormatoSolicitud());
                            detalleComSolic.setComisionSolicitudAgente(comisionSolicitudAgente);
                            detalleComSolic.setComisionSolicitudSupervisor(comisionSolicitudSupervisor);
                            detalleComSolic.setComisionSolicitudGerente(comisionSolicitudGerente);
                            detalleComSolic.setComisionPolizaAgente(comisionPolizaAgente);
                            detalleComSolic.setComisionPolizaSupervisor(comisionPolizaSupervisor);
                            detalleComSolic.setComisionPolizaGerente(comisionPolizaGerente);
                            List listaDetallesComision3=getAgenteDao().obtenDetalleComisionSolicitud(solicitud.getFolioSolicitud(),solicitud.getFormatoSolicitud());
                            
                            if(listaDetallesComision3.isEmpty()){
                                agenteDao.insertaDetalleComisionSolicitud(detalleComSolic);
                            } else{
                                agenteDao.actualizaDetalleComisionSolicitud(detalleComSolic);
                            }
                        }
                        
                    }
                    
                    else{
                    	/**
                         * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                         */
                        detalleComSolic.setFolioSolicitud(solicitud.getFolioSolicitud());
                        detalleComSolic.setFormatoSolicitud(solicitud.getFormatoSolicitud());
                        detalleComSolic.setComisionSolicitudAgente(comisionSolicitudAgente);
                        detalleComSolic.setComisionSolicitudSupervisor(comisionSolicitudSupervisor);
                        detalleComSolic.setComisionSolicitudGerente(comisionSolicitudGerente);
                        detalleComSolic.setComisionPolizaAgente(0);
                        detalleComSolic.setComisionPolizaSupervisor(0);
                        detalleComSolic.setComisionPolizaGerente(0);
                        List listaDetallesComision1=getAgenteDao().obtenDetalleComisionSolicitud(solicitud.getFolioSolicitud(),solicitud.getFormatoSolicitud());
                        if(listaDetallesComision1.isEmpty()){
                            agenteDao.insertaDetalleComisionSolicitud(detalleComSolic);
                        } else{
                            agenteDao.actualizaDetalleComisionSolicitud(detalleComSolic);
                        }
                    }
                    
                    totalComisionFijaAgente = totalComisionFijaAgente + comisionFijaAgente;
                    System.out.println("totalComisionFijaAgente"+totalComisionFijaAgente);
                    totalComisionFijaSupervisor = totalComisionFijaSupervisor + comisionFijaSupervisor;
                    System.out.println("totalComisionFijaSupervisor"+totalComisionFijaSupervisor);
                    totalComisionFijaGerente = totalComisionFijaGerente + comisionFijaGerente;
                    System.out.println("totalComisionFijaGerente"+totalComisionFijaGerente);
                    aportacionReservaBonoTrimestralAgente = aportacionReservaBonoTrimestralAgente + reservaBonoTrimestral;
                    System.out.println("aportacionReservaBonoTrimestralAgente"+aportacionReservaBonoTrimestralAgente);
                    totalProduccionPuntos = totalProduccionPuntos + tarifa.getPuntosProduccion();
                    System.out.println("totalProduccionPuntos"+totalProduccionPuntos);
                }
                ProduccionQuincenaPuntosAgente produccionQuin=new ProduccionQuincenaPuntosAgente();
                produccionQuin.setCveAgente(agente.getCveAgente());
                Calendar c1=Calendar.getInstance();
                String anioComision=Integer.toString(c1.get(Calendar.YEAR));
                Integer anioComisionAux=new Integer(anioComision);
                produccionQuin.setAnoQuincenaComision(anioComisionAux);
                produccionQuin.setNumQuincenaComision(numQnaComision);
                produccionQuin.setTotalProduccionPuntos(totalProduccionPuntos);
                produccionQuin.setReservaBonoTrim(aportacionReservaBonoTrimestralAgente);
                produccionQuin.setIndicadorCalculoAsignacionBonoTrim(0);
                agenteDao.insertaProduccionQuincenaPuntosAgente(produccionQuin);
            }
        }
        
        
        
        bandera=true;
        return bandera;
    }
    
    
    
    public ISolicitudDao getSolicitudDao() {
        return solicitudDao;
    }
    
    public void setSolicitudDao(ISolicitudDao solicitudDao) {
        this.solicitudDao = solicitudDao;
    }
    
    public IAgenteDao getAgenteDao() {
        return agenteDao;
    }
    
    public void setAgenteDao(IAgenteDao agenteDao) {
        this.agenteDao = agenteDao;
    }
    
    public IPolizaDao getPolizaDao() {
        return polizaDao;
    }
    
    public void setPolizaDao(IPolizaDao polizaDao) {
        this.polizaDao = polizaDao;
    }
    
}
