/*
 * MenuDTO.java
 *
 * Created on 5 de diciembre de 2006, 11:12 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package test.data;

import java.util.List;

/**
 *
 * @author QTX
 */
public class MenuDTO {
    private String idMenu;
    private String idParentMenu;
    private String descripcion;
    private String link;
    private String perfil;
    private String nivelMenu;
    
    /** Creates a new instance of MenuDTO */
    public MenuDTO() {
    }
    
    public MenuDTO(String idMenu, String idParentMenu, String descripcion, String link, String perfil, String nivelMenu) {
        this.idMenu = idMenu;
        this.idParentMenu = idParentMenu;
        this.descripcion = descripcion;
        this.link = link;
        this.perfil = perfil;
        this.nivelMenu = nivelMenu;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getIdParentMenu() {
        return idParentMenu;
    }

    public void setIdParentMenu(String idParentMenu) {
        this.idParentMenu = idParentMenu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getNivelMenu() {
        return nivelMenu;
    }

    public void setNivelMenu(String nivelMenu) {
        this.nivelMenu = nivelMenu;
    }
    
}
