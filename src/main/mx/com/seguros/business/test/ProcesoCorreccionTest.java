/**
 * 
 */
package mx.com.seguros.business.test;

import mx.com.seguros.business.correccion.IProcesoCorreccionDatosBusiness;
import mx.com.seguros.test.BaseServiceTest;
import mx.com.seguros.utils.XMLUtil;
import mx.com.seguros.web.correccion.RegistrarTicketCorreccionCommand;

/**
 * CLase de pruebas unitarias para los servicios de aplicación de cambios de un ticket de corrección de datos
 * @author Emigdio Hernandez
 *
 */
public class ProcesoCorreccionTest extends BaseServiceTest{

	
	public void testAplicarCambios() throws Exception{
		
		IProcesoCorreccionDatosBusiness servicio = (IProcesoCorreccionDatosBusiness)getBean("procesoCorreccionDatosBusiness");
		
		RegistrarTicketCorreccionCommand cmd = new RegistrarTicketCorreccionCommand();
		
	
        
        cmd.setTicket(servicio.consultarDetalleTicketCorreccion(38));
        cmd.setDatosOriginales(XMLUtil.formXML(cmd.getTicket().getDatosOriginales()));
        cmd.setDatosNuevos(XMLUtil.formXML(cmd.getTicket().getDatosNuevos()));
		
        servicio.aplicarCambiosTicketCorreccion(cmd);
		
	}
}
