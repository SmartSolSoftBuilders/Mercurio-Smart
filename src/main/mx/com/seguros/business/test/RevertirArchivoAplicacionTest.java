/**
 * 
 */
package mx.com.seguros.business.test;

import java.util.List;

import mx.com.seguros.business.comisiones.CalculoBonoPolizaBusiness;
import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.model.ResumenCalculoBonoPolizaAgente;
import mx.com.seguros.test.BaseServiceTest;

import org.apache.log4j.Logger;

/**
 * Clase de pruebas unitarias para la consulta del calculo de bono en modo
 * de previsualización
 * @author Emigdio HErnandez
 *
 */
public class RevertirArchivoAplicacionTest extends BaseServiceTest{
	/**Log de clase*/
	private static final Logger log  = Logger.getLogger(RevertirArchivoAplicacionTest.class);
	public void testRevertirArchivoAplicacion(){
		try{
			PagosBusiness service = (PagosBusiness)getBean("pagosBusiness");
			
			service.revertirArchivoAplicacionCargado(2479L);
			service.revertirArchivoAplicacionCargado(2478L);
			service.revertirArchivoAplicacionCargado(2477L);
			service.revertirArchivoAplicacionCargado(2476L);
			service.revertirArchivoAplicacionCargado(2475L);
			service.revertirArchivoAplicacionCargado(2474L);
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		
	}
}
