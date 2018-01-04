package mx.com.seguros.business.consulta;

import java.io.File;

import mx.com.seguros.dto.ResultadoCarteraSolicitudDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

public interface GeneraArchivoConsultaGeneralExcel {
	File generaArchivoExcel(ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado);

	File generaArchivoCarteraExcel(ResultadoPaginadoDTO<ResultadoCarteraSolicitudDTO> resultado);
}
