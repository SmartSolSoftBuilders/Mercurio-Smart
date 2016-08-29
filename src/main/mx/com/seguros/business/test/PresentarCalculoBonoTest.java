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
public class PresentarCalculoBonoTest extends BaseServiceTest{
	/**Log de clase*/
	private static final Logger log  = Logger.getLogger(PresentarCalculoBonoTest.class);
	public void testPrevisualizarCalculoBono(){
		try{
			CalculoBonoPolizaBusiness service = (CalculoBonoPolizaBusiness)getBean("calculoBonoPolizaBusiness");
			
			List<ResumenCalculoBonoPolizaAgente> resumenes =  service.obtenerCalculoDeBonosAFechaActual(null, null,null);
			log.debug(resumenes);
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		
	}
}
