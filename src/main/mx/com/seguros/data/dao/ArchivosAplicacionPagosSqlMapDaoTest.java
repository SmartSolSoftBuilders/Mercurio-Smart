/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.model.ArchivosAplicacionCargados;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.test.BaseServiceTest;

import org.apache.log4j.Logger;

/**
 * Clase de pruebs unitarias par el DAO de operaciones sobre la tabla
 * de archivos de aplicación de pagos
 * @author Emigdio Hernandez
 *
 */
public class ArchivosAplicacionPagosSqlMapDaoTest extends BaseServiceTest{
	private static final Logger log  = Logger.getLogger(ArchivosAplicacionPagosSqlMapDaoTest.class);
	
	@Override
    protected void setUp() throws Exception{
		super.setUp();
	}
	
	/**
	 * Prebas unitarias del método de obtenDetalleComisionSolicitud del AgenteDao
	 */
	public void testArchivosAplicacionPagosDao_findArchivosAplicacionCargados(){
		ArchivosAplicacionPagosDao dao = (ArchivosAplicacionPagosDao)getBean("archivosAplicacionPagosDao");
		CriteriosConsultaArchivosAplicacionCargadosDTO criterios = new CriteriosConsultaArchivosAplicacionCargadosDTO();
		List<ArchivosAplicacionCargados> detalle = dao.findArchivosAplicacionCargados(criterios);
		log.debug(detalle);
	}
	/**
	 * Pruebas unitarias para crear nuevos archivos de aplicación en bd
	 */
	public void ttestArchivosAplicacionPagosDao_insertarArchivoAplicacion(){
		ArchivosAplicacionPagosDao dao = (ArchivosAplicacionPagosDao)getBean("archivosAplicacionPagosDao");
		ArchivosAplicacionCargados archivo = new ArchivosAplicacionCargados();
		archivo.setNumQuincena(202012);
		archivo.setConsecutivoArchivo(0);
		archivo.setFechaCarga(new Date());
		archivo.setIdPlaza(1);
		archivo.setUsername("masterDir");
		dao.insertarArchivoAplicacion(archivo);
	}
	/**
	 * Método de pruebas unitarias para la consulta y carga de pólizas en modo masivo por ID
	 */
	public void ttestPolizaDao_consultarPolizasBatch(){
		IPolizaDao polizaDao = (IPolizaDao)getBean("polizaDao");
		List<Integer> numerosPoliza = new ArrayList<Integer>();
		List<Integer> numerosConsignatario = new ArrayList<Integer>();
		
		numerosPoliza.add(93020127); numerosConsignatario.add(10215);
		numerosPoliza.add(93020127); numerosConsignatario.add(11102);
		numerosPoliza.add(93020118); numerosConsignatario.add(10215);
		numerosPoliza.add(93020118); numerosConsignatario.add(11102);
		numerosPoliza.add(93020118); numerosConsignatario.add(11112);
		numerosPoliza.add(93020118); numerosConsignatario.add(13516);
		numerosPoliza.add(93020109); numerosConsignatario.add(10215);
		numerosPoliza.add(93020109); numerosConsignatario.add(11102);
		numerosPoliza.add(93020109); numerosConsignatario.add(11112);
		numerosPoliza.add(93020109); numerosConsignatario.add(13516);
		numerosPoliza.add(93020092); numerosConsignatario.add(10215);
		numerosPoliza.add(93020092); numerosConsignatario.add(11112);

		
		List<PolizaIndividual> resultados = polizaDao.cargarPolizasPorPKBatch(numerosPoliza, numerosConsignatario);
		log.debug(resultados);
	}
}
