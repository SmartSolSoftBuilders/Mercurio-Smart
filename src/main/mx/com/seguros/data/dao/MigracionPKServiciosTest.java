/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.Calendar;
import java.util.Date;

import mx.com.seguros.business.comisiones.CalculoComisionesBusiness;
import mx.com.seguros.business.comisiones.CalculoDescuentoComisionesBusiness;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.reporte.ReporteBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.test.BaseServiceTest;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.web.poliza.RegistroPolizaCommand;
import mx.com.seguros.web.solicitud.DatosSolicitudCommand;

import org.apache.log4j.Logger;

/**
 * Clase de pruebas unitarias para las modificaciones de los servicios de negocio afectados
 * por la migración de la llave primaria de la tabla de Solicitud
 * @author Emigdio Hernández
 *
 */
public class MigracionPKServiciosTest extends BaseServiceTest {

private static final Logger log  = Logger.getLogger(MigracionPKServiciosTest.class);
	
	@Override
    protected void setUp() throws Exception{
		super.setUp();
		
		
	}
	/**
	 * Pruebas unitarias del Servicio de cálculo de comisiones
	 */
	public void testCalculoComisionesBusiness_calcularComisionesAgentes(){
		CalculoComisionesBusiness servicio = (CalculoComisionesBusiness)getBean("calculoComisionesBusiness");
		
		ejecutarQuery("delete  from ProduccionQuincenaPuntosAgente where anoQuincenaComision = 2011  and numQuincenaComision = 2;");		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		servicio.calcularComisionesAgentes(cal.getTime(), new Date(), 2);
		
	}
	/**
	 * Pruebas del servicio de CalculoDescuentoComisiones
	 */
	public void testCalculoDescuentoComisionesBusiness_calcularDescuentosComisionesAgentes(){
		CalculoDescuentoComisionesBusiness service = (CalculoDescuentoComisionesBusiness)getBean("calculoDescuentoComisionesBusiness");
		service.calcularDescuentosComisionesAgentes();
	}
	
	/**
	 * Pruebas para el servicio PolizaBusiness
	 */
	public void testPolizaBusiness_registrarPoliza_Alta(){
		IPolizaBusiness servicio = (IPolizaBusiness)getBean("polizaBusiness");
		ISolicitudDao solDao = (ISolicitudDao)getBean("solicitudDao");
		
		ejecutarQuery("delete from PolizaIndividual where numPoliza = 10215");
		
		RegistroPolizaCommand  datosPoliza= new RegistroPolizaCommand();
		PolizaIndividual poliza = new PolizaIndividual();
		datosPoliza.setModificacion(false);
		datosPoliza.setPolizaIndividual(poliza);
		
		poliza.setNumPoliza(10215);
		poliza.setNumConsignatario(13516);
		poliza.setFechaInicioVigencia(FormatUtil.stringToDate("30/11/2010"));
		poliza.setFechaFinVigencia(FormatUtil.stringToDate("30/11/2056"));
		poliza.setSumaAseguradaIndividual(138512.00);
		poliza.setFechaExpedicion(FormatUtil.stringToDate("30/11/2010"));
		poliza.setFolioSolicitud(87199);
		poliza.setTipoSeguro("99");
		poliza.setAgrupacionCIS(93004895);
		poliza.setIdEstatusPolizaSeguimiento(1);
		poliza.setIdEstatusPagosPoliza(1);
		poliza.setTipoMovimientoPoliza("A");
		poliza.setSumaGastosFunerarios(0.0);
		poliza.setSumaSEVI(0.0);
		poliza.setPlazoSeguro(36);
		poliza.setFormatoSolicitud("FSP");
		
		poliza.setSolicitud((Solicitud)solDao.obtenerDetalleSolicitudPorFolio(87199, "FSP"));
		
		servicio.registrarPoliza(datosPoliza);
	}
	public void testPolizaBusiness_registrarPoliza_Baja(){
		IPolizaBusiness servicio = (IPolizaBusiness)getBean("polizaBusiness");
		ISolicitudDao solDao = (ISolicitudDao)getBean("solicitudDao");
		
		ejecutarQuery("update PolizaIndividual set tipoMovimientoPoliza = 'A' where numPoliza = 90029446");
		
		RegistroPolizaCommand  datosPoliza= new RegistroPolizaCommand();
		PolizaIndividual poliza = new PolizaIndividual();
		datosPoliza.setModificacion(false);
		datosPoliza.setPolizaIndividual(poliza);
		
		poliza.setNumPoliza(90029446);
		poliza.setNumConsignatario(52000);
		poliza.setFechaInicioVigencia(FormatUtil.stringToDate("30/11/2007"));
		poliza.setFechaFinVigencia(FormatUtil.stringToDate("30/11/2056"));
		poliza.setSumaAseguradaIndividual(138512.00);
		poliza.setFechaExpedicion(FormatUtil.stringToDate("22/10/207"));
		poliza.setFolioSolicitud(1322);
		poliza.setTipoSeguro("1");
		poliza.setAgrupacionCIS(90032361);
		poliza.setIdEstatusPolizaSeguimiento(5);
		poliza.setIdEstatusPagosPoliza(6);
		poliza.setFechaCancelacion(FormatUtil.stringToDate("03/04/2008"));
		poliza.setTipoMovimientoPoliza("B");
		poliza.setSumaGastosFunerarios(0.0);
		poliza.setSumaSEVI(0.0);
		poliza.setPlazoSeguro(36);
		poliza.setFormatoSolicitud("FSP");
		
		poliza.setSolicitud((Solicitud)solDao.obtenerDetalleSolicitudPorFolio(1322, "FSP"));
		
		servicio.registrarPoliza(datosPoliza);
	}
	public void testPolizaBusiness_registrarPoliza_Cambio(){
		IPolizaBusiness servicio = (IPolizaBusiness)getBean("polizaBusiness");
		ISolicitudDao solDao = (ISolicitudDao)getBean("solicitudDao");
		
		ejecutarQuery("delete from PolizaIndividual where numPoliza = 9109149");
		
		RegistroPolizaCommand  datosPoliza= new RegistroPolizaCommand();
		PolizaIndividual poliza = new PolizaIndividual();
		datosPoliza.setModificacion(false);
		datosPoliza.setPolizaIndividual(poliza);
		
		poliza.setNumPoliza(9109149);
		poliza.setNumConsignatario(10202);
		poliza.setFechaInicioVigencia(FormatUtil.stringToDate("15/11/2009"));
		poliza.setFechaFinVigencia(FormatUtil.stringToDate("15/11/2060"));
		poliza.setSumaAseguradaIndividual(210108.00);
		poliza.setFechaExpedicion(FormatUtil.stringToDate("01/10/2009"));
		poliza.setFolioSolicitud(147612);
		poliza.setTipoSeguro("4");
		poliza.setAgrupacionCIS(93115276);
		poliza.setIdEstatusPolizaSeguimiento(1);
		poliza.setIdEstatusPagosPoliza(1);
		poliza.setFechaCancelacion(FormatUtil.stringToDate("03/04/2008"));
		poliza.setTipoMovimientoPoliza("C");
		poliza.setSumaGastosFunerarios(0.0);
		poliza.setSumaSEVI(0.0);
		poliza.setPlazoSeguro(36);
		poliza.setFormatoSolicitud("FSP");
		
		poliza.setSolicitud((Solicitud)solDao.obtenerDetalleSolicitudPorFolio(147612, "FSP"));
		
		servicio.registrarPoliza(datosPoliza);
	}
	public void testPolizaBusiness_generarReportes(){
		
		IPolizaBusiness servicio = (IPolizaBusiness)getBean("polizaBusiness");
		PolizaIndividual poliza = new PolizaIndividual();
		RegistroPolizaCommand  datosPoliza= new RegistroPolizaCommand();
		datosPoliza.setPolizaIndividual(poliza);
		poliza.setNumPoliza(32037681);
		poliza.setNumConsignatario(11112);
		poliza.getSolicitud().setFolioSolicitud(131998);
		poliza.getSolicitud().setFormatoSolicitud("FSP");
		poliza.getSolicitud().getCertificadoindividual().setNumCertificado(9864);
		poliza.getSolicitud().getCertificadoindividual().setIdPlaza(3);
		
		servicio.generarReportes(datosPoliza);
	}
	public void testPolizaBusiness_obtenerPolizasPorFolioSolicitudNoCancelada(){
		
		IPolizaBusiness servicio = (IPolizaBusiness)getBean("polizaBusiness");
		log.debug(servicio.obtenerPolizasPorFolioSolicitudNoCancelada(87199, "FSP"));
	}
	/**
	 * Pruebas para el servicio ReporteBusiness
	 */
	public void testReporteBusiness_generarReporteCertificadoIndividual(){
		ReporteBusiness servicio = (ReporteBusiness)getBean("reporteBusiness");
		
		servicio.generarReporteCertificadoIndividual(87199, "FSP", 10215, 6955, "3");
	}
	/**
	 * Pruebas para el servicio de SolicitudBusiness
	 */
	public void testSolicitudBusiness_registrarSolicitud(){
		
		ejecutarQuery("delete from Beneficiario where folioSolicitud = 1;");
		ejecutarQuery("delete from CertificadoIndividual where folioSolicitud = 1 and idPlaza = 3;");
		ejecutarQuery("delete from PolizaIndividual where folioSolicitud = 1;");
		ejecutarQuery("delete from Solicitud where folioSolicitud = 1;");
		
		ISolicitudBusiness service = (ISolicitudBusiness)getBean("solicitudBusiness");
		DatosSolicitudCommand datosSolicitud = new DatosSolicitudCommand();
		Solicitud sol = new Solicitud();
		datosSolicitud.setSolicitud(sol);
		
		sol.setFolioSolicitud(1);
		sol.setFormatoSolicitud("FSP");
		
		sol.setFechaSolicitud(new Date());
		sol.setTipoSolicitudNormal(true);
		sol.setFechaCaptura(new Date());
		sol.getAgente().setCveAgente(1);
		sol.setCvePromotor(1);
		sol.setCveTarifa(1);
		
		sol.getTarifa().setCveTarifa(1);
		sol.getContratante().setNumNominaContratante("TETG761219RKA");
		sol.getContratante().setApMaternoContratante("GARCIA");
		sol.getContratante().setApPaternoContratante("ELIGIO");
		sol.getContratante().setNombre1Contratante("JOSE");
		sol.getContratante().setTipoMovimiento("C");
		sol.getSolicitante().setRFCsolicitante("TETG761219RKA");
		sol.getSolicitante().setEstadoCivilSolicitante("1");
		sol.getSolicitante().setApMaternoSolicitante("GARCIA");
		sol.getSolicitante().setApPaternoSolicitante("ELIGIO");
		sol.getSolicitante().setNombre1Solicitante("JOSE");
		sol.getSolicitante().setCalle("PASEO DE LAS HIGUERAS");
		sol.getSolicitante().setCiudadPoblacion("COYOACAN");
		sol.getSolicitante().setCodPostal(04250);
		sol.getSolicitante().setColonia("PASEOS DE TASQUEÑA");
		sol.getSolicitante().setDelegacionMpio("COYOACAN");
		sol.getSolicitante().setEdificio(null);
		sol.getSolicitante().setEmail("dd@ee.com");
		sol.getSolicitante().setEntidadFederativa("DISTRITO FEDERAL");
		sol.getSolicitante().setEsFumadorAsegurado(false);
		sol.getSolicitante().setEstadoCivilSolicitante("1");
		sol.getSolicitante().setFechaNacimientoSolicitante(new Date());
		sol.getSolicitante().setIngresoMensualSolicitante("2300.0");
		sol.getSolicitante().setNumExtInt("2");
		sol.getSolicitante().setPuestoSolicitante("JEF");
		sol.getSolicitante().setSexoSolicitanteMasculino(true);
		sol.setCveEmpresa(1922);
		sol.getEmpresa().setCveEmpresa(1922);
		sol.setIdEstatusSolicitud(1);
		Beneficiario benef = new Beneficiario();
		benef.setFolioSolicitud(1);
		benef.setFormatoSolicitud("FSP");
		benef.setApPaternoBeneficiario("TABACO");
		benef.setApMaternoBeneficiario("MEDINA");
		benef.setNombre1Beneficiario("TERESA");
		benef.setNombre2Beneficiario("");
		benef.setParentesco("PADRE");
		benef.setPorcentajeAsignado(100.0);
		benef.setFechaNacimientoBeneficiario(new Date());
		sol.setBeneficiario(new Beneficiario[1]);
		sol.getBeneficiario()[0] = benef;
				
		
		service.registrarSolicitud(datosSolicitud);
	}
	public void testSolicitudBusiness_obtenSolicitudPorFolioSolicitud(){
		ISolicitudBusiness service = (ISolicitudBusiness)getBean("solicitudBusiness");
		log.debug(service.obtenSolicitudPorFolioSolicitud(118512, "FSP"));
	}
	public void testSolicitudBusiness_obtenerDetalleSolicitudPorFolio(){
		ISolicitudBusiness service = (ISolicitudBusiness)getBean("solicitudBusiness");
		log.debug(service.obtenerDetalleSolicitudPorFolio(118512, "FSP"));
	}
	public void testSolicitudBusiness_actualizarSolicitud(){
		ISolicitudBusiness service = (ISolicitudBusiness)getBean("solicitudBusiness");
		DatosSolicitudCommand datosSolicitud = new DatosSolicitudCommand();
		Solicitud sol = new Solicitud();
		datosSolicitud.setSolicitud(sol);
		
		
		sol.setFolioSolicitud(118512);
		sol.setFormatoSolicitud("FSP");
		
		sol.setFechaSolicitud(new Date());
		sol.setTipoSolicitudNormal(true);
		sol.setFechaCaptura(new Date());
		sol.getAgente().setCveAgente(1);
		sol.setCvePromotor(1);
		sol.setCveTarifa(1);
		
		sol.getTarifa().setCveTarifa(1);
		sol.getContratante().setNumNominaContratante("TETG761219RKA");
		sol.getContratante().setApMaternoContratante("GARCIA");
		sol.getContratante().setApPaternoContratante("ELIGIO");
		sol.getContratante().setNombre1Contratante("JOSE");
		sol.getContratante().setTipoMovimiento("C");
		sol.getSolicitante().setRFCsolicitante("TETG761219RKA");
		sol.getSolicitante().setEstadoCivilSolicitante("1");
		sol.getSolicitante().setApMaternoSolicitante("GARCIA");
		sol.getSolicitante().setApPaternoSolicitante("ELIGIO");
		sol.getSolicitante().setNombre1Solicitante("JOSE");
		sol.getSolicitante().setCalle("PASEO DE LAS HIGUERAS");
		sol.getSolicitante().setCiudadPoblacion("COYOACAN");
		sol.getSolicitante().setCodPostal(04250);
		sol.getSolicitante().setColonia("PASEOS DE TASQUEÑA");
		sol.getSolicitante().setDelegacionMpio("COYOACAN");
		sol.getSolicitante().setEdificio(null);
		sol.getSolicitante().setEmail("dd@ee.com");
		sol.getSolicitante().setEntidadFederativa("DISTRITO FEDERAL");
		sol.getSolicitante().setEsFumadorAsegurado(false);
		sol.getSolicitante().setEstadoCivilSolicitante("1");
		sol.getSolicitante().setFechaNacimientoSolicitante(new Date());
		sol.getSolicitante().setIngresoMensualSolicitante("2300.0");
		sol.getSolicitante().setNumExtInt("2");
		sol.getSolicitante().setPuestoSolicitante("JEF");
		sol.getSolicitante().setSexoSolicitanteMasculino(true);
		sol.setCveEmpresa(1922);
		sol.getEmpresa().setCveEmpresa(1922);
		sol.setIdEstatusSolicitud(1);
		Beneficiario benef = new Beneficiario();
		benef.setFolioSolicitud(1);
		benef.setFormatoSolicitud("FSP");
		benef.setApPaternoBeneficiario("TABACO");
		benef.setApMaternoBeneficiario("MEDINA");
		benef.setNombre1Beneficiario("TERESA");
		benef.setNombre2Beneficiario("");
		benef.setParentesco("PADRE");
		benef.setPorcentajeAsignado(100.0);
		benef.setFechaNacimientoBeneficiario(new Date());
		sol.setBeneficiario(new Beneficiario[1]);
		sol.getBeneficiario()[0] = benef;
		
		
		service.actualizarSolicitud(datosSolicitud);
	}
	public void testSolicitudBusiness_consultarCertificadoPorFolio(){
		ISolicitudBusiness service = (ISolicitudBusiness)getBean("solicitudBusiness");
		log.debug(service.consultarCertificadoPorFolio(118512,"FSP"));
	}
	
}
