package mx.com.seguros.business.test;

import java.util.List;

import mx.com.seguros.business.comisiones.CalculoBonoPolizaBusiness;
import mx.com.seguros.business.descuentos.DescuentosBusiness;
import mx.com.seguros.business.pagos.CuentaClienteBusiness;
import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.model.ResumenCalculoBonoPolizaAgente;
import mx.com.seguros.test.BaseServiceTest;

import org.apache.log4j.Logger;

/**
 * Clase de pruebas unitarias para el ajuste de saldos negativos
 * @author Emigdio Hernandez
 *
 */
public class AjustarSaldosNegativosTest extends BaseServiceTest{
	/**Log de clase*/
	private static final Logger log  = Logger.getLogger(AjustarSaldosNegativosTest.class);
	public void testAjustarSaldos(){
		try{
			CuentaClienteBusiness service = (CuentaClienteBusiness)getBean("cuentaClienteBusiness");
			
			service.ajustarSaldosNegativos();
			
			PagosBusiness pagosService = (PagosBusiness)getBean("pagosBusiness");
			
			pagosService.ajustarSaldoActualEnDescuentosAplicados();
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		
	}
}
