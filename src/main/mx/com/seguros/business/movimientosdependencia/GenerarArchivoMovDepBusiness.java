/*
 * GenerarArchivoMovDepBusiness.java
 *
 * Created on 27 de octubre de 2008, 06:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.business.movimientosdependencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import mx.com.seguros.business.reporte.ReporteBusiness;
import mx.com.seguros.data.dao.IMovimientosDependenciaDAO;
import mx.com.seguros.model.Contratante;
import mx.com.seguros.model.MovimientosDependencia;
import mx.com.seguros.web.movimientosdependencia.GenerarArchivoMovimientosDependenciaCommand;

/**
 *
 * @author QTX
 */
public class GenerarArchivoMovDepBusiness implements IGenerarArchivoMovDepBusiness{
    private IMovimientosDependenciaDAO movimientosDependenciaDAO;
    private ReporteBusiness reporteBusiness;
    /** Creates a new instance of GenerarArchivoMovDepBusiness */
    public GenerarArchivoMovDepBusiness() {
    }

    @Override
    public List obtenerDatosArchivo(GenerarArchivoMovimientosDependenciaCommand movimientosDependencia) {
        List listaDatos = new ArrayList();
        List objetos = new ArrayList();
        MovimientosDependencia movDependencia = movimientosDependencia.getMovimientosDependencia();        
        String anioQuincena = movimientosDependencia.getAnioQuincena();        
        String siglas = movimientosDependencia.getSiglasRetenedor();
        Contratante[] listaContratantes = movDependencia.getContratantes();
        if(anioQuincena.length() == 5){
            anioQuincena = anioQuincena.substring(0,4)+"0"+anioQuincena.substring(4,5);
        }
        movDependencia.setAnioQuincena(anioQuincena);
        listaDatos = movimientosDependenciaDAO.obtenerDatosArchivo(movDependencia);        
        System.out.println("siglas retenedor " + siglas);
        System.out.println("anio quincena " + anioQuincena);
        objetos.add(siglas);
        objetos.add(listaDatos);
        objetos.add(anioQuincena);
        objetos.add(listaContratantes);
        return objetos;
    }
    
   
    public String crearArchivoTXT (List objetos){        
        //String ruta = "C:/Archivos de programa/Apache Software Foundation/Tomcat 6.0/webapps/seguros/reportes/";
        //String ruta = "C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/seguros2/reportes/";
        
        String nombre = objetos.get(0).toString()+objetos.get(2).toString()+".txt";       
        String ruta = reporteBusiness.obtenerNombreArchivoSalida(nombre);
        System.out.println("ruta y nombre "+ruta);
        try {
              FileWriter fw =new FileWriter(ruta);
              BufferedWriter bw = new BufferedWriter(fw);
              Double importeAux = 0.0;
              String importeStr = new String();
              for (int i=0; i < ((List)objetos.get(1)).size(); i++){
                MovimientosDependencia elemento = (MovimientosDependencia) ((List)objetos.get(1)).get(i);
                StringBuffer parametros = new StringBuffer();
                parametros.append(1);
                parametros.append("       ");
                parametros.append("00000000");
                parametros.append(objetos.get(2));
                parametros.append(999999);
                parametros.append(elemento.getHistorial().getCveDescuento());
                parametros.append(elemento.getHistorial().getTipoMovimientoEnvio());
                importeAux = elemento.getHistorial().getTotalImporteMovimiento();
                importeStr = importeAux.toString();
                List importeCompletoList = new ArrayList();
                StringBuffer parametroImporte = new StringBuffer();
                StringTokenizer stokenizer = new StringTokenizer(importeStr,".");
                String parametroImporteFinal = new String();
                while (stokenizer.hasMoreTokens()){
                        String importeEntero = stokenizer.nextToken();
                        importeCompletoList.add(importeEntero);
                    }
                for(int j = 0; j < importeCompletoList.size(); j++){
                    parametroImporte.append(importeCompletoList.get(j).toString());                    
                }                
                if (parametroImporte.length() < 7){
                    parametroImporteFinal = (parametroImporte + "0").toString();
                    while(parametroImporteFinal.length() < 7){
                        parametroImporteFinal = "0" + parametroImporteFinal.toString();
                    }                    
                }
                parametros.append(parametroImporteFinal);// ejemplo 0054800 la cantidad original es 548.00                
                parametros.append(elemento.getHistorial().getNumNominaContratante());
                if ((elemento.getSolicitud().getContratante().getApPaternoContratante()+ " "+elemento.getSolicitud().getContratante().getApMaternoContratante() + " "
                        +elemento.getSolicitud().getContratante().getNombre1Contratante() + " "+elemento.getSolicitud().getContratante().getNombre2Contratante() + " ").length()<28){
                parametros.append(elemento.getSolicitud().getContratante().getApPaternoContratante() + " ");//deben ser maximo 28 caracteres con el nombre completo
                parametros.append(elemento.getSolicitud().getContratante().getApMaternoContratante() + " ");
                parametros.append(elemento.getSolicitud().getContratante().getNombre1Contratante() + " ");
                parametros.append(elemento.getSolicitud().getContratante().getNombre2Contratante() + " ");
                } else {
                    String nombreCompleto = (elemento.getSolicitud().getContratante().getApPaternoContratante()+ " "+elemento.getSolicitud().getContratante().getApMaternoContratante() + " "
                        +elemento.getSolicitud().getContratante().getNombre1Contratante() + " "+elemento.getSolicitud().getContratante().getNombre2Contratante() + " ").substring(0,28);
                    parametros.append(nombreCompleto);
                }                
                String saltoLinea = System.getProperty("line.separator");
                parametros.append(saltoLinea);
                bw.write(parametros.toString());                
                }
                Contratante[] contratantes = (Contratante[])(objetos.get(3));
                List contratantesAdicionales = new ArrayList();
                for (int i=0;i < contratantes.length; i++){
                    if(contratantes[i].getNumNominaContratante() != null){
                        if(!contratantes[i].getNumNominaContratante().equals("")){
                        contratantesAdicionales.add(contratantes[i]);                        
                        }
                    }
                }
                if(contratantesAdicionales.size() > 0){ 
                	List listaMovimientos = (List)objetos.get(1);
                    MovimientosDependencia elemento = listaMovimientos.isEmpty()?null:(MovimientosDependencia)listaMovimientos.get(0);
                    PrintWriter pw = new PrintWriter(fw);
                    for (int i=0; i < contratantesAdicionales.size() && elemento!=null; i++){
                        StringBuffer parametros = new StringBuffer();
                        parametros.append(1);
                        parametros.append("       ");
                        parametros.append("00000000");
                        parametros.append(objetos.get(2));
                        parametros.append(999999);
                        parametros.append(elemento.getHistorial().getCveDescuento());
                        parametros.append(((Contratante)(contratantesAdicionales.get(i))).getTipoMovimiento());
                        importeAux = ((Contratante)(contratantesAdicionales.get(i))).getImporteTarifa();
                        importeStr = importeAux.toString();
                        List importeCompletoList = new ArrayList();
                        StringBuffer parametroImporte = new StringBuffer();
                        StringTokenizer stokenizer = new StringTokenizer(importeStr,".");
                        String parametroImporteFinal = new String();
                        while (stokenizer.hasMoreTokens()){
                            String importeEntero = stokenizer.nextToken();
                            importeCompletoList.add(importeEntero);
                        }
                        for(int j = 0; j < importeCompletoList.size(); j++){
                        parametroImporte.append(importeCompletoList.get(j).toString());                    
                        }                
                        if (parametroImporte.length() < 7){
                            parametroImporteFinal = (parametroImporte + "0").toString();
                            while(parametroImporteFinal.length() < 7){
                            parametroImporteFinal = "0" + parametroImporteFinal.toString();
                            }                    
                        }
                        parametros.append(parametroImporteFinal);// ejemplo 0054800 la cantidad original es 548.00                
                        parametros.append(((Contratante)(contratantesAdicionales.get(i))).getNumNominaContratante());
                        if ((((Contratante)(contratantesAdicionales.get(i))).getApPaternoContratante()+ " "+((Contratante)(contratantesAdicionales.get(i))).getApMaternoContratante() + " "
                            +((Contratante)(contratantesAdicionales.get(i))).getNombre1Contratante() + " "+((Contratante)(contratantesAdicionales.get(i))).getNombre2Contratante() + " ").length()<28){
                            parametros.append(((Contratante)(contratantesAdicionales.get(i))).getApPaternoContratante() + " ");//deben ser maximo 28 caracteres con el nombre completo
                            parametros.append(((Contratante)(contratantesAdicionales.get(i))).getApMaternoContratante() + " ");
                            parametros.append(((Contratante)(contratantesAdicionales.get(i))).getNombre1Contratante() + " ");
                            parametros.append(((Contratante)(contratantesAdicionales.get(i))).getNombre2Contratante() + " ");
                        } else {
                            String nombreCompleto = (((Contratante)(contratantesAdicionales.get(i))).getApPaternoContratante()+ " "+((Contratante)(contratantesAdicionales.get(i))).getApMaternoContratante() + " "
                            +((Contratante)(contratantesAdicionales.get(i))).getNombre1Contratante() + " "+((Contratante)(contratantesAdicionales.get(i))).getNombre2Contratante() + " ").substring(0,28);
                            parametros.append(nombreCompleto);
                        }                        
                        String saltoLinea = System.getProperty("line.separator");
                        parametros.append(saltoLinea);
                        bw.write(parametros.toString());
                        //pw.println(parametros.toString());                        
                    }
                }
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }        
        return nombre;
    }

    public void setMovimientosDependenciaDAO(IMovimientosDependenciaDAO movimientosDependenciaDAO) {
        this.movimientosDependenciaDAO = movimientosDependenciaDAO;
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
