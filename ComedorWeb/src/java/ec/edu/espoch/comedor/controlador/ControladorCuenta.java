/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.entidad.CCuenta;
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
public class ControladorCuenta {
    
     private CCuenta objCuenta;// st objeto para insertar
    private CCuenta selCuenta;//st objeto seleccionar
    private ArrayList <CCuenta> lstCuenta;

    public ControladorCuenta() {
    }

    public ControladorCuenta(CCuenta objCuenta, CCuenta selCuenta, ArrayList<CCuenta> lstCuenta) {
        this.objCuenta = objCuenta;
        this.selCuenta = selCuenta;
        this.lstCuenta = lstCuenta;
    }

    public CCuenta getObjCuenta() {
        return objCuenta;
    }

    public void setObjCuenta(CCuenta objCuenta) {
        this.objCuenta = objCuenta;
    }

    public CCuenta getSelCuenta() {
        return selCuenta;
    }

    public void setSelCuenta(CCuenta selCuenta) {
        this.selCuenta = selCuenta;
    }

    public ArrayList<CCuenta> getLstCuenta() {
        return lstCuenta;
    }

    public void setLstCuenta(ArrayList<CCuenta> lstCuenta) {
        this.lstCuenta = lstCuenta;
    }
 @PostConstruct
    public void rinit(){
    cargarCuenta();//Inicializa metodos
    }
    
     private void cargarCuenta()
    {
    try{
        this.lstCuenta=Mcuenta.obtenerCuenta();
        }catch(Exception e){
            System.out.println("e"+e.getMessage().toString());
    }
    }
     
     public void insertarCuenta() {
        try {
            if (Mcuenta.insertarCuenta(objCuenta)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglInsertCuenta.hide()");//esto se debe cambiar deacuerdo a la interfaz del usuario
                cargarCuenta();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no insertados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
      public void actualizarCuenta() {
        try {
            if (Mcuenta.modificarCuenta(selCuenta)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos actualizados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglUpdatCuenta.hide()");
                this.selCuenta=new CCuenta();
                cargarCuenta();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no actualizados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
      public void eliminarCuenta() {
        try {
            if (Mcuenta.elminarCuenta(selCuenta)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos eliminados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglDeletCuenta.hide()");
                this.selCuenta=new CCuenta();
                cargarCuenta();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no eliminados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
     
     public void buscarCuentaId(int id) {
        try {
            if (objCuenta.getIdCuenta()==id) {
                Mcuenta.obtenerObjetoCuentaid(id);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Si existe la cuenta del Cliente"));
                DefaultRequestContext.getCurrentInstance().execute("wglBuscarCuenta.hide()");
                this.selCuenta=new CCuenta();
                cargarCuenta();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("No existe la cuenta del Cliente"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }

      
}