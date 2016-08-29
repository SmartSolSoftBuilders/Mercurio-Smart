/*
 * RegistroAbonoQuincenalPrestEmplBusiness.java
 *
 * Created on 2 de junio de 2008, 09:14 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package mx.com.seguros.business.comisiones;

import java.util.Date;
import java.util.List;
import mx.com.seguros.data.dao.IAgenteDao;
import mx.com.seguros.data.dao.IPrestamosDao;
import mx.com.seguros.model.Empleado;
import mx.com.seguros.model.PrestamoEmpleado;
import mx.com.seguros.web.comisiones.GenerarPagoComisionesCommand;
import mx.com.seguros.model.PagoPrestamoEmpleado;

/**
 *
 * @author QTX
 */
public class RegistroAbonoQuincenalPrestEmplBusiness {

    private IAgenteDao agenteDao;
    private IPrestamosDao prestamosDao;
    private GenerarPagoComisionesCommand comisionesCommand;

    /** Creates a new instance of RegistroAbonoQuincenalPrestEmplBusiness */
    public RegistroAbonoQuincenalPrestEmplBusiness() {
    }

    /** Creates a new instance of CalculoComisiones */
    public boolean registrarAbonosEmpleado(int numQnaComision) {

        boolean bandera = false;

        System.out.println("Antes del FOR");
        List listaEmpleadoAgente = getAgenteDao().obtenListaEmpleadoAgente();
        for (int i = 0; i < listaEmpleadoAgente.size(); i++) {
            System.out.println("Destro del FOR");
            Empleado empleado = (Empleado) listaEmpleadoAgente.get(i);
            System.out.println("Despues de asignacion de empleado");
            if (getAgenteDao().obtenListaPrestamoEmpleadoNoLiquidado(empleado.getCveEmpleado()).isEmpty()) {
                System.out.println("*****lista vacia*****");
            } else {
                List listaPrestamoNoLiquidado = getAgenteDao().obtenListaPrestamoEmpleadoNoLiquidado(empleado.getCveEmpleado());
                for (int j = 0; j < listaPrestamoNoLiquidado.size(); j++) {
                    PrestamoEmpleado prestamoEmpl = (PrestamoEmpleado) listaPrestamoNoLiquidado.get(j);
                    PagoPrestamoEmpleado pagoPrestEmpl = new PagoPrestamoEmpleado();
                    int cveEmpleado = prestamoEmpl.getCveEmpleado();
                    int idPrestamo = prestamoEmpl.getIdPrestamo();
                    pagoPrestEmpl.setCveEmpleado(cveEmpleado);
                    pagoPrestEmpl.setIdPrestamo(idPrestamo);

                    PagoPrestamoEmpleado primerPagoEmpleado = new PagoPrestamoEmpleado();
                    primerPagoEmpleado = (PagoPrestamoEmpleado) agenteDao.obtenPrimerPagoPrestamoEmpleado(pagoPrestEmpl);

                    if (primerPagoEmpleado != null) {
                        PagoPrestamoEmpleado ultimoPagoPrestamoEmpleado = null;
                        System.out.println("Estoy antes obtener el ultimo pago");
                        ultimoPagoPrestamoEmpleado = (PagoPrestamoEmpleado) prestamosDao.obtenerUltimoPagoPrestamoEmpleado(pagoPrestEmpl);
                        System.out.println("Estoy despues de obtener ultimo pago");

                        if (ultimoPagoPrestamoEmpleado != null) {
                            int idPagoActual = ultimoPagoPrestamoEmpleado.getIdPago() + 1;
                            System.out.println("id pago actual" + idPagoActual);
                            Date fechaPagoActual = new Date();
                            pagoPrestEmpl.setCveEmpleado(prestamoEmpl.getCveEmpleado());
                            pagoPrestEmpl.setIdPrestamo(prestamoEmpl.getIdPrestamo());
                            pagoPrestEmpl.setIdPago(idPagoActual);
                            pagoPrestEmpl.setMontoPagado(prestamoEmpl.getImportePagosRegular());
                            pagoPrestEmpl.setFechaPago(fechaPagoActual);
                            prestamosDao.insertarNuevoPagoPrestamoEmpleado(pagoPrestEmpl);

                            //edicion

                            int pagosTotalesDelPrestamo = prestamoEmpl.getNumPagosTotales();
                            if (idPagoActual == pagosTotalesDelPrestamo) {
                                prestamosDao.actualizaPrestamoEmpleado(prestamoEmpl);
                            }
                        }



                    /*int pagoRealAux=prestamoEmpl.getNumPagosTotales();
                    int idPagoActual=pagoPrestEmpl.getIdPago();
                    if(idPagoActual==pagoRealAux){
                    prestamoEmpl.setCveEmpleado(empleado.getCveEmpleado());
                    prestamoEmpl.setIdPrestamo(idPagoActual);
                    prestamosDao.actualizaPrestamoEmpleado(prestamoEmpl);

                    }*/

                    } else {
                        System.out.println("Entrando else de comisiones command");
                        if (prestamoEmpl.getNumQuincenaAplicacion() == numQnaComision) {
                            System.out.println("No insertare pagos");
                        } else {
                            int idPagoActual = 1;
                            Date fechaPagoActual = new Date();
                            pagoPrestEmpl.setCveEmpleado(prestamoEmpl.getCveEmpleado());
                            pagoPrestEmpl.setIdPrestamo(prestamoEmpl.getIdPrestamo());
                            pagoPrestEmpl.setIdPago(idPagoActual);
                            pagoPrestEmpl.setMontoPagado(prestamoEmpl.getImportePagosRegular());
                            pagoPrestEmpl.setFechaPago(fechaPagoActual);
                            prestamosDao.insertarNuevoPagoPrestamoEmpleado(pagoPrestEmpl);

                        }
                    }
                }
                bandera = true;
            }
        }
        return bandera;


    }

    public IAgenteDao getAgenteDao() {
        return agenteDao;
    }

    public void setAgenteDao(IAgenteDao agenteDao) {
        this.agenteDao = agenteDao;
    }

    public IPrestamosDao getPrestamosDao() {
        return prestamosDao;
    }

    public void setPrestamosDao(IPrestamosDao prestamosDao) {
        this.prestamosDao = prestamosDao;
    }

    public GenerarPagoComisionesCommand getComisionesCommand() {
        return comisionesCommand;
    }

    public void setComisionesCommand(GenerarPagoComisionesCommand comisionesCommand) {
        this.comisionesCommand = comisionesCommand;
    }
}



