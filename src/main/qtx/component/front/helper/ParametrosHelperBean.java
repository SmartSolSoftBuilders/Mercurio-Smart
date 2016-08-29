package qtx.component.front.helper;

import java.util.HashMap;
import java.util.List;

public class ParametrosHelperBean {

	private String nombreQuery;
	private String tituloHelper;
	private HashMap parametrosQuery;
	private int widthVentana;
	private int heightVentana;
	private String funcionNotificacion;
	private List<ParametrosCamposHelperBean> camposHelper;
	
	public List<ParametrosCamposHelperBean> getCamposHelper() {
		return camposHelper;
	}
	public void setCamposHelper(List<ParametrosCamposHelperBean> camposHelper) {
		this.camposHelper = camposHelper;
	}
	public int getHeightVentana() {
		return heightVentana;
	}
	public void setHeightVentana(int heightVentana) {
		this.heightVentana = heightVentana;
	}
	public String getNombreQuery() {
		return nombreQuery;
	}
	public void setNombreQuery(String nombreQuery) {
		this.nombreQuery = nombreQuery;
	}
	public HashMap getParametrosQuery() {
		return parametrosQuery;
	}
	public void setParametrosQuery(HashMap parametrosQuery) {
		this.parametrosQuery = parametrosQuery;
	}
	public String getTituloHelper() {
		return tituloHelper;
	}
	public void setTituloHelper(String tituloHelper) {
		this.tituloHelper = tituloHelper;
	}
	public int getWidthVentana() {
		return widthVentana;
	}
	public void setWidthVentana(int widthVentana) {
		this.widthVentana = widthVentana;
	}
	/**
	 * @return the funcionNotificacion
	 */
	public String getFuncionNotificacion() {
		return funcionNotificacion;
	}
	/**
	 * @param funcionNotificacion the funcionNotificacion to set
	 */
	public void setFuncionNotificacion(String funcionNotificacion) {
		this.funcionNotificacion = funcionNotificacion;
	}
}