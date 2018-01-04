package mx.com.seguros.web.seguridad.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.com.seguros.data.dao.IAgenteDao;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.Empleado;
import mx.com.seguros.model.seguridad.Menu;
import mx.com.seguros.model.seguridad.Rol;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.lang.StringUtils;

/**
 * Clase de utilería para realizar operaciones y consultas relacionadas a la seguridad
 * y usuarios del sistema 
 * @version 1.0
 * @author Emigdio Hernández
 *
 */


public class SeguridadUtil {
	
	private IAgenteDao agenteDao;
	/**
	 * Rol de ventas
	 */
	public static String ROL_VENTAS = "rol_ventas";
	/**
	 * Rol de administrador regional
	 */
	public static String ROL_ADMIN = "rol_admin_central";
	/**
	 * Rol de direccción central
	 */
	public static String ROL_DIRECCION = "rol_direccion";
	/**
	 * Operaciones 1
	 */
	public static String ROL_OPERACIONES1 = "rol_op_centrales";
	/**
	 * Operaciones 2
	 */
	public static String ROL_OPERACIONES2 = "rol_operaciones";
	/**
	 * Roles de atención a clientes
	 */
	public static String ROL_ATENCION_CLIENTES = "rol_atencion_clientes";
	public static String ROL_ATENCION_CLIENTES_CENTRAL = "rol_atencion_clientes_central";
	
	public static String ROL_CONSULTA_ESPECIAL = "rol_consulta_especial";
	
	/**
	 * Determina si el usuario tiene el rol de ventas
	 * @return true si el usuario actual tiene el rol de ventas
	 */
	public boolean isRolVentas(){
		if(SecurityContextHolder.getContext() != null && 
				SecurityContextHolder.getContext().getAuthentication() != null){
			GrantedAuthority roles []= SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			for(GrantedAuthority rol:roles){
				if(rol.getAuthority().equals(ROL_VENTAS)){
					return true;
				}
			}
		}
		
		return false;
	}
	/**
	 * Determina si el usuario tiene el rol de administrador regional
	 * @return
	 */
	public boolean isRolAdministrador(){
		if(SecurityContextHolder.getContext() != null && 
				SecurityContextHolder.getContext().getAuthentication() != null){
			GrantedAuthority roles []= SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			if(roles != null){
				for(GrantedAuthority rol:roles){
					if(rol.getAuthority().equals(ROL_ADMIN)){
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	/**
	 * Determina si el usuario tiene el rol de direccion
	 * @return
	 */
	public boolean isRolDireccion(){
		if(SecurityContextHolder.getContext() != null && 
				SecurityContextHolder.getContext().getAuthentication() != null){
			GrantedAuthority roles []= SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			if(roles != null){
				for(GrantedAuthority rol:roles){
					if(rol.getAuthority().equals(ROL_DIRECCION)){
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	/**
	 * Determina si esl usuario es del rol operaciones
	 * @return
	 */
	public boolean isRolOperaciones(){
		if(SecurityContextHolder.getContext() != null && 
				SecurityContextHolder.getContext().getAuthentication() != null){
			GrantedAuthority roles []= SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			if(roles!=null){
				for(GrantedAuthority rol:roles){
					if(rol.getAuthority().equals(ROL_OPERACIONES1) || rol.getAuthority().equals(ROL_OPERACIONES2)){
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	
	/**
	 * Determina si esl usuario es del rol consulta especial
	 * @return
	 */
	
	public boolean isRolConsultaEspecial(){
		if(SecurityContextHolder.getContext() != null && 
				SecurityContextHolder.getContext().getAuthentication() != null){
			GrantedAuthority roles []= SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			for(GrantedAuthority rol:roles){
				if(rol.getAuthority().equals(ROL_CONSULTA_ESPECIAL)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Verifica si tiene el rol de operaciones pero no de oficinas centrales
	 * @return
	 */
	public boolean isRolOperacionesNoCentrales(){
		if(SecurityContextHolder.getContext() != null && 
				SecurityContextHolder.getContext().getAuthentication() != null){
			GrantedAuthority roles []= SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			if(roles!=null){
				for(GrantedAuthority rol:roles){
					if(rol.getAuthority().equals(ROL_OPERACIONES2)){
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	/**
	 * Verifica si el usuario actual cuenta con algún rol de atención a clientes
	 * @return
	 */
	public boolean isRolAntencionClientes(){
		
		if(SecurityContextHolder.getContext() != null && 
				SecurityContextHolder.getContext().getAuthentication() != null){
			GrantedAuthority roles []= SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			if(roles!=null){
				for(GrantedAuthority rol:roles){
					if(rol.getAuthority().equals(ROL_ATENCION_CLIENTES) || rol.getAuthority().equals(ROL_ATENCION_CLIENTES_CENTRAL)){
						return true;
					}
				}
			}
			
		}
		
		return false;
		
	}
	/**
	 * Obtiene un objeto Empleado de la base de datos en base al usuario que ha iniciado sesión en el sistema
	 * 
	 * @return Empleado encontrado
	 */
	public Empleado getEmpleado(){
		Usuario usr = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(usr != null){
			return agenteDao.obtenerEmpleadoPorClave((Integer)usr.getUserInfo().get("cveEmpleado"));
		}
		return null;
	}
	/**
	 * Obtiene el objeto de agente en caso de que el usuario sea del rol de ventas, si no es
	 * del rol de ventas se retorna null
	 * @return
	 */
	public Agente getAgente(){
		Usuario usr = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(usr != null){
			return agenteDao.obtenerAgente(((Integer)usr.getUserInfo().get("cveEmpleado")));
		}
		return null;
	}
	/**
	 * Recupera el usuario actualmente loggeado en el sistema
	 * @return Usuario que ha iniciado sesión
	 */
	public Usuario getUsuario(){
		return (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	
	/**
	 * Método de acceso al campo agenteDao.
	 * @return El valor del campo agenteDao
	 */
	public IAgenteDao getAgenteDao() {
		return agenteDao;
	}

	/**
	 * Asigna el valor al campo agenteDao.
	 * @param agenteDao el valor agenteDao a asignar
	 */
	public void setAgenteDao(IAgenteDao agenteDao) {
		this.agenteDao = agenteDao;
	}

	/**
	 * Crea una cadena con la declaración en forma de lista 
	 * de html del menú del usuario
	 * @return
	 */
	public static String obtenerMenu(HttpServletRequest request){
		Usuario usr = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		StringBuffer menu = new  StringBuffer();
		
		List<Menu> elementosRaiz = (List<Menu>)usr.getUserInfo().get("menu");
		
		if(elementosRaiz != null){
			menu.append("<ul class='sf-menu'>\n");
			for(Menu nodoRaiz:elementosRaiz){
				
				menu.append(pintarNodo(nodoRaiz,request));
				
			}
			menu.append("</ul>\n");
			
		}
		
		return menu.toString();
	}
	/**
	 * Pinta un solo nodo envuelto en etiquetas <li> y se invoca
	 * recursivamente para pintar sus hijos
	 * @param nodo nodo a pintar
	 * @return Cadena con la declaración del nodo
	 */
	private static Object pintarNodo(Menu nodo, HttpServletRequest request) {
		
		StringBuffer menu = new StringBuffer();
		menu.append("<li>\n");
		if(StringUtils.isNotBlank(nodo.getRuta())){
			menu.append("<a href='"+request.getContextPath()+nodo.getRuta()+"'>"+nodo.getTitulo()+"</a>\n");	
		}else{
			menu.append("<a href='#'>"+nodo.getTitulo()+"</a>\n");
		}
		if(nodo.getSubMenus()!=null && !nodo.getSubMenus().isEmpty()){
			menu.append("<ul>\n");
				for(Menu submenu:nodo.getSubMenus()){
					menu.append(pintarNodo(submenu,request));
				}
			menu.append("</ul>\n");
		}
		menu.append("</li>\n");
		
		
		return menu.toString();
	}
}
