/*
 * Agente.java
 *
 * Created on 17 de marzo de 2008, 03:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.dto.SolicitudPKParamDTO;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.ComisionBrutaAgente;
import mx.com.seguros.model.DescuentoComisionAgente;
import mx.com.seguros.model.BonoTrimestralAgente;
import mx.com.seguros.model.Empleado;
import mx.com.seguros.model.ProduccionQuincenaPuntosAgente;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import mx.com.seguros.model.DetalleComisionSolicitud;
import mx.com.seguros.model.PagoPrestamoEmpleado;
/**
 *
 * @author Alverik
 */
public class AgenteSqlMapDao  extends SqlMapClientDaoSupport implements IAgenteDao {
    
    /** Creates a new instance of Agente */
    public AgenteSqlMapDao() {
    }
    
    @Override
    public Object obtenerIndicadorEsquemaEmpleado(int cveAgente){
        return getSqlMapClientTemplate().queryForObject("obtenerIndicadorEsquemaEmpleado",cveAgente);
    }
    
    @Override
    public Object obtenPrimerPagoPrestamoEmpleado(PagoPrestamoEmpleado pagoPrestEmpl){
        return getSqlMapClientTemplate().queryForObject("obtenPrimerPagoPrestamoEmpleado",pagoPrestEmpl);
    }
    
    @Override
    public List obtenListaPrestamoEmpleadoNoLiquidado(int cveEmpleado){
        return getSqlMapClientTemplate().queryForList("obtenListaPrestamoEmpleadoNoLiquidado",cveEmpleado);
//return getSqlMapClientTemplate().queryForList("obtenListaPrestamoEmpleadoNoLiquidado",cveEmpleado);
    }
    
    @Override
    public List obtenListaEmpleadoAgente(){
        return getSqlMapClientTemplate().queryForList("obtenListaEmpleadoAgente");
    }
    
    @Override
    public List obtenTodosAgentes(){
        return getSqlMapClientTemplate().queryForList("obtenTodosAgentes");
    }
    
    @Override
    public List obtenListaBonoTrimestralAgente(){
        return getSqlMapClientTemplate().queryForList("obtenListaBonoTrimestralAgente");
    }
    
    @Override
    public List obtenComisionBrutaAgente(int cveAgente){
        return getSqlMapClientTemplate().queryForList("obtenComisionBrutaAgente",cveAgente);
    }
    
    @Override
    public void actualizaComisionBrutaAgente(ComisionBrutaAgente comisionAgente){
        this.getSqlMapClientTemplate().update("actualizaComisionBrutaAgente",comisionAgente);
    }
    
    @Override
    public void insertaComisionBrutaAgente(ComisionBrutaAgente comisionAgente){
        this.getSqlMapClientTemplate().insert("insertaComisionBrutaAgente",comisionAgente);
    }
    
    
    @Override
    public List obtenProduccionQuincenaPuntosAgente(int cveAgente){
        return getSqlMapClientTemplate().queryForList("obtenProduccionQuincenaPuntosAgente",cveAgente);
    }
    
    @Override
    public void actualizaProduccionQuincenaPuntosAgente(ProduccionQuincenaPuntosAgente produccionQuin){
        this.getSqlMapClientTemplate().update("actualizaProduccionQuincenaPuntosAgente",produccionQuin);
    }
    
    @Override
    public void insertaProduccionQuincenaPuntosAgente(ProduccionQuincenaPuntosAgente produccionQuin){
        this.getSqlMapClientTemplate().insert("insertaProduccionQuincenaPuntosAgente",produccionQuin);
    }
    
    @Override
     public List obtenDescuentoComisionAgente(int cveAgente){
        return getSqlMapClientTemplate().queryForList("obtenDescuentoComisionAgente",cveAgente);
    }
     
    @Override
     public void actualizaDescuentoComisionAgente(DescuentoComisionAgente descuentoComision){
        this.getSqlMapClientTemplate().update("actualizaDescuentoComisionAgente",descuentoComision);
    }
    
    @Override
    public void insertaDescuentoComisionAgente(DescuentoComisionAgente descuentoComision){
        this.getSqlMapClientTemplate().insert("insertaDescuentoComisionAgente",descuentoComision);
    }
    
    @Override
    public Object obtenerComisionBrutaAgente(int cveAgente){
        return getSqlMapClientTemplate().queryForObject("obtenerComisionBrutaAgente",cveAgente);
    }
    
    @Override
    public Object obtenerTipoAgente(int cveAgente){
        return getSqlMapClientTemplate().queryForObject("obtenerTipoAgente",cveAgente);
    }
    
    @Override
    public List obtenerListaProduccionesQuincenalesPuntosAgente(int cveAgente){
        return  this.getSqlMapClientTemplate().queryForList("obtenerListaProduccionesQuincenalesPuntosAgente",cveAgente);
    }
    
    @Override
    public void actualizaProduccionesQuincenalesPuntosAgente(ProduccionQuincenaPuntosAgente produccionQuin){
        this.getSqlMapClientTemplate().update("actualizaProduccionesQuincenalesPuntosAgente",produccionQuin);
    }
    
    @Override
     public List obtenBonoTrimestralAgente(){
        return getSqlMapClientTemplate().queryForList("obtenBonoTrimestralAgente");
    }
    
    @Override
     public void actualizaBonoTrimestralAgente(BonoTrimestralAgente bonoTrim){
        this.getSqlMapClientTemplate().update("actualizaBonoTrimestralAgente",bonoTrim);
    }
     
    @Override
    public void insertaBonoTrimestralAgente(BonoTrimestralAgente bonoTrim){
        this.getSqlMapClientTemplate().insert("insertaBonoTrimestralAgente",bonoTrim);
    }
    
    @Override
    public List obtenDetalleComisionSolicitud(int folioSolicitud, String formatoSolicitud){
        return getSqlMapClientTemplate().queryForList("obtenDetalleComisionSolicitud",new SolicitudPKParamDTO(folioSolicitud, formatoSolicitud));
    }
    
    @Override
    public void actualizaDetalleComisionSolicitud(DetalleComisionSolicitud detalleComSolic){
        this.getSqlMapClientTemplate().update("actualizaDetalleComisionSolicitud",detalleComSolic);
    }
    
    @Override
    public void insertaDetalleComisionSolicitud(DetalleComisionSolicitud detalleComSolic){
        this.getSqlMapClientTemplate().insert("insertaDetalleComisionSolicitud",detalleComSolic);
    }
    
    @Override
    public List obtenCveAgentePorEsquema(int idEsquema) {
        return getSqlMapClientTemplate().queryForList("obtenCveAgentePorEsquema",idEsquema);
    }
    
    @Override
    public List obtenerClaveAgentePorProduccionQuincenal(ProduccionQuincenaPuntosAgente produccion){
        return getSqlMapClientTemplate().queryForList("obtenerClaveAgentePorProduccionQuincenal",produccion);
    }
    
    @Override
    public Object obtenerClaveSupervisoryGerente(int cveAgente){
        return getSqlMapClientTemplate().queryForObject("obtenerClaveSupervisoryGerente",cveAgente);
    }
    
    @Override
    public Object obtenerEsquemaGerente(int cveGerente){
        return getSqlMapClientTemplate().queryForObject("obtenerEsquemaGerente",cveGerente);
    }
    
    @Override
    public Object obtenerEsquemaSupervisor(int cveSupervisor){
        return getSqlMapClientTemplate().queryForObject("obtenerEsquemaSupervisor",cveSupervisor);
    }
    
    @Override
    public List obtenerListaGerentesPorProduccion(int numQuincenaReporte){
       return getSqlMapClientTemplate().queryForList("obtenerListaGerentesPorProduccion",numQuincenaReporte); 
    }
    
    @Override
    public List obtenerListaSupervisoresPorProduccion(int numQuincenaReporte){
       return getSqlMapClientTemplate().queryForList("obtenerListaSupervisoresPorProduccion",numQuincenaReporte); 
    }
    
    @Override
    public void borraBonoTrimestralAgente(){
        this.getSqlMapClientTemplate().delete("borraBonoTrimestralAgente");
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IAgenteDao#obtenerEmpleadoPorClave(int)
     */
	@Override
	public Empleado obtenerEmpleadoPorClave(int claveEmpleado) {
		return (Empleado)getSqlMapClientTemplate().queryForObject("obtenerEmpleadoPorClave", claveEmpleado);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IAgenteDao#obtenerAgente(int)
	 */
	@Override
	public Agente obtenerAgente(int claveEmpleado) {
		return (Agente)getSqlMapClientTemplate().queryForObject("obtenerAgentePorClaveEmpleado", claveEmpleado);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IAgenteDao#obtenerAgentePorCveAgente(int)
	 */
	@Override
	public Agente obtenerAgentePorCveAgente(int cveAgente) {
		
			
		return (Agente)getSqlMapClientTemplate().queryForObject("obtenerAgentePorClaveAgente", cveAgente);
	}
	
	
}
