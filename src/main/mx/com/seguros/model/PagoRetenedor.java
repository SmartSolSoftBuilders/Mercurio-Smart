/*
 * Created 20 Febrero 2011, 22:24 hrs.
 */
package mx.com.seguros.model;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * La idea detras de esta clase es cambiar el manejo de la carga de los archivos
 * de pagos del retenedor usando una aproximacion oriuentada a objetos, y no a
 * tipos de datos crudos (lista de strings) como se hacia anteriormente.
 * @author Cesar Garcia Mauricio
 */
public class PagoRetenedor {
    // Orden para los registros rechazados:

    private static final int NUM_NOMINA_CONTRATANTE_RECH = 0;
    private static final int QUINCENA_ARCHIVO_RECH = 1;
    private static final int IMPORTE_REPORTADO_RECH = 2;
    private static final int CAUSA_RECHAZO = 3;
    private static final Logger LOG;
    
    private Integer numQnaArchivo;
    
    private String numNominaContratante;
   
    private BigDecimal montoPagoReportado;
    
    private String causaRechazo;
    //@Property
    //private Date fechaDepositoDep;

    public PagoRetenedor(List<String> pagoRetenedorItem) {
        numNominaContratante = pagoRetenedorItem.get(
                NUM_NOMINA_CONTRATANTE_RECH).trim();
        String numQnaStr;
        numQnaStr = pagoRetenedorItem.get(QUINCENA_ARCHIVO_RECH);
        numQnaArchivo = Integer.parseInt(numQnaStr);
        String importeReportadoStr;
        importeReportadoStr = pagoRetenedorItem.get(IMPORTE_REPORTADO_RECH);
        montoPagoReportado = new BigDecimal(importeReportadoStr);
        causaRechazo = pagoRetenedorItem.get(CAUSA_RECHAZO);
        /*
        String fechaDepositoDepStr = (String) pagoRetenedorItem.get(PagoRetenedor.);
        try {
        fechaDepositoDep = DateUtils.parseDate(fechaDepositoDepStr, new String[]{"yyyy-MM-dd"});
        } catch (ParseException ex) {
        LOG.error("Error al transformar formato de fecha de deposito a dependencia", ex);
        }
         */
        
    }

   
    public Integer getNumQnaArchivo() {
        return numQnaArchivo;
    }

    public void setNumQnaArchivo(final Integer numQnaArchivo) {
        this.numQnaArchivo = numQnaArchivo;
    }

    public String getNumNominaContratante() {
        return numNominaContratante;
    }

    public void setNumNominaContratante(final String numNominaContratante) {
        this.numNominaContratante = numNominaContratante;
    }

    public BigDecimal getMontoPagoReportado() {
        return montoPagoReportado;
    }

    public void setMontoPagoReportado(final BigDecimal montoPagoReportado) {
        this.montoPagoReportado = montoPagoReportado;
    }
    /*
    public Date getFechaDepositoDep() {
    return fechaDepositoDep;
    }

    public void setFechaDepositoDep(final Date fechaDepositoDep) {
    this.fechaDepositoDep = fechaDepositoDep;
    }
     */

    public String getCausaRechazo() {
        return causaRechazo;
    }

    public void setCausaRechazo(final String causaRechazo) {
        this.causaRechazo = causaRechazo;
    }

    static {
        LOG = LoggerFactory.getLogger(PagoRetenedor.class);
    }
}
