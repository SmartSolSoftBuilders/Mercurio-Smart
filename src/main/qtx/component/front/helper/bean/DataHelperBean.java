package qtx.component.front.helper.bean;

import java.util.List;

public class DataHelperBean {

	private String titulo;
	private int numregistros;
	private List<ColumnaHelperBean> columnas;
	private List<RegistroHelperBean> registros;
	private String funcion;
	
	public List<ColumnaHelperBean> getColumnas() {
		return columnas;
	}
	public void setColumnas(List<ColumnaHelperBean> columnas) {
		this.columnas = columnas;
	}
	public List<RegistroHelperBean> getRegistros() {
		return registros;
	}
	public void setRegistros(List<RegistroHelperBean> registros) {
		this.registros = registros;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getNumregistros() {
		return numregistros;
	}
	public void setNumregistros(int numregistros) {
		this.numregistros = numregistros;
	}
	/**
	 * @return the funcionNotificacion
	 */
	public String getFuncion() {
		return funcion;
	}
	/**
	 * @param funcionNotificacion the funcionNotificacion to set
	 */
	public void setFuncion(String funcionNotificacion) {
		this.funcion = funcionNotificacion;
	}
}
