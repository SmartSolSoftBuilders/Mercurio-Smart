/*
 * HelperModelProvider.java
 *
 * Created on 22 de agosto de 2007, 11:15 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package qtx.component.front.helper.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import qtx.component.front.helper.ParametrosCamposHelperBean;
import qtx.component.front.helper.ParametrosHelperBean;
import qtx.component.front.helper.ParametrosHelperConstants;
import qtx.component.front.helper.data.HelperDao;
import test.data.MenuDTO;

/**
 *
 * @author QTX
 */
public class HelperModelProvider {
    
    private List listadoPrueba;
    private HelperDao helperDao;
    /** Creates a new instance of HelperModelProvider */
    public HelperModelProvider() {
        /** Bean de prueba **/
        MenuDTO dto1 = new MenuDTO("idMenu1","idParentMenu1","description1","link1","perfil1","nivelMenu1");
        MenuDTO dto2 = new MenuDTO("idMenu2","idParentMenu2","description2","link2","perfil2","nivelMenu2");
        MenuDTO dto3 = new MenuDTO("idMenu3","idParentMenu3","description3","link3","perfil3","nivelMenu3");
        MenuDTO dto4 = new MenuDTO("idMenu4","idParentMenu4","description4","link4","perfil4","nivelMenu4");
        
        listadoPrueba = new ArrayList();
        listadoPrueba.add(dto1);
        listadoPrueba.add(dto2);
        listadoPrueba.add(dto3);
        listadoPrueba.add(dto4);
    }
    
    public DataHelperBean getModel(ParametrosHelperBean parametrosBean) throws Exception{
        List resultadoBusqueda = new ArrayList();
        HashMap map = parametrosBean.getParametrosQuery();
        if(map.size()>0){
            resultadoBusqueda = helperDao.getData(parametrosBean.getNombreQuery(), map);
        } else{
            resultadoBusqueda = helperDao.getData(parametrosBean.getNombreQuery());
        }
        
        List<ParametrosCamposHelperBean> camposHelper = parametrosBean.getCamposHelper();
        
        DataHelperBean dataBean = new DataHelperBean();
        dataBean.setTitulo(parametrosBean.getTituloHelper());
        dataBean.setFuncion(parametrosBean.getFuncionNotificacion());
        dataBean.setNumregistros(listadoPrueba.size());
        List<ColumnaHelperBean> columnas = new ArrayList<ColumnaHelperBean>();
        
        for(ParametrosCamposHelperBean campoHelper  : camposHelper){
            ColumnaHelperBean columna = new ColumnaHelperBean();
            columna.setColumNom(campoHelper.getCampoForma());
            columna.setControl(campoHelper.getControl());
            columna.setDescripcion(campoHelper.getDescripcion());
            columna.setVisible(campoHelper.getVisible());
            
            columnas.add(columna);
        }
        dataBean.setColumnas(columnas);
        
        List<RegistroHelperBean> registros = new ArrayList<RegistroHelperBean>();
        
        int numregistro = 1;
        for(Object beanPrueba : resultadoBusqueda) {
            RegistroHelperBean registro = new RegistroHelperBean();
            registro.setNumero(numregistro++);
            
            List<CampoHelperBean> campos = new ArrayList<CampoHelperBean>();
            for(ParametrosCamposHelperBean campoHelper  : camposHelper){
                CampoHelperBean campo = new CampoHelperBean();
                campo.setColumNom(campoHelper.getCampoForma());
                campo.setVisible(campoHelper.getVisible());
                Object value = PropertyUtils.getNestedProperty(beanPrueba,campoHelper.getCampoObjeto());
                if(value != null){
                    if(value.getClass()==Date.class){
                        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                        campo.setValue(sd.format(value));
                    } else {
                        campo.setValue(value.toString());
                    }
                } else {
                    campo.setValue(ParametrosHelperConstants.VALOR_NO_ENCONTRADO);
                }
                
                campos.add(campo);
            }
            registro.setCampos(campos);
            registros.add(registro);
        }
        dataBean.setRegistros(registros);
        
        return dataBean;
    }
    
    public void setHelperDao(HelperDao helperDao) {
        this.helperDao = helperDao;
    }
    
}
