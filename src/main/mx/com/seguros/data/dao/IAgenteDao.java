/*
 * IAgenteDao.java
 *
 * Created on 17 de marzo de 2008, 03:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.Agente;
import mx.com.seguros.model.BonoTrimestralAgente;
import mx.com.seguros.model.ComisionBrutaAgente;
import mx.com.seguros.model.DescuentoComisionAgente;
import mx.com.seguros.model.DetalleComisionSolicitud;
import mx.com.seguros.model.Empleado;
import mx.com.seguros.model.PagoPrestamoEmpleado;
import mx.com.seguros.model.ProduccionQuincenaPuntosAgente;

/**
 *
 * @author Alverik
 */
public interface IAgenteDao {
    
    /** Creates a new instance of IAgenteDao */
    public List obtenTodosAgentes();
    public List obtenListaBonoTrimestralAgente();
    public void insertaComisionBrutaAgente(ComisionBrutaAgente comisionAgente);
    public void insertaDescuentoComisionAgente(DescuentoComisionAgente descuentoComision);
    public Object obtenerComisionBrutaAgente(int cveAgente);
    public Object obtenerTipoAgente(int cveAgente);
    public List obtenerListaProduccionesQuincenalesPuntosAgente(int cveAgente);
    public void actualizaProduccionesQuincenalesPuntosAgente(ProduccionQuincenaPuntosAgente produccionQuin);
    public void insertaBonoTrimestralAgente(BonoTrimestralAgente bonoTrim);
    public void insertaProduccionQuincenaPuntosAgente(ProduccionQuincenaPuntosAgente produccionQuin);
    
    public List obtenComisionBrutaAgente(int cveAgente);
    public void actualizaComisionBrutaAgente(ComisionBrutaAgente comisionAgente);
    public List obtenProduccionQuincenaPuntosAgente(int cveAgente);
    public void actualizaProduccionQuincenaPuntosAgente(ProduccionQuincenaPuntosAgente produccionQuin);
    public List obtenDescuentoComisionAgente(int cveAgente);
    public void actualizaDescuentoComisionAgente(DescuentoComisionAgente descuentoComision);
    public List obtenBonoTrimestralAgente();
    public void actualizaBonoTrimestralAgente(BonoTrimestralAgente bonoTrim);
    
    public List obtenDetalleComisionSolicitud(int folioSolicitud, String formatoSolicitud);
    public void actualizaDetalleComisionSolicitud(DetalleComisionSolicitud detalleComSolic);
    public void insertaDetalleComisionSolicitud(DetalleComisionSolicitud detalleComSolic);

    public List obtenListaEmpleadoAgente();
    public List obtenListaPrestamoEmpleadoNoLiquidado(int cveEmpleado);
    public Object obtenPrimerPagoPrestamoEmpleado(PagoPrestamoEmpleado pagoPrestEmpl);
    
    public Object obtenerIndicadorEsquemaEmpleado(int cveAgente);
    public List obtenCveAgentePorEsquema(int idEsquema);
    public List obtenerClaveAgentePorProduccionQuincenal(ProduccionQuincenaPuntosAgente produccion);
    
    public Object obtenerClaveSupervisoryGerente(int cveAgente);
    public Object obtenerEsquemaGerente(int cveGerente);
    public Object obtenerEsquemaSupervisor(int cveSupervisor);
    
     public List obtenerListaGerentesPorProduccion(int numQuincenaReporte);
      public List obtenerListaSupervisoresPorProduccion(int numQuincenaReporte);
       public void borraBonoTrimestralAgente();
       
    /**
     * Busca a un empleado por su clave   
     * @param claveEmpleado
     * @return empleado encontrado
     */
    Empleado obtenerEmpleadoPorClave(int claveEmpleado);
    /**
     * Obtiene un agente en base a su clave de empleado
     * @param claveEmpleado Clave de empleado buscada
     * @return Agente encontrado, null si no se encuentra
     */
    Agente obtenerAgente(int claveEmpleado);
    /**
     * Obtiene un objeto de Agente por clave única del agente
     * @param cveAgente Clave del agente buscar
     * @return Objeto de agente lleno
     */
    Agente obtenerAgentePorCveAgente(int cveAgente);
}
