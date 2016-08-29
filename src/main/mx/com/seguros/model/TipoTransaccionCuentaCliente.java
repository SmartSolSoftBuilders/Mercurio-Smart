/**
 * 
 */
package mx.com.seguros.model;

/**
 * Modelo que representa la tabla de TipoTransaccionCuentaCliente
 * @author SmartSolutions
 *
 */
public class TipoTransaccionCuentaCliente {
	
	public static int CVE_TIPO_MOV_DEPOSITO = 1;
	public static int CVE_TIPO_MOV_RETIRO = 2;
	public static int CVE_TIPO_MOV_DISPOSICION = 3;
	private int cveTipoTransaccion;
	private String descripcion;
	
	public TipoTransaccionCuentaCliente(){}
	
	public TipoTransaccionCuentaCliente(int clave){
		
		this.setCveTipoTransaccion(cveTipoTransaccion);
	}
	/**
	 * @return the cveTipoTransaccion
	 */
	public int getCveTipoTransaccion() {
		return cveTipoTransaccion;
	}
	/**
	 * @param cveTipoTransaccion the cveTipoTransaccion to set
	 */
	public void setCveTipoTransaccion(int cveTipoTransaccion) {
		this.cveTipoTransaccion = cveTipoTransaccion;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
