/*
 * HelperDao.java
 *
 * Created on 23 de agosto de 2007, 10:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package qtx.component.front.helper.data;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author QTX
 */
public interface HelperDao {
    
    List getData(String id);
    
    List getData(String id, Object parametros);
    
    List getData(String id, HashMap parametros);
    
}
