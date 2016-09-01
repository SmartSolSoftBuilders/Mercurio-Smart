package mx.com.seguros.business.consulta;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.draw.geom.Path;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.dto.CriteriosConsultaPolizaPorBajaDTO;
import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

public class GeneraArchivoConsultaGeneralExcelImpl implements GeneraArchivoConsultaGeneralExcel {
  

	public GeneraArchivoConsultaGeneralExcelImpl() {
		super();
	}



	@Override
	public File generaArchivoExcel(ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado) {
		
		XSSFWorkbook libroTrabajo = new XSSFWorkbook();
		XSSFSheet hoja1 = libroTrabajo.createSheet("Hoja 1");
		File archivo = null;
		try {
			archivo = File.createTempFile("pattern", ".xlsx");
			System.out.println("RUTA excel generado: " + archivo.getAbsolutePath());
	        String[] titulos = { "Plaza", "Certificado", "Nombre Contratante", "Num. Nómina Asegurado", "Folio de Solicitud", "Formato", "Fecha Solicitud", "Estado Solicitud", "Nombre Asegurado", "RFC Asegurado", "Tel. Solicitante", "Emisor", "Pagos Póliza", "Paquete ", "Grupo Asegurado","Prima Mensual","Escuela","Sucursal","Agente","Saldo Cuenta","Importe Retiros" };
	        XSSFCell celdaTitulos;
	        int renglonApartir=5;
	        System.out.println("RUTA excel generado: " + archivo.getAbsolutePath());
	        
	        XSSFFont font = libroTrabajo.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			XSSFCellStyle style = libroTrabajo.createCellStyle();
			style.setFont(font);
	        
	        //Generar el contenido
	        Row encabezado = hoja1.createRow((short)0);
	        	Cell cell= encabezado.createCell((short)0);
	        	cell.setCellValue("Consulta General de Solicitudes");
	        	cell.setCellStyle(style);
	        	
	        Row fila1 = hoja1.createRow((short)1);
	        	Cell cell2= fila1.createCell((short)0);
	        	cell2.setCellValue(" ");
	        	
	        Row fila2 = hoja1.createRow((short)2);
	        	Cell cell3= fila2.createCell((short)0);
	        	cell3.setCellValue("Total de Registros: " + resultado.getTotalResultados());
	        	cell3.setCellStyle(style);
	        	
	        Row fila3 = hoja1.createRow((short)3);
	        	Cell cell4= fila3.createCell((short)0);
	        	cell4.setCellValue("Total de Primas: " + resultado.getTotalPrima());
	        	cell4.setCellStyle(style);
	        	
	        Row fila4 = hoja1.createRow((short)4);
	        	Cell cell5= fila4.createCell((short)0);
	        	cell5.setCellValue(" ");
	        
	        
	        Row renglonTitulos = null; //fila7
	        for (int j = 0; j < titulos.length; j++) {
	        	if(j == 0){
	        		renglonTitulos = hoja1.createRow(j+1+renglonApartir);
	        	}
	        	Cell cell6 = renglonTitulos.createCell((short)j);
	        	cell6.setCellValue(titulos[j].toString().toUpperCase());
	        	cell6.setCellStyle(style);
	        }
	        
	        Row filaContenido = null;
	        int renglonSiguiente = 8;
	        System.out.println(resultado.getResultados());
	        for(int k = 8; k < resultado.getResultados().size()+8; k++){
	       		filaContenido = hoja1.createRow(k);     		
	       		Cell cell7= filaContenido.createCell((short)0);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getCvePlaza().toString());
	       		cell7= filaContenido.createCell((short)1);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNumCertificado().toString());
	       		cell7= filaContenido.createCell((short)2);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombre1Contratante().toString());
	       		//cell7= filaContenido.createCell((short)3);
	       		//cell7.setCellValue(resultado.getResultados().get(k-8).getNombre2Contratante().toString());
	       		//cell7= filaContenido.createCell((short)4);
	       		//	cell7.setCellValue(resultado.getResultados().get(k-8).getApMaternoContratante().toString());
	       		cell7= filaContenido.createCell((short)3);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNumNominaAsegurado().toString());
	       		cell7= filaContenido.createCell((short)4);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getFolioSolicitud().toString());
	       		cell7= filaContenido.createCell((short)5);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getFormatoSolicitud().toString());
	       		cell7= filaContenido.createCell((short)6);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getFechaSolicitud().toString());
	       		cell7= filaContenido.createCell((short)7);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getDescripcionEstadoSolicitud().toString());
	       		cell7= filaContenido.createCell((short)8);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombre1Asegurado().toString());
	       		//cell7= filaContenido.createCell((short)11);
	       		//cell7.setCellValue(resultado.getResultados().get(k-8).getNombre2Asegurado().toString());
	       		//cell7= filaContenido.createCell((short)12);
	       		//cell7.setCellValue(resultado.getResultados().get(k-8).getApPaternoAsegurado().toString());
	       		//cell7= filaContenido.createCell((short)13);
	       		//cell7.setCellValue(resultado.getResultados().get(k-8).getApMaternoAsegurado().toString());
	       		cell7= filaContenido.createCell((short)9);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getRFCasegurado().toString());
	       		cell7= filaContenido.createCell((short)10);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getTelefonoSolicitante().toString());
	       		cell7= filaContenido.createCell((short)11);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNumConsignatario().toString());
	       		//cell7= filaContenido.createCell((short)17);
	       		//cell7.setCellValue(resultado.getResultados().get(k-8).getNumPoliza().toString());
	       		//cell7= filaContenido.createCell((short)18);
	       		//cell7.setCellValue(resultado.getResultados().get(k-8).getFechaInicioVigencia().toString());
	       		//cell7= filaContenido.createCell((short)19);
	       		//cell7.setCellValue(resultado.getResultados().get(k-8).getDescripcionEstadoPoliza().toString());
	       		cell7= filaContenido.createCell((short)12);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getDescripcionEstadoPolizaPagos().toString());
	       		cell7= filaContenido.createCell((short)13);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombrePaquete().toString());
	       		cell7= filaContenido.createCell((short)14);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombreGrupoAsegurado().toString());
	       		cell7= filaContenido.createCell((short)15);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getPrimaMensual().toString());
	       		cell7= filaContenido.createCell((short)16);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombreEmpresa().toString());
	       		cell7= filaContenido.createCell((short)17);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombreSucursal().toString());
	       		cell7= filaContenido.createCell((short)18);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombre1Agente().toString());
	       		//cell7= filaContenido.createCell((short)27);
	       		//cell7.setCellValue(resultado.getResultados().get(k-8).getNombre2Agente().toString());
	       		//cell7= filaContenido.createCell((short)28);
	       		//cell7.setCellValue(resultado.getResultados().get(k-8).getApPaternoAgente().toString());
	       		//cell7= filaContenido.createCell((short)29);
	       		//cell7.setCellValue(resultado.getResultados().get(k-8).getApMaternoAgente().toString());
	       		//cell7= filaContenido.createCell((short)30);
	       		//cell7.setCellValue(resultado.getResultados().get(k-8).getApMaternoAgente().toString());
	       		/*cell7= filaContenido.createCell((short)31);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getSaldoCuenta().toString());
	       		cell7= filaContenido.createCell((short)32);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getSaldoCuenta().toString());
	       		cell7= filaContenido.createCell((short)33);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getImporteRetiros().toString());*/

	        }
	        
	        
	      //Guarda el workbook en el archivo temporal
            FileOutputStream out = new FileOutputStream(archivo);
            libroTrabajo.write(out);
            out.close();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return archivo;
	}



	private Cell setCellValue(Object object) {
		// TODO Auto-generated method stub
		return null;
	}


}

