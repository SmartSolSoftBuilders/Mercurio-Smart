package mx.com.seguros.business.pagos;

/*
 * PagosBusiness.java
 *
 * Created on 07 de abril de 2010, 07:40 PM
 *
 */
import java.util.ArrayList;
import java.util.List;

import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.model.ArchivosAplicacionCargados;
import mx.com.seguros.model.CifrasControlProcesoAutofinanciar;

/**
 *
 * @author Cesar Garcia Mauricio
 */
public interface PagosBusiness {

    // void readPayFile(List<List<String>> datosArchivo);
    void readPayFile(ArrayList<List<String>> datosArchivo);
    /**
     * Una vez leído el archivo de aplicación de pagos
     * se obtienen las siguientes columnas
	 * QUINCENA QUE SE ESTÁ PAGANDO: Almacenada como cadena con los datos del número de quincena y el año, separadas por un espacio ejemplo: '20 2012' quincena 20 del 2012 -- campo que será leído
	 * INICIO DE VIGENCIA: Fecha con el formato yyyyMMdd ejemplo: 20110615 -- campo que será leído
	 * EMISIOR: Número entero
	 * CARPETA: número entero -- campo que será leído (número de póliza)
	 * PÓLIZA: número entero -- campo que será leído
	 * RFC: informativo
	 * RFC: informativo
	 * NOMBRE: informativo
	 * PAGO: número decimal  --- Campo que será leído
	 * OV: número decimal
	 * COLECTIVO : número decimal
	 * El primero renglón será desechado, en este renglón deben de ir los títulos
	 * 
     * @param datosArchivo
     */
    void cargarArchivoAplicacionPagos(List<List<String>> datosArchivo, byte[] contenidoArchivo, String usuario, String nombreArchivo) throws Exception ;
    
    /**
     * Consulta un conjunto de archivos de aplicación en base a un criterio proporcionado
     * @param criterio Criterios de filtrado
     * @return Resultados encontrados
     */
    List<ArchivosAplicacionCargados> consultarArchivosAplicacionCargados(CriteriosConsultaArchivosAplicacionCargadosDTO criterio);
    
    /**
     * Consulta un archivo de aplicación cargado en base a su llave primaria
     * @param idArchivo Llave primaria
     * @return Archivo de aplicación, null si no se encuentra
     */
    ArchivosAplicacionCargados consultaArcivoAplicacionCargadoPorId(Long idArchivo);
    
    /**
     * Proceso batch para la revisión de la cartera  de las pólizas que no han sido canceladas
     * por el cliente y que no han tenido pagos pero cuentan con fondo de ahorro, se tomará
     * en cuenta el ahorro para pagar la vigencia de la póliza
     */
    CifrasControlProcesoAutofinanciar autoFinanciarPolizasAutomaticamente(Integer idPlaza, Integer idEstatusPolizaPagos ) throws Exception;
    /**
     * Valida si los primeros 10 registros del archivo de aplicación y a se encuentran cargados en los descuentos aplicados de sus
     * pólizas correspondientes. Retorna true en caso de que ningun descuento esté aplicado en el sistema
     * Retorna false si existe al menos un descuento que ya se aplicó.
     * @param datosArchivo Datos cargados del archivo
     * @return True si es válido, false en otro caso
     */
    boolean validarContenidoArchivoAplicacion(List<List<String>> datosArchivo);
    /**
     * Revierte las aplicaciones de pagos del archivo enviado como parámetro, elimina el archivo y las aplicaciones del pago
     * restando los posibles ahorros del asegurado
     * @param idArchivoAplicacion Identificador del archivo de aplicación de pagos a revertir
     * @return True si se logró revertir el archivo exitósamente, false si existen condiciones en las que no se puedan revertir
     */
    boolean revertirArchivoAplicacionCargado(Long idArchivoAplicacion);
    
    
    void ajustarSaldoActualEnDescuentosAplicados();
   
    
}
