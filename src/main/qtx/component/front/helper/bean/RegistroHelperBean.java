package qtx.component.front.helper.bean;

import java.util.List;

public class RegistroHelperBean {

	private int numero;
	private List<CampoHelperBean> campos;
	
	public List<CampoHelperBean> getCampos() {
		return campos;
	}
	public void setCampos(List<CampoHelperBean> campos) {
		this.campos = campos;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
