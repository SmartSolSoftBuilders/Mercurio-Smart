package mx.com.seguros.business.consulta;

import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.dto.CriteriosConsultaPolizaPorBajaDTO;
import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

public class ConsultaEspecialBusiness implements IConsultaEspecialBusiness{
    private ISolicitudDao solicitudDao;
    
    private IPolizaDao polizaDao;
    
    @Override
    public void consultarSolicitudesEsp(CriteriosConsultaSolicitudesDTO criterios, ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado) {
        solicitudDao.consultarSolicitudesEsp(criterios, resultado);
    }

    /**
     * @return the solicitudDao
     */
    public ISolicitudDao getSolicitudDao() {
        return solicitudDao;
    }

    /**
     * @param solicitudDao the solicitudDao to set
     */
    public void setSolicitudDao(ISolicitudDao solicitudDao) {
        this.solicitudDao = solicitudDao;
    }

	@Override
	public void consultarPolizasPorBaja(CriteriosConsultaPolizaPorBajaDTO criterios, ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado) {
		polizaDao.consultarPolizasPorBaja(criterios, resultado);
		
	}

	/**
	 * @param polizaDao the polizaDao to set
	 */
	public void setPolizaDao(IPolizaDao polizaDao) {
		this.polizaDao = polizaDao;
	}
}
