/*
 * IAseguradoDao.java
 *
 * Created on 8 de octubre de 2007, 12:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import mx.com.seguros.model.Contratante;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitante;
import mx.com.seguros.model.Asegurado;

public interface IAseguradoDao {
    
    public void insertarAsegurado(Solicitante solicitante, Contratante contratante, PolizaIndividual poliza);
    /**
     * Inserta un asegurado de forma directa a la BD
     * @param asegurado
     */
    public void insertarAseguradoArchivoPoliza(Asegurado asegurado);
    
    /**
     * Crea un nuevo objeto de asegurado en base a los datos de solicitante, contratante y poliza
     * @param solicitante Datos fuente
     * @param contratante Datos fuente
     * @param poliza Datos fuente
     * @return Objeto de asegurado creado
     */
    Asegurado crearAsegurado(Solicitante solicitante, Contratante contratante, PolizaIndividual poliza);
    /**
     * Actualiza el objeto de asegurado en la BD
     * @param aseguradoActualizar Datos fuente a actualizar
     */
    void actualizarAsegurado(Asegurado aseguradoActualizar);
}
