/*
 * Proyecto: Estrategas Seguros - Inbursa
 * Archivo: IRegistroArchivoPolizasDao.java
 * Fecha de creación: 17/06/2011
 * Última Modificación: 17/06/2011
 */

package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.RegistroArchivoPolizas;
import mx.com.seguros.model.ResumenCargaArchivoPolizas;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

/**
 * Interface del objeto de acceso a datos para la lectura de la tabla de RegistroArchivoPolizas
 * @author Emigdio Hernández
 */
public interface IRegistroArchivoPolizasDao {
    /**
     * Consulta las pólizas cargadas pendientes cargadas desde archivo de acuerdo
     * al estado enviado como parámetro
     * @param estadoRegistroPoliza Estado requerido del registro
     * @param resultado Resultado de la consulta y configuración del paginador
     */
    void consultarRegistroArchivoPolizasPorEstatus(Integer estadoRegistroPoliza, ResultadoPaginadoDTO resultado);
    /**
     * Consulta por ID un registro cargado del archivo de pólizas
     * @param id ID a consultar
     * @return Registro encontrado, null en caso de no encontrarlo
     */
    RegistroArchivoPolizas consultarPorId(Long id);
    /**
     * Actualiza el registro de poliza cargado de archivo al estatus indicado
     * @param registroId Registro a actualizar
     * @param estatus Estatus destino
     */
    void actualizarEstatusRegistro(Long registroId,Integer estatus);
    /**
     * Inserta un nuevo registro de resumen de carga de archivo
     * @param resumenCarga Datos a insertar
     */
    void insertarResumenCargaArchivoPolizas(ResumenCargaArchivoPolizas resumenCarga);
    /**
     * Consulta los archivos que han sido cargados en el sistema
     * @return Lista con los archivos cargados
     */
    List<ResumenCargaArchivoPolizas> consultarArchivosCargados();
    /**
     * Consulta los registros cargados para cierto archivo de pólizas y que tengan cierto estado,
     * si el estado se envía nulo entonces no se utiliza en los criterios de búsqueda
     * @param idResumenCargaArchivoPolizas  ID del archivo para el cual se desea obtener su contenido
     * @param idEstadoRegistroPoliza Estado (opcional) de los registros
     * @return
     */
    List<RegistroArchivoPolizas> consultarRegistrosArchivoPolizaPorArchivoCargado(Integer IdResumenCargaArchivoPolizas,Integer idEstadoRegistroPoliza);
    /**
     * Inserta un nuevo registro de archivo de pólizas
     * @param registro Datos de origen
     */
    void insertarRegistroArchivoPolizas(RegistroArchivoPolizas registro);
    /**
     * Consulta un registro de resumen de carga de archivo basado en su ID
     * @param id ID a buscar
     * @return Objeto resumen econtrado, null en caso de no encontrarlos
     */
    ResumenCargaArchivoPolizas consultarArchivoPolizasPorId(Integer id);
    /**
     * Elimina un registro de archivo de pólizas por ID
     * @param idRegistro ID a eliminar
     */
    void eliminarRegistroArchivoPolizas(Integer idRegistro);
}
