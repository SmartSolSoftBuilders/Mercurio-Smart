/*
 * AseguradoSqlMapDao.java
 *
 * Created on 8 de octubre de 2007, 12:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import mx.com.seguros.model.Asegurado;
import mx.com.seguros.model.Contratante;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitante;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
/**
 *
 * @author Cesar
 */
public class AseguradoSqlMapDao extends SqlMapClientDaoSupport implements IAseguradoDao {
    
    /** Creates a new instance of AseguradoSqlMapDao */
    public AseguradoSqlMapDao() {
    }

    
    public void insertarAsegurado(Solicitante solicitante, Contratante contratante, PolizaIndividual poliza) {
        
        getSqlMapClientTemplate().insert("insertarAsegurado",
        		crearAsegurado(solicitante, contratante, poliza));
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IAseguradoDao#crearAsegurado(mx.com.seguros.model.Solicitante, mx.com.seguros.model.Contratante, mx.com.seguros.model.PolizaIndividual)
     */
    @Override
    public Asegurado crearAsegurado(Solicitante solicitante, Contratante contratante, PolizaIndividual poliza){
    	Asegurado asegurado = new Asegurado();
        asegurado.setNumNominaAsegurado(contratante.getNumNominaContratante());
        asegurado.setRFCasegurado(solicitante.getRFCsolicitante());
        asegurado.setApMaternoAsegurado(solicitante.getApMaternoSolicitante());
        asegurado.setApPaternoAsegurado(solicitante.getApPaternoSolicitante());
        asegurado.setNombre1Asegurado(solicitante.getNombre1Solicitante());
        asegurado.setNombre2Asegurado(solicitante.getNombre2Solicitante());
        asegurado.setFechaNacimientoAsegurado(solicitante.getFechaNacimientoSolicitante());
        asegurado.setPuestoAsegurado(solicitante.getPuestoSolicitante());
        asegurado.setSexoAseguradoMasculino(solicitante.getSexoSolicitanteMasculino());
        asegurado.setEstadoCivilAsegurado(solicitante.getEstadoCivilSolicitante());
        asegurado.setIngresoMensualAsegurado(solicitante.getIngresoMensualSolicitante());
        asegurado.setCalle(solicitante.getCalle());
        asegurado.setEdificio(solicitante.getEdificio());
        asegurado.setNumExtInt(solicitante.getNumExtInt());
        asegurado.setColonia(solicitante.getColonia());
        asegurado.setCodPostal(solicitante.getCodPostal());
        asegurado.setDelegacionMpio(solicitante.getDelegacionMpio());
        asegurado.setCiudadPoblacion(solicitante.getDelegacionMpio());
        asegurado.setEntidadFederativa(solicitante.getEntidadFederativa());
        asegurado.setLada(solicitante.getLada()!=null?solicitante.getLada():0);
        asegurado.setTelefono(solicitante.getTelefono()!=null?solicitante.getTelefono():0);
        asegurado.setNumPoliza(poliza.getNumPoliza());
        asegurado.setEmail(solicitante.getEmail());
        asegurado.setNumConsignatario(poliza.getNumConsignatario());
        return asegurado;
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IAseguradoDao#insertarAseguradoArchivoPoliza(mx.com.seguros.model.Asegurado)
     */
    @Override
    public void insertarAseguradoArchivoPoliza(Asegurado asegurado) {
        getSqlMapClientTemplate().insert("insertarAsegurado",asegurado);
    }

    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IAseguradoDao#actalizarAsegurado(mx.com.seguros.model.Asegurado)
     */
	@Override
	public void actualizarAsegurado(Asegurado aseguradoActualizar) {
		getSqlMapClientTemplate().update("actualizarAsegurado",aseguradoActualizar);
		
	}
}
