package qtx.component.front.helper;

import com.mysql.jdbc.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ParametrosHelperRequestBinder implements ParametrosHelperBinder {

	private static Log logger = LogFactory.getLog(ParametrosHelperRequestBinder.class);
	
	public ParametrosHelperBean bind(Object parametros) {
		ParametrosHelperBean bean = new ParametrosHelperBean();
		HttpServletRequest request = (HttpServletRequest)parametros;

		String nombre = request.getParameter(ParametrosHelperConstants.PARAM_NOMBRE);
		String titulo = request.getParameter(ParametrosHelperConstants.PARAM_TITULO);
		String campos = request.getParameter(ParametrosHelperConstants.PARAM_CAMPOS);
		String paramsQuery = request.getParameter(ParametrosHelperConstants.PARAM_PARAMETROS);
		String funcionNotificacion = request.getParameter(ParametrosHelperConstants.PARAM_FUNCION_NOTIFICACION);
		bean.setNombreQuery(nombre);
		bean.setTituloHelper(titulo);
		bean.setParametrosQuery(this.bindParametrosToList(paramsQuery));
		bean.setCamposHelper(this.bindCamposToList(campos));
		bean.setFuncionNotificacion(funcionNotificacion);
		return bean;
	}
	
	private String[] bindToArrayString(String paramsQuery, String separ) {
		StringTokenizer tokens = new StringTokenizer(paramsQuery,separ);
		String[] aTokens = new String[tokens.countTokens()];
		int i = 0;
		logger.debug("---- bindToArrayString");
		while(tokens.hasMoreTokens()){
			logger.debug("------" + aTokens[i]);
			aTokens[i++] = tokens.nextToken();
		}
		return aTokens;
	}
	
	private List<ParametrosCamposHelperBean> bindCamposToList(String campos){
		List<ParametrosCamposHelperBean> lista = new ArrayList<ParametrosCamposHelperBean>();
		String[] aTokens = this.bindToArrayString(campos,",");
		
		for(int i=0 ;i<aTokens.length; i++){
			String[] fTokens = this.bindToArrayString(aTokens[i],":");
			ParametrosCamposHelperBean cbean = new ParametrosCamposHelperBean();
			cbean.setDescripcion(fTokens[0]);
			cbean.setCampoBD(fTokens[1]);
                        cbean.setCampoObjeto(fTokens[2]);
			cbean.setCampoForma(fTokens[3]);
                        cbean.setVisible(fTokens[4].charAt(0));
                        cbean.setControl(fTokens[5].charAt(0));
                        
			lista.add(cbean);
		}
		
		return lista;
	}
        
        private HashMap bindParametrosToList(String parametros){
		HashMap map = new HashMap();
		String[] aTokens = this.bindToArrayString(parametros,",");
		
		for(int i=0 ;i<aTokens.length; i++){
			String[] fTokens = this.bindToArrayString(aTokens[i],":");

			map.put(fTokens[0],fTokens.length>1?fTokens[1]:"");
		}
		
		return map;
	}

}
