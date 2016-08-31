package mx.com.seguros.business.consulta;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.draw.geom.Path;
import org.apache.poi.xssf.usermodel.XSSFCell;
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
	        System.out.println("RUTA excel generado: " + archivo.getAbsolutePath());
	        //Generar el contenido
	        
	        //Guarda el workbook en el archivo temporal
            FileOutputStream out = new FileOutputStream(archivo);
            libroTrabajo.write(out);
            out.close();
           
         
	        return archivo;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        /*Row renglonTitulos = hoja1.createRow(0);
        for (int j = 0; j < resultado.length; j++) {
            renglonTitulos = hoja1.createRow(j);
            for (int i = 0; i < 25; i++) {
                  celdaTitulos = renglonTitulos.createCell(i);
                  celdaTitulos.setCellValue(i);
            }
      }
      renglonTitulos = hoja1.createRow(7);
      for (int i = 0; i < 25-1; i++) {
            celdaTitulos = renglonTitulos.createCell(0);
            celdaTitulos.setCellValue("Plaza");
            celdaTitulos = renglonTitulos.createCell(1);
            celdaTitulos.setCellValue("Certificado");
            celdaTitulos = renglonTitulos.createCell(2);
            celdaTitulos.setCellValue("Nombre Contratante");
            celdaTitulos = renglonTitulos.createCell(3);
            celdaTitulos.setCellValue("Num. Nómina Asegurado");
            celdaTitulos = renglonTitulos.createCell(4);
            celdaTitulos.setCellValue("Folio de Solicitud");
            celdaTitulos = renglonTitulos.createCell(5);
            celdaTitulos.setCellValue("Formato");
            celdaTitulos = renglonTitulos.createCell(6);
            celdaTitulos.setCellValue("Fecha Solicitud");
            celdaTitulos = renglonTitulos.createCell(7);
            celdaTitulos.setCellValue("Estado Solicitud");
            celdaTitulos = renglonTitulos.createCell(8);
            celdaTitulos.setCellValue("Nombre Asegurado");
            celdaTitulos = renglonTitulos.createCell(9);
            celdaTitulos.setCellValue("RFC Asegurado");
            celdaTitulos = renglonTitulos.createCell(10);
            celdaTitulos.setCellValue("Tel. Solicitante");
            celdaTitulos = renglonTitulos.createCell(11);
            celdaTitulos.setCellValue("Emisor");
            celdaTitulos = renglonTitulos.createCell(12);
            celdaTitulos.setCellValue("Pagos Póliza");
            celdaTitulos = renglonTitulos.createCell(13);
            celdaTitulos.setCellValue("Paquete");
            celdaTitulos = renglonTitulos.createCell(14);
            celdaTitulos.setCellValue("Grupo Asegurado");
            celdaTitulos = renglonTitulos.createCell(15);
            celdaTitulos.setCellValue("Prima Mensual");
            celdaTitulos = renglonTitulos.createCell(16);
            celdaTitulos.setCellValue("Escuela");
            celdaTitulos = renglonTitulos.createCell(17);
            celdaTitulos.setCellValue("Sucursal");
            celdaTitulos = renglonTitulos.createCell(18);
            celdaTitulos.setCellValue("Agente");
            celdaTitulos = renglonTitulos.createCell(19);
            celdaTitulos.setCellValue("Saldo Cuenta");
            celdaTitulos = renglonTitulos.createCell(20);
            celdaTitulos.setCellValue("Importe Retiros");
      }*/
		return archivo;
	}


}

