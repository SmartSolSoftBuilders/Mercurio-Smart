/**
 * 
 */
package mx.com.seguros.business.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.test.BaseServiceTest;
import mx.com.seguros.utils.CargaArchivo;

import org.apache.log4j.Logger;

/**
 * Clase de pruebas unitarias para la importación de archivo de aplicación de pagos
 * @author Emigdio Hernandez
 *
 */
public class ImportarArchivoAplicacionTest extends BaseServiceTest{
	/**Log de clase*/
	private static final Logger log  = Logger.getLogger(ImportarArchivoAplicacionTest.class);
	public void testImportarArchivoAplicacion(){
		try{
			PagosBusiness service = (PagosBusiness)getBean("pagosBusiness");
			
			File archivo = new File("C:\\Emigdio\\Proyectos SmartSolutions\\fase 4\\archivo de aplicación\\carga2.xls");
			InputStream is = new FileInputStream(archivo);
			CargaArchivo carga = new CargaArchivo();
			List<List<String>> datosArchivo  = carga.cargaInformacionArchivo(is);
		
			service.cargarArchivoAplicacionPagos(datosArchivo,null,"test","carga2.xls" );
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		
	}
}
