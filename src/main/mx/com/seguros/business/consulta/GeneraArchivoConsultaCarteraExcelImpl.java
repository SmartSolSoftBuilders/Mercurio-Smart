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

import mx.com.seguros.dto.ResultadoCarteraSolicitudDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

//Se debe modificar para la consulta con los campos solicitados
public class GeneraArchivoConsultaCarteraExcelImpl implements GeneraArchivoConsultaGeneralExcel {

	public GeneraArchivoConsultaCarteraExcelImpl() {
		super();
	}

	@Override
	public File generaArchivoCarteraExcel(ResultadoPaginadoDTO<ResultadoCarteraSolicitudDTO> resultado) {

		XSSFWorkbook libroTrabajo2 = new XSSFWorkbook();
		XSSFSheet hoja2 = libroTrabajo2.createSheet("Hoja 2");
		File archivo2 = null;

		try {
			archivo2 = File.createTempFile("pattern", ".xlsx");
			String[] titulos = { "Numero Poliza", "Numero Consignatario", "Nombre Plaza", "Apellido Paterno Empleado",
					"Apellido Materno Empleado", "Nombre 1 Empleado", "Nombre 2 Empleado", "Clave Empleado",
					"Clave Agente", "Nombre Empresa", "Municipio", "CONCATENADA",

			};

			int renglonApartir = 0;
			// System.out.println("RUTA excel generado: " +
			// archivo.getAbsolutePath());

			// crea estilos
			XSSFFont negrtias = libroTrabajo2.createFont();
			negrtias.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			negrtias.setFontName("Arial");
			XSSFCellStyle styleTitulo = libroTrabajo2.createCellStyle();
			styleTitulo.setFont(negrtias);
			styleTitulo.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			styleTitulo.setFillPattern(CellStyle.SOLID_FOREGROUND);
			styleTitulo.setAlignment(XSSFCellStyle.ALIGN_CENTER);

			XSSFFont fuenteContenido = libroTrabajo2.createFont();
			fuenteContenido.setFontName("Arial");
			XSSFCellStyle styleContenido = libroTrabajo2.createCellStyle();
			styleContenido.setFont(fuenteContenido);
			styleContenido.setAlignment(XSSFCellStyle.ALIGN_CENTER);

			XSSFDataFormat formato = libroTrabajo2.createDataFormat();
			XSSFCellStyle styleFormato = libroTrabajo2.createCellStyle();
			styleFormato.setDataFormat(formato.getFormat("$ #,##0.00"));
			styleFormato.setAlignment(XSSFCellStyle.ALIGN_CENTER);

			XSSFDataFormat formato2 = libroTrabajo2.createDataFormat();
			XSSFCellStyle styleFormato2 = libroTrabajo2.createCellStyle();
			styleFormato2.setDataFormat(formato2.getFormat("$ 0.00"));
			styleFormato2.setAlignment(XSSFCellStyle.ALIGN_CENTER);

			XSSFCellStyle styleFecha = libroTrabajo2.createCellStyle();
			CreationHelper createHelper = libroTrabajo2.getCreationHelper();
			styleFecha.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
			styleFecha.setAlignment(XSSFCellStyle.ALIGN_CENTER);

			// Generar el contenido

			Row renglonTitulos = null; // fila7
			for (int j = 0; j < titulos.length; j++) {
				if (j == 0) {
					renglonTitulos = hoja2.createRow(j + renglonApartir);
				}
				Cell cell6 = renglonTitulos.createCell((short) j);
				cell6.setCellValue(titulos[j].toString().toUpperCase());

			}
			// numero de poliza
			Row filaContenido = null;
			// System.out.println("resultados: " + resultado.getResultados());
			for (int k = 1; k < resultado.getResultados().size() + 1; k++) {
				filaContenido = hoja2.createRow(k);

				Cell cell7 = filaContenido.createCell((short) 0);
				// System.out.println("resultados: " + filaContenido);
				Integer numPoliza = resultado.getResultados().get(k - 1).getNumPoliza();
				if (numPoliza != null) {
					cell7.setCellValue(numPoliza);

				} else {
					cell7.setCellValue("N/A");

				}
				// numero consignatario
				cell7 = filaContenido.createCell((short) 1);
				Integer numConsignatario = resultado.getResultados().get(k - 1).getNumConsignatario();
				// System.out.println("resultado numConsignatario : " +
				// numConsignatario);
				if (numConsignatario != null) {
					cell7.setCellValue(numConsignatario);

				} else {
					cell7.setCellValue("N/A");

				}
				// alias
				cell7 = filaContenido.createCell((short) 2);
				String alias = resultado.getResultados().get(k - 1).getAlias().toString();

				if (cell7 != null) {
					cell7.setCellValue(alias);

				} else {
					cell7.setCellValue("N/A");

				}
				// appellido paterno empleado
				cell7 = filaContenido.createCell((short) 3);
				String apPaternoEmpleado = resultado.getResultados().get(k - 1).getapPaternoEmpleado().toString();

				/*
				 * System.out.println("resultado apPaternoEmpleado: " +
				 * getapPaternoEmpleado);
				 */
				if (cell7 != null) {
					cell7.setCellValue(apPaternoEmpleado);

				} else {
					cell7.setCellValue("N/A");

				}

				// appellido materno empleado
				cell7 = filaContenido.createCell((short) 4);
				String apMaternoEmpleado = resultado.getResultados().get(k - 1).getapMaternoEmpleado().toString();

				/*
				 * System.out.println("resultado apPaternoEmpleado: " +
				 * getapPaternoEmpleado);
				 */
				if (cell7 != null) {
					cell7.setCellValue(apMaternoEmpleado);

				} else {
					cell7.setCellValue("N/A");

				}

				// nombre 1empleado
				cell7 = filaContenido.createCell((short) 5);
				String nombre1Empleado = resultado.getResultados().get(k - 1).getNombre1Empleado().toString();

				if (cell7 != null) {
					cell7.setCellValue(nombre1Empleado);

				} else {
					cell7.setCellValue("N/A");

				}

				// nombre 2empleado
				cell7 = filaContenido.createCell((short) 6);
				String nombre2Empleado = resultado.getResultados().get(k - 1).getNombre2Empleado().toString();

				if (cell7 != null) {
					cell7.setCellValue(nombre2Empleado);

				} else {
					cell7.setCellValue("N/A");

				}

				// clave empleado
				cell7 = filaContenido.createCell((short) 7);
				Integer cveEmpleado = resultado.getResultados().get(k - 1).getCveEmpleado();

				if (numConsignatario != null) {
					cell7.setCellValue(cveEmpleado);

				} else {
					cell7.setCellValue("N/A");

				}

				// clave agente
				cell7 = filaContenido.createCell((short) 8);
				Integer cveAgente = resultado.getResultados().get(k - 1).getCveAgente();
				// System.out.println("resultado cveAgente : " + cveAgente);

				if (numConsignatario != null) {
					cell7.setCellValue(cveAgente);

				} else {
					cell7.setCellValue("N/A");

				}

				// nombre empresa
				cell7 = filaContenido.createCell((short) 9);
				String nombreEmpresa = resultado.getResultados().get(k - 1).getNombreEmpresa().toString();

				if (cell7 != null) {
					cell7.setCellValue(nombreEmpresa);

				} else {
					cell7.setCellValue("N/A");

				}

				// nombre sucursal
				cell7 = filaContenido.createCell((short) 10);
				String nombreSucursal = resultado.getResultados().get(k - 1).getNombreSucursal().toString();

				if (cell7 != null) {
					cell7.setCellValue(nombreSucursal);

				} else {
					cell7.setCellValue("N/A");

				}

				// concatenada
				cell7 = filaContenido.createCell((short) 11);
				String concatenada = resultado.getResultados().get(k - 1).getConcatenada().toString();

				if (cell7 != null) {
					cell7.setCellValue(concatenada);

				} else {
					cell7.setCellValue("N/A");

				}

			}

			try {
				// Guarda el workbook en el archivo temporal
				FileOutputStream out2 = new FileOutputStream(archivo2);
				libroTrabajo2.write(out2);
				out2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return archivo2;

	}

	@Override
	public File generaArchivoExcel(ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
