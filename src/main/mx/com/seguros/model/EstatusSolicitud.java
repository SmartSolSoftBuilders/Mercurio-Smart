/*
 * EstatusSolicitud.java
 *
 * Created on 16 de enero de 2008, 03:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;
import mx.com.seguros.model.Solicitud;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author QTX
 */
public class EstatusSolicitud {
    
    /** Creates a new instance of EstatusSolicitud */
    public EstatusSolicitud() {
    }
     private int idEstatusSolicitud;
    private String descripcionEstatusSolicitud;    
   private List<Solicitud> solicitud = new ArrayList<Solicitud>();
        
         public List<Solicitud> getSolicitud() {
            return solicitud;
    }

    public void setSolicitud(List<Solicitud> solicitud) {
        this.solicitud = solicitud;
    }

    public int getIdEstatusSolicitud() {
        return idEstatusSolicitud;
    }

    public void setIdEstatusPoliza(int idEstatusSolicitud) {
        this.setIdEstatusSolicitud(idEstatusSolicitud);
    }

    public String getDescripcionEstatusSolicitud() {
        return descripcionEstatusSolicitud;
    }

    public void setDescripcionEstatusSolicitud(String descripcionEstatusSolicitud) {
        this.descripcionEstatusSolicitud = descripcionEstatusSolicitud;
    }

    /**
     * @param idEstatusSolicitud the idEstatusSolicitud to set
     */
    public void setIdEstatusSolicitud(int idEstatusSolicitud) {
        this.idEstatusSolicitud = idEstatusSolicitud;
    }
}
