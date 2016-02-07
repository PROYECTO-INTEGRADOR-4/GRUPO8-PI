/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.entidad.*;
import ec.edu.espoch.comedor.modelo.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.DefaultRequestContext;

/**
 *
 * @author ANGELA
 */
@ManagedBean
@ViewScoped
public final class ControladorMenu implements Serializable {

    private CMenu objMenu;
    private CMenu selObjMenu;
    private ArrayList<CMenu> lstMenus;
    private ArrayList<CServicio> filteredMenus;
    private int id;

    public ControladorMenu() {
        this.objMenu = new CMenu();
        this.selObjMenu = new CMenu();
        this.lstMenus = new ArrayList<>();
    }

    public CMenu getObjMenu() {
        return objMenu;
    }

    public void setObjMenu(CMenu objMenu) {
        this.objMenu = objMenu;
    }

    public CMenu getSelObjMenu() {
        return selObjMenu;
    }

    public void setSelObjMenu(CMenu selObjMenu) {
        this.selObjMenu = selObjMenu;
    }

    public ArrayList<CMenu> getLstMenus() {
        cargarMenu();
        return lstMenus;
    }

    public void setLstMenus(ArrayList<CMenu> lstMenus) {
        this.lstMenus = lstMenus;
    }

    public ArrayList<CServicio> getFilteredMenus() {
        return filteredMenus;
    }

    public void setFilteredMenus(ArrayList<CServicio> filteredMenus) {
        this.filteredMenus = filteredMenus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PostConstruct
    public void rinit() {
        // cargarMenu();//Inicializa metodos
    }

    private void cargarMenu() {
        try {
            this.lstMenus = MMenu.obtenerMenu(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void eliminar() {
        int a = 0;
    }
    /*
     public void insertarMenu() {
     try {
     if (MMenu.insertarMenu(objMenu)) {
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
     DefaultRequestContext.getCurrentInstance().execute("wglInsertMenu.hide()");//esto se debe cambiar deacuerdo a la interfaz del usuario
     cargarMenu();
     } else {
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage("Fracaso", new FacesMessage("Datos no insertados"));
     }
     } catch (Exception e) {
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage("Exito", new FacesMessage(e.getMessage()));
     }
     }

     public void actualizarMenu() {
     try {
     if (MMenu.modificarMenu(selMenu)) {
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage("Exito", new FacesMessage("Datos actualizados correctamente"));
     DefaultRequestContext.getCurrentInstance().execute("wglUpdatMenu.hide()");
     this.selMenu = new CMenu();
     cargarMenu();
     } else {
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage("Fracaso", new FacesMessage("Datos no actualizados"));
     }
     } catch (Exception e) {
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage("Exito", new FacesMessage(e.getMessage()));
     }
     }

     public void eliminarMenu() {
     try {
     if (MMenu.elminarMenu(selMenu)) {
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage("Exito", new FacesMessage("Datos eliminados correctamente"));
     DefaultRequestContext.getCurrentInstance().execute("wglDeletMenu.hide()");
     this.selMenu = new CMenu();
     cargarMenu();
     } else {
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage("Fracaso", new FacesMessage("Datos no eliminados"));
     }
     } catch (Exception e) {
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage("Exito", new FacesMessage(e.getMessage()));
     }
     }
     */
}
