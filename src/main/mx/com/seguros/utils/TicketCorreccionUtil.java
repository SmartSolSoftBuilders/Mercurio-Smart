/**
 * 
 */
package mx.com.seguros.utils;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase de utilerías que usa el proceso de ticket de corrección de datos
 * @author Emigdio Hernandez
 *
 */
public class TicketCorreccionUtil {

	private static final Logger log;

    static {
        log = LoggerFactory.getLogger(TicketCorreccionUtil.class);
       
    }
	/**
	 * Evalúa si existe cambio en algún campo del objeto datosNuevos respecto al objeto datosOriginales, de
	 * existir cambio se copian a datosDestino
	 * @param nombreCampo Nombre del campo a evaluar
	 * @param datosOriginales Objeto con los datos originales
	 * @param datosNuevos Objeto con lo datos nuevos
	 * @param datosDestino objeto destino del cambio
	 * @return true si se aplico el cambio, false en otro caso
	 */
	public static boolean evaluarCambioEnCampo(String nombreCampo,Object datosOriginales,Object datosNuevos,Object datosDestino){
		
		try {
			Object campoOriginal =  PropertyUtils.getNestedProperty(datosOriginales, nombreCampo);
			Object campoNuevo = PropertyUtils.getNestedProperty(datosNuevos, nombreCampo);
			if(campoNuevo != null && StringUtils.isNotBlank(campoNuevo.toString()) && !campoNuevo.equals(campoOriginal)){
				PropertyUtils.setProperty(datosDestino, nombreCampo, campoNuevo);
				return true;
			}
			
		} catch (Exception e) {
			log.error("Error al evaluar propiedad " + nombreCampo,e);
			
			return false;
		}
		return false;
	}
}
