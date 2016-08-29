/*
 * IndexController.java
 *
 * Created on 12 de mayo de 2008, 11:38 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.seguridad;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
/**
 *
 * @author QTX
 */
public class IndexAdminController extends MultiActionController {
    
    /** Creates a new instance of IndexController */
    public ModelAndView mostrarPaginaAdmin(HttpServletRequest arg0, HttpServletResponse arg1) {
		return new ModelAndView("index_admin");	}

    
}
