/*
 * RegistroPrestamosEmpleadoCommand.java
 *
 * Created on 22 de mayo de 2008, 11:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.movimientosdependencia;
import mx.com.seguros.business.movimientosdependencia.ArchivoTXT;
import mx.com.seguros.model.Contratante;
import mx.com.seguros.model.MovimientosDependencia;
import mx.com.seguros.model.Solicitud;
/**
 *
 * @author QTX
 */
public class GenerarArchivoMovimientosDependenciaCommand{
    
    private static final int NUM_MAXIMO_CONTRATANTES = 15;    
    private String siglasRetenedor;
    private String anioQuincena;
    private String cveDescuento;
    /**
	 * @return the cveDescuento
	 */
	public String getCveDescuento() {
		return cveDescuento;
	}

	/**
	 * @param cveDescuento the cveDescuento to set
	 */
	public void setCveDescuento(String cveDescuento) {
		this.cveDescuento = cveDescuento;
	}

	/**
	 * @return the anioQuincena
	 */
	public String getAnioQuincena() {
		return anioQuincena;
	}

	/**
	 * @param anioQuincena the anioQuincena to set
	 */
	public void setAnioQuincena(String anioQuincena) {
		this.anioQuincena = anioQuincena;
	}

	/**
	 * @return the siglasRetenedor
	 */
	public String getSiglasRetenedor() {
		return siglasRetenedor;
	}

	/**
	 * @param siglasRetenedor the siglasRetenedor to set
	 */
	public void setSiglasRetenedor(String siglasRetenedor) {
		this.siglasRetenedor = siglasRetenedor;
	}

	/** Creates a new instance of GenerarArchivoMovimientosDependenciaCommand */
    public GenerarArchivoMovimientosDependenciaCommand() {
        Contratante[] contratante = new Contratante[NUM_MAXIMO_CONTRATANTES];        
        for(int i=0; i<NUM_MAXIMO_CONTRATANTES; i++)
            contratante[i] = new Contratante();
        getMovimientosDependencia().setContratantes(contratante);    
    }
    
    private MovimientosDependencia movimientosDependencia=new MovimientosDependencia();
    private ArchivoTXT archivoTXT = new ArchivoTXT();
    private Integer cveRetenedor=0;
    /**
	 * @return the cveRetenedor
	 */
	public Integer getCveRetenedor() {
		return cveRetenedor;
	}

	/**
	 * @param cveRetenedor the cveRetenedor to set
	 */
	public void setCveRetenedor(Integer cveRetenedor) {
		this.cveRetenedor = cveRetenedor;
	}

	public MovimientosDependencia getMovimientosDependencia() {
        return movimientosDependencia;
    }

    public void setMovimientosDependencia(MovimientosDependencia movimientosDependencia) {
        this.movimientosDependencia = movimientosDependencia;
    }

    public ArchivoTXT getArchivoTXT() {
        return archivoTXT;
    }

    public void setArchivoTXT(ArchivoTXT archivoTXT) {
        this.archivoTXT = archivoTXT;
   }
   
}
