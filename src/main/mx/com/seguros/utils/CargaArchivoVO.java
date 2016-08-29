/*
 * CargaArchivoVO.java
 *
 * Created on 1 de febrero de 2008, 10:59 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.utils;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Capacitacion
 */
public class CargaArchivoVO {
    
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
