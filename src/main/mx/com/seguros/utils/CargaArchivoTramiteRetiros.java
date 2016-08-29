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
 * Clase que sirve para leer el formato del archivo de trámite de retiros y crear una lista de cadenas
 * listas para su procesamiento.
 * El archivo de cambio de estatus de póliza es un achivo de Excel 2007 (no xml)
 * Fila 1: Ignorada, títulos
 * Columna A: Número Emisor
 * Columna C: Número de la póliza
 * Columna D: Concepto del retiro
 * Columna F: Monto del retiro (con comas)
 * Columna G: Operador del trámite
 * Columna H: Nombre de la sucursal del trámite
 * Columna I: Fecha del trámite (formato dd/MM/yyyy)
 * 
 * @author Emigdio Herández
 */
public class CargaArchivoTramiteRetiros {
	
	final int NUM_EMISOR=0;
    final int NUM_POLIZA=1;
    final int CONCEPTO = 2;
    final int MONTO = 4;
    final int OPERADOR = 5;
    final int SUCURSAL = 6;
    final int FECHA = 7;

    /**
     * Carga la información del archivo según el formato de columnas establecido
     * @param inputFile
     * @return
     * @throws Exception
     */
    public List<String[]> cargaInformacionArchivo(InputStream inputFile) throws Exception{
        List<String[]> listaFilas=new ArrayList<String[]>();
       
            Workbook workbook = Workbook.getWorkbook(inputFile);
            Sheet sheet = workbook.getSheets()[0];
            Cell[] renglon;
            for(int row=1; row < sheet.getRows();row++){
                renglon=sheet.getRow(row);
                String[] listaColumna = new String[7];
                
                if(renglon.length>NUM_EMISOR){
                	listaColumna[0] = renglon[NUM_EMISOR].getContents();
                }else{
                	listaColumna[0] = "";
                }
                
                if(renglon.length>NUM_POLIZA){
                	listaColumna[1] = renglon[NUM_POLIZA].getContents();
                }else{
                	listaColumna[1] = "";
                }
                
                if(renglon.length>CONCEPTO){
                	listaColumna[2] = renglon[CONCEPTO].getContents();
                }else{
                	listaColumna[2] = "";
                }
                
                if(renglon.length>MONTO){
                	listaColumna[3] = renglon[MONTO].getContents();
                }else{
                	listaColumna[3] = "";
                }
                
                if(renglon.length>OPERADOR){
                	listaColumna[4] = renglon[OPERADOR].getContents();
                }else{
                	listaColumna[4] = "";
                }
                
                if(renglon.length>SUCURSAL){
                	listaColumna[5] = renglon[SUCURSAL].getContents();
                }else{
                	listaColumna[5] = "";
                }
                
                if(renglon.length>FECHA){
                	listaColumna[6] = renglon[FECHA].getContents();
                }else{
                	listaColumna[6] = "";
                }
                
                listaFilas.add(listaColumna);
            }
        
        return listaFilas;
    }
    
}

    