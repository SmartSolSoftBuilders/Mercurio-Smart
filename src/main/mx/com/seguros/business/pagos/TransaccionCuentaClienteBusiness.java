package mx.com.seguros.business.pagos;


import java.math.BigDecimal;

import mx.com.seguros.model.CuentaCliente;
import mx.com.seguros.model.TransaccionCuentaCliente;

public interface TransaccionCuentaClienteBusiness {

	/**
	 * La transaccion consta de una insercion de historico de movimientos en
	 * cuenta y una actualizacion del saldo en la cuenta del cliente.
	 * 
	 * @param importeTransaccion
	 * @param cveTipoTransaccion
	 * @param cuentaCliente
	 * @return el id de la transaccion realizado si esta fue exitosa, null en
	 *         caso contrario
	 */
	TransaccionCuentaCliente realizarTransaccion(BigDecimal importeTransaccion,
			int cveTipoTransaccion, CuentaCliente cuentaCliente);

	/**
	 * La transaccion consta de una insercion de historico de movimientos en
	 * cuenta y una insercion de una cuenta del cliente con saldo en cero.
	 * 
	 * @param importeTransaccion
	 * @param cveTipoTransaccion
	 * @param cuentaCliente
	 * @return el id de la transaccion realizado si esta fue exitosa, null en
	 *         caso contrario
	 */
	//TransaccionCuentaCliente realizarTransaccionCuentaNueva(String numNominaContratante);

}
