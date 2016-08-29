package mx.com.seguros.web.seguridad.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.seguros.data.dao.IAgenteDao;
import mx.com.seguros.model.seguridad.Menu;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.acegisecurity.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.dao.DataAccessException;
 
/**
 * DAO de autenticación personalizado para obtener la clave de empleado
 * @version 1.0
 * @author 
 *
 */


public class AutenticacionDaoJdbcImpl extends JdbcDaoImpl {   
    private String[] userInfoObjectTypes;   
    
    private IAgenteDao agenteDao;
    
    public static String ROLES = null;
     @Override
     
    public UserDetails loadUserByUsername(String username) {
	try {
		
		UserDetails user = super.loadUserByUsername(username);
		Long cveEmpleado = getJdbcTemplate().queryForLong("select cveEmpleado from users where username = '"+username+"'");
				
		Map info = new HashMap();
		info.put("cveEmpleado", cveEmpleado.intValue());
		
		info.put("menu", obtenerMenuUsuario(username));
		
		//actualizar el objeto local estático de listado de roles
		
		
		
		cargarRoles(cveEmpleado.intValue());
		
		
		
		
		return new Usuario(user.getUsername(), user.getPassword(), user.isEnabled(), user.getAuthorities(), info);
		
		
	   
		
	} catch (UsernameNotFoundException ex1) {
	    ex1.printStackTrace();
	    throw ex1;
	} catch (DataAccessException ex2) {
	    ex2.printStackTrace();
	    throw ex2;
	}
    }
     
    /**
     * Obtiene el menú de un usuario en base a su nombre de usuario y de acuerdo con los
     * permisos de sus roles asignados 
     * @param username Usuario del cuál obtener el menú
     * @return Conjunto de objetos de menú encontrados
     */
    private List<Menu> obtenerMenuUsuario(String username) {
		
    	 
    	List<Map> resultadosMap = getJdbcTemplate().queryForList(
    	"Select menu.* from menu, menu_rol, role, authorities where "+
        "menu.idMenu = menu_rol.idMenu and "+
        "menu_rol.authority = role.authority and "+
        "role.authority = authorities.authority and "+
        "authorities.username = ? "+
        "order by menu.idMenu asc", 
        new Object[]{username});
    	
    	List<Menu> resultadosMenu = new ArrayList<Menu>();
    	Map<String,String> idsMenu = new HashMap<String,String>();
    	Menu elementoMenu = null;
    	for(Map resultadoMap:resultadosMap){
    		
    		if(idsMenu.containsKey(resultadoMap.get("idMenu").toString())){
    			continue;
    		}
    		
    		elementoMenu = new Menu();
    		
    		elementoMenu.setIdMenu(resultadoMap.get("idMenu").toString());
    		elementoMenu.setIdMenuPadre(resultadoMap.get("idMenuPadre")!=null?resultadoMap.get("idMenuPadre").toString():null);
    		elementoMenu.setDescripcion(resultadoMap.get("descripcion").toString());
    		elementoMenu.setRuta(resultadoMap.get("ruta")!=null?resultadoMap.get("ruta").toString():null);
    		elementoMenu.setTitulo(resultadoMap.get("titulo")!=null?resultadoMap.get("titulo").toString():null);
    		resultadosMenu.add(elementoMenu);
    		idsMenu.put(elementoMenu.getIdMenu(), elementoMenu.getIdMenu());
    	}
    	
    	
    	
    	
    	List<Menu> menuFinal =  acomodarMenu(resultadosMenu,null);
    	return menuFinal;
    	
	}

    /**
     * Estructura de manera jerárquica un conjunto de elementos de menú de forma que sea más fácil su
     * representación en la capa de vista
     * @param resultadosMenu Lista de menús de forma plana
     * @return Lista de menús jerárquica
     * 
     */
	private List<Menu> acomodarMenu(List<Menu> resultadosMenu,Menu padre) {
		List<Menu> nodosRaiz = new ArrayList<Menu>();
			for(Menu nodo:resultadosMenu){
				
				if(nodo.getIdMenuPadre() == null && padre == null){
					//si es nodo raíz
					nodosRaiz.add(nodo);
					nodo.setSubMenus(acomodarMenu(resultadosMenu.subList(resultadosMenu.indexOf(nodo), resultadosMenu.size()), nodo));
				}else if(nodo.getIdMenuPadre()!=null && padre != null && nodo.getIdMenuPadre().equals(padre.getIdMenu())){
					//si no es nodo raíz y el nodo tiene padre
					nodosRaiz.add(nodo);
					nodo.setSubMenus(acomodarMenu(resultadosMenu.subList(resultadosMenu.indexOf(nodo), resultadosMenu.size()), nodo));
				}
			}
		return nodosRaiz;
	}

	
	
	public void setUserInfoObjectTypes(String[] userInfoObjectTypes) {
	this.userInfoObjectTypes = userInfoObjectTypes;
    }
	/**
	 * Inicializa los roles del sistema
	 */
	public void cargarRoles(int cveEmpleado) {
		StringBuffer rolesTmp = new StringBuffer();
		List<Map> rolesActuales = getJdbcTemplate().queryForList("select authority from role");
		for(Map mapaResult:rolesActuales){
			rolesTmp.append(mapaResult.get("authority").toString() + ",");
		}
		ROLES = rolesTmp.toString().substring(0,rolesTmp.length()-1);
		
		try{
			agenteDao.obtenerAgente(cveEmpleado);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	/**
	 * @return the agenteDao
	 */
	public IAgenteDao getAgenteDao() {
		return agenteDao;
	}

	/**
	 * @param agenteDao the agenteDao to set
	 */
	public void setAgenteDao(IAgenteDao agenteDao) {
		this.agenteDao = agenteDao;
	}
}