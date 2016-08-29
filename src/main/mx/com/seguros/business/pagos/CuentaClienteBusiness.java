package mx.com.seguros.business.pagos;

import java.math.BigDecimal;
import java.util.List;

import mx.com.seguros.business.pagos.exception.SaldoNegativoException;
import mx.com.seguros.model.CuentaCliente;

public interface CuentaClienteBusiness {

	/**
	 * Recupera la cuenta del cliente.
	 * 
	 * @param numNominaContratante
	 * @return null si no existe una cuenta asociada al cliente de RFC dado.
	 */
	CuentaCliente findById(Integer numPoliza, Integer numConsignatario);

	Boolean updateCuentaCliente(CuentaCliente cuentaCliente,
			BigDecimal importeTransaccion) throws SaldoNegativoException;

	/**
	 * Crea una cuenta nueva para el cliente, con saldo en cero.
	 * @param numNominaContratante
	 */
	CuentaCliente createCuentaCliente(Integer numPoliza, Integer numNominaContratante);
	
	 /**
     * Método utilitario para ajustar saldos negativos en la cuenta del cliente tomando saldo de otras pólizas del mismo cliente
     * @return
     */
    boolean ajustarSaldosNegativos();
	
    

}
