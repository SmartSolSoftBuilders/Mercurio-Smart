package mx.com.seguros.web.solicitud;

import java.util.ArrayList;
import java.util.List;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;

/**
 *
 * @author Di VaiO
 */
public class DatosSolicitudCommand {
    private static final int NUM_MAXIMO_BENEFICIARIOS = 8;
    
   
    public DatosSolicitudCommand() {
        Beneficiario[] beneficiario = new Beneficiario[NUM_MAXIMO_BENEFICIARIOS];
        solicitud = new Solicitud();
        for(int i=0; i<NUM_MAXIMO_BENEFICIARIOS; i++)
            beneficiario[i] = new Beneficiario();
        solicitud.setBeneficiario(beneficiario);
        polizaIndividual = new PolizaIndividual();
    }
    
    private Solicitud solicitud;

    private PolizaIndividual polizaIndividual;

    private Integer registroArchivoPolizaOrigen = null;

    private boolean modificacion = false;
    
    private BeneficioAdicionalPoliza[] beneficiosPoliza = null;
    
    public Solicitud getSolicitud() {
        return solicitud;
    }
    
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    /**
     * @return the polizaIndividual
     */
    public PolizaIndividual getPolizaIndividual() {
        return polizaIndividual;
    }

    /**
     * @param polizaIndividual the polizaIndividual to set
     */
    public void setPolizaIndividual(PolizaIndividual polizaIndividual) {
        this.polizaIndividual = polizaIndividual;
    }

    /**
     * @return the registroArchivoPolizaOrigen
     */
    public Integer getRegistroArchivoPolizaOrigen() {
        return registroArchivoPolizaOrigen;
    }

    /**
     * @param registroArchivoPolizaOrigen the registroArchivoPolizaOrigen to set
     */
    public void setRegistroArchivoPolizaOrigen(Integer registroArchivoPolizaOrigen) {
        this.registroArchivoPolizaOrigen = registroArchivoPolizaOrigen;
    }

    /**
     * @return the modificacion
     */
    public boolean isModificacion() {
        return modificacion;
    }

    /**
     * @param modificacion the modificacion to set
     */
    public void setModificacion(boolean modificacion) {
        this.modificacion = modificacion;
    }

	/**
	 * @return the beneficiosPoliza
	 */
	public BeneficioAdicionalPoliza[] getBeneficiosPoliza() {
		return beneficiosPoliza;
	}

	/**
	 * @param beneficiosPoliza the beneficiosPoliza to set
	 */
	public void setBeneficiosPoliza(BeneficioAdicionalPoliza[] beneficiosPoliza) {
		this.beneficiosPoliza = beneficiosPoliza;
	}
}
