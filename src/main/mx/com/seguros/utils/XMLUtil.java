/**
 * 
 */
package mx.com.seguros.utils;

import mx.com.seguros.dto.DetalleBeneficioAdicionalDTO;
import mx.com.seguros.dto.DetalleCalculoSumaAseguradaDTO;
import mx.com.seguros.dto.HistoricoTarifaDTO;
import mx.com.seguros.dto.TramitePolizaDTO;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.ProductosInburnomina;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Clase de utilerías de XML para serializar y des-serializar objetos
 * @author Emigdio Hernández
 *
 */
public class XMLUtil {

	public static XStream converter = new  XStream(new DomDriver());
	
	static {
		converter.alias("historicoTarifa", HistoricoTarifaDTO.class);
		converter.alias("detalleCalculoSumaAsegurada", DetalleCalculoSumaAseguradaDTO.class);
		converter.alias("detalleCalculoBeneficio", DetalleBeneficioAdicionalDTO.class);
		converter.alias("tramitePoliza", TramitePolizaDTO.class);
		converter.alias("ProductosInburnomina", ProductosInburnomina.class);
	}
	
	public static String toXML(PolizaIndividual poliza){
		return converter.toXML(poliza);
	}
	
	public static PolizaIndividual formXML(String xml){
		return (PolizaIndividual)converter.fromXML(xml);
	}
	
	
}
