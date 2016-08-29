package mx.com.seguros.data.dao.impl;

import java.util.Date;

import mx.com.seguros.data.dao.TransaccionCuentaClienteDao;
import mx.com.seguros.model.TransaccionCuentaCliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TransaccionCuentaClienteSqlMapDao extends SqlMapClientDaoSupport
		implements TransaccionCuentaClienteDao {

	public Long insertarTransaccion(
			TransaccionCuentaCliente transaccionCuentaCliente) {
		// log.trace("Antes de insertar transaccionCuentaCliente: "
		// + transaccionCuentaCliente);
		fechaTransaccion = new Date();
		transaccionCuentaCliente.setFechaTransaccion(fechaTransaccion);
		Long transaccionCuentaClienteId;
		transaccionCuentaClienteId = (Long) getSqlMapClientTemplate().insert(
				"insertTransaccionCuentaCliente", transaccionCuentaCliente);
		if (transaccionCuentaClienteId == null) {
			StringBuilder sb = new StringBuilder();
			sb.append("No se pudo realizar la transacci\u00F3n en la cuenta del ");
			sb.append("cliente");
			log.error(sb.toString());
		}
		log.debug("transaccionCuentaCliente: " + transaccionCuentaCliente);
		return transaccionCuentaClienteId;
	}

	private static final Logger log;

	private Date fechaTransaccion;

	static {
		log = LoggerFactory.getLogger(TransaccionCuentaClienteSqlMapDao.class);
	}

}
