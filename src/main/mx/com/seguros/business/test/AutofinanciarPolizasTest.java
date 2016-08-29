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
 * Clase de prueba unitaria para el proceso batch de autifinanciar pólizas pendientes de pagos
 * @author Emigdio Hernandez
 *
 */
public class AutofinanciarPolizasTest extends BaseServiceTest{
	/**Log de clase*/
	private static final Logger log  = Logger.getLogger(AutofinanciarPolizasTest.class);
	public void testImportarArchivoAplicacion(){
		try{
			PagosBusiness service = (PagosBusiness)getBean("pagosBusiness");
			
			service.autoFinanciarPolizasAutomaticamente(null, null);
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		
	}
}
