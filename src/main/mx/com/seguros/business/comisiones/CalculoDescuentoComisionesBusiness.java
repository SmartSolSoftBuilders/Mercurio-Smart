/*
 * CalculoDescuentoComisionesBusiness.java
 *
 * Created on 24 de marzo de 2008, 09:41 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.business.comisiones;
import java.lang.Integer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import mx.com.seguros.data.dao.IAgenteDao;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.ComisionBrutaAgente;
import mx.com.seguros.model.DetalleDescuentoComisionSolicitud;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.model.DescuentoComisionAgente;
import mx.com.seguros.model.DescuentosAplicados;
import mx.com.seguros.model.DetalleComisionSolicitud;
/**
 *
 * @author QTX
 */
public class CalculoDescuentoComisionesBusiness {
    private IAgenteDao agenteDao;
    private ISolicitudDao solicitudDao;
    private IPolizaDao polizaDao;
    
    /** Creates a new instance of CalculoDescuentoComisionesBusiness */
    public CalculoDescuentoComisionesBusiness() {
    }
    
    public boolean calcularDescuentosComisionesAgentes(){
        boolean bandera=false;
        final int ESTATUS_CANCELADA=5;
        final int ESTATUS_CANCELADA_PETICION_CLIENTE=6;
        
        
        
        Double importeDoceavoComisionAgente=0.00;
        Double importeDoceavoComisionSupervisor=0.00;
        Double importeDoceavoComisionGerente=0.00;
        Double importeDescuentoComisionAgente=0.00;
        Double importeDescuentoComisionSupervisor=0.00;
        Double importeDescuentoComisionGerente=0.00;
        
        
        Double totalDescuentoComisionAgente=0.00;
        Double totalDescuentoComisionSupervisor=0.00;
        Double totalDescuentoComisionGerente=0.00;
        
        Double totalComisionBrutaAgente=0.00;
        Double totalComisionBrutaSupervisor=0.00;
        Double totalComisionBrutaGerente=0.00;
        
        List listaAgentes=getAgenteDao().obtenTodosAgentes();
        for(int i=0;i<listaAgentes.size();i++){
            Agente agente =(Agente)listaAgentes.get(i);
            PolizaIndividual poliza=new PolizaIndividual();
            Solicitud solicitudAux=new Solicitud();
            DetalleDescuentoComisionSolicitud detalleDescComSolic=new DetalleDescuentoComisionSolicitud();
            solicitudAux.setCveAgente(agente.getCveAgente());
            
            List listaSolicitudes = solicitudDao.obtenSolicitudesAgente(solicitudAux);
            
            if(listaSolicitudes.isEmpty()){
                System.out.println("lista nula");
            }
            
            else{
                System.out.println("tiene valores");
                
                for(int j=0;j<listaSolicitudes.size();j++){
                    Solicitud solicitud=(Solicitud)listaSolicitudes.get(j);
                    /**
                     * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                     */
                    poliza=(PolizaIndividual) getPolizaDao().obtenerPolizaPorSolicitud(solicitud.getFolioSolicitud(),solicitud.getFormatoSolicitud());
                    
                    if(poliza != null && poliza.getIdEstatusPolizaSeguimiento()==ESTATUS_CANCELADA){
                        
                        if(poliza.getIdEstatusPagosPoliza()==ESTATUS_CANCELADA_PETICION_CLIENTE ){
                            //   DescuentosAplicados descuentos=new DescuentosAplicados();
                            ComisionBrutaAgente comisionAgente=new ComisionBrutaAgente();
                            
                            if(poliza.getIndicadorDescuentoComision()==0){
                                //descuentos.setNumPoliza(poliza.getNumPoliza());
                                List listaDescuentosAplicados=polizaDao.obtenListaDescuentosAplicados(poliza.getNumPoliza());
                                //String numElementos=(String)polizaDao.contarListaDescuentosAplicados(poliza.getNumPoliza());
                                Integer numElementos=Integer.parseInt(polizaDao.contarListaDescuentosAplicados(poliza.getNumPoliza()));
                                System.out.println("numero de elementos"+numElementos);
                                int numElementosTotales;
                                
                                if(numElementos==null){
                                    System.out.println("****Lista de elementos vacia****");
                                    numElementosTotales = 0;
                                }
                                
                                //Integer numElementosTotales=new Integer(numElementos);
                                //int numElementosTotales=Integer.parseInt(numElementos);
                                else{
                                    numElementosTotales=Integer.valueOf(numElementos).intValue();
                                }
                                if(numElementosTotales < 24){
                                    System.out.println("mis elementos"+numElementosTotales);
                                    Double numMesesDescuentoAplicado= 0.00;
                                    Double numDoceavosDescuento=0.00;
                                    numMesesDescuentoAplicado= numElementosTotales / 2.00;
                                    //System.out.println("numMesesDescuentoAplicado"+numMesesDescuentoAplicado);
                                    numDoceavosDescuento= 12 - numMesesDescuentoAplicado;
                                    //System.out.println("numDoceavosDescuento"+numDoceavosDescuento);
                                    /**
                                     * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                                     */
                                    DetalleComisionSolicitud detalleComSolic= (DetalleComisionSolicitud)
                                    		solicitudDao.obtenerDetalleComisionSolicitud(solicitud.getFolioSolicitud(),solicitud.getFormatoSolicitud());
                                    //ComisionBrutaAgente comision=(ComisionBrutaAgente)agenteDao.obtenerComisionBrutaAgente(agente.getCveAgente());
                                    //System.out.println("comision fija agente"+comision.getTotalComisionFijaAgente());
                                    importeDoceavoComisionAgente = totalComisionBrutaAgente / 12;
                                    //System.out.println("importeDoceavoComisionAgente"+importeDoceavoComisionAgente);
                                    importeDoceavoComisionSupervisor = totalComisionBrutaSupervisor / 12;
                                    //System.out.println("importeDoceavoComisionSupervisor"+importeDoceavoComisionSupervisor);
                                    importeDoceavoComisionGerente = totalComisionBrutaGerente / 12;
                                    //System.out.println("importeDoceavoComisionGerente"+importeDoceavoComisionGerente);
                                    
                                    importeDescuentoComisionAgente= importeDoceavoComisionAgente * numDoceavosDescuento;
                                   // System.out.println("importeDoceavoComisionGerente"+importeDescuentoComisionAgente);
                                    importeDescuentoComisionSupervisor= importeDoceavoComisionSupervisor * numDoceavosDescuento;
                                   // System.out.println("importeDescuentoComisionSupervisor"+importeDescuentoComisionSupervisor);
                                    importeDescuentoComisionGerente= importeDoceavoComisionGerente * numDoceavosDescuento;
                                   // System.out.println("importeDescuentoComisionGerente"+importeDescuentoComisionGerente);
                                    
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                    Date $180Dias = null;
                                    try {
                                        $180Dias = dateFormat.parse("19/02/1986");
                                    } catch (ParseException ex) {
                                        ex.printStackTrace();
                                    }
                                    Date fechaPolizaLimite =new Date( poliza.getFechaInicioVigencia().getTime() + $180Dias.getTime());
                                    
                                    if(poliza.getFechaCancelacion() != null && poliza.getFechaCancelacion().compareTo(fechaPolizaLimite) > 180){
                                        importeDescuentoComisionAgente = importeDescuentoComisionAgente / 2;
                                        importeDescuentoComisionSupervisor = importeDescuentoComisionSupervisor / 2;
                                        importeDescuentoComisionGerente = importeDescuentoComisionGerente / 2;
                                    }
                                    
                                    
                                    
                                    int numPoliza=poliza.getNumPoliza();
                                    int numConsignatario=poliza.getNumConsignatario();
                                    poliza.setNumPoliza(numPoliza);
                                    poliza.setNumConsignatario(numConsignatario);
                                    poliza.setIndicadorDescuentoComision(1);
                                    polizaDao.actualizaIndicadorDescuentoComision(poliza);
                                    
                                    /**
                                     * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                                     */
                                    detalleDescComSolic.setFolioSolicitud(solicitud.getFolioSolicitud());
                                    detalleDescComSolic.setFormatoSolicitud(solicitud.getFormatoSolicitud());
                                    detalleDescComSolic.setImporteDescuentoComisionAgente(importeDescuentoComisionAgente);
                                    detalleDescComSolic.setImporteDescuentoComisionSupervisor(importeDescuentoComisionSupervisor);
                                    detalleDescComSolic.setImporteDescuentoComisionGerente(importeDescuentoComisionGerente);
                                    /**
                                     * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                                     */
                                    List listaDetallesDescCom=getSolicitudDao().
                                    		obtenDetalleDescuentoComisionSolicitud(solicitud.getFolioSolicitud(),solicitud.getFormatoSolicitud());
                
                                            if(listaDetallesDescCom.isEmpty()){                
                                            solicitudDao.insertaDetalleDescuentoComisionSolicitud(detalleDescComSolic);
                                            }
                                            else{
                                                solicitudDao.actualizaDetalleDescuentoComisionSolicitud(detalleDescComSolic);
                                            }
                                    
                                    
                                }else{
                                	/**
                                     * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                                     */
                                    detalleDescComSolic.setFolioSolicitud(solicitud.getFolioSolicitud());
                                    detalleDescComSolic.setFormatoSolicitud(solicitud.getFormatoSolicitud());
                                    detalleDescComSolic.setImporteDescuentoComisionAgente(0);
                                    detalleDescComSolic.setImporteDescuentoComisionSupervisor(0);
                                    detalleDescComSolic.setImporteDescuentoComisionGerente(0);
                                    /**
                                     * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
                                     */
                                    List listaDetallesDescCom=getSolicitudDao().
                                    		obtenDetalleDescuentoComisionSolicitud(solicitud.getFolioSolicitud(),solicitud.getFormatoSolicitud());
                
                                            if(listaDetallesDescCom.isEmpty()){                
                                            solicitudDao.insertaDetalleDescuentoComisionSolicitud(detalleDescComSolic);
                                            }
                                            else{
                                                solicitudDao.actualizaDetalleDescuentoComisionSolicitud(detalleDescComSolic);
                                            }
                                 }
                                
                            }
                        }
                        totalDescuentoComisionAgente = totalDescuentoComisionAgente + importeDescuentoComisionAgente;
                        //    System.out.println("totalDescuentoComisionAgente"+totalDescuentoComisionAgente);
                        totalDescuentoComisionSupervisor = totalDescuentoComisionSupervisor + importeDescuentoComisionSupervisor;
                        //  System.out.println("totalDescuentoComisionSupervisor"+totalDescuentoComisionSupervisor);
                        totalDescuentoComisionGerente = totalDescuentoComisionGerente + importeDescuentoComisionGerente;
                        // System.out.println("totalDescuentoComisionGerente"+totalDescuentoComisionGerente);
                    }
                    
                    
                    
                }
                DescuentoComisionAgente descuentoComision=new DescuentoComisionAgente();
                descuentoComision.setCveAgente(agente.getCveAgente());
                descuentoComision.setTotalDescuentoComisionAgente(totalDescuentoComisionAgente);
                descuentoComision.setTotalDescuentoComisionGerente(totalDescuentoComisionGerente);
                descuentoComision.setTotalDescuentoComisionSupervisor(totalDescuentoComisionSupervisor);
                List listaDescuentos=getAgenteDao().obtenDescuentoComisionAgente(agente.getCveAgente());
                
                if(listaDescuentos.isEmpty()){
                    agenteDao.insertaDescuentoComisionAgente(descuentoComision);
                } else{
                    agenteDao.actualizaDescuentoComisionAgente(descuentoComision);
                }
               
            }
            System.out.println("lista de agentes"+listaAgentes.size());
            System.out.println("indice de lista"+i);
        }
         bandera=true;
        System.out.println("Termina metodo de calculo descuento comisiones");
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
