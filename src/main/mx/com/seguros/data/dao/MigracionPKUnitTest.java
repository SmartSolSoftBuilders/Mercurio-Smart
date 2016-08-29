/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.CertificadoIndividual;
import mx.com.seguros.model.Contratante;
import mx.com.seguros.model.DetalleComisionSolicitud;
import mx.com.seguros.model.DetalleDescuentoComisionSolicitud;
import mx.com.seguros.model.HistorialMovimientosContratante;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitante;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.test.BaseServiceTest;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;

/**
 * Conjunto de pruebas unitarias para asegurar el correcto funcionamiento de los querys modificados
 * al hacer la migración de la llave primaria de la tabla de Solicitud
 * @author Emigdio Hernández
 * 
 * Query de preparación:
 * 
 */
@SuppressWarnings("rawtypes")
public class MigracionPKUnitTest extends BaseServiceTest{

	private static final Logger log  = Logger.getLogger(MigracionPKUnitTest.class);
	
	@Override
    protected void setUp() throws Exception{
		super.setUp();
		
		
	}
	public void test_inicial(){
		ejecutarQuery("delete from PolizaIndividual where folioSolicitud = 2255510 and numPoliza = 666");
		ejecutarQuery("delete from DetalleComisionSolicitud where folioSolicitud = 2255510");
		ejecutarQuery("delete from CertificadoIndividual where folioSolicitud = 2255510");
		ejecutarQuery("delete from Solicitud where folioSolicitud = 2255511");
		ejecutarQuery("delete from Solicitud where folioSolicitud = 2255512");
		ejecutarQuery("delete from DetalleDescuentoComisionSolicitud where folioSolicitud = 2255511");
	
	}
	/**
	 * Prebas unitarias del método de obtenDetalleComisionSolicitud del AgenteDao
	 */
	public void testAgenteDao_obtenDetalleComisionSolicitud(){
		IAgenteDao dao = (IAgenteDao)getBean("agenteDao");
		
		List detalle = dao.obtenDetalleComisionSolicitud(36111, "FSP");
		log.debug(detalle);
	}
	
	/**
	 * Pruebas para el método de insertarDetalleComisiónSolicitud
	 */
	public void testAgenteDao_insertaDetalleComisionSolicitud(){
		IAgenteDao dao = (IAgenteDao)getBean("agenteDao");
		
		DetalleComisionSolicitud detalleComSolic = new DetalleComisionSolicitud();
		
		detalleComSolic.setFolioSolicitud(2255510);
        detalleComSolic.setFormatoSolicitud("FSP");
        detalleComSolic.setComisionSolicitudAgente(0.1);
        detalleComSolic.setComisionSolicitudSupervisor(0.1);
        detalleComSolic.setComisionSolicitudGerente(0.1);
        detalleComSolic.setComisionPolizaAgente(0);
        detalleComSolic.setComisionPolizaSupervisor(0);
        detalleComSolic.setComisionPolizaGerente(0);
        
        dao.insertaDetalleComisionSolicitud(detalleComSolic);
        
	}
	/**
	 * Pruebas para el método de actualizaDetalleComisionSolicitud
	 */
	public void testAgenteDao_actualizaDetalleComisionSolicitud(){
		IAgenteDao dao = (IAgenteDao)getBean("agenteDao");
		DetalleComisionSolicitud detalleComSolic = new DetalleComisionSolicitud();
		detalleComSolic.setFolioSolicitud(2255510);
        detalleComSolic.setFormatoSolicitud("FSP");
        detalleComSolic.setComisionSolicitudAgente(1.1);
        detalleComSolic.setComisionSolicitudSupervisor(0.1);
        detalleComSolic.setComisionSolicitudGerente(0.1);
        detalleComSolic.setComisionPolizaAgente(0);
        detalleComSolic.setComisionPolizaSupervisor(0);
        detalleComSolic.setComisionPolizaGerente(0);
        
        dao.actualizaDetalleComisionSolicitud(detalleComSolic);
	}
	/**
	 * Pruebas para el método de insertar un beneficiario
	 */
	public void testBeneficiarioDao_insertarBeneficiario(){
		IBeneficiarioDao dao = (IBeneficiarioDao)getBean("beneficiarioDao");
		Beneficiario beneficiario = new Beneficiario();
		
		beneficiario.setFolioSolicitud(2255510);
		beneficiario.setFormatoSolicitud("FSP");
		beneficiario.setTipoBeneficiario(true);
		beneficiario.setApPaternoBeneficiario("Paterno");
		beneficiario.setApMaternoBeneficiario("Materno");
		beneficiario.setNombre1Beneficiario("Nombre 1");
		beneficiario.setNombre2Beneficiario("Nombre 2");
		beneficiario.setFechaNacimientoBeneficiario(new Date());
		beneficiario.setParentesco("Padre");
		beneficiario.setPorcentajeAsignado(70.0);
		
		dao.insertarBeneficiario(beneficiario);
	}
	/**
	 * Pruebas para el DAO de certificado individual
	 */
	public void testCertificadoIndividualDao_recuperarCvePlaza(){
		ICertificadoIndividualDao dao = (ICertificadoIndividualDao)getBean("certificadoIndividualDao");
		
		log.debug(dao.recuperarCvePlaza(2255510, "FSP"));
		
	}
	public void testCertificadoIndividualDao_consultarCertificadoPorFolio(){
		
		ICertificadoIndividualDao dao = (ICertificadoIndividualDao)getBean("certificadoIndividualDao");
		
		log.debug(dao.consultarCertificadoPorFolio(2255510, "FSP"));
			
	}
	public void testCertificadoIndividualDao_insertarCertificadoIndividual(){
		
		ICertificadoIndividualDao dao = (ICertificadoIndividualDao)getBean("certificadoIndividualDao");
		CertificadoIndividual certIndividual = new CertificadoIndividual();
		
		certIndividual.setFechaExpedicion(new Date());
		certIndividual.setFolioSolicitud(2255510);
		certIndividual.setFormatoSolicitud("FSP");
		certIndividual.setIdPlaza(1);
		certIndividual.setNumCertificado(dao.recuperarUltimoCertificadoPorPlaza(1));
				
		dao.insertarCertificadoIndividual(certIndividual);
		
	}
	
	
	/**
	 * actualizarSolicitud 
	 */
	public void testPolizaDao_actualizarSolicitud(){
		
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		
		dao.actualizarSolicitud(2255510,"FSP");
		
	}
	/**
	 * obtenerCvePlaza 
	 */
	public void testPolizaDao_obtenerPlaza(){
		
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		
		dao.obtenerPlaza(2255510,"FSP");
		
	}
	/**
	 * seleccionarPolizaNum
	 */
	public void testPolizaDao_obtenerPolizaNumPoliza(){
		
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		Map params = new HashedMap();
		params.put("numPoliza", 93117121);
		dao.obtenerPolizaNumPoliza(params);
		
	}
	/**
	 * seleccionarPolizaNumConsignatario
	 */
	public void testPolizaDao_obtenerDetallePolizaPorNumero(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		dao.obtenerDetallePolizaPorNumero(93117121,13501);
		
	}
	/**
	 * seleccionarPolizaNumContratante
	 */
	public void testPolizaDao_obtenerPolizaNumContratante(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		Map params = new HashMap();
		params.put("numNominaContratante","0000000001029");
		dao.obtenerPolizaNumContratante(params);
	}
	/**
	 * seleccionarPolizaApPaternoContratante
	 */
	public void testPolizaDao_obtenerPolizaApPaternoContratante(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		Map params = new HashMap();
		params.put("apPaternoContratante","AGUILAR");
		dao.obtenerPolizaApPaternoContratante(params);
	}
	/**
	 * seleccionarPolizaNumeroCertificado
	 */
	public void testPolizaDao_obtenerPolizaCertificado(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		Map params = new HashMap();
		params.put("numCertificado",8945);
		dao.obtenerPolizaCertificado(params);
		
	}
	/**
	 * seleccionarPolizaRFC
	 */
	public void testPolizaDao_obtenerRfcAsegurado(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		Map params = new HashMap();
		params.put("RFCasegurado","AALL5010275C5");
		
		dao.obtenerRfcAsegurado(params);
	}
	/**
	 * seleccionarPolizaApPaterno
	 */
	public void testPolizaDao_obtenerApellidoAsegurado(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		Map params = new HashMap();
		params.put("apPaternoAsegurado", "AGUILAR");
		dao.obtenerApellidoAsegurado(params);
	}
	/**
	 * seleccionarPolizaEntregadaEmitidaAgente
	 */
	public void testPolizaDao_obtenerPolizaEntregadaEmitidaAgente(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		dao.obtenerPolizaEntregadaEmitidaAgente("1");
	}
	/**
	 * obtenPolizaPorEntregarAsegurado
	 */
	public void testPolizaDao_obtenerPolizasPorEntregarAsegurado(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		dao.obtenerPolizasPorEntregarAsegurado("1");
	}
	/**
	 * obtenerPolizaPorSolicitud
	 */
	public void testPolizaDao_obtenerPolizaPorSolicitud(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		dao.obtenerPolizaPorSolicitud(2255510,"FSP");
	}
	/**
	 * obtenerRetenedor
	 */
	public void testPolizaDao_obtenerRetenedor(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		dao.obtenerRetenedor(2255510,"FSP");
	}
	/**
	 * obtenerPolizasPorNumNominaContratante
	 */
	public void testPolizaDao_obtenerPolizasPorNumNominaContratante(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		dao.obtenerPolizasPorNumNominaContratante("0000000001029");
	}
	/**
	 * consultaContadorPolizasVigentes
	 */
	public void testPolizaDao_consultaContadorPolizasVigentes(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		dao.consultaContadorPolizasVigentes("0000000001029");
	}
	/**
	 * consultaPolizasVigentes
	 */
	public void testPolizaDao_consultaPolizasVigentes(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		dao.consultaPolizasVigentes("0000000001029");
	}
	/**
	 * consultaContadorPolizasMvtoQnaCliente
	 */
	public void testPolizaDao_consultaContadorPolizasMvtoQnaCliente(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		HistorialMovimientosContratante hist = new HistorialMovimientosContratante();
		hist.setNumNominaContratante("0000000001029");
		hist.setQnaProgramadaEnvioMovimientoHistorial("");
		dao.consultaContadorPolizasMvtoQnaCliente(hist);
	}
	/**
	 * consultaPolizasMvtoQnaCliente
	 */
	public void testPolizaDao_consultaPolizasMvtoQnaCliente(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		HistorialMovimientosContratante hist = new HistorialMovimientosContratante();
		hist.setNumNominaContratante("0000000001029");
		hist.setQnaProgramadaEnvioMovimientoHistorial("");
		dao.consultaPolizasMvtoQnaCliente(hist);
	}
	/**
	 * consultarClaveDescuentoPorSolicitud 
	 */
	public void testPolizaDao_consultarClaveDescuentoPorSolicitud(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		dao.consultarClaveDescuentoPorSolicitud(2255510,"FSP");
	}
	/**
	 * obtenPolizaPorFolioSolicitud
	 */
	public void testPolizaDao_obtenerPolizasPorFolioSolicitudNoCancelada(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		dao.obtenerPolizasPorFolioSolicitudNoCancelada(2255510,"FSP");
	}
	/**
	 * obtenListaPolizasCambio
	 */
	public void testPolizaDao_obtenListaPolizasCambio(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		dao.obtenListaPolizasCambio("0000000001029");
	}
	/**
	 * buscarPolizasAnteriores
	 */
	public void testPolizaDao_NA(){
		/**
		 * Query no utilizado
		 */
	}
	/**
	 * Pruebas unitarias para el DAO de póliza
	 */
	/**
	 * insertarPoliza
	 */
	public void testPolizaDao_insertarPoliza(){
		IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
		
		PolizaIndividual poliza = new PolizaIndividual();
		
		poliza.setFolioSolicitud(2255510);
		poliza.setFormatoSolicitud("FSP");
		
		poliza.setNumConsignatario(12345);
		poliza.setNumPoliza(666);
		poliza.setAgrupacionCIS(93004895);
		poliza.setFechaInicioVigencia(new Date());
		poliza.setFechaFinVigencia(new Date());
		poliza.setSumaAseguradaIndividual(0.0);
		poliza.setFechaExpedicion(new Date());
		poliza.setTipoSeguro("100");
		poliza.setIdEstatusPolizaSeguimiento(1);
		poliza.setIdEstatusPagosPoliza(1);
		poliza.setIndicadorPagoComisionEntregaPoliza(0);
		poliza.setIndicadorDescuentoComision(0);
		poliza.setTipoMovimientoPoliza("A");
		poliza.setQnaProgEnvioMvtoPoliza(null);
		poliza.setSumaGastosFunerarios(0.0);
		poliza.setSumaSEVI(0.0);
		poliza.setSumaBAF(0.0);
		poliza.setSumaCPF(0.0);
		
		dao.insertarPoliza(poliza);
	}
	
	
	/**
	 * Conjunto de pruebas para el DAO de SolicitudDao
	 * Folio: 2255511  Formato FSP
	 */
	/**
	 * insertarSolicitud
	 */
	public void testSolicitudDao_insertarSolicitud(){
		ISolicitudDao dao = (ISolicitudDao)getBean("solicitudDao");
		
		Solicitud solicitud = new Solicitud();
		
		solicitud.setFolioSolicitud(2255511);
		solicitud.setFormatoSolicitud("FSP");
		
		
		solicitud.setRFCsolicitante("AALL5010275C5");
		solicitud.setNumNominaContratante("0000000001029");
		solicitud.setFechaSolicitud(new Date());
		solicitud.setCvePromotor(1);
		solicitud.setFechaCaptura(new Date());
		solicitud.setCveAgente(1);
        solicitud.setCveTarifa(1);
        solicitud.setIdEstatusSolicitud(ConstantesGenerales.ESTATUS_SOLICITUD_PRECAPTURA);
        solicitud.setTipoSolicitudNormal(true);
        solicitud.setClaveUsuarioRegistro("masterOp1");
        solicitud.setFechaRegistro(new Date());
        solicitud.setCveEmpresa(6163);
        solicitud.setFechaProduccion(new Date());
     
        dao.insertarSolicitud(solicitud);
        
		
		
		
	}
	/**
	 * obtenSolicitudPorEstatusYnumNominaContratante
	 */
	public void testSolicitudDao_obtenSolicitudPorEstatusYnumNominaContratante(){
		ISolicitudDao dao = (ISolicitudDao)getBean("solicitudDao");
		Solicitud solicitud = new Solicitud();
		solicitud.setNumNominaContratante("0000000001029");
		solicitud.setIdEstatusSolicitud(ConstantesGenerales.ESTATUS_SOLICITUD_PRECAPTURA);
		log.debug(dao.obtenSolicitudPorEstatusYnumNominaContratante(solicitud));
	}
	/**
	 * obtenerDetalleComisionSolicitud
	 */
	public void testSolicitudDao_obtenerDetalleComisionSolicitud(){
		ISolicitudDao dao = (ISolicitudDao)getBean("solicitudDao");
		log.debug(dao.obtenerDetalleComisionSolicitud(36111,"FSP"));
	}
	/**
	 * obtenDetalleDescuentoComisionSolicitud
	 */
	public void testSolicitudDao_obtenDetalleDescuentoComisionSolicitud(){
		ISolicitudDao dao = (ISolicitudDao)getBean("solicitudDao");
		log.debug(dao.obtenDetalleDescuentoComisionSolicitud(1315,"FSP"));
	}
	/**
	 * actualizaDetalleDescuentoComisionSolicitud
	 */
	public void testSolicitudDao_actualizaDetalleDescuentoComisionSolicitud(){
		ISolicitudDao dao = (ISolicitudDao)getBean("solicitudDao");
		DetalleDescuentoComisionSolicitud detalle = new DetalleDescuentoComisionSolicitud();
		detalle.setFolioSolicitud(1315);
		detalle.setFormatoSolicitud("FSP");
		detalle.setImporteDescuentoComisionAgente(0);
		detalle.setImporteDescuentoComisionGerente(0);
		detalle.setImporteDescuentoComisionSupervisor(0);
		dao.actualizaDetalleDescuentoComisionSolicitud(detalle);
	}
	/**
	 * insertaDetalleDescuentoComisionSolicitud
	 */
	public void testSolicitudDao_insertaDetalleDescuentoComisionSolicitud(){
		ISolicitudDao dao = (ISolicitudDao)getBean("solicitudDao");
		DetalleDescuentoComisionSolicitud detalle = new DetalleDescuentoComisionSolicitud();
		detalle.setFolioSolicitud(2255511);
		detalle.setFormatoSolicitud("FSP");
		detalle.setImporteDescuentoComisionAgente(0);
		detalle.setImporteDescuentoComisionGerente(0);
		detalle.setImporteDescuentoComisionSupervisor(0);
		dao.actualizaDetalleDescuentoComisionSolicitud(detalle);
		dao.insertaDetalleDescuentoComisionSolicitud(detalle);
	}
	/**
	 * obtenSolicitudPorFolioSolicitud
	 */
	public void testSolicitudDao_obtenSolicitudPorFolioSolicitud(){
		ISolicitudDao dao = (ISolicitudDao)getBean("solicitudDao");
		log.debug(dao.obtenSolicitudPorFolioSolicitud(2255511, "FSP"));
	}
	/**
	 * seleccionarSolicitudFolio
	 */
	public void testSolicitudDao_obtenerDetalleSolicitudPorFolio(){
		ISolicitudDao dao = (ISolicitudDao)getBean("solicitudDao");
		log.debug(dao.obtenerDetalleSolicitudPorFolio(2255511, "FSP"));
		
	}
	/**
	 * insertarSolicitudDeArchivo
	 */
	public void testSolicitudDao_insertarSolicitudDeArchivo(){
		ISolicitudDao dao = (ISolicitudDao)getBean("solicitudDao");
		Solicitud solicitud = new Solicitud();
		
		solicitud.setFolioSolicitud(2255512);
		solicitud.setFormatoSolicitud("FSP");
		
		
		solicitud.setRFCsolicitante("AALL5010275C5");
		solicitud.setNumNominaContratante("0000000001029");
		solicitud.setFechaSolicitud(new Date());
		solicitud.setCvePromotor(1);
		solicitud.setFechaCaptura(new Date());
		solicitud.setCveAgente(1);
        solicitud.setCveTarifa(1);
        solicitud.setIdEstatusSolicitud(ConstantesGenerales.ESTATUS_SOLICITUD_PRECAPTURA);
        solicitud.setTipoSolicitudNormal(true);
        solicitud.setClaveUsuarioRegistro("masterOp1");
        solicitud.setFechaRegistro(new Date());
        solicitud.setCveEmpresa(6163);
        solicitud.setFechaProduccion(new Date());
		dao.insertarSolicitudDeArchivo(solicitud);
		
	}
	/**
	 * countConsultaGeneralSolicitudes
	 * consultaGeneralSolicitudes
	 * 
	 */
	public void testSolicitudDao_consultarSolicitudes(){
		ISolicitudDao dao = (ISolicitudDao)getBean("solicitudDao");
		CriteriosConsultaSolicitudesDTO criterios = new CriteriosConsultaSolicitudesDTO();
		ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultados = new ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO>();
		resultados.setPaginaActual(1);
		resultados.setPrimerVez(true);
		resultados.setRegistrosPorPagina(100);
		
		dao.consultarSolicitudes(criterios,resultados );
		log.debug(resultados);
	}
	/**
	 * actualizarSolicitudCompleto
	 */
	public void testSolicitudDao_actualizarSolicitud(){
		ISolicitudDao dao = (ISolicitudDao)getBean("solicitudDao");
		Solicitud solicitud = dao.obtenerDetalleSolicitudPorFolio(2255510, "FSP");
		
		solicitud.setFechaCaptura(new Date());
		solicitud.setNumNominaContratante(solicitud.getContratante().getNumNominaContratante());
		solicitud.setRFCsolicitante(solicitud.getSolicitante().getRFCsolicitante());
		dao.actualizarSolicitud(solicitud);
	}
}
