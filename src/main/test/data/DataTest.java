package test.data;

import java.util.ArrayList;
import java.util.List;

import qtx.component.front.helper.bean.CampoHelperBean;
import qtx.component.front.helper.bean.ColumnaHelperBean;
import qtx.component.front.helper.bean.DataHelperBean;
import qtx.component.front.helper.bean.RegistroHelperBean;

public class DataTest {

	public static DataHelperBean generarDataBean(){
		CampoHelperBean campo1 = new CampoHelperBean();
		CampoHelperBean campo2 = new CampoHelperBean();
		CampoHelperBean campo3 = new CampoHelperBean();
		
		campo1.setColumNom("datoFormA");
		campo1.setValue("abcde");
		campo1.setVisible('1');
		campo2.setColumNom("datoFormB");
		campo2.setValue("fg");
		campo2.setVisible('1');
		campo3.setColumNom("datoFormC");
		campo3.setValue("hij");
		campo3.setVisible('1');
		
		List<CampoHelperBean> lista1 = new ArrayList<CampoHelperBean>();
		lista1.add(campo1);
		lista1.add(campo2);
		lista1.add(campo3);
		
		List<CampoHelperBean> lista2 = new ArrayList<CampoHelperBean>();
		lista2.add(campo1);
		lista2.add(campo2);
		lista2.add(campo3);
		
		List<CampoHelperBean> lista3 = new ArrayList<CampoHelperBean>();
		lista3.add(campo1);
		lista3.add(campo2);
		lista3.add(campo3);
		
		RegistroHelperBean reg1 = new RegistroHelperBean();
		reg1.setNumero(1);
		reg1.setCampos(lista1);		
		RegistroHelperBean reg2 = new RegistroHelperBean();
		reg2.setNumero(2);
		reg2.setCampos(lista2);		
		RegistroHelperBean reg3 = new RegistroHelperBean();
		reg3.setNumero(3);
		reg3.setCampos(lista3);		
		
		List<RegistroHelperBean> listRegs = new ArrayList<RegistroHelperBean>();
		listRegs.add(reg1);
		listRegs.add(reg2);
		listRegs.add(reg3);
		
		ColumnaHelperBean col1 = new ColumnaHelperBean();
		col1.setVisible('1');
		col1.setDescripcion("Columna A");
		col1.setControl('1');
		col1.setColumNom("datoFormA");
		
		ColumnaHelperBean col2 = new ColumnaHelperBean();
		col2.setVisible('1');
		col2.setDescripcion("Columna B");
		col2.setControl('0');
		col2.setColumNom("datoFormB");
		
		ColumnaHelperBean col3 = new ColumnaHelperBean();
		col3.setVisible('1');
		col3.setDescripcion("Columna C");
		col3.setControl('0');
		col3.setColumNom("datoFormC");
		
		List<ColumnaHelperBean> listCols = new ArrayList<ColumnaHelperBean>();
		listCols.add(col1);
		listCols.add(col2);
		listCols.add(col3);
		
		DataHelperBean data = new DataHelperBean();
		data.setTitulo("Test Data de Helper.");
		data.setColumnas(listCols);
		data.setRegistros(listRegs);
		data.setNumregistros(3);
		
		return data;
	}
}
