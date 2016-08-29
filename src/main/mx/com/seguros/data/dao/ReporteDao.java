/*
Fecha de creacion 13 feb 2011, 19:18 hrs.
 */
package mx.com.seguros.data.dao;

import java.util.Map;

/**
 *
 * @author Cesar Garcia M
 */
public interface ReporteDao {

    public Map<String, Object> getParametersReporteCartaResumenPoliza(int numCertificado, int numPoliza);
}
