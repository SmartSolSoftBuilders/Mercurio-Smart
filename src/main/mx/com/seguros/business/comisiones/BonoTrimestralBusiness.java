/*
 * BonoTrimestralBusiness.java
 *
 * Created on 24 de marzo de 2008, 03:28 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.business.comisiones;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.*;
import java.util.List;
import mx.com.seguros.data.dao.IAgenteDao;
import mx.com.seguros.data.dao.IEsquemaRetencionImpuestosDao;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.ComisionBrutaAgente;
import mx.com.seguros.model.Empleado;
import mx.com.seguros.model.ProduccionQuincenaPuntosAgente;
import mx.com.seguros.model.TipoAgente;
import mx.com.seguros.model.BonoTrimestralAgente;
import mx.com.seguros.web.comisiones.GenerarPagoComisionesCommand;
import mx.com.seguros.business.reporte.ReporteBusiness;
import mx.com.seguros.business.reporte.ReportesPDF;
/**
 *
 * @author QTX
 */
public class BonoTrimestralBusiness {
    private IAgenteDao agenteDao;
    private ISolicitudDao solicitudDao;
    private IPolizaDao polizaDao;
    private IEsquemaRetencionImpuestosDao esquemasRetencionDao;
    private int numReportes;
    private int ejecucionBonoTrimReciente;
    
    
    Integer honorarios=1;
    Integer asimilablesSalario=2;
    Integer factura=4;
    Integer noDeterminado=5;
    
    
    String rutaReportePagoComisionesSupervisor=new String();
    String rutaReportePagoComisionesGerente=new String();
    String rutaReportePagoComisionesSupervisorAsimilables=new String();
    String rutaReportePagoComisionesGerenteAsimilables=new String();
    String rutaReportePagoComisionesSupervisorFactura=new String();
    String rutaReportePagoComisionesGerenteFactura=new String();
    String rutaReportePagoComisionesSupervisorNoDeterminado=new String();
    String rutaReportePagoComisionesGerenteNoDeterminado=new String();
    
    ReporteBusiness reporteBusiness = null;
   

	ReportesPDF reporteGenerado = new ReportesPDF();
    
    private ProduccionQuincenaPuntosAgente produccionQuin;
    
    
    /** Creates a new instance of BonoTrimestralBusiness */
    public BonoTrimestralBusiness() {
    }
    
    public boolean obtenerBonoTrimestral(int numQnaComision){
        boolean bandera=false;
        
        
        
        double efectividadMinimaVentasTrimestre=0.00;
        double efectividadOptimaVentasTrimestre=0.00;
        double efectividadMaximaVentasTrimestre=0.00;
        
        double importeBonoAgente=0.00;
        double importeBonoSupervisor=0.00;
        double importeBonoGerente=0.00;
        
        double porcentajeBonoAgente=0.00;
        double porcentajeBonoSupervisor=0.00;
        double porcentajeBonoGerente=0.00;
        
        
        
        List listaAgentes=getAgenteDao().obtenTodosAgentes();
        List listaBonos=getAgenteDao().obtenBonoTrimestralAgente();
        
        if(listaBonos.isEmpty()){
            
        } else{
            agenteDao.borraBonoTrimestralAgente();
        }
        
        for(int i=0;i<listaAgentes.size();i++){
            int contadorAplicacionBonoAgente = 0;
            double totalReservaBonoTrimestral=0;
            double totalProduccionTrimestralPuntosAgente=0;
            System.out.println("indice lista agentes"+i);
            Agente agente =(Agente)listaAgentes.get(i);
            TipoAgente tipoagt=(TipoAgente)agenteDao.obtenerTipoAgente(agente.getTipoAgente());
            
            
            
            if(getAgenteDao().obtenerListaProduccionesQuincenalesPuntosAgente(agente.getCveAgente()).isEmpty()){
                System.out.println("******lista sin valores******");
            }
            
            else{
                System.out.println("******La lista contiene valores******");
                List listaProducciones=getAgenteDao().obtenerListaProduccionesQuincenalesPuntosAgente(agente.getCveAgente());
                for(int j=0;j<listaProducciones.size();j++){
                    System.out.println("indice lista producciones"+j);
                    ProduccionQuincenaPuntosAgente prodLista=(ProduccionQuincenaPuntosAgente)listaProducciones.get(j);
                    
                    contadorAplicacionBonoAgente = contadorAplicacionBonoAgente + 1 ;
                    System.out.println("contadorAplicacionBonoAgente"+contadorAplicacionBonoAgente);
                    totalProduccionTrimestralPuntosAgente = totalProduccionTrimestralPuntosAgente + prodLista.getTotalProduccionPuntos();
                    System.out.println("totalProduccionTrimestralPuntosAgente"+totalProduccionTrimestralPuntosAgente);
                    totalReservaBonoTrimestral = totalReservaBonoTrimestral + prodLista.getReservaBonoTrim();
                    System.out.println("totalReservaBonoTrimestral"+totalReservaBonoTrimestral);
                    
                    int anoQuincena=prodLista.getAnoQuincenaComision();
                    int cveAgente=prodLista.getCveAgente();
                    int numQuincenaComision=prodLista.getNumQuincenaComision();
                    System.out.println("año quincena comision"+anoQuincena);
                    System.out.println("clave del agente"+cveAgente);
                    System.out.println("numer de quincena"+numQuincenaComision);
                    
                    ProduccionQuincenaPuntosAgente produccionQuin=new ProduccionQuincenaPuntosAgente();
                    produccionQuin.setAnoQuincenaComision(anoQuincena);
                    produccionQuin.setCveAgente(cveAgente);
                    produccionQuin.setNumQuincenaComision(numQuincenaComision);
                    produccionQuin.setIndicadorCalculoAsignacionBonoTrim(1);
                    agenteDao.actualizaProduccionesQuincenalesPuntosAgente(produccionQuin);
                    
                }
                efectividadMinimaVentasTrimestre=(tipoagt.getProduccionMinimaPuntos() * 0.80) * 3;
                efectividadOptimaVentasTrimestre=(tipoagt.getProduccionMinimaPuntos() * 0.90) * 3;
                efectividadMaximaVentasTrimestre=tipoagt.getProduccionMinimaPuntos() * 3;
                
                if(contadorAplicacionBonoAgente >3){
                    System.out.println("estoy en el if contador bono agente > 3");
                    
                    
                    
                    if(totalProduccionTrimestralPuntosAgente < efectividadMinimaVentasTrimestre){
                        importeBonoAgente = 0;
                        System.out.println("else importeBonoAgente"+importeBonoAgente);
                        importeBonoSupervisor = totalReservaBonoTrimestral / 2;
                        System.out.println("else importeBonoSupervisor"+importeBonoSupervisor);
                        importeBonoGerente = totalReservaBonoTrimestral / 2;
                        System.out.println("else importeBonoGerente"+importeBonoGerente);
                        
                    } else {
                        if(totalProduccionTrimestralPuntosAgente >= efectividadMinimaVentasTrimestre
                                && totalProduccionTrimestralPuntosAgente <= efectividadOptimaVentasTrimestre){
                            
                            porcentajeBonoAgente = (totalProduccionTrimestralPuntosAgente * 100) / efectividadMaximaVentasTrimestre;
                            porcentajeBonoSupervisor = (100 - porcentajeBonoAgente) / 2;
                            porcentajeBonoGerente = porcentajeBonoSupervisor;
                            
                            importeBonoAgente = (totalReservaBonoTrimestral * porcentajeBonoAgente) / 100;
                            importeBonoSupervisor = (totalReservaBonoTrimestral * porcentajeBonoSupervisor) / 100;
                            importeBonoGerente = (totalReservaBonoTrimestral * porcentajeBonoGerente) / 100;
                            
                        } else{
                            importeBonoAgente = totalReservaBonoTrimestral;
                            importeBonoSupervisor = 0;
                            importeBonoGerente = 0;
                        }
                        
                        
                    }
                    
                    
                }
                
                else {
                    if(totalProduccionTrimestralPuntosAgente >= efectividadMinimaVentasTrimestre
                            && totalProduccionTrimestralPuntosAgente <= efectividadOptimaVentasTrimestre){
                        
                        porcentajeBonoAgente = (totalProduccionTrimestralPuntosAgente * 100) / efectividadMaximaVentasTrimestre;
                        porcentajeBonoSupervisor = (100 - porcentajeBonoAgente) / 2;
                        porcentajeBonoGerente = porcentajeBonoSupervisor;
                        
                        importeBonoAgente = (totalReservaBonoTrimestral * porcentajeBonoAgente) / 100;
                        importeBonoSupervisor = (totalReservaBonoTrimestral * porcentajeBonoSupervisor) / 100;
                        importeBonoGerente = (totalReservaBonoTrimestral * porcentajeBonoGerente) / 100;
                        
                    } else{
                        importeBonoAgente = totalReservaBonoTrimestral;
                        importeBonoSupervisor = 0;
                        importeBonoGerente = 0;
                    }
                    
                    
                }
                BonoTrimestralAgente bonoTrim=new BonoTrimestralAgente();
                bonoTrim.setCveAgente(agente.getCveAgente());
                bonoTrim.setImporteBonoAgente(importeBonoAgente);
                bonoTrim.setImporteBonoGerente(importeBonoGerente);
                bonoTrim.setImporteBonoSupervisor(importeBonoSupervisor);
                agenteDao.insertaBonoTrimestralAgente(bonoTrim);
                
                bandera=true;
                
                
            }
            
        }
        
        String rutaReporteAsignacionBonoTrimestral = reporteBusiness.generarReporteAsignacionBonoTrimestral(numQnaComision);
        reporteGenerado.setRutaReporteAsignacionBonoTrimestral(rutaReporteAsignacionBonoTrimestral);
        setNumReportes(2);
        
       
        
        return bandera;
    }
    
   
    
    //Generacion de los reportes//
    public int generarReportes(GenerarPagoComisionesCommand comisiones) throws IOException {
        
        
        int cveAgente;
        
        ComisionBrutaAgente comision=comisiones.getComisionBrutaAgente();
        Date fechaInicioPeriodoComisiones=comision.getFechaInicioPeriodoComisiones();
        Date fechaFinPeriodoComisiones=comision.getFechaFinPeriodoComisiones();
        int numQuincenaReporte=comision.getNumQuincenaReporte();
        int anioQuincenaReporte=comision.getAnioQuincena();
        List listaEsquemas=getEsquemasRetencionDao().obtenerListaEsquemasRetencion();
        ArrayList rutas=new ArrayList();
        
        
        
        int cveEmpleado;
        
        
        Calendar c1=Calendar.getInstance();
        String anioComision=Integer.toString(c1.get(Calendar.YEAR));
        Integer anioComisionAux=new Integer(anioComision);
        ProduccionQuincenaPuntosAgente produccion=new ProduccionQuincenaPuntosAgente();
        produccion.setAnoQuincenaComision(anioComisionAux);
        produccion.setNumQuincenaComision(numQuincenaReporte);
        List listaAgentesProduccion=agenteDao.obtenerClaveAgentePorProduccionQuincenal(produccion);
        int indicadorReportesGerentesySupervisoresHonorarios=0;
        int indicadorReportesGerentesySupervisoresAsimilables=0;
        int indicadorReportesGerentesySupervisoresFactura=0;
        int indicadorReportesGerentesySupervisoresNoDeterminado=0;
        int indicador=0;
        
        for(int a=0; a<listaAgentesProduccion.size();a++ ){
            
            ProduccionQuincenaPuntosAgente produccionAux=(ProduccionQuincenaPuntosAgente)listaAgentesProduccion.get(a);
            cveAgente=produccionAux.getCveAgente();
            System.out.println("clave agente en lista produccion"+cveAgente);
            
            Agente unAgente=new Agente();
            unAgente=(Agente) agenteDao.obtenerIndicadorEsquemaEmpleado(cveAgente);
            if(unAgente.getIdEsquema()==honorarios){
                System.out.println("estoy en el if obtener indicador esquema empleado");
                System.out.println(fechaInicioPeriodoComisiones+" "+fechaFinPeriodoComisiones+" "+cveAgente+" "+numQuincenaReporte);
                String rutaReportePagoComisionesAgente = reporteBusiness.generarReportePagoComisionesAgente(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveAgente,numQuincenaReporte,anioQuincenaReporte);
                rutas.add(rutaReportePagoComisionesAgente);
                reporteGenerado.setRutaReportePagoComisionesAgente(rutaReportePagoComisionesAgente);
              /*  if(!(indicadorReportesGerentesySupervisoresHonorarios==1)){
                    GenerarReportesGerentesySupervisores(rutas,
                            numQuincenaReporte,fechaInicioPeriodoComisiones,
                            fechaFinPeriodoComisiones,
                            cveAgente,
                            indicador);
                    indicadorReportesGerentesySupervisoresHonorarios=1;
                }*/
                
                
            }
            
            if(unAgente.getIdEsquema()==asimilablesSalario){
                String rutaReportePagoComisionesAgenteAsimilables = reporteBusiness.generarReportePagoComisionesAgenteAsimilables(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveAgente,numQuincenaReporte,anioQuincenaReporte);
                rutas.add(rutaReportePagoComisionesAgenteAsimilables);
                reporteGenerado.setRutaReportePagoComisionesAgenteAsimilables(rutaReportePagoComisionesAgenteAsimilables);
              /*  if(!(indicadorReportesGerentesySupervisoresAsimilables==1)){
                    GenerarReportesGerentesySupervisores(rutas,
                            numQuincenaReporte,fechaInicioPeriodoComisiones,
                            fechaFinPeriodoComisiones,cveAgente,
                            indicador);
                    indicadorReportesGerentesySupervisoresAsimilables=1;
                }*/
                
            }
            
            if(unAgente.getIdEsquema()==factura){
                String rutaReportePagoComisionesAgenteFactura = reporteBusiness.generarReportePagoComisionesAgenteFactura(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveAgente,numQuincenaReporte,anioQuincenaReporte);
                rutas.add(rutaReportePagoComisionesAgenteFactura);
                reporteGenerado.setRutaReportePagoComisionesAgenteFactura(rutaReportePagoComisionesAgenteFactura);
               /* if(!(indicadorReportesGerentesySupervisoresFactura==1)){
                    GenerarReportesGerentesySupervisores(rutas,
                            numQuincenaReporte,fechaInicioPeriodoComisiones,
                            fechaFinPeriodoComisiones,cveAgente,
                            indicador);
                    indicadorReportesGerentesySupervisoresFactura=1;
                }*/
            }
            
            
            
            if(unAgente.getIdEsquema()==noDeterminado){
                String rutaReportePagoComisionesAgenteNoDeterminado = reporteBusiness.generarReportePagoComisionesAgenteNoDeterminado(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveAgente,numQuincenaReporte,anioQuincenaReporte);
                rutas.add(rutaReportePagoComisionesAgenteNoDeterminado);
                reporteGenerado.setRutaReportePagoComisionesAgenteNoDeterminado(rutaReportePagoComisionesAgenteNoDeterminado);
               /* if(!(indicadorReportesGerentesySupervisoresNoDeterminado==1)){
                    GenerarReportesGerentesySupervisores(rutas,
                            numQuincenaReporte,fechaInicioPeriodoComisiones,
                            fechaFinPeriodoComisiones,cveAgente,
                            indicador);
                    indicadorReportesGerentesySupervisoresNoDeterminado=1;
                }*/
            }
            
            
            
            
        }
        
        GenerarReportesGerentesySupervisores(rutas,
                numQuincenaReporte,anioQuincenaReporte,fechaInicioPeriodoComisiones,
                fechaFinPeriodoComisiones);
        
        for(int i=0;i<rutas.size();i++)   {
            String filesToZip = (String)rutas.get(i);
            System.out.println("una ruta   "+filesToZip);
        }
        
        hacerZip(rutas,fechaInicioPeriodoComisiones,fechaFinPeriodoComisiones,comisiones);
     return getNumReportes();

    }
    
    
     public int cambiarValoresRetorno(){
        setNumReportes(1);
        return getNumReportes();   
    }
    
    
    public void GenerarReportesGerentesySupervisores(ArrayList rutas,
            int numQuincenaReporte,
            int anioQuincenaReporte,
            Date fechaInicioPeriodoComisiones,
            Date fechaFinPeriodoComisiones){
        
        int cveGerente;
        int cveSupervisor;
        
        List listaGerentesProduccion=agenteDao.obtenerListaGerentesPorProduccion(numQuincenaReporte);
        for(int b=0;b<listaGerentesProduccion.size();b++){
            Agente unGerente=(Agente) listaGerentesProduccion.get(b);
            cveGerente=unGerente.getCveGerente();
            Empleado empleadoGerente=new Empleado();
            empleadoGerente=(Empleado) agenteDao.obtenerEsquemaGerente(cveGerente);
            if(empleadoGerente.getIdEsquema()==honorarios){
                rutaReportePagoComisionesGerente = reporteBusiness.generarReportePagoComisionesGerente(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveGerente,numQuincenaReporte,anioQuincenaReporte);
                reporteGenerado.setRutaReportePagoComisionesGerente(rutaReportePagoComisionesGerente);
                rutas.add(rutaReportePagoComisionesGerente);
                
            }
            
            if(empleadoGerente.getIdEsquema()==asimilablesSalario){
                rutaReportePagoComisionesGerenteAsimilables = reporteBusiness.generarReportePagoComisionesGerenteAsimilables(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveGerente,numQuincenaReporte,anioQuincenaReporte);
                reporteGenerado.setRutaReportePagoComisionesGerenteAsimilables(rutaReportePagoComisionesGerenteAsimilables);
                rutas.add(rutaReportePagoComisionesGerenteAsimilables);
                
            }
            
            if(empleadoGerente.getIdEsquema()==factura){
                rutaReportePagoComisionesGerenteFactura = reporteBusiness.generarReportePagoComisionesGerenteFactura(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveGerente,numQuincenaReporte,anioQuincenaReporte);
                reporteGenerado.setRutaReportePagoComisionesGerenteFactura(rutaReportePagoComisionesGerenteFactura);
                rutas.add(rutaReportePagoComisionesGerenteFactura);
                
            }
            
            if(empleadoGerente.getIdEsquema()==noDeterminado){
                rutaReportePagoComisionesGerenteNoDeterminado = reporteBusiness.generarReportePagoComisionesGerenteNoDeterminado(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveGerente,numQuincenaReporte,anioQuincenaReporte);
                reporteGenerado.setRutaReportePagoComisionesGerenteNoDeterminado(rutaReportePagoComisionesGerenteNoDeterminado);
                rutas.add(rutaReportePagoComisionesGerenteNoDeterminado);
                
            }
        }
        
        List listaSupervisoresProduccion=agenteDao.obtenerListaSupervisoresPorProduccion(numQuincenaReporte);
        for(int c=0;c<listaSupervisoresProduccion.size();c++){
            Agente unSupervisor=(Agente) listaSupervisoresProduccion.get(c);
            cveSupervisor=unSupervisor.getCveSupervisor();
            Empleado empleadoSupervisor=new Empleado();
            empleadoSupervisor=(Empleado) agenteDao.obtenerEsquemaSupervisor(cveSupervisor);
            if(empleadoSupervisor.getIdEsquema()==honorarios){
                rutaReportePagoComisionesSupervisor = reporteBusiness.generarReportePagoComisionesSupervisor(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveSupervisor,numQuincenaReporte,anioQuincenaReporte);
                reporteGenerado.setRutaReportePagoComisionesSupervisor(rutaReportePagoComisionesSupervisor);
                rutas.add(rutaReportePagoComisionesSupervisor);
                
            }
            if(empleadoSupervisor.getIdEsquema()==asimilablesSalario){
                rutaReportePagoComisionesSupervisorAsimilables = reporteBusiness.generarReportePagoComisionesSupervisorAsimilables(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveSupervisor,numQuincenaReporte,anioQuincenaReporte);
                reporteGenerado.setRutaReportePagoComisionesSupervisorAsimilables(rutaReportePagoComisionesSupervisorAsimilables);
                rutas.add(rutaReportePagoComisionesSupervisorAsimilables);
                
            }
            
            if(empleadoSupervisor.getIdEsquema()==factura){
                rutaReportePagoComisionesSupervisorFactura = reporteBusiness.generarReportePagoComisionesSupervisorFactura(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveSupervisor,numQuincenaReporte,anioQuincenaReporte);
                reporteGenerado.setRutaReportePagoComisionesSupervisorFactura(rutaReportePagoComisionesSupervisorFactura);
                rutas.add(rutaReportePagoComisionesSupervisorFactura);
                
            }
            if(empleadoSupervisor.getIdEsquema()==noDeterminado){
                rutaReportePagoComisionesSupervisorNoDeterminado = reporteBusiness.generarReportePagoComisionesSupervisorNoDeterminado(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones,cveSupervisor,numQuincenaReporte,anioQuincenaReporte);
                reporteGenerado.setRutaReportePagoComisionesSupervisorNoDeterminado(rutaReportePagoComisionesSupervisorNoDeterminado);
                rutas.add(rutaReportePagoComisionesSupervisorNoDeterminado);
                
            }
        }
        
    }
    
    
    
    
    
    
    public void hacerZip(ArrayList rutas,Date fechaInicioPeriodoComisiones,Date fechaFinPeriodoComisiones,GenerarPagoComisionesCommand comisiones) throws IOException{
        ReportesPDF rutaZip=new ReportesPDF();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy") ;
        String rutaVista="ReportesComisiones"+sdf.format(fechaInicioPeriodoComisiones)+"A"+sdf.format(fechaFinPeriodoComisiones)+".zip";
          
        String zipFileName = reporteBusiness.obtenerNombreArchivoSalida(
        		"ReportesComisiones"+sdf.format(fechaInicioPeriodoComisiones)+"A"+sdf.format(fechaFinPeriodoComisiones)+".zip");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        for(int i=0;i<rutas.size();i++)   {
            String filesToZip = reporteBusiness.obtenerNombreArchivoSalida((String)rutas.get(i));
            System.out.println("filesToZip "+filesToZip);
            File f = new File(filesToZip);
            byte[] buffer = new byte[18024];
            try{
                out.setLevel(Deflater.DEFAULT_COMPRESSION);
                FileInputStream in = new FileInputStream(filesToZip);
                out.putNextEntry(new ZipEntry(filesToZip));
                int len;
                while ((len = in.read(buffer)) > 0){
                    out.write(buffer, 0, len);
                }
                f.delete();
                out.closeEntry();
                in.close();
                
            } catch (IllegalArgumentException iae){
                iae.printStackTrace();
                System.exit(0);
            } catch (FileNotFoundException fnfe){
                fnfe.printStackTrace();
                System.exit(0);
            } catch (IOException ioe){
                ioe.printStackTrace();
                System.exit(0);
            }
            
            
        }
        
        out.close();
        reporteGenerado.setRutaVista(rutaVista);
        comisiones.setReportes(reporteGenerado);
    }
    
    
    
    
    
    
    public ReportesPDF obtenerReporte(GenerarPagoComisionesCommand comisiones){
        return comisiones.getReportes();
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
    
    public int getNumReportes() {
        return numReportes;
    }
    
    public void setNumReportes(int numReportes) {
        this.numReportes = numReportes;
    }
    
    public IEsquemaRetencionImpuestosDao getEsquemasRetencionDao() {
        return esquemasRetencionDao;
    }
    
    public void setEsquemasRetencionDao(IEsquemaRetencionImpuestosDao esquemasRetencionDao) {
        this.esquemasRetencionDao = esquemasRetencionDao;
    }
    
    public int getEjecucionBonoTrimReciente() {
        return ejecucionBonoTrimReciente;
    }
    
    public void setEjecucionBonoTrimReciente(int ejecucionBonoTrimReciente) {
        this.ejecucionBonoTrimReciente = ejecucionBonoTrimReciente;
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
    
    
}
