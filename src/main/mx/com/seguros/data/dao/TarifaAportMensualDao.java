package mx.com.seguros.data.dao;

import java.math.BigDecimal;

public interface TarifaAportMensualDao {
	BigDecimal findTarifaPoliza(Integer folioSolicitud);
	
	
}
