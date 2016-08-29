package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.CuentaCliente;

public interface CuentaClienteDao {

	/**
	 * Obtiene las cuentas del cliente asociadas a un contratante
	 * @param numNominaContratante
	 * @return
	 */
	List<CuentaCliente> obtenerCuentaClienteByNumNominaContratante(String numNominaContratante);
	/**
	 * Obtiene una cuenta del cliente asociada a una póliza en particular
	 * @param numPoliza
	 * @param numConsignatario
	 * @return
	 */
	CuentaCliente obtenerCuentaClienteByPoliza(Integer numPoliza, Integer numConsignatario);

	/** @return true si la actualizacion fue exitosa */
	Boolean updateCuentaCliente(CuentaCliente cuentaCliente);

	/**
	 * NOTE Cuando se invoque a este metodo la cuenta del cliente debe estar
	 * completamente llena, con los 4 parametros debidamente inicializados:
	 * numNominaContratante, fechaCalculo, transId & saldoCuenta.
	 * 
	 * @param cuentaCliente
	 */
	void createCuentaCliente(CuentaCliente cuentaCliente);

	// boolean registrarPagoRecibido(String numNominaContratante,
	// BigDecimal importeReportado, int numQna);
	
	List<CuentaCliente> obtenerCuentasConSaldosNegativos();
	
	List<CuentaCliente> obtenerCuentasPositivasDeContratante(String numNominaContratante);

}
