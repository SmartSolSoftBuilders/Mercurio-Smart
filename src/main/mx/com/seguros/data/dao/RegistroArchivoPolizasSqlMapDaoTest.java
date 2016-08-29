/*
 * Proyecto: Estrategas Seguros - Inbursa
 * Archivo: RegistroArchivoPolizasSqlMapDaoTest.java
 * Fecha de creación: 10/06/2011
 * Última Modificación: 10/06/2011
 */

package mx.com.seguros.data.dao;

import java.util.List;
import mx.com.seguros.business.archivopolizas.ArchivoPolizasBusiness;
import mx.com.seguros.model.EstadoRegistroPoliza;
import mx.com.seguros.model.RegistroArchivoPolizas;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.test.BaseServiceTest;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

/**
 *
 * @author Emigdio
 */
public class RegistroArchivoPolizasSqlMapDaoTest extends BaseServiceTest {
    
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of consultarRegistroArchivoPolizasPorEstatus method, of class RegistroArchivoPolizasSqlMapDao.
     */
    public void testConsultarRegistroArchivoPolizasPorEstatus() {
        System.out.println("consultarRegistroArchivoPolizasPorEstatus");
        
        ArchivoPolizasBusiness instance = (ArchivoPolizasBusiness)getBean("archivoPolizasBusiness");
        ResultadoPaginadoDTO res = new ResultadoPaginadoDTO();
        res.setRegistrosPorPagina(50);
        res.setPaginaActual(1);
        instance.consultarRegistroArchivoPolizasPorEstatus(EstadoRegistroPoliza.PENDIENTE,res);
        assertNotNull(res.getResultados());
       
    }

    public void testConsultarRegistroArchivoPolizasPorEstatus2() {
        System.out.println("consultarRegistroArchivoPolizasPorEstatus");

        IRegistroArchivoPolizasDao instance = (IRegistroArchivoPolizasDao)getBean("registroArchivoPolizasDao");
        ResultadoPaginadoDTO res = new ResultadoPaginadoDTO();
        res.setRegistrosPorPagina(50);
        res.setPaginaActual(1);
        instance.consultarRegistroArchivoPolizasPorEstatus(EstadoRegistroPoliza.PENDIENTE,res);
        assertNotNull(res.getResultados());

    }

     public void testConsultarRegistroArchivoPolizasPorId() {

        IRegistroArchivoPolizasDao instance = (IRegistroArchivoPolizasDao)getBean("registroArchivoPolizasDao");

        RegistroArchivoPolizas registro= instance.consultarPorId(1L);
        assertNotNull(registro);

    }

  

    
}
