package mx.com.seguros.business.pagos.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import mx.com.seguros.business.pagos.CuentaClienteBusiness;
import mx.com.seguros.business.pagos.exception.SaldoNegativoException;
import mx.com.seguros.data.dao.CuentaClienteDao;
import mx.com.seguros.model.CuentaCliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuentaClienteBusinessImpl implements CuentaClienteBusiness {

    @Override
    public CuentaCliente findById(Integer numPoliza, Integer numConsignatario) {
        CuentaCliente cuentaCliente;
        try {
            cuentaCliente = cuentaClienteDao.obtenerCuentaClienteByPoliza(numPoliza, numConsignatario);
        } catch (Exception e) {
            cuentaCliente = null;
            handleMissingCuentaCliente(numPoliza, numConsignatario);
            e.printStackTrace();
        }
        if (cuentaCliente == null) {
            handleMissingCuentaCliente(numPoliza, numConsignatario);
        } else {
            log.debug(cuentaCliente.toString());
        }
        return cuentaCliente;
    }

    private void handleMissingCuentaCliente(Integer numPoliza, Integer numConsignatario) {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("No fue posible recuperar la cuenta del cliente");
        sb.append(" - RFC del contratante ");
        sb.append(numPoliza + " - " +numConsignatario);
        if(log.isTraceEnabled()) {
            log.trace(sb.toString());
        }
        return;
    }

    @Override
    public Boolean updateCuentaCliente(CuentaCliente cuentaCliente, BigDecimal importeTransaccion) throws SaldoNegativoException {
        // if (log.isDebugEnabled()) {
        // log.debug("Antes de actualizar saldo cuentaCliente: "
        // + cuentaCliente);
        // log.debug("importeTransaccion: " + importeTransaccion);
        // }
        BigDecimal saldoCuenta;
        saldoCuenta = cuentaCliente.getSaldoCuenta();
        BigDecimal saldoCuentaNuevo;
        // El importe de la transaccion ya trae el signo adecuado de modo que
        // este add a veces es subtract.
        saldoCuentaNuevo = saldoCuenta.add(importeTransaccion);
       /*if (saldoCuentaNuevo.compareTo(BigDecimal.ZERO) < 0) {
            StringBuilder msgExc = new StringBuilder();
            msgExc.append("No se permiten saldos de cuenta negativos: ");
            msgExc.append("saldo actual = ");
            msgExc.append(saldoCuenta);
            if (log.isInfoEnabled()) {
                log.info(msgExc.toString());
            }
            throw new SaldoNegativoException(msgExc.toString());
        } else {
            
        }*/
        cuentaCliente.setSaldoCuenta(saldoCuentaNuevo);
        cuentaCliente.setFechaCalculoSaldo(new Date());
        Boolean pagoRegistrado;
        pagoRegistrado = cuentaClienteDao.updateCuentaCliente(cuentaCliente);
        // log.info(cuentaCliente.toString());
        return pagoRegistrado;
    }

    @Override
    public CuentaCliente createCuentaCliente(Integer numPoliza, Integer numConsignatario) {
        CuentaCliente cuentaCliente;
        cuentaCliente = new CuentaCliente(numPoliza,numConsignatario);
        cuentaCliente.setSaldoCuenta(BigDecimal.ZERO);
        cuentaCliente.setFechaCalculoSaldo(new Date());
        cuentaClienteDao.createCuentaCliente(cuentaCliente);
        return cuentaCliente;
    }
    private CuentaClienteDao cuentaClienteDao;

    public void setCuentaClienteDao(CuentaClienteDao cuentaClienteDao) {
        this.cuentaClienteDao = cuentaClienteDao;
    }
    private static final Logger log;

    static {
        log = LoggerFactory.getLogger(CuentaClienteBusinessImpl.class);
    }
    
    
    /*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.pagos.PagosBusiness#ajustarSaldosNegativos()
	 */
	@Override
	public boolean ajustarSaldosNegativos() {
		//consultar saldos negativos
		List<CuentaCliente> saldosNegativos = cuentaClienteDao.obtenerCuentasConSaldosNegativos();
		
		for(CuentaCliente cuentaNegativa:saldosNegativos){
			System.out.println(cuentaNegativa.getNumNominaContratante());
			//por cada saldo negativo consultar si hay otros saldos con los cuales compensar
			List<CuentaCliente> saldosPositivosDeCliente = cuentaClienteDao.obtenerCuentasPositivasDeContratante(cuentaNegativa.getNumNominaContratante());
			double saldoNegativo = 0;
			double saldoPositivo = 0;
			double saldoADescontar = 0;
			if(saldosPositivosDeCliente.size() > 0){
				saldoNegativo = cuentaNegativa.getSaldoCuenta().doubleValue();
				//empezar a compensar la cuenta negativa con los positivos
				for(CuentaCliente cuentaPositiva:saldosPositivosDeCliente){
					if(saldoNegativo >=0){
						break;
					}
					saldoPositivo = cuentaPositiva.getSaldoCuenta().doubleValue();
					//elegir el número menor entre el absoluto del saldo negativo y el positivo
					saldoADescontar = (saldoNegativo*-1)<saldoPositivo?saldoNegativo*-1:saldoPositivo;
					//Descontar saldo
					saldoNegativo += saldoADescontar;
					saldoPositivo -= saldoADescontar;
					cuentaPositiva.setSaldoCuenta(new BigDecimal(saldoPositivo));
					//actualizar cuenta positiva
					cuentaPositiva.setFechaCalculoSaldo(new Date());
					cuentaClienteDao.updateCuentaCliente(cuentaPositiva);
				}
				
			}
			//Actualizar cuenta negativa
			cuentaNegativa.setSaldoCuenta(new BigDecimal(saldoNegativo));
			cuentaNegativa.setFechaCalculoSaldo(new Date());
			cuentaClienteDao.updateCuentaCliente(cuentaNegativa);
		}
		
		
		
		
		
		return false;
	}
}
