/**
 * 
 */
package mx.com.seguros.business.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.test.BaseServiceTest;
import mx.com.seguros.utils.CargaArchivo;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

import org.apache.log4j.Logger;

/**
 * Clase de prueba unitaria para el proceso batch de autifinanciar pólizas pendientes de pagos
 * @author Emigdio Hernandez
 *
 */
public class ConsultasAutofinanciarPolizasTest extends BaseServiceTest{
	/**Log de clase*/
	private static final Logger log  = Logger.getLogger(ConsultasAutofinanciarPolizasTest.class);
	public void testImportarArchivoAplicacion(){
		try{
			IPolizaDao dao = (IPolizaDao)getBean("polizaDao");
			
			ResultadoPaginadoDTO<PolizaIndividual> resultados = new ResultadoPaginadoDTO<PolizaIndividual>();
			resultados.setRegistrosPorPagina(500);
			
			dao.consultarPolizasParaAutofinanciar(resultados,3, 8);
			
			
			System.out.println(resultados.getTotalResultados());
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		
	}
}
