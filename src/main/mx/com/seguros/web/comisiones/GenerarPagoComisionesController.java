/*
 * GenerarPagoComisionesController.java
 *
 * Created on 13 de marzo de 2008, 09:49 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package mx.com.seguros.web.comisiones;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.seguros.business.comisiones.BonoTrimestralBusiness;
import mx.com.seguros.business.comisiones.CalculoComisionesBusiness;
import mx.com.seguros.business.comisiones.CalculoDescuentoComisionesBusiness;
import mx.com.seguros.business.comisiones.RegistroAbonoQuincenalPrestEmplBusiness;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author QTX
 */
public class GenerarPagoComisionesController extends AbstractWizardFormController {

    private BonoTrimestralBusiness bonoBusiness;
    private CalculoComisionesBusiness calculoComisionesBusiness;
    private CalculoDescuentoComisionesBusiness calculoDescuentoComisionesBusiness;
    private RegistroAbonoQuincenalPrestEmplBusiness registroAbonoPrestamosBusiness;
    int numReportes = 0;

    /** Creates a new instance of GenerarPagoComisionesController */
    public GenerarPagoComisionesController() {
        this.setSupportedMethods(new String[]{METHOD_POST, METHOD_GET});
        setPages(new String[]{"generarComisiones/generarPagoComisiones"});
        setCommandClass(GenerarPagoComisionesCommand.class);
        setCommandName("comisiones");
        setSessionForm(true);
        setValidator(new GenerarPagoComisionesValidator());
        setValidateOnBinding(false);
    }

    @Override
    protected void validatePage(Object command, Errors errors, int page) {
        /* ConsultaPolizaCommand datosPoliza = (ConsultaPolizaCommand) command;
        ConsultaPolizaValidator validator = (ConsultaPolizaValidator) getValidator();
        switch (page) {
        case 0:
        validator.validatePage0(datosPoliza, errors);
        break;
        }*/
    }

    @Override
    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException bindException) throws Exception {
        GenerarPagoComisionesCommand comisiones = (GenerarPagoComisionesCommand) command;
        Date fechaInicioPeriodoComisiones = comisiones.getComisionBrutaAgente().getFechaInicioPeriodoComisiones();
        System.out.println("FECHA INICIO" + fechaInicioPeriodoComisiones);
        System.out.println("antes de todos los calculos");
        Date fechaFinPeriodoComisiones = comisiones.getComisionBrutaAgente().getFechaFinPeriodoComisiones();
        System.out.println("FECHA fin" + fechaFinPeriodoComisiones);
        int numQnaComision = comisiones.getComisionBrutaAgente().getNumQuincenaReporte();
        int anioQuincena = comisiones.getComisionBrutaAgente().getAnioQuincena();
        System.out.println("quincena" + numQnaComision);
        System.out.println("anio quincena" + anioQuincena);
        System.out.println("despues de lasasignaciones");

        calculoComisionesBusiness.calcularComisionesAgentes(fechaInicioPeriodoComisiones, fechaFinPeriodoComisiones, numQnaComision);
        calculoDescuentoComisionesBusiness.calcularDescuentosComisionesAgentes();
        System.out.println("Estoy entrando a un nuevo metodo");
        registroAbonoPrestamosBusiness.registrarAbonosEmpleado(numQnaComision);



        if (numQnaComision == 6 || numQnaComision == 12 || numQnaComision == 18 || numQnaComision == 24) {
            System.out.println("if bono trimestral");
            bonoBusiness.obtenerBonoTrimestral(numQnaComision);
            System.out.println("despues if bono trimestral");
            bonoBusiness.generarReportes(comisiones);
        }
        else {
            bonoBusiness.generarReportes(comisiones);
        }
        //System.out.println("ruta rep bono"+bonoBusiness.obtenerReporte(comisiones).getRutaReporteAsignacionBonoTrimestral());
        //   System.out.println("ruta rep comisiones"+bonoBusiness.obtenerReporte(comisiones).getRutaReportePagoComisiones());
        //    System.out.println("ruta lista supervisores"+bonoBusiness.obtenerReporte(comisiones).getRutaListaSupervisores());
        //    System.out.println("ruta lista gerentes"+bonoBusiness.obtenerReporte(comisiones).getRutaListaGerentes());
        request.getSession().setAttribute("ReportesPDF", bonoBusiness.obtenerReporte(comisiones));
        if (bonoBusiness.getNumReportes() == 2) {
            ModelAndView mav = new ModelAndView("generarComisiones/operacionCorrecta");
            bonoBusiness.cambiarValoresRetorno();
            return mav;
        } else {
            ModelAndView mav1 = new ModelAndView("generarComisiones/operacionCorrecta2");
            return mav1;
        }



    }

    @Override
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView(new RedirectView("generarPagoComisionesController"));
    }

    @Override
    protected void initBinder(HttpServletRequest req,
            ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("dd/MM/yyyy"), true));
    }

    public BonoTrimestralBusiness getBonoBusiness() {
        return bonoBusiness;
    }

    public void setBonoBusiness(BonoTrimestralBusiness bonoBusiness) {
        this.bonoBusiness = bonoBusiness;
    }

    public CalculoComisionesBusiness getCalculoComisionesBusiness() {
        return calculoComisionesBusiness;
    }

    public void setCalculoComisionesBusiness(CalculoComisionesBusiness calculoComisionesBusiness) {
        this.calculoComisionesBusiness = calculoComisionesBusiness;
    }

    public CalculoDescuentoComisionesBusiness getCalculoDescuentoComisionesBusiness() {
        return calculoDescuentoComisionesBusiness;
    }

    public void setCalculoDescuentoComisionesBusiness(CalculoDescuentoComisionesBusiness calculoDescuentoComisionesBusiness) {
        this.calculoDescuentoComisionesBusiness = calculoDescuentoComisionesBusiness;
    }

    public RegistroAbonoQuincenalPrestEmplBusiness getRegistroAbonoPrestamosBusiness() {
        return registroAbonoPrestamosBusiness;
    }

    public void setRegistroAbonoPrestamosBusiness(RegistroAbonoQuincenalPrestEmplBusiness registroAbonoPrestamosBusiness) {
        this.registroAbonoPrestamosBusiness = registroAbonoPrestamosBusiness;
    }
}
