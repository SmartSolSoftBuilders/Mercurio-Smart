/*
 * generaXLS.java
 *
 * Created on 6 de marzo de 2008, 12:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package mx.com.seguros.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import mx.com.seguros.business.reporte.ReporteBusiness;
import org.apache.commons.lang.SystemUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
/**
 *
 * @author Alverik, CGM
 */
public class GeneraXLS {
	
	public static final String ARCHIVO_RECHAZOS_DIR;
    private static final String FOLDER_SEPARATOR;
    private static final Logger LOG;
    private String strNombreArchivo;
    private ReporteBusiness reporteBusiness = new ReporteBusiness();
    static {
        LOG = LoggerFactory.getLogger(GeneraXLS.class);
        FOLDER_SEPARATOR = SystemUtils.FILE_SEPARATOR;
        ARCHIVO_RECHAZOS_DIR = FOLDER_SEPARATOR
                + "Archivos" + FOLDER_SEPARATOR;
        LOG.info("ARCHIVO_RECHAZOS_DIR: " + ARCHIVO_RECHAZOS_DIR);
    }
    /** Creates a new instance of generaXLS */
    public GeneraXLS() {
    }
    
    public void generaLibro(ArrayList datos,String nombreHoja,String nombreArchivo,String rutaArchivo) throws Exception{
    	//HSSFWorkbook objWB = new HSSFWorkbook();
        //HSSFSheet hoja1 = objWB.createSheet(nombreHoja);
    	Workbook wbs = new XSSFWorkbook();
    	   
        //HSSFSheet hoja1 = objWB.createSheet(nombreHoja);
    	Sheet hoja1 = wbs.createSheet(nombreHoja);
    	System.out.println("reporte");
    	for(int i=0;i<datos.size();i++){
        	Row fila = hoja1.createRow((short)i);
            ArrayList filaDatos=(ArrayList)datos.get(i);
            for(int j=0;j<filaDatos.size();j++){
                //HSSFCell celda = fila.createCell((short)j);
            	Cell celda = fila.createCell((short)j);
                celda.setCellValue(filaDatos.get(j).toString());
                //HSSFCellStyle estiloCelda = objWB.createCellStyle();
                CellStyle estiloCelda = wbs.createCellStyle();
                estiloCelda.setAlignment(CellStyle.ALIGN_FILL);
                celda.setCellStyle(estiloCelda);
            }
        }
        setStrNombreArchivo(reporteBusiness.obtenerNombreArchivoSalida(rutaArchivo + nombreArchivo+".xlsx"));
        //setStrNombreArchivo("C:/Archivos de programa/Apache Software Foundation/Tomcat 6.0/webapps/seguros/reportes/"+nombreArchivo+".xls");
        //setStrNombreArchivo("C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/seguros2/reportes/"+nombreArchivo+".xls");
        
        File objFile = new File(getStrNombreArchivo());
        FileOutputStream archivoSalida = new FileOutputStream(objFile);
        wbs.write(archivoSalida);
        archivoSalida.close();
    }

    public String getStrNombreArchivo() {
        return strNombreArchivo;
    }

    public void setStrNombreArchivo(String strNombreArchivo) {
        this.strNombreArchivo = strNombreArchivo;
    }
    
    
    
}
