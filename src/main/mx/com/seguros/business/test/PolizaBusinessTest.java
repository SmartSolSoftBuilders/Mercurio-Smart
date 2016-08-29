package mx.com.seguros.business.test;

import java.util.ArrayList;
import java.util.List;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.test.BaseServiceTest;

import org.apache.log4j.Logger;
/**
 * Clase de pruebas para el servicio de registro y consulta de pólizas
 * Describir el objetivo de la clase con punto al final.
 * @version 1.0
 * @author Emigdio Hernández
 *
 */
public class PolizaBusinessTest extends BaseServiceTest{
	/**Log de clase*/
	private static final Logger log  = Logger.getLogger(PolizaBusinessTest.class);
	public void testConsultarCatalogoBeneficios(){
		
		IPolizaBusiness service = (IPolizaBusiness)getBean("polizaBusiness");
		log.debug("Numero de beneficios:"+service.consultarCatalogoBeneficiosAdicionales().size());
	}
	
	public void testRegistrarBeneficiosAdicionales(){
		
		IPolizaBusiness service = (IPolizaBusiness)getBean("polizaBusiness");
		
		PolizaIndividual poliza = service.obtenerDetallePolizaPorNumero(9109149, 10202);
		poliza.setFolioSolicitud(147612);
		poliza.setFormatoSolicitud("FSP");
		List<BeneficioAdicional> catalogo = service.consultarCatalogoBeneficiosAdicionales();
		BeneficioAdicionalPoliza benefPoliza = null;
		List<BeneficioAdicionalPoliza> beneficios = new ArrayList<BeneficioAdicionalPoliza>();
		for(BeneficioAdicional unBeneficio:catalogo){
			benefPoliza = new BeneficioAdicionalPoliza();
			benefPoliza.setIdBeneficioAdicional(unBeneficio.getIdBeneficioAdicional());
			
			benefPoliza.setSumaBeneficio(1552.0);
			benefPoliza.setMontoCobertura(1000.00);
			beneficios.add(benefPoliza);
			
		}
		poliza.setBeneficiosAdicionales(beneficios);
		service.guardarBeneficiosAdicionales(poliza);
		
		
	}
	
	public void testConsultarBeneficiosDePoliza(){
		
		IPolizaBusiness service = (IPolizaBusiness)getBean("polizaBusiness");
		log.debug("Numero de beneficios de póliza:"+service.consultarBeneficiosAdicionalesDePoliza(392, 4588484));
	}
public void testEliminarBeneficios(){
		
		IPolizaBusiness service = (IPolizaBusiness)getBean("polizaBusiness");
		service.eliminarBeneficiosAdicionalesDePoliza(392, 4588484);
	}

}
