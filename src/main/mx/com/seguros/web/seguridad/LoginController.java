/*
 * LoginController.java
 *
 * Created on 12 de mayo de 2008, 12:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.seguridad;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author QTX
 */
public class LoginController extends MultiActionController{
    
    /** Creates a new instance of LoginController */
    public ModelAndView mostrarPagina(HttpServletRequest req, HttpServletResponse res) {
		return new ModelAndView("login");	}
    
}
