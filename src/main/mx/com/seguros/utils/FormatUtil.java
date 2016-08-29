/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * Clase de utilería para tranformar claves y formatos desde el archivo de registros de pólizas
 * de inbursa
 * @author Emigdio Hernández
 */
public class FormatUtil {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private static NumberFormat formatoMoneda = new DecimalFormat("$ #,##0.00");
	private static NumberFormat formatoNumeroSinDecimales = new DecimalFormat("#,##0");
    /**
     * Transofrma una cadena con el contenido de 'SI' o 'NO' o 'S' o 'N' o 'true' o 'false'
     * a un objeto Boolean
     * @param cadena Datos fuente
     * @return resultado de la conversión, null en caso de no lograrse
     */
    public static Boolean tranformarBoolean(String cadena){

        if(cadena != null){
            for(String valorSi:ConstantesGenerales.SI){
                if(valorSi.equalsIgnoreCase(cadena.trim())){
                    return Boolean.TRUE;
                }
            }
            for(String valorNo:ConstantesGenerales.NO){
                if(valorNo.equalsIgnoreCase(cadena.trim())){
                    return Boolean.FALSE;
                }
            }
        }
        return null;
    }
    /**
     * Verifica si la cadena enviada representa alguno de los posibles valores
     * del sexo masculino
     * 'H' , 'M' , 'MASCULINO' 'HOMBRE'
     * @param cadena Cadena fuente
     * @return True en caso de ser masculino, false en otro caso
     */
    public static Boolean esSexoMasculino(String cadena){
        if(cadena != null){
            for(String valor:ConstantesGenerales.MASCULINO){
                if(valor.equalsIgnoreCase(cadena.trim())){
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }
    /**
     * Transforma los valores del estado civil del asegurado a las claves del estado civil
     * del sistema
     * Archivo inbursa - Catalogo sistema:
     * S - Soltero - 1
     * C - Casado - 2
     * U - Unión Libre - 6
     * V - Viudo - 4
     * P - P ? - 1
     * D - Divorciado - 3
     *
     * @param cveEstadoCivilAsegurado
     * @return
     */
    public static String transformarEstadoCivil(String cveEstadoCivilAsegurado) {
        
        if(StringUtils.isNotBlank(cveEstadoCivilAsegurado)){
        	switch(cveEstadoCivilAsegurado.charAt(0)){
	            case 'S': return "Soltero";
	            case 'C': return "Casado";
	            case 'U': return "Unión Libre";
	            case 'V': return "Viudo";
	            case 'D': return "Divorciado";
	            default: return "Soltero";
        	}
        }
        return null;
        
    }
    /**
     * Transforma el estado civil a partir de su descripción al entero equivalente
     * @param descEstadoCivil
     * @return
     */
    public static int transformarEstadoCivilDeDescripcion(String descEstadoCivil){

        int cveEstadoCivil = 0;
        if(descEstadoCivil != null){
            if("Soltero".equalsIgnoreCase(descEstadoCivil)){
                cveEstadoCivil = 1;
            }else if("Casado".equalsIgnoreCase(descEstadoCivil)){
                cveEstadoCivil = 2;
            }else if("Divorciado".equalsIgnoreCase(descEstadoCivil)){
                cveEstadoCivil = 3;
            }else if("Viudo".equalsIgnoreCase(descEstadoCivil)){
                cveEstadoCivil = 4;
            }else if("Separado".equalsIgnoreCase(descEstadoCivil)){
                cveEstadoCivil = 5;
            }else if("Unión Libre".equalsIgnoreCase(descEstadoCivil)){
                cveEstadoCivil = 6;
            }
        }

        return cveEstadoCivil;
    }
    /**
     * Intenta parsear una fecha con el formato dd/MM/yyyy
     * Si no logra hacer el parseo regresa un objeto nulo
     * @param fecha Fecha en cadena
     * @return Date que representa la cadena, null en caso de no lograr parsearla
     */
    public static Date stringToDate(String fecha){
    	try{
    		return dateFormat.parse(fecha);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return null;
    	
    
    }
    /**
     * Convierte una fecha al formato estándar del sistema dd/MM/yyyy
     * @param fecha Fecha en date
     * @return Cadena que representa la fecha enviada
     */
    public static String dateToString(Date fecha){
    	try{
    		return dateFormat.format(fecha);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return StringUtils.EMPTY;
    	
    
    }
    /**
     * Intenta parsear una fecha con el formato enviado como parámetro
     * Si no logra hacer el parseo regresa un objeto nulo
     * @param fecha Fecha en cadena
     * @return Date que representa la cadena, null en caso de no lograr parsearla
     */
    public static Date stringToDate(String fecha,String patron){
    	try{
    	    SimpleDateFormat formato = new SimpleDateFormat(patron);
    		return formato.parse(fecha);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return null;
    	
    
    }
    /**
     * Intenta convertir la cadena enviada a número, si no lo logra retorna nulo
     * @param numero Cadena con el número a convertir
     * @return Número representado por la cadena, null en caso de no poder convertirlo
     */
    public static Integer parseIntNull(String numero){
    	try{
    		return Integer.parseInt(numero);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return null;
    }
    
    public static String formatoMoneda(Double numero){
    	if(numero == null){
    		return StringUtils.EMPTY;
    	}
    	return formatoMoneda.format(numero);
    }
    
    public static String formatoNumeroEntero(Double numero){
    	if(numero == null){
    		return StringUtils.EMPTY;
    	}
    	return formatoNumeroSinDecimales.format(numero);
    }
    
    
}
