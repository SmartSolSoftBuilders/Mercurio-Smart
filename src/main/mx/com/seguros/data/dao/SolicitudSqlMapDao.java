/*
 * SolicitudMapperDao.java
 *
 * Created on 29 de agosto de 2007, 02:50 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.dto.SolicitudPKParamDTO;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.ComisionBrutaAgente;
import mx.com.seguros.model.DetalleDescuentoComisionSolicitud;
import mx.com.seguros.model.EstatusSolicitud;
import mx.com.seguros.model.HistoricoTarifa;
import mx.com.seguros.model.Promotor;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
/**
 *
 * @author QTX
 */
public class SolicitudSqlMapDao extends SqlMapClientDaoSupport implements ISolicitudDao{
    
    /** Creates a new instance of SolicitudMapperDao */
    public SolicitudSqlMapDao() {
    }

    @Override
    public void insertarSolicitud(Solicitud solicitud) {
        getSqlMapClientTemplate().insert("insertarSolicitud", solicitud);
    }
    
    @Override
    public List obtenSolicitudPorEstatusYnumNominaContratante(Solicitud solicitud){
        return (List)getSqlMapClientTemplate().queryForList("obtenSolicitudPorEstatusYnumNominaContratante",solicitud);
    }
    
    @Override
    public Object obtenTarifaMensualPorClaveTarifa(int cveTarifa){
        return getSqlMapClientTemplate().queryForObject("obtenTarifasPorSolicitud",cveTarifa);
        
    }
    
    @Override
    public List obtenListaSolicitudesVencidas(ComisionBrutaAgente comisionBrutaAgente){
        return  this.getSqlMapClientTemplate().queryForList("obtenListaSolicitudesVencidas",comisionBrutaAgente);
    }
    
    @Override
    public List obtenSolicitudesAgente(Solicitud solicitud){
        return (List) this.getSqlMapClientTemplate().queryForList("obtenListaSolicitudesAgente",solicitud);
    }
    
    @Override
    public Object obtenerDetalleComisionSolicitud(int folioSolicitud,String formatoSolicitud){
        return getSqlMapClientTemplate().queryForObject("obtenerDetalleComisionSolicitud",
        		new  SolicitudPKParamDTO(folioSolicitud, formatoSolicitud));
    }
    
    @Override
     public List obtenDetalleDescuentoComisionSolicitud(int folioSolicitud, String formatoSolicitud){
        return getSqlMapClientTemplate().queryForList("obtenDetalleDescuentoComisionSolicitud",
        		new  SolicitudPKParamDTO(folioSolicitud, formatoSolicitud));
    }
    
    @Override
    public void actualizaDetalleDescuentoComisionSolicitud(DetalleDescuentoComisionSolicitud detalleDescComSolic){
        this.getSqlMapClientTemplate().update("actualizaDetalleDescuentoComisionSolicitud",detalleDescComSolic);
    }
    
    @Override
    public void insertaDetalleDescuentoComisionSolicitud(DetalleDescuentoComisionSolicitud detalleDescComSolic){
        this.getSqlMapClientTemplate().insert("insertaDetalleDescuentoComisionSolicitud",detalleDescComSolic);
    }
    
    @Override
    public Object obtenSolicitudPorFolioSolicitud(int folioSolicitud,String formatoSolicitud) {
         return getSqlMapClientTemplate().queryForObject("obtenSolicitudPorFolioSolicitud",
        		 new  SolicitudPKParamDTO(folioSolicitud, formatoSolicitud));
    }
   
    @Override
    public TarifaAportMensual obtenerTarifaMensualPorImporte(double importeTarifa) {
    	List res = getSqlMapClientTemplate().queryForList("obtenTarifaPorImporte",importeTarifa);
    	if(res!= null && !res.isEmpty()){
    		return (TarifaAportMensual)res.get(0);
    	}
        return null;
    }

    @Override
    public void insertarSolicitudDeArchivo(Solicitud solicitud) {
        getSqlMapClientTemplate().insert("insertarSolicitudDeArchivo",solicitud);
    }

    @Override
    public void consultarSolicitudes(CriteriosConsultaSolicitudesDTO criterios, ResultadoPaginadoDTO resultado) {
        String nombreContratanteOriginal = null;
        
        //se agregan los "%" para que realice correctamente la búsqueda por nombre
    	if(criterios != null && StringUtils.isNotBlank(criterios.getNombreContratante())){
    		nombreContratanteOriginal = criterios.getNombreContratante() ;
    		criterios.setNombreContratante("%"  + nombreContratanteOriginal +"%");
        }
    	if(resultado != null){
            if(resultado.isPrimerVez()){
                //obtener el total de registros de la consulta
                Integer totalResultados = (Integer)getSqlMapClientTemplate().queryForObject("countConsultaGeneralSolicitudes", criterios);
                resultado.setTotalResultados(totalResultados);
                resultado.setTotalPaginas((int)Math.ceil( ((double)totalResultados)/((double)resultado.getRegistrosPorPagina()) ));
                
                //Obtener el total de primas que arroja la consulta
                Double totalPrima = (Double)getSqlMapClientTemplate().queryForObject("sumConsultaGeneralSolicitudes", criterios);
                resultado.setTotalPrima(totalPrima);
                
                
            }
            resultado.setResultados(getSqlMapClientTemplate().queryForList("consultaGeneralSolicitudes",criterios,
                    (resultado.getPaginaActual()-1)*resultado.getRegistrosPorPagina()
                    ,resultado.getRegistrosPorPagina() ));
        }
    	 if(criterios != null  ){
    		 criterios.setNombreContratante(nombreContratanteOriginal);
         }

    }
    
    @Override
    public void consultarSolicitudesEsp(CriteriosConsultaSolicitudesDTO criterios, ResultadoPaginadoDTO resultado) {
        String nombreContratanteOriginal = null;
        
        //se agregan los "%" para que realice correctamente la búsqueda por nombre
    	if(criterios != null && StringUtils.isNotBlank(criterios.getNombreContratante())){
    		nombreContratanteOriginal = criterios.getNombreContratante() ;
    		criterios.setNombreContratante("%"  + nombreContratanteOriginal +"%");
        }
    	if(resultado != null){
            if(resultado.isPrimerVez()){
                //obtener el total de registros de la consulta
                Integer totalResultados = (Integer)getSqlMapClientTemplate().queryForObject("countConsultaEspecial", criterios);
                resultado.setTotalResultados(totalResultados);
                resultado.setTotalPaginas((int)Math.ceil( ((double)totalResultados)/((double)resultado.getRegistrosPorPagina()) ));
                
                //Obtener el total de primas que arroja la consulta
                Double totalPrima = (Double)getSqlMapClientTemplate().queryForObject("sumConsultaEspecial", criterios);
                resultado.setTotalPrima(totalPrima);
                
                
            }
            resultado.setResultados(getSqlMapClientTemplate().queryForList("consultaEspecial",criterios,
                    (resultado.getPaginaActual()-1)*resultado.getRegistrosPorPagina()
                    ,resultado.getRegistrosPorPagina() ));
        }
    	 if(criterios != null  ){
    		 criterios.setNombreContratante(nombreContratanteOriginal);
         }

    }

    @Override
    public Solicitud obtenerDetalleSolicitudPorFolio(int folioSolicitud, String formatoSolicitud) {
        Map params = new HashMap();
        params.put("folioSolicitud",folioSolicitud);
        params.put("formatoSolicitud", formatoSolicitud);
        return (Solicitud)getSqlMapClientTemplate().queryForObject("seleccionarSolicitudFolio",params);
    }

    @Override
    public void actualizarSolicitud(Solicitud solicitud) {
        getSqlMapClientTemplate().update("actualizarSolicitudCompleto",solicitud);
        getSqlMapClient().flushDataCache();
    }

	@Override
	public List<EstatusSolicitud> consultarEstatusSolicitud() {
		return getSqlMapClientTemplate().queryForList("obtenerEstatusSolicitud");
	}
	
	@Override
    @SuppressWarnings("unchecked")
    public Collection<Solicitud> obtenSolicitudCollPorNumNominaContratante(String numNominaContratante, Date fechaLimiteCarga) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("numNominaContratante", numNominaContratante);
        paramMap.put("fechaLimiteCarga", fechaLimiteCarga);
        Collection<Solicitud> solColl;
        solColl = (Collection) getSqlMapClientTemplate().queryForList("obtenSolicitudPorNumNominaContratante", paramMap);
        return solColl;
    }
    private static Logger LOG;

    static {
        LOG = LoggerFactory.getLogger(SolicitudSqlMapDao.class);
    }

	@Override
	public void actualizarTarifaTotal(Solicitud solicitud) {
		getSqlMapClientTemplate().update("actualizarTarifaTotal",solicitud);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ISolicitudDao#consultarBeneficiarios(java.lang.Integer, java.lang.String)
	 */
	@Override
	public List<Beneficiario> consultarBeneficiarios(Integer foliosSolicitud,
			String formatoSolicitud) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("folioSolicitud", foliosSolicitud);
		params.put("formatoSolicitud", formatoSolicitud);
		return (List<Beneficiario>)getSqlMapClientTemplate().queryForList("consultarBeneficiarios",params);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ISolicitudDao#buscarPromotor(java.lang.Integer)
	 */
	@Override
	public Promotor buscarPromotor(Integer cvePromotor) {
		return (Promotor)getSqlMapClientTemplate().queryForObject("buscarPromotor",cvePromotor);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ISolicitudDao#actualizarPKSolicitud(mx.com.seguros.model.Solicitud, mx.com.seguros.model.Solicitud)
	 */
	@Override
	public void actualizarPKSolicitud(Solicitud datosOriginales,
			Solicitud datosNuevos) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("folioSolicitudNuevo", datosNuevos.getFolioSolicitud());
		params.put("formatoSolicitudNuevo", datosNuevos.getFormatoSolicitud());
		params.put("folioSolicitud", datosOriginales.getFolioSolicitud());
		params.put("formatoSolicitud", datosOriginales.getFormatoSolicitud());
		getSqlMapClientTemplate().update("actualizarPKSolicitud",params);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ISolicitudDao#insertarHistoricoTarifa(mx.com.seguros.model.HistoricoTarifa)
	 */
	@Override
	public void insertarHistoricoTarifa(HistoricoTarifa historico) {
		getSqlMapClientTemplate().insert("insertarHistoricoTarifa",historico);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ISolicitudDao#consultarHistoricoTarifaSolicitud(mx.com.seguros.model.Solicitud)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<HistoricoTarifa> consultarHistoricoTarifaSolicitud(
			Solicitud solicitud) {
		return getSqlMapClientTemplate().queryForList("consultarHistoricoTarifaSolicitud",solicitud);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ISolicitudDao#consultarHistoricoTarifaEnFecha(mx.com.seguros.model.Solicitud, java.util.Date)
	 */
	@Override
	public HistoricoTarifa consultarHistoricoTarifaEnFecha(Solicitud sol,
			Date fecha) {
		Map params = new HashMap();
		params.put("folioSolicitud",sol.getFolioSolicitud());
		params.put("formatoSolicitud", sol.getFormatoSolicitud());
		params.put("fecha", fecha);
		return (HistoricoTarifa)getSqlMapClientTemplate().queryForObject("buscarTarifaEnFecha",params);
	}

	@Override
	public void carteraSolicitudes(ResultadoPaginadoDTO resultado) {
				
    	if(resultado != null){
           /* if(resultado.isPrimerVez()){
                //obtener el total de registros de la consulta
                Integer totalResultados = (Integer)getSqlMapClientTemplate().queryForObject("countConsultaCarteraSolicitudes");
                resultado.setTotalResultados(totalResultados);
                resultado.setTotalPaginas((int)Math.ceil( ((double)totalResultados)/((double)resultado.getRegistrosPorPagina()) ));
                                   
                
            }*/
            
            
           // resultado.setResultados(getSqlMapClientTemplate().queryForList("consultaCarteraSolicitudes",
                   // (resultado.getPaginaActual()-1)*resultado.getRegistrosPorPagina()
                    //,resultado.getRegistrosPorPagina() ));
    		
    		resultado.setResultados(getSqlMapClientTemplate().queryForList("consultaCarteraSolicitudes"));
        }
    	 		
	}
	
}
