/**
 * 
 */
package mx.com.seguros.data.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import mx.com.seguros.data.dao.IBitacoraEmisionReporteDao;
import mx.com.seguros.model.BitacoraEmisionReporte;

/**
 * Implementación del objeto de acceso a datos para la Bitácora de Emisión de Reportes
 * @author Emigdio Hernández
 *
 */
public class BitacoraEmisionReporteSqlMapDao extends SqlMapClientDaoSupport implements
		IBitacoraEmisionReporteDao {

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IBitacoraEmisionReporteDao#insertarBitacoraEmisionReporte(mx.com.seguros.model.BitacoraEmisionReporte)
	 */
	@Override
	public void insertarBitacoraEmisionReporte(
			BitacoraEmisionReporte datosEntrada) {

		getSqlMapClientTemplate().insert("insertarBitacoraEmisionReporte",datosEntrada);

	}

}
