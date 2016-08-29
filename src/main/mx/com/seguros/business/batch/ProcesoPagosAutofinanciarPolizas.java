/**
 * 
 */
package mx.com.seguros.business.batch;

import mx.com.seguros.business.pagos.PagosBusiness;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Job para los procesos de autofinanciar pólizas
 * @author Emigdio Hernandez
 *
 */
public class ProcesoPagosAutofinanciarPolizas extends QuartzJobBean  {
	/**
	 * Servicio de pagos para ejecutar el método de autofinanciamiento
	 */
	PagosBusiness pagosBusiness;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext arg0)throws JobExecutionException {
		Logger log  = Logger.getLogger(ProcesoPagosAutofinanciarPolizas.class);
		try {
			log.info("Iniciando el proceso de autofinanciar pólizas");
			pagosBusiness.autoFinanciarPolizasAutomaticamente(1,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(2,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(3,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(4,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(5,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(6,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(7,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(8,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(9,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(10,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(11,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(12,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(13,null);
			pagosBusiness.autoFinanciarPolizasAutomaticamente(14,null);
			log.info("Terminado el proceso de autofinanciar pólizas");
		} catch (Exception e) {
			log.error(e);
			throw new JobExecutionException(e);
		}
		
	}
	/**
	 * @return the pagosBusines
	 */
	public PagosBusiness getPagosBusiness() {
		return pagosBusiness;
	}
	/**
	 * @param pagosBusines the pagosBusines to set
	 */
	public void setPagosBusiness(PagosBusiness pagosBusines) {
		this.pagosBusiness = pagosBusines;
	}

}
