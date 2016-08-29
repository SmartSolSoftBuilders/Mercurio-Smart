package mx.com.seguros.business.pagos.impl;

import java.math.BigDecimal;
import java.util.Date;

import mx.com.seguros.business.pagos.CuentaClienteBusiness;
import mx.com.seguros.business.pagos.TransaccionCuentaClienteBusiness;
import mx.com.seguros.data.dao.TransaccionCuentaClienteDao;
import mx.com.seguros.model.CuentaCliente;
import mx.com.seguros.model.TipoTransaccionCuentaCliente;
import mx.com.seguros.model.TransaccionCuentaCliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class TransaccionCuentaClienteBusinessImpl 
		implements TransaccionCuentaClienteBusiness {
	private static final Logger log = LoggerFactory.getLogger(TransaccionCuentaClienteBusinessImpl.class);
	@Transactional
	public TransaccionCuentaCliente realizarTransaccion(BigDecimal importeTransaccion, int cveTipoTransaccion,CuentaCliente cuentaCliente) {
		Date fechaCalculoSaldo;
		fechaCalculoSaldo = new Date();
		cuentaCliente.setFechaCalculoSaldo(fechaCalculoSaldo);
		cuentaClienteBusiness.updateCuentaCliente(cuentaCliente,
				importeTransaccion);

		TransaccionCuentaCliente transaccionCta;
		transaccionCta = insertTransaccion(importeTransaccion,cveTipoTransaccion, cuentaCliente);

		if (log.isTraceEnabled()) {
			TipoTransaccionCuentaCliente tipoTransaccion;
			tipoTransaccion = transaccionCta.getTipoTransaccionCuentaCliente();
			StringBuilder msg = new StringBuilder();
			msg.append(tipoTransaccion.getDescripcion());
			msg.append(" Monto ");
			msg.append(transaccionCta.getImporteTransaccion());
			msg.append(" Saldo ");
			msg.append(cuentaCliente.getSaldoCuenta());
			log.trace(msg.toString());
		}
		return transaccionCta;
	}

	private TransaccionCuentaCliente insertTransaccion(BigDecimal importeTransaccion, int cveTipoTransaccion,CuentaCliente cuenta) {
		TransaccionCuentaCliente transaccion;
		transaccion = new TransaccionCuentaCliente(cveTipoTransaccion);
		transaccion.setImporteTransaccion(importeTransaccion);
		transaccion.setNumPoliza(cuenta.getNumPoliza());
		transaccion.setNumConsignatario(cuenta.getNumConsignatario());
		transaccionCuentaClienteDao.insertarTransaccion(transaccion);
		return transaccion;
	}

	// @Autowired
	private TransaccionCuentaClienteDao transaccionCuentaClienteDao;

	public void setTransaccionCuentaClienteDao(
			TransaccionCuentaClienteDao transaccionCuentaClienteDao) {
		this.transaccionCuentaClienteDao = transaccionCuentaClienteDao;
	}

	// @Autowired
	private CuentaClienteBusiness cuentaClienteBusiness;

	public void setCuentaClienteBusiness(
			CuentaClienteBusiness cuentaClienteBusiness) {
		this.cuentaClienteBusiness = cuentaClienteBusiness;
	}

}
