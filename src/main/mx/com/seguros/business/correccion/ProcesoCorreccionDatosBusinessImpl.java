/**
 * 
 */
package mx.com.seguros.business.correccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.business.solicitud.SolicitudBusiness;
import mx.com.seguros.data.dao.IAseguradoDao;
import mx.com.seguros.data.dao.IBeneficiarioDao;
import mx.com.seguros.data.dao.IContratanteDao;
import mx.com.seguros.data.dao.IDescuetosAplicadosDao;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.data.dao.ISolicitanteDao;
import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.data.dao.ITicketCorreccionDao;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.ComentarioTicket;
import mx.com.seguros.model.Contratante;
import mx.com.seguros.model.EstadoTicketCorreccion;
import mx.com.seguros.model.HistoricoTarifa;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitante;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TicketCorreccion;
import mx.com.seguros.utils.TicketCorreccionUtil;
import mx.com.seguros.web.correccion.RegistrarTicketCorreccionCommand;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementación del servicio de negocio para el proceso de corrección de datos
 * @author Emigdio Hernandez
 *
 */
public class ProcesoCorreccionDatosBusinessImpl implements IProcesoCorreccionDatosBusiness {
	
	private ITicketCorreccionDao ticketCorreccionDao = null;
	private ISolicitudBusiness solicitudBusiness = null;
    private IPolizaBusiness polizaBusiness = null;
    private IContratanteDao contratanteDao = null;
    private ISolicitanteDao solicitanteDao = null;
    private ISolicitudDao solicitudDao = null;
    private IBeneficiarioDao beneficiarioDao = null;
    private IAseguradoDao aseguradoDao = null;
    private IPolizaDao polizaDao = null;
    private IDescuetosAplicadosDao descuentosAplicadosDao = null;

    private static final Logger log;

    static {
        log = LoggerFactory.getLogger(ProcesoCorreccionDatosBusinessImpl.class);
    }
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.correccion.IPocesoCorreccionDatosBusiness#consultarTicketsCorreccion(java.lang.Integer, java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<TicketCorreccion> consultarTicketsCorreccion(
			Integer idEstadoCorreccion, Date fechaInicial, Date fechaFinal,
			String usuario) {
		return ticketCorreccionDao.consultarTicketsCorreccion(idEstadoCorreccion, fechaInicial, fechaFinal, usuario);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.correccion.IPocesoCorreccionDatosBusiness#consultarDetalleTicketCorreccion(java.lang.Integer)
	 */
	@Override
	public TicketCorreccion consultarDetalleTicketCorreccion(
			Integer idTicketCorreccion) {
		return ticketCorreccionDao.consultarDetalleTicketCorreccion(idTicketCorreccion);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.correccion.IPocesoCorreccionDatosBusiness#guardarTicketCorreccion(mx.com.seguros.model.TicketCorreccion)
	 */
	@Override
	public Integer guardarTicketCorreccion(TicketCorreccion ticket) {
		return ticketCorreccionDao.guardarTicketCorreccion(ticket);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.correccion.IPocesoCorreccionDatosBusiness#actualizarTicketCorreccion(mx.com.seguros.model.TicketCorreccion)
	 */
	@Override
	public void actualizarTicketCorreccion(TicketCorreccion ticket) {
		
		
		
		ticketCorreccionDao.actualizarTicketCorreccion(ticket);		
	}
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.correccion.IPocesoCorreccionDatosBusiness#agregarComentarioTicket(mx.com.seguros.model.ComentarioTicket)
	 */
	@Override
	public Integer agregarComentarioTicket(ComentarioTicket comentario) {
		return ticketCorreccionDao.agregarComentarioTicket(comentario);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.correccion.IPocesoCorreccionDatosBusiness#actualizarEstadoTicketCorreccion(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void actualizarEstadoTicketCorreccion(Integer idTicketCorreccion,
			Integer idEstadoTicketCorreccion) {
		ticketCorreccionDao.actualizarEstadoTicketCorreccion(idTicketCorreccion, idEstadoTicketCorreccion);
		
	}
	/**
	 * @param ticketCorreccionDao the ticketCorreccionDao to set
	 */
	public void setTicketCorreccionDao(ITicketCorreccionDao ticketCorreccionDao) {
		this.ticketCorreccionDao = ticketCorreccionDao;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.correccion.IProcesoCorreccionDatosBusiness#consultarEstadosTicketCorreccion()
	 */
	@Override
	public List<EstadoTicketCorreccion> consultarEstadosTicketCorreccion() {
		return ticketCorreccionDao.consultarEstadosTicketCorreccion();
	}
	/**
	 * @param solicitudBusiness the solicitudBusiness to set
	 */
	public void setSolicitudBusiness(ISolicitudBusiness solicitudBusiness) {
		this.solicitudBusiness = solicitudBusiness;
	}
	/**
	 * @param polizaBusiness the polizaBusiness to set
	 */
	public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
		this.polizaBusiness = polizaBusiness;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.correccion.IProcesoCorreccionDatosBusiness#aplicarCambiosTicketCorreccion(mx.com.seguros.web.correccion.RegistrarTicketCorreccionCommand)
	 */
	@Override
	public void aplicarCambiosTicketCorreccion(
			RegistrarTicketCorreccionCommand datosTicket) {
		
		//Aplicar cambios solicitud
		Solicitud solicitudBD = solicitudBusiness.obtenerDetalleSolicitudPorFolio(datosTicket.getDatosOriginales().getSolicitud().getFolioSolicitud()
				,datosTicket.getDatosOriginales().getSolicitud().getFormatoSolicitud());
		if(solicitudBD != null){
			
			solicitudBD.setBeneficiario(solicitudBusiness.consultarBeneficiarios(solicitudBD.getFolioSolicitud(), 
					solicitudBD.getFormatoSolicitud()));
			
			datosTicket.getDatosNuevos().getSolicitud().getContratante().setNumNominaContratante(
					datosTicket.getDatosNuevos().getSolicitud().getNumNominaContratante()
					);
			datosTicket.getDatosNuevos().getSolicitud().getSolicitante().setRFCsolicitante(
					datosTicket.getDatosNuevos().getSolicitud().getRFCsolicitante()
					);
						
			//Verificar que datos cambian
			aplicarCambiosSolicitud(solicitudBD,datosTicket);
			aplicarCambiosContratante(solicitudBD.getContratante(),datosTicket);
			aplicarCambiosSolicitante(solicitudBD.getSolicitante(),datosTicket);
			aplicarCambiosBeneficiarios(solicitudBD,datosTicket);
			
			PolizaIndividual polizaBD = polizaBusiness.obtenerDetallePolizaPorNumero(datosTicket.getDatosOriginales().getNumPoliza(), 
					datosTicket.getDatosOriginales().getNumConsignatario());
	        
	        List <BeneficioAdicional> beneficios = polizaBusiness.consultarCatalogoBeneficiosAdicionales();
	        List <BeneficioAdicionalPoliza> beneficiosPoliza = new ArrayList<BeneficioAdicionalPoliza>();
	        
	        BeneficioAdicionalPoliza beneficioEnPoliza = null;
	        for(BeneficioAdicional beneficio:beneficios){
	        	beneficioEnPoliza = new BeneficioAdicionalPoliza();
	        	beneficioEnPoliza.setDescripcionBeneficio(beneficio.getDescripcionBeneficioAdicional());
	        	beneficioEnPoliza.setIdBeneficioAdicional(beneficio.getIdBeneficioAdicional());
	        	asignarMontosDeBeneficio(beneficioEnPoliza,polizaBD.getBeneficiosAdicionales());
	        	beneficiosPoliza.add(beneficioEnPoliza);
	     	   
	        }
	        polizaBD.setBeneficiosAdicionales(beneficiosPoliza);
			aplicarCambiosPoliza(polizaBD,datosTicket);
			actualizarSolicitud(solicitudBD,datosTicket);
			polizaBD.setFolioSolicitud(solicitudBD.getFolioSolicitud());
	        polizaBD.setFormatoSolicitud(solicitudBD.getFormatoSolicitud());
	        polizaBD.setSolicitud(solicitudBD);
			actualizarPoliza(polizaBD);
			actualizarAsegurado(polizaBD);
			
			
			//Verificar los cambios en llaves primarias de solicitud y póliza
			aplicarCambiosLlavesPrimarias(polizaBD,datosTicket);
			
			
			
		}
		
		
		
	}
	
	/**
	 * Verifica y aplica los cambios únicamente en llaves primarias de solicitud y póliza
	 * @param polizaBD Datos actuales en BD
	 * @param datosTicket Contiene los datos originales y los datos nuevos
	 */
	private void aplicarCambiosLlavesPrimarias(PolizaIndividual polizaBD,
			RegistrarTicketCorreccionCommand datosTicket) {
		Solicitud solNueva = datosTicket.getDatosNuevos().getSolicitud();
		Solicitud solOriginal = datosTicket.getDatosOriginales().getSolicitud();
		//Existe cambio en Folio y formato ?
		
		if((solNueva.getFolioSolicitud() != null && 
				solNueva.getFolioSolicitud() > 0 &&
				!solOriginal.getFolioSolicitud().equals(solNueva.getFolioSolicitud()))
				||
				(StringUtils.isNotBlank(solNueva.getFormatoSolicitud()) && 
				!solOriginal.getFormatoSolicitud().equals(solNueva.getFormatoSolicitud()))
				){
			//Cambio en folio/formato
			solicitudDao.actualizarPKSolicitud(solOriginal, solNueva);
		}
		
		
		
		//Existe cambio en numPoliza numConsignatario ?
		if((datosTicket.getDatosNuevos().getNumPoliza() != null && 
				datosTicket.getDatosNuevos().getNumPoliza() > 0 &&
				!datosTicket.getDatosNuevos().getNumPoliza().equals(datosTicket.getDatosOriginales().getNumPoliza()))
				||
				(datosTicket.getDatosNuevos().getNumConsignatario() != null && 
				datosTicket.getDatosNuevos().getNumConsignatario() > 0 &&
				!datosTicket.getDatosNuevos().getNumConsignatario().equals(datosTicket.getDatosOriginales().getNumConsignatario()))
				){
			//Cambio en numPoliza/numConsignatario
			polizaDao.actualizarPkPolizaIndividual(datosTicket.getDatosOriginales(), datosTicket.getDatosNuevos());
			
		}
		
		
		
	}
	/**
	 * Actualiza los datos del asegurado en base a los datos de la póliza y al solicitud
	 * @param polizaBD Datos de origen
	 */
	private void actualizarAsegurado(PolizaIndividual polizaBD) {
		//también se verifica el caso donde no exista el asegurado
		
		
		if(polizaBD.getAsegurado() != null && polizaBD.getAsegurado().getIdAsegurado() != null && polizaBD.getAsegurado().getIdAsegurado()>0 ){
			Integer idAsegurado = polizaBD.getAsegurado().getIdAsegurado();
			polizaBD.setAsegurado( aseguradoDao.crearAsegurado(polizaBD.getSolicitud().getSolicitante(), 
					polizaBD.getSolicitud().getContratante(), polizaBD));
			polizaBD.getAsegurado().setIdAsegurado(idAsegurado);
			aseguradoDao.actualizarAsegurado(polizaBD.getAsegurado());
		}else{
			
			aseguradoDao.insertarAsegurado(polizaBD.getSolicitud().getSolicitante(), 
				polizaBD.getSolicitud().getContratante(), polizaBD);
		}
		
		
		
	}
	/**
	 * Aplica los cambios del objeto de póliza a la BD
	 * @param polizaBD
	 */
	private void actualizarPoliza(PolizaIndividual polizaBD) {
		
		
		List<BeneficioAdicionalPoliza> listaBeneficios = new ArrayList<BeneficioAdicionalPoliza>();
        for(BeneficioAdicionalPoliza benef:polizaBD.getBeneficiosAdicionales()){
        	if(benef.getSumaBeneficio() != null && benef.getSumaBeneficio()>0 &&
        			benef.getMontoCobertura() != null && benef.getMontoCobertura() > 0){
        		benef.setNumPoliza(polizaBD.getNumPoliza());
        		benef.setNumConsignatario(polizaBD.getNumConsignatario());
        		listaBeneficios.add(benef);
        	}
        }
        polizaBD.setBeneficiosAdicionales(listaBeneficios);
        
        polizaBusiness.actualizarPolizaIndividual(polizaBD);
       
       
        polizaBusiness.guardarBeneficiosAdicionales(polizaBD);
		
	}
	/**
	 * Aplica los cambios realizados al objeto de Póliza y beneficios adicionaless
	 * @param polizaBD
	 * @param datosTicket
	 */
	private void aplicarCambiosPoliza(PolizaIndividual polizaBD,
			RegistrarTicketCorreccionCommand datosTicket) {
		//verificar campos que cambian
		//Verificar que datos cambian
		PolizaIndividual original = datosTicket.getDatosOriginales();
		PolizaIndividual nuevo = datosTicket.getDatosNuevos();
		
		String[] camposAplicables = new String[]{
				"agrupacionCIS",
				"fechaExpedicion",
				"fechaInicioVigencia",
				"fechaFinVigencia",
				"sumaBAF",
				"sumaAseguradaIndividual",
				"sumaGastosFunerarios",
				"sumaSEVI",
				"tipoSeguro",
				"idEstatusPolizaSeguimiento",
				"idEstatusPagosPoliza",
				"importeAhorroAdicionalMensual"
			};
		
		for(String campo:camposAplicables){
			TicketCorreccionUtil.evaluarCambioEnCampo(campo, original,
					nuevo, polizaBD);
		}
		
		//Beneficios adicionales
		for(int i=0;i<original.getBeneficiosAdicionales().size();i++){
			TicketCorreccionUtil.evaluarCambioEnCampo("sumaBeneficio", 
					original.getBeneficiosAdicionales().get(i),
					nuevo.getBeneficiosAdicionales().get(i), polizaBD.getBeneficiosAdicionales().get(i));
			TicketCorreccionUtil.evaluarCambioEnCampo("montoCobertura", 
					original.getBeneficiosAdicionales().get(i),
					nuevo.getBeneficiosAdicionales().get(i), polizaBD.getBeneficiosAdicionales().get(i));
		}
		
	}
	/**
	 * Asigna los montos de un beneficio adicional buscando el id de beneficioEnPoliza en la lista
	 * de beneficios adicionales para obtener sus montos.
	 * @param beneficioEnPoliza Beneficio para asignar sus montos
	 * @param beneficiosAdicionales Lista de beneficios adicionales de donde buscar
	 */
	private void asignarMontosDeBeneficio(
			BeneficioAdicionalPoliza beneficioEnPoliza,
			List<BeneficioAdicionalPoliza> beneficiosAdicionales) {
		if(beneficiosAdicionales != null){
			for(BeneficioAdicionalPoliza benefLista:beneficiosAdicionales){
				if(benefLista.getIdBeneficioAdicional().equals(beneficioEnPoliza.getIdBeneficioAdicional())){
					beneficioEnPoliza.setSumaBeneficio(benefLista.getSumaBeneficio());
					beneficioEnPoliza.setMontoCobertura(benefLista.getMontoCobertura());
				}
			}
		}
		
	}
	/**
	 * Aplica los cambios de la solicitud a la BD
	 * @param solicitudBD
	 * @param datosTicket 
	 */
	private void actualizarSolicitud(Solicitud solicitudBD, RegistrarTicketCorreccionCommand datosTicket) {
		int cveEstadoCivil = NumberUtils.toInt(solicitudBD.getSolicitante().getEstadoCivilSolicitante(),0);
		solicitudBD.getSolicitante().setEstadoCivilSolicitante(SolicitudBusiness.estadoCivil(cveEstadoCivil));


        if(contratanteDao.recuperarContratantePorNumNomina(solicitudBD.getNumNominaContratante()) == null){
            contratanteDao.insertarContratante(solicitudBD.getContratante());
        }else{
            contratanteDao.actualizarContratante(solicitudBD.getContratante());
        }

        
        if(solicitanteDao.recuperarSolicitantePorRFC(solicitudBD.getRFCsolicitante()) != null){
            solicitanteDao.actualizarSolicitante(solicitudBD.getSolicitante());
        }
        else{
            solicitanteDao.insertarSolicitanteDao(solicitudBD.getSolicitante());
        }
        
            
        solicitudDao.actualizarSolicitud(solicitudBD);
     
        
        beneficiarioDao.eliminarBeneficiariosSolicitud(solicitudBD.getFolioSolicitud(), 
        		solicitudBD.getFormatoSolicitud());
        
        for(Beneficiario benef:solicitudBD.getBeneficiario()){
        	if(benef != null && StringUtils.isNotBlank(benef.getApPaternoBeneficiario())
        			&& benef.getPorcentajeAsignado() != null && benef.getPorcentajeAsignado()>0){
        		benef.setCveBeneficiario(0);
        		benef.setFolioSolicitud(solicitudBD.getFolioSolicitud());
        		benef.setFormatoSolicitud(solicitudBD.getFormatoSolicitud());
        		beneficiarioDao.insertarBeneficiario(benef);
        	}
        }
        
        //revisar el cambio en cveTarifa
        if(TicketCorreccionUtil.evaluarCambioEnCampo("cveTarifa", datosTicket.getDatosOriginales().getSolicitud(),
						datosTicket.getDatosNuevos().getSolicitud(), solicitudBD)){
        	HistoricoTarifa historico = new HistoricoTarifa();
        	historico.setCveTarifa(datosTicket.getDatosOriginales().getSolicitud().getCveTarifa());
        	historico.setFechaFin(new Date());
        	historico.setUsuario(datosTicket.getTicket().getUsuarioAutoriza());
        	historico.setTarifaTotal(datosTicket.getDatosOriginales().getSolicitud().getTarifaTotal()!=null?
        			datosTicket.getDatosOriginales().getSolicitud().getTarifaTotal():0.0);
        	historico.setFolioSolicitud(solicitudBD.getFolioSolicitud());
        	historico.setFormatoSolicitud(solicitudBD.getFormatoSolicitud());
        	solicitudBusiness.insertarHistoricoTarifa(historico);
        }
        
        
	}
	/**
	 * Verifica y aplica los cambios realizados a beneficiarios de una solicitud
	 * @param solicitudBD
	 * @param datosTicket
	 */
	private void aplicarCambiosBeneficiarios(Solicitud solicitudBD,
			RegistrarTicketCorreccionCommand datosTicket) {
		String[] camposAplicables = new String[]{
				"apPaternoBeneficiario",
				"apMaternoBeneficiario",
				"nombre1Beneficiario",
				"nombre2Beneficiario",
				"fechaNacimientoBeneficiario",
				"parentesco",
				"porcentajeAsignado",
			};
		
		
		for(int i=0;i<solicitudBD.getBeneficiario().length;i++){
			
			for(String campo:camposAplicables){
				TicketCorreccionUtil.evaluarCambioEnCampo(campo, datosTicket.getDatosOriginales().getSolicitud().getBeneficiario()[i],
						datosTicket.getDatosNuevos().getSolicitud().getBeneficiario()[i], solicitudBD.getBeneficiario()[i]);
			}
			
		}
		
		
	}
	/**
	 * Verifica y aplica los cambios en el objeto de solicitante
	 * @param contratante
	 * @param datosTicket
	 */
	private void aplicarCambiosSolicitante(Solicitante solicitanteBD,
			RegistrarTicketCorreccionCommand datosTicket) {
		//Verificar que datos cambian
		Solicitante original = datosTicket.getDatosOriginales().getSolicitud().getSolicitante();
		Solicitante nuevo = datosTicket.getDatosNuevos().getSolicitud().getSolicitante();
		
		String[] camposAplicables = new String[]{
				"RFCsolicitante",
				"apPaternoSolicitante",
				"apMaternoSolicitante",
				"nombre1Solicitante",
				"nombre2Solicitante",
				"fechaNacimientoSolicitante",
				"puestoSolicitante",
				"ingresoMensualSolicitante",
				"sexoSolicitanteMasculino",
				"estadoCivilSolicitante",
				"calle",
				"edificio",
				"numExtInt",
				"colonia",
				"delegacionMpio",
				"ciudadPoblacion",
				"entidadFederativa",
				"codPostal",
				"email",
				"lada",
				"telefono"
			};
		
		for(String campo:camposAplicables){
			TicketCorreccionUtil.evaluarCambioEnCampo(campo, original,
					nuevo, solicitanteBD);
		}
		
	}
	/**
	 * Verifica y aplica los cambios en el objeto de contratante
	 * @param contratante
	 * @param datosTicket
	 */
	private void aplicarCambiosContratante(Contratante contratanteBD,
			RegistrarTicketCorreccionCommand datosTicket) {
		//Verificar que datos cambian
		Contratante original = datosTicket.getDatosOriginales().getSolicitud().getContratante();
		Contratante nuevo = datosTicket.getDatosNuevos().getSolicitud().getContratante();
		
		String[] camposAplicables = new String[]{
				"numNominaContratante",
				"nombre1Contratante",
				"nombre2Contratante",
				"apPaternoContratante",
				"apMaternoContratante"
			};
		
		for(String campo:camposAplicables){
			TicketCorreccionUtil.evaluarCambioEnCampo(campo, original,
					nuevo, contratanteBD);
		}
		
	}
	/**
	 * Evalúa los posibles cambios en objeto solicitud y los aplica en BD
	 * @param solicitudBD
	 * @param datosTicket
	 */
	private void aplicarCambiosSolicitud(Solicitud solicitudBD,
			RegistrarTicketCorreccionCommand datosTicket) {
		//Verificar que datos cambian
		Solicitud solicitudOriginal = datosTicket.getDatosOriginales().getSolicitud();
		Solicitud solicitudNueva = datosTicket.getDatosNuevos().getSolicitud();
		
		String[] camposAplicables = new String[]{
				"cveAgente",
				"tipoSolicitudNormal",
				"cveTarifa",
				"cvePromotor",
				"fechaSolicitud",
				"fechaProduccion",
				"cveEmpresa",
				"numNominaContratante",
				"RFCsolicitante",
				};
		
		for(String campo:camposAplicables){
			TicketCorreccionUtil.evaluarCambioEnCampo(campo, solicitudOriginal,
					solicitudNueva, solicitudBD);
		}
		
	}
	/**
	 * @param contratanteDao the contratanteDao to set
	 */
	public void setContratanteDao(IContratanteDao contratanteDao) {
		this.contratanteDao = contratanteDao;
	}
	/**
	 * @param solicitanteDao the solicitanteDao to set
	 */
	public void setSolicitanteDao(ISolicitanteDao solicitanteDao) {
		this.solicitanteDao = solicitanteDao;
	}
	/**
	 * @param solicitudDao the solicitudDao to set
	 */
	public void setSolicitudDao(ISolicitudDao solicitudDao) {
		this.solicitudDao = solicitudDao;
	}
	/**
	 * @param beneficiarioDao the beneficiarioDao to set
	 */
	public void setBeneficiarioDao(IBeneficiarioDao beneficiarioDao) {
		this.beneficiarioDao = beneficiarioDao;
	}
	/**
	 * @param aseguradoDao the aseguradoDao to set
	 */
	public void setAseguradoDao(IAseguradoDao aseguradoDao) {
		this.aseguradoDao = aseguradoDao;
	}
	/**
	 * @param polizaDao the polizaDao to set
	 */
	public void setPolizaDao(IPolizaDao polizaDao) {
		this.polizaDao = polizaDao;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.correccion.IProcesoCorreccionDatosBusiness#polizaCuentaConPagosAplicados(mx.com.seguros.model.PolizaIndividual)
	 */
	@Override
	public boolean polizaCuentaConPagosAplicados(PolizaIndividual poliza) {
		
		Integer ultQna = 
		descuentosAplicadosDao.obtenerUltimaQuincenaPagadaPoliza(poliza);
		return ultQna != null && ultQna > 0;
	}
	/**
	 * @param descuentosAplicadosDao the descuentosAplicadosDao to set
	 */
	public void setDescuentosAplicadosDao(
			IDescuetosAplicadosDao descuentosAplicadosDao) {
		this.descuentosAplicadosDao = descuentosAplicadosDao;
	}

}
