package mx.com.seguros.reporte.descuento;

import java.util.Collection;
import java.util.Map;

import mx.com.seguros.model.DescuentosAplicados;
import mx.com.seguros.model.PolizaIndividual;

public interface DescuentoReporte {

	/**
	 * TODO - To document
	 * 
	 * @param poliza
	 * @param descuentoAplicadoColl
	 * @return
	 */
	String generarReporte(PolizaIndividual poliza);

	/**
	 * Calcula los datos finales a mostrar en el reporte de descuentos
	 * aplicados, con los pagos correspondientes a quincenas de adeudo ya
	 * sumarizadas y resumidas. Los datos del reporte son:
	 * <p>
	 * numQnaArchivo <br>
	 * montoReportado <br>
	 * pagoPrima <br>
	 * pagoAhorro <br>
	 * saldoCtaCliente <br>
	 * fechaInicioCobertura <br>
	 * fechaFinalCobertura <br>
	 * 
	 * @param poliza
	 *            Es la poliza pagada con los descuentos aplicados.
	 */
	Collection<DescuentosAplicados> calcularRegistrosReporteDescuentosAplicados(
			PolizaIndividual poliza);

	Map<String, Object> findParametrosReporteDescuentos(PolizaIndividual poliza);

}
