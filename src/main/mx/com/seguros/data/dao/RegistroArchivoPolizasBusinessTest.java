/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import mx.com.seguros.business.archivopolizas.ArchivoPolizasBusiness;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.test.BaseServiceTest;

/**
 * Pruebas unitarias para el servicio de manipulación de los registros del archivo de pólizas
 * de inbursa
 * @author Emigdio Hernández
 */
public class RegistroArchivoPolizasBusinessTest extends BaseServiceTest {
   public void testCopiarSolicitud(){


         ArchivoPolizasBusiness instance = (ArchivoPolizasBusiness)getBean("archivoPolizasBusiness");
         PolizaIndividual sol = instance.copiarRegistroArchivoPolizaASistema(1L);
         assertNotNull(sol);

     }
}
