/**
* Nombre del Programa : Usuario.java
* Autor                            : Emigdio
* Compania                    : Ultrasist
* Proyecto                      : NSJP                    Fecha: 02/08/2011
* Marca de cambio        : N/A
* Descripcion General    : Describir el objetivo de la clase de manera breve
* Programa Dependiente  :N/A
* Programa Subsecuente :N/A
* Cond. de ejecucion        :N/A
* Dias de ejecucion          :N/A                             Horario: N/A
*                              MODIFICACIONES
*------------------------------------------------------------------------------
* Autor                       :N/A
* Compania               :N/A
* Proyecto                 :N/A                                 Fecha: N/A
* Modificacion           :N/A
*------------------------------------------------------------------------------
*/
package mx.com.seguros.web.seguridad.util;
import java.util.Map;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.User;
/**
 * Describir el objetivo de la clase con punto al final.
 * @version 1.0
 * @author Emigdio
 *
 */

 
public class Usuario extends User {   
 
    private Map userInfo; 
    
    public Usuario(String username, String password, boolean isEnabled, GrantedAuthority[] authorities, Map user) {
	super(username, password, isEnabled, true, true, true, authorities);
	this.setUserInfo(user);
    }   
    public Usuario(String username, String password, boolean isEnabled, GrantedAuthority[] arrayAuths) {       
	super(username, password, isEnabled, true, true, true, arrayAuths);   
    }   
    public Map getUserInfo() {
        return userInfo;
    }  
    public void setUserInfo(Map userInfo) {
        this.userInfo = userInfo;
    }
}

