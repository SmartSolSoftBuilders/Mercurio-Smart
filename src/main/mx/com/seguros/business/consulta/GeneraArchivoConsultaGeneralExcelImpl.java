package mx.com.seguros.business.consulta;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	        String[] titulos = { 
					        		"Plaza", 	
					        		"Certificado", 	
					        		"Nombre Contratante", 	
					        		"Num. Nómina Asegurado", 	
					        		"Folio de Solicitud",
					        		"Formato", 	
					        		"Fecha Solicitud",
					        		"Estado Solicitud", 	
					        		"Nombre Asegurado", 	
					        		"RFC Asegurado", 	
					        		"Tel. Solicitante", 	
					        		"Emisor", 	
					        		"Num. de Poliza", 	
					        		"Fecha Inicio Vigencia", 	
					        		"Seguimiento a Póliza", 	
					        		"Pagos Póliza", 	
					        		"Paquete", 	
					        		"Grupo Asegurado", 	
					        		"Prima Mensual", 	
					        		"Escuela", 	
					        		"Sucursal", 	
					        		"Agente", 	
					        		"Saldo Cuenta", 	
					        		"Importe Retiros" 
	        					};
	        
	        int renglonApartir=5;
	        //System.out.println("RUTA excel generado: " + archivo.getAbsolutePath());
	        
	        //crea estilos
	        XSSFFont negrtias = libroTrabajo.createFont();
	        negrtias.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	        negrtias.setFontName("Arial");
			XSSFCellStyle styleTitulo = libroTrabajo.createCellStyle();
			styleTitulo.setFont(negrtias);
			styleTitulo.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			styleTitulo.setFillPattern(CellStyle.SOLID_FOREGROUND);
			styleTitulo.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			
			XSSFFont fuenteContenido = libroTrabajo.createFont();
			fuenteContenido.setFontName("Arial");
			XSSFCellStyle styleContenido = libroTrabajo.createCellStyle();
			styleContenido.setFont(fuenteContenido);
			styleContenido.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			
			XSSFDataFormat formato = libroTrabajo.createDataFormat();
			XSSFCellStyle styleFormato = libroTrabajo.createCellStyle();
			styleFormato.setDataFormat(formato.getFormat("$ #,##0.00"));
			styleFormato.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			
			XSSFDataFormat formato2 = libroTrabajo.createDataFormat();
			XSSFCellStyle styleFormato2 = libroTrabajo.createCellStyle();
			styleFormato2.setDataFormat(formato2.getFormat("$ 0.00"));
			styleFormato2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			
			XSSFCellStyle styleFecha = libroTrabajo.createCellStyle();
			CreationHelper createHelper = libroTrabajo.getCreationHelper();
			styleFecha.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
			styleFecha.setAlignment(XSSFCellStyle.ALIGN_CENTER);
	        
	        //Generar el contenido
	        Row encabezado = hoja1.createRow((short)0);
	        	Cell cell= encabezado.createCell((short)0);
	        	cell.setCellValue("Consulta General de Solicitudes");
	        	cell.setCellStyle(styleTitulo);
	        	hoja1.autoSizeColumn((short)0);
	        	
	        Row fila1 = hoja1.createRow((short)1);
	        	Cell cell2= fila1.createCell((short)0);
	        	cell2.setCellValue(" ");
	        	
	        Row fila2 = hoja1.createRow((short)2);
	        	Cell cell3= fila2.createCell((short)0);
	        	cell3.setCellValue("Total de Registros: ");
	        	Cell cell3_1 = fila2.createCell((short)1);
	        	cell3_1.setCellValue(resultado.getTotalResultados());
	        	cell3.setCellStyle(styleTitulo);
	        	cell3_1.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)2);
	        	
	        Row fila3 = hoja1.createRow((short)3);
	        	Cell cell4= fila3.createCell((short)0);
	        	cell4.setCellValue("Total de Primas: ");
	        	Cell cell4_1 = fila3.createCell((short)1);
	        	cell4_1.setCellValue(resultado.getTotalPrima());
	        	cell4.setCellStyle(styleTitulo);
	        	cell4_1.setCellStyle(styleFormato);
	        	hoja1.autoSizeColumn((short)3);
	        	
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
	        	cell6.setCellStyle(styleTitulo);
	        	hoja1.autoSizeColumn((short)j);
	        }
	        
	        Row filaContenido = null;
	        //System.out.println(resultado.getResultados());
	        for(int k = 8; k < resultado.getResultados().size()+8; k++){
	       		filaContenido = hoja1.createRow(k);
	       		
	       		Cell cell7= filaContenido.createCell((short)0);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getCvePlaza().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)0);
	        	
	       		cell7= filaContenido.createCell((short)1);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNumCertificado());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)1);
	        	
	       		cell7= filaContenido.createCell((short)2);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombre1Contratante().toString() + " " + 
	       						   resultado.getResultados().get(k-8).getNombre2Contratante().toString() + " " +
	       						   resultado.getResultados().get(k-8).getApMaternoContratante().toString()
	       						   );
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)2);
	        	
	       		cell7= filaContenido.createCell((short)3);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNumNominaAsegurado().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)3);
	        	
	       		cell7= filaContenido.createCell((short)4);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getFolioSolicitud());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)4);
	        	
	       		cell7= filaContenido.createCell((short)5);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getFormatoSolicitud().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)5);
	        	
	       		cell7= filaContenido.createCell((short)6);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getFechaSolicitud());
	       		cell7.setCellStyle(styleContenido);
	       		cell7.setCellStyle(styleFecha);
	        	hoja1.autoSizeColumn((short)6);
	        	
	       		cell7= filaContenido.createCell((short)7);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getDescripcionEstadoSolicitud().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)7);
	        	
	       		cell7= filaContenido.createCell((short)8);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombre1Asegurado().toString() + " " +
	       						   resultado.getResultados().get(k-8).getNombre2Asegurado().toString() + " " +
	       						   resultado.getResultados().get(k-8).getApMaternoAsegurado().toString() 
	       						   );
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)8);
	        	
	       		cell7= filaContenido.createCell((short)9);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getRFCasegurado().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)9);
	        	
	       		cell7= filaContenido.createCell((short)10);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getTelefonoSolicitante().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)10);
	        	
	       		cell7= filaContenido.createCell((short)11);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNumConsignatario().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)11);
	        	
	       		cell7= filaContenido.createCell((short)12);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNumPoliza().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)12);
	        	
	       		cell7= filaContenido.createCell((short)13);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getFechaInicioVigencia());
	       		cell7.setCellStyle(styleContenido);
	       		cell7.setCellStyle(styleFecha);
	        	hoja1.autoSizeColumn((short)13);
	        	
	       		cell7= filaContenido.createCell((short)14);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getDescripcionEstadoPoliza().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)14);
	        	
	       		cell7= filaContenido.createCell((short)15);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getDescripcionEstadoPolizaPagos().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)15);
	        	
	       		cell7= filaContenido.createCell((short)16);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombrePaquete().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)16);
	        	
	       		cell7= filaContenido.createCell((short)17);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombreGrupoAsegurado().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)17);
	        	
	       		cell7= filaContenido.createCell((short)18);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getPrimaMensual().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)18);
	        	
	       		cell7= filaContenido.createCell((short)19);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombreEmpresa().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)19);
	        	
	       		cell7= filaContenido.createCell((short)20);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombreSucursal().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)20);
	        	
	       		cell7= filaContenido.createCell((short)21);
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombre1Agente().toString() + " " +
	       						   resultado.getResultados().get(k-8).getNombre2Agente().toString() + " " +
	       						   resultado.getResultados().get(k-8).getApPaternoAgente().toString() + " " +
	       						   resultado.getResultados().get(k-8).getApMaternoAgente().toString()
	       						   );
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)21);
	        	
	       		cell7= filaContenido.createCell((short)22);
	       		Double saldoCuenta = resultado.getResultados().get(k-8).getSaldoCuenta();
	       		//System.out.println("saldo cuenta: " + saldoCuenta);
	       		if(saldoCuenta != null){
	       			
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getSaldoCuenta());
		       		cell7.setCellStyle(styleFormato);
		       		hoja1.autoSizeColumn((short)22);
		       		
	       		}else {
	       			
	       			cell7.setCellValue(0);
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)22);
		       		
	       		}
	       		
	       		cell7= filaContenido.createCell((short)23);
	       		Double importeRetiros = resultado.getResultados().get(k-8).getImporteRetiros();
	       		//System.out.println("importeRetiros: " + importeRetiros);
	       		if(importeRetiros != null){
	       			
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getImporteRetiros());
		       		cell7.setCellStyle(styleFormato);
		       		hoja1.autoSizeColumn((short)23);
		       		
	       		} else {
	       			
	       			cell7.setCellValue(0);
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)23);
		       		
	       		}
	       		
	        }
	        
	        try {
	      //Guarda el workbook en el archivo temporal
            FileOutputStream out = new FileOutputStream(archivo);
            libroTrabajo.write(out);
            out.close();
	        }
	        catch (IOException e) {
				e.printStackTrace();
			}
            
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return archivo;
	}


}

