package qtx.component.front.helper;

public class ParametrosCamposHelperBean {
    
    private String descripcion;
    private String campoBD;
    private String campoObjeto;
    private String campoForma;
    private char visible;
    private char control;
    
    public String getCampoBD() {
        return campoBD;
    }
    public void setCampoBD(String campoBD) {
        this.campoBD = campoBD;
    }
    public String getCampoForma() {
        return campoForma;
    }
    public void setCampoForma(String campoForma) {
        this.campoForma = campoForma;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public char getVisible() {
        return visible;
    }
    
    public void setVisible(char visible) {
        this.visible = visible;
    }
    
    public char getControl() {
        return control;
    }
    
    public void setControl(char control) {
        this.control = control;
    }

    public String getCampoObjeto() {
        return campoObjeto;
    }

    public void setCampoObjeto(String campoObjeto) {
        this.campoObjeto = campoObjeto;
    }
}
