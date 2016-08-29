/*
 * CargaArchivo.java
 *
 * Created on 31 de enero de 2008, 01:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.utils;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * Clase que sirve para leer el formato del archivo de cambio de estatus de póliza y crear una lista de cadenas
 * listas para su procesamiento.
 * El archivo de cambio de estatus de póliza es un achivo de Excel 2007 (no xml)
 * Fila 1: Ignorada, contiene los títulos de las columnas
 * Columna A: Número Emisor
 * Columna B: Folio de la Solicitud
 * Columna C: Número de la póliza
 * Columna I: Indicador de estatus de la póliza:
 * 
 * @author Emigdio Herández
 */
public class CargaArchivoCambioEstatusPoliza {
    
    /** Creates a new instance of CargaArchivo */
    final int NUM_POLIZA=2;
    final int NUM_EMISOR=0;
    final int ESTATUS=8;

    public List cargaInformacionArchivo(InputStream inputFile) throws Exception{
        List<String[]> listaFilas=new ArrayList<String[]>();
       
            Workbook workbook = Workbook.getWorkbook(inputFile);
            Sheet sheet = workbook.getSheets()[0];
            Cell[] renglon;
            for(int row=1; row < sheet.getRows();row++){
                renglon=sheet.getRow(row);
                String[] listaColumna = new String[3];
                if(renglon!= null && renglon.length>ESTATUS){
                	listaColumna[0] = renglon[NUM_POLIZA].getContents();
                    listaColumna[1] = renglon[NUM_EMISOR].getContents();
                    listaColumna[2] = renglon[ESTATUS].getContents();
                }else{
                	listaColumna[0] = "";
                	listaColumna[1] = "";
                	listaColumna[2] = "";
                }
                
                listaFilas.add(listaColumna);
            }
        
        return listaFilas;
    }
    
}
