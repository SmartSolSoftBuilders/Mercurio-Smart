/*
 * ICertificadoIndividualDao.java
 *
 * Created on 3 de octubre de 2007, 16:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import mx.com.seguros.model.CertificadoIndividual;

/**
 *
 * @author CGM
 */
public interface ICertificadoIndividualDao {
    int recuperarCvePlaza(int folioSolicitud, String formatoSolicitud);
    int recuperarUltimoCertificadoPorPlaza(int idPlaza);
    int insertarCertificadoIndividual(CertificadoIndividual certificadoIndividual);
    /**
     * Consulta un certificado individual de una solicitud en base al folio de la solicitud
     * @param folioSolicitud Folio a buscar
     * @param formatoSolicitud Formato de la solicitud a buscar
     * @return Certificado encontrado
     */
    CertificadoIndividual consultarCertificadoPorFolio(Integer folioSolicitud, String formatoSolicitud);
    
    CertificadoIndividual buscarCertificadoPorCertificadoYPlaza(Integer numCertificado,String cvePlaza);
    
}
