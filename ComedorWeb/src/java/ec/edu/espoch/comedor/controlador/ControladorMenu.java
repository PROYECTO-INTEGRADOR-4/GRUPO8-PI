/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;
import ec.edu.espoch.comedor.entidad.*;
import ec.edu.espoch.comedor.modelo.*;
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
public class ControladorMenu {
    private CMenu objMenu;// st objeto para insertar
    private CMenu selMenu;//st objeto seleccionar
    private ArrayList <CMenu> lstMenu;

    public ControladorMenu() {
    }

    public ControladorMenu(CMenu objMenu, CMenu selMenu, ArrayList<CMenu> lstMenu) {
        this.objMenu = objMenu;
        this.selMenu = selMenu;
        this.lstMenu = lstMenu;
    }

    public CMenu getObjMenu() {
        return objMenu;
    }

    public void setObjMenu(CMenu objMenu) {
        this.objMenu = objMenu;
    }

    public CMenu getSelMenu() {
        return selMenu;
    }

    public void setSelMenu(CMenu selMenu) {
        this.selMenu = selMenu;
    }

    public ArrayList<CMenu> getLstMenu() {
        return lstMenu;
    }

    public void setLstMenu(ArrayList<CMenu> lstMenu) {
        this.lstMenu = lstMenu;
    }
    
    @PostConstruct
    public void rinit(){
    cargarMenu();//Inicializa metodos
    }
    
     private void cargarMenu()
    {
    try{
        this.lstMenu=MMenu.obtenerMenu();
        }catch(Exception e){
            System.out.println("e"+e.getMessage().toString());
    }
    }
     
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
                DefaultRequestContext.getCurrentInstance().execute("wglUpdatCliente.hide()");
                this.selMenu=new CMenu();
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
    
      
}
