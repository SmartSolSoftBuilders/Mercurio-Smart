/*
 * CargaArchivo.java
 *
 * Created on 31 de enero de 2008, 01:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Capacitacion
 */
public class CargaArchivo {
    
    /** Creates a new instance of CargaArchivo */
    final int QUINCENA_ARCHIVO=0;
    final int RFC_SOLICITANTE=1;
    final int DESCUENTO_APLICADO=2;

    public ArrayList cargaInformacionArchivo(InputStream inputFile) throws Exception{
        ArrayList listaFilas=new ArrayList();
       
            Workbook workbook = Workbook.getWorkbook(inputFile);
            Sheet sheet = workbook.getSheet(0);
            Cell[] renglon;
            for(int row=0; row < sheet.getRows();row++){
                renglon=sheet.getRow(row);
                ArrayList listaColumna=new ArrayList();
                for(int colum=0;colum<renglon.length;colum++){
                    listaColumna.add(colum,renglon[colum].getContents());
                }
                listaFilas.add(row,listaColumna);
            }
        
        return listaFilas;
    }
    
    public boolean validaArchivoDescuentos(ArrayList listaFilas){
        try{
            ArrayList fila=(ArrayList)listaFilas.get(0);
            if(!fila.get(0).toString().isEmpty()){
                if(fila.get(RFC_SOLICITANTE).toString().equals(""))
                    return false;
                if(fila.get(QUINCENA_ARCHIVO).toString().equals(""))
                    return false;
                if(fila.get(DESCUENTO_APLICADO).toString().equals(""))
                    return false;
                else{
                    Integer.parseInt(fila.get(QUINCENA_ARCHIVO).toString());
                    Integer.parseInt(fila.get(DESCUENTO_APLICADO).toString());
                }
            }else
                return false;
        }catch(ArrayIndexOutOfBoundsException er){
            return false;
        }catch(NumberFormatException er){
            return false;
        }
        return true;
    }
}
