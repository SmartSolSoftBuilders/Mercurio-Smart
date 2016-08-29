package qtx.component.front.helper.spring;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import org.springframework.web.servlet.view.xslt.AbstractXsltView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import qtx.component.front.helper.bean.CampoHelperBean;
import qtx.component.front.helper.bean.ColumnaHelperBean;
import qtx.component.front.helper.bean.DataHelperBean;
import qtx.component.front.helper.bean.RegistroHelperBean;

public class HelperXsltView extends AbstractXsltView {

	@Override
	protected Source createXsltSource(Map model, String root, HttpServletRequest request, HttpServletResponse response) throws Exception {

		DataHelperBean dataBean = (DataHelperBean)model.get("helper");
		List <ColumnaHelperBean>columnas = dataBean.getColumnas();
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		Element rootEl = doc.createElement(root);		
		rootEl.setAttribute("numregistros",String.valueOf(dataBean.getNumregistros()));
		doc.appendChild(rootEl);
		
		Element tituloEl = doc.createElement("titulo");
		tituloEl.appendChild(doc.createTextNode(dataBean.getTitulo()));
		rootEl.appendChild(tituloEl);
		
		Element funcionEl = doc.createElement("funcion");
		funcionEl.appendChild(doc.createTextNode(dataBean.getFuncion()));
		rootEl.appendChild(funcionEl);
		
		Element colsEl = doc.createElement("columnas");		
		for(ColumnaHelperBean columna : columnas){
			Element colEl = doc.createElement("columna");
			colEl.setAttribute("visible",String.valueOf(columna.getVisible()));
			colEl.setAttribute("columNom",String.valueOf(columna.getColumNom()));
			colEl.setAttribute("control",String.valueOf(columna.getControl()));
			colEl.appendChild(doc.createTextNode(columna.getDescripcion()));
			
			colsEl.appendChild(colEl);
		}
		rootEl.appendChild(colsEl);
		
		List <RegistroHelperBean> registros = dataBean.getRegistros();
		Element regsEl = doc.createElement("registros");
		
		for(RegistroHelperBean registro : registros){
			List <CampoHelperBean> campos = registro.getCampos();
			Element regEl = doc.createElement("registro");
			regEl.setAttribute("numero",String.valueOf(registro.getNumero()));
			
			for(CampoHelperBean campo : campos){
				Element campoEl = doc.createElement("campo");
				campoEl.setAttribute("columNom",campo.getColumNom());
				campoEl.setAttribute("visible",String.valueOf(campo.getVisible()));
				campoEl.appendChild(doc.createTextNode(campo.getValue()));

				regEl.appendChild(campoEl);
			}
			regsEl.appendChild(regEl);
		}
		rootEl.appendChild(regsEl);
		
		return new DOMSource(rootEl);
	}

	public HelperXsltView() {
		super();

	}

}
