/*
 * GenerarArchivoPagosRetenedorBusiness.java
 *
 * Created on 14 de noviembre de 2008, 01:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.business.movimientosdependencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import mx.com.seguros.business.reporte.ReporteBusiness;
import mx.com.seguros.business.reporte.ReportesPDF;
import mx.com.seguros.data.dao.ILayoutMovimientosRecibidosDao;
import mx.com.seguros.model.LayoutMovimientosRecibidos;
import mx.com.seguros.web.movimientosdependencia.GenerarArchivoPagosRetenedorCommand;

/**
 *
 * @author QTXr
 */
public class GenerarArchivoPagosRetenedorBusiness implements IGenerarArchivoPagosRetenedorBusiness{
    private ILayoutMovimientosRecibidosDao layoutDao;
    private String error;
    private ReporteBusiness reporteBusiness = null;
    /** Creates a new instance of GenerarArchivoPagosRetenedorBusiness */
    public GenerarArchivoPagosRetenedorBusiness() {
    }

    public void leerArchivoPagoRetenedores(InputStream archivoEntrada) {
        try{
        InputStreamReader fr = new InputStreamReader(archivoEntrada);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        StringBuffer filaInsertar = new StringBuffer();
        LayoutMovimientosRecibidos layout = new LayoutMovimientosRecibidos();
        layoutDao.eliminarRegistrosListaColumnas();
        while((linea=br.readLine())!=null){ 
            if(!linea.isEmpty()){
                while(linea.length() < 105){
                    linea = linea + " ";
                }            
            /*layout.setConstante(Integer.parseInt(linea.substring(0,1)));            
            layout.setEspacios(linea.substring(1,8));
            layout.setNumCertificado(linea.substring(8,16));
            layout.setFechaInicioDescuento(linea.substring(16,22));
            layout.setFechaSuspencionDescuento(linea.substring(22,28));
            layout.setCveDescuento(linea.substring(28,30));
            layout.setTipoMovimiento(linea.substring(30,31));
            layout.setImporteDescuento(Double.parseDouble(linea.substring(31,36))+.00);
            layout.setRFC(linea.substring(38,51));
            layout.setNombre(linea.substring(51,80));*/
            layout.setAnioQuincena(linea.substring(0,6));
            layout.setRFC(linea.substring(6,19));
            layout.setNombre(linea.substring(19,47));
            layout.setCveDescuento(linea.substring(70,72));
            layout.setImporteDescuento(Double.parseDouble(linea.substring(72,85)));
            layoutDao.insertarLayoutMovimientosRecibidos(layout);
            }
        }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ILayoutMovimientosRecibidosDao getLayoutDao() {
        return layoutDao;
    }

    public void setLayoutDao(ILayoutMovimientosRecibidosDao layoutDao) {
        this.layoutDao = layoutDao;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String generarArchivoPagosRetenedor() {
        List listaDatosLayout = layoutDao.obtenerDatosLista();
        LayoutMovimientosRecibidos elemento = (LayoutMovimientosRecibidos)listaDatosLayout.get(0);
        String anioQuincenaPago = elemento.getAnioQuincena();
        String cveDescuento = elemento.getCveDescuento();
        String siglasRetenedor = layoutDao.obtenerSiglasRetenedor(cveDescuento); 
        System.out.println("siglasRetenedor "+siglasRetenedor);
        
        String rutaArchivoPagosRetenedor = reporteBusiness.generarArchivoPagosRetenedor(anioQuincenaPago,siglasRetenedor);        
        return rutaArchivoPagosRetenedor;
    }
    
    public String generarArchivoAltaAsegurados(int cveRetenedor){
        List listaDatosLayout = layoutDao.obtenerDatosLista();
        LayoutMovimientosRecibidos elemento = (LayoutMovimientosRecibidos)listaDatosLayout.get(0);
        String anioQuincenaAplicacion = elemento.getAnioQuincena();
        String cveDescuento = elemento.getCveDescuento();
        String siglasRetenedor = layoutDao.obtenerSiglasRetenedor(cveDescuento);
        
        String rutaArchivoAltaAsegurados = reporteBusiness.generarArchivoAltaAsegurados(cveRetenedor,anioQuincenaAplicacion,siglasRetenedor);        
        return rutaArchivoAltaAsegurados;
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
