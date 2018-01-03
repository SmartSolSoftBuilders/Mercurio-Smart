package mx.com.seguros.web.consulta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.consulta.GeneraArchivoConsultaGeneralExcel;
import mx.com.seguros.business.consulta.GeneraArchivoConsultaGeneralExcelImpl;
import mx.com.seguros.business.consulta.IConsultaGeneralSolicitudesBusiness;

import mx.com.seguros.business.movimientosdependencia.ArchivoTXT;
import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.dto.ResultadoCarteraSolicitudDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.utils.ResultadoPaginadoDTO;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;
import mx.com.seguros.web.seguridad.util.Usuario;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ConsultaGeneralCarteraController extends MultiActionController {

	private Integer registrosPorPagina;
	private IConsultaGeneralSolicitudesBusiness consultaGeneralSolicitudesBusiness;
	private GeneraArchivoConsultaGeneralExcel generaArchivoConsultaCarteraExcel;
	private SeguridadUtil seguridadUtil;

	public void consultaGeneralCarteraController(HttpServletRequest request, HttpServletResponse response) {

		// ModelAndView mav = new ModelAndView (getFormView());
		// mav.addObject(getCommandName(), command);

		ResultadoPaginadoDTO<ResultadoCarteraSolicitudDTO> resultado = new ResultadoPaginadoDTO<ResultadoCarteraSolicitudDTO>();
		resultado.setPaginaActual(1);
		resultado.setRegistrosPorPagina(getRegistrosPorPagina());
		if (StringUtils.isNotBlank(request.getParameter("paginaActual"))) {
			resultado.setPrimerVez(false);
			resultado.setPaginaActual(NumberUtils.toInt(request.getParameter("paginaActual"), 1));
			resultado.setTotalResultados(NumberUtils.toInt(request.getParameter("totalResultados"), 1));
			resultado.setTotalPaginas(NumberUtils.toInt(request.getParameter("totalPaginas"), 1));
			resultado.setTotalPrima(NumberUtils.toDouble(request.getParameter("totalPrima"), 0));
		}
		/*
		 * CriteriosConsultaSolicitudesDTO criterios =
		 * (CriteriosConsultaSolicitudesDTO)command; int indiceOrden =
		 * NumberUtils.toInt(request.getParameter("indiceOrden"),-1);
		 * if(indiceOrden >=0 ){
		 * if(StringUtils.isBlank(criterios.getOrden()[indiceOrden])){
		 * criterios.getOrden()[indiceOrden] = "asc"; }else
		 * if(criterios.getOrden()[indiceOrden].equals("asc")){
		 * criterios.getOrden()[indiceOrden] = "desc"; }else{
		 * criterios.getOrden()[indiceOrden] = ""; } }
		 */
		/*
		 * if(StringUtils.isNotBlank(criterios.getStrFechaSolicitudInicial())){
		 * criterios.setFechaSolicitudInicial(DateUtils.parseDate(criterios.
		 * getStrFechaSolicitudInicial(), new String[]{"dd/MM/yyyy"})); }
		 * if(StringUtils.isNotBlank(criterios.getStrFechaSolicitudFinal())){
		 * criterios.setFechaSolicitudFinal(DateUtils.parseDate(criterios.
		 * getStrFechaSolicitudFinal(), new String[]{"dd/MM/yyyy"})); }
		 */

		// Verificar si se desea exportar en Excel La consulta
		// consultaGeneralSolicitudesBusiness.consultarSolicitudes(criterios,
		// resultado);

		consultaGeneralSolicitudesBusiness.consultarCarteraSolicitudes(resultado);
		System.out.println("idPlaza: " + seguridadUtil.getEmpleado().getIdPlaza());
		System.out.println("UserName: " + seguridadUtil.getUsuario().getUsername());

		// System.out.println(seguridadUtil);
		// if(request.getParameter("formato") != null &&
		// "xlsx".equals(request.getParameter("formato"))){

		try {
			resultado.setPaginaActual(1);
			// resultado.setRegistrosPorPagina(65525);
			File archivo2 = this.generaArchivoConsultaCarteraExcel.generaArchivoCarteraExcel(resultado);
			InputStream inputstream = new FileInputStream(archivo2);

			response.setContentType("application/force-download");
			response.setHeader("Content-Disposition", "attachment; filename= " + "consultaCartera.xlsx");
			IOUtils.copy(inputstream, response.getOutputStream());
			response.flushBuffer();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		// return null;
		// }

		// mav.addObject("resultado", resultado);

		// mav.addObject("rolVentas",seguridadUtil.isRolVentas());
		// mav.addObject("rolAdministrador",seguridadUtil.isRolAdministrador());
		// mav.addObject("rolDireccion",seguridadUtil.isRolDireccion());

		// return mav;
	}

	/**
	 * @return the registrosPorPagina
	 */
	public Integer getRegistrosPorPagina() {
		return registrosPorPagina;
	}

	/**
	 * @param registrosPorPagina
	 *            the registrosPorPagina to set
	 */
	public void setRegistrosPorPagina(Integer registrosPorPagina) {
		this.registrosPorPagina = registrosPorPagina;
	}

	/**
	 * @return the consultaGeneralSolicitudesBusiness
	 */
	public IConsultaGeneralSolicitudesBusiness getConsultaGeneralSolicitudesBusiness() {
		return consultaGeneralSolicitudesBusiness;
	}

	/**
	 * @param consultaGeneralSolicitudesBusiness
	 *            the consultaGeneralSolicitudesBusiness to set
	 */
	public void setConsultaGeneralSolicitudesBusiness(
			IConsultaGeneralSolicitudesBusiness consultaGeneralSolicitudesBusiness) {
		this.consultaGeneralSolicitudesBusiness = consultaGeneralSolicitudesBusiness;
	}

	/**
	 * Método de acceso al campo seguridadUtil.
	 * 
	 * @return El valor del campo seguridadUtil
	 */
	public SeguridadUtil getSeguridadUtil() {
		return seguridadUtil;
	}

	/**
	 * Asigna el valor al campo seguridadUtil.
	 * 
	 * @param seguridadUtil
	 *            el valor seguridadUtil a asignar
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}

	public GeneraArchivoConsultaGeneralExcel getGeneraArchivoConsultaCarteraExcel() {
		return generaArchivoConsultaCarteraExcel;
	}

	public void setGeneraArchivoConsultaCarteraExcel(
			GeneraArchivoConsultaGeneralExcel generaArchivoConsultaGeneralExcel) {
		this.generaArchivoConsultaCarteraExcel = generaArchivoConsultaGeneralExcel;
	}

}
