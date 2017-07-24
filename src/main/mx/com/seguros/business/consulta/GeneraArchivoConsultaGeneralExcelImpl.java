package mx.com.seguros.business.consulta;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

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
	        //System.out.println("resultados: " + resultado.getResultados());
	        for(int k = 8; k < resultado.getResultados().size()+8; k++){
	       		filaContenido = hoja1.createRow(k);
	       		Cell cell7= filaContenido.createCell((short)0);
	       		//System.out.println("resultados: " + filaContenido);
	       		String cvePlaza = resultado.getResultados().get(k-8).getCvePlaza();
	       		if(cvePlaza != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getCvePlaza());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)0);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)0);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)1);
	       		Integer numCertificado = resultado.getResultados().get(k-8).getNumCertificado();
	       		//System.out.println("resultado noCert: " + numCertificado);
	       		if(numCertificado != null) {
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNumCertificado());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)1);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)1);
	       		}
	       		
	       		cell7= filaContenido.createCell((short)2);
	       		String nombreContratante = resultado.getResultados().get(k-8).getNombre1Contratante().toString() + " " + 
						   resultado.getResultados().get(k-8).getNombre2Contratante().toString() + " " +
						   resultado.getResultados().get(k-8).getApPaternoContratante().toString()+ " " +
						   resultado.getResultados().get(k-8).getApMaternoContratante().toString();
	       		/*System.out.println("resultado nombreCompletoContratante: " + nombreContratante);*/
	       		if(cell7 != null) {
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombre1Contratante().toString() + " " + 
	       						   resultado.getResultados().get(k-8).getNombre2Contratante().toString() + " " +
	       						   resultado.getResultados().get(k-8).getApPaternoContratante().toString()+ " " +
	       						   resultado.getResultados().get(k-8).getApMaternoContratante().toString()
	       						   );
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)2);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)2);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)3);
	       		String numNominaAsegurado = resultado.getResultados().get(k-8).getNumNominaAsegurado();
	       		//System.out.println("resultados noNomina: " + resultado.getResultados().get(k-8).getNumNominaAsegurado().toString());
	       		if(numNominaAsegurado != null) {
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNumNominaAsegurado());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)3);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)3);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)4);
	       		Integer folioSolicitud = resultado.getResultados().get(k-8).getFolioSolicitud();
	       		//System.out.println("resultados foliosol: " + folioSolicitud);
	       		if(folioSolicitud != null) {
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getFolioSolicitud().toString());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)4);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)4);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)5);
	       		String formatoSol = resultado.getResultados().get(k-8).getFormatoSolicitud();
	       		//System.out.println("resultados formatoSol: " + formatoSol);
	       		if(formatoSol != null) {
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getFormatoSolicitud());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)5);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)5);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)6);
	       		Date fechasolicitud = resultado.getResultados().get(k-8).getFechaSolicitud();
	       		//System.out.println("resultados fechaSol: " + fechasolicitud);
	       		if(fechasolicitud != null) {
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getFechaSolicitud());
	       		cell7.setCellStyle(styleContenido);
	       		cell7.setCellStyle(styleFecha);
	        	hoja1.autoSizeColumn((short)6);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)6);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)7);
	       		String descEdoSol = resultado.getResultados().get(k-8).getDescripcionEstadoSolicitud();
	       		//System.out.println("resultados descEstadoSol: " + descEdoSol);
	       		if(descEdoSol != null) {
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getDescripcionEstadoSolicitud());
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)7);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)7);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)8);
	       		String nombreAsegurado =   resultado.getResultados().get(k-8).getNombre1Asegurado().toString() + " " +
										   resultado.getResultados().get(k-8).getNombre2Asegurado().toString() + " " +
										   resultado.getResultados().get(k-8).getApPaternoAsegurado().toString()+ " " +
										   resultado.getResultados().get(k-8).getApMaternoAsegurado().toString();
	       		
	       		/*System.out.println("resultados nombreAsegurado: " + nombreAsegurado);*/
	       		if(nombreAsegurado != null) {
	       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombre1Asegurado().toString() + " " +
	       						   resultado.getResultados().get(k-8).getNombre2Asegurado().toString() + " " +
	       						   resultado.getResultados().get(k-8).getApPaternoAsegurado().toString()+ " " +
	       						   resultado.getResultados().get(k-8).getApMaternoAsegurado().toString() 
	       						   );
	       		cell7.setCellStyle(styleContenido);
	        	hoja1.autoSizeColumn((short)8);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)8);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)9);
	       		String RFCAsegurado = resultado.getResultados().get(k-8).getRFCasegurado();
	       		//System.out.println("resultados RFCAsegurado: " + RFCAsegurado);
	       		if(RFCAsegurado != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getRFCasegurado());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)9);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)9);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)10);
	       		String telSolicitante = resultado.getResultados().get(k-8).getTelefonoSolicitante();
	       		//System.out.println("resultados telSolicitante: " + telSolicitante);
	       		if(telSolicitante != null) { 
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getTelefonoSolicitante());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)10);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)10);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)11);
	       		Integer numConsignatario = resultado.getResultados().get(k-8).getNumConsignatario();
	       		//System.out.println("resultados noConsignatario: " + numConsignatario);
	       		if(numConsignatario != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getNumConsignatario().toString());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)11);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)11);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)12);
	       		Integer numPoliza = resultado.getResultados().get(k-8).getNumPoliza();
	       		//System.out.println("resultados noPoliza: " + resultado.getResultados().get(k-8).getNumPoliza().toString());
	       		if(numPoliza != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getNumPoliza().toString());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)12);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)12);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)13);
	       		Date fechaIniVigencia = resultado.getResultados().get(k-8).getFechaInicioVigencia();
	       		//System.out.println("resultados fechaInicioVigencia: " + fechaIniVigencia);
	       		if(fechaIniVigencia != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getFechaInicioVigencia());
		       		cell7.setCellStyle(styleContenido);
		       		cell7.setCellStyle(styleFecha);
	        	hoja1.autoSizeColumn((short)13);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)13);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)14);
	       		String descEdoPoliza = resultado.getResultados().get(k-8).getDescripcionEstadoPoliza();
	       		//System.out.println("resultados descEdoPoliza: " + descEdoPoliza);
	       		if(descEdoPoliza != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getDescripcionEstadoPoliza());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)14);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)14);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)15);
	       		String descEdoPolizaPagos = resultado.getResultados().get(k-8).getDescripcionEstadoPolizaPagos();
	       		//System.out.println("resultados descEdoPolizaPagos: " + descEdoPolizaPagos);
	       		if(descEdoPolizaPagos != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getDescripcionEstadoPolizaPagos().toString());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)15);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)15);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)16);
	       		String nombrePaquete = resultado.getResultados().get(k-8).getNombrePaquete();
	       		//System.out.println("resultados nombrePaquete: " + nombrePaquete);
	       		if(nombrePaquete != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombrePaquete().toString());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)16);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)16);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)17);
	       		String nombreGpoAsegurado = resultado.getResultados().get(k-8).getNombreGrupoAsegurado();
	       		//System.out.println("resultados nombreGpoAsegurado: " + nombreGpoAsegurado);
	       		if(nombreGpoAsegurado != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombreGrupoAsegurado());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)17);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)17);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)18);
	       		Double primaMensual = resultado.getResultados().get(k-8).getPrimaMensual();
	       		//System.out.println("resultados primaMensual: " + primaMensual);
	       		if(primaMensual != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getPrimaMensual().toString());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)18);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)18);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)19);
	       		String nombreEmpresa = resultado.getResultados().get(k-8).getNombreEmpresa();
	       		//System.out.println("resultados nombreEmpresa: " + nombreEmpresa);
	       		if(nombreEmpresa != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombreEmpresa());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)19);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)19);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)20);
	       		String nombreSucursal = resultado.getResultados().get(k-8).getNombreSucursal();
	       		//System.out.println("resultados nombreSucursal: " + nombreSucursal);
	       		if(nombreSucursal != null) {
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getNombreSucursal());
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)20);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)20);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)21);
	       		String nombreAgente = resultado.getResultados().get(k-8).getNombre1Agente() + " " +
					    resultado.getResultados().get(k-8).getNombre2Agente() + " " +
					    resultado.getResultados().get(k-8).getApPaternoAgente() + " " +
					    resultado.getResultados().get(k-8).getApMaternoAgente();
	       		/*System.out.println("resultados nombreAgente: " + nombreAgente);*/
	       		if(nombreAgente != null) {
	       			cell7.setCellValue(resultado.getResultados().get(k-8).getNombre1Agente() + " " +
		       						   resultado.getResultados().get(k-8).getNombre2Agente() + " " +
		       						   resultado.getResultados().get(k-8).getApPaternoAgente() + " " +
		       						   resultado.getResultados().get(k-8).getApMaternoAgente()
		       						   );
		       		cell7.setCellStyle(styleContenido);
		        	hoja1.autoSizeColumn((short)21);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)21);
	       		}
	        	
	       		cell7= filaContenido.createCell((short)22);
	       		Double saldoCuenta = resultado.getResultados().get(k-8).getSaldoCuenta();
	       		//System.out.println("saldo cuenta: " + saldoCuenta);
	       		if(saldoCuenta != null){
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getSaldoCuenta());
		       		cell7.setCellStyle(styleFormato);
		       		hoja1.autoSizeColumn((short)22);
	       		}else{
	       			cell7.setCellValue("N/A");
		       		cell7.setCellStyle(styleFormato2);
		       		hoja1.autoSizeColumn((short)22);
	       		}
	       		
	       		cell7= filaContenido.createCell((short)23);
	       		//System.out.println("resultados ImporteRetiros: " + resultado.getResultados().get(k-8).getImporteRetiros());
	       		Double importeRetiros = resultado.getResultados().get(k-8).getImporteRetiros();
	       		//System.out.println("importeRetiros: " + importeRetiros);
	       		if(importeRetiros != null){
	       			
		       		cell7.setCellValue(resultado.getResultados().get(k-8).getImporteRetiros());
		       		cell7.setCellStyle(styleFormato);
		       		hoja1.autoSizeColumn((short)23);
		       		
	       		} else {
	       			
	       			cell7.setCellValue("N/A");
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

