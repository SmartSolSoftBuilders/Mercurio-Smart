package mx.com.seguros.business.test;

import java.util.List;

import mx.com.seguros.business.comisiones.CalculoBonoPolizaBusiness;
import mx.com.seguros.model.ResumenCalculoBonoPolizaAgente;
import mx.com.seguros.model.ResumenProcesoCalculoBono;
import mx.com.seguros.test.BaseServiceTest;

import org.apache.log4j.Logger;
/**
 * Clase de pruebas unitarias para probar la inserción del cálculo de bono de agente
 * @author Emigdio Hernandez
 *
 */
public class InsertarCalculoBonoAgenteTest  extends BaseServiceTest{
	/**Log de clase*/
	private static final Logger log  = Logger.getLogger(InsertarCalculoBonoAgenteTest.class);
	public void testGuardarCalculoBono(){
		try{
			CalculoBonoPolizaBusiness service = (CalculoBonoPolizaBusiness)getBean("calculoBonoPolizaBusiness");
			
			ResumenProcesoCalculoBono resumen =  service.registrarCalculoBonoFinal(null, null,"test",null);
			log.debug(resumen);
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		
	}
}
