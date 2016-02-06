/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.entidad.CCuenta;
import ec.edu.espoch.comedor.entidad.CDetalleCuenta;

import ec.edu.espoch.comedor.entidad.CTipoTransacion;
import ec.edu.espoch.comedor.modelo.MDetalleCuenta;
import ec.edu.espoch.comedor.modelo.MTipoTransaccion;
import ec.edu.espoch.comedor.modelo.Mcuenta;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.context.DefaultRequestContext;

/**
 *
 * @author SYSTEMarket-pc
 */

@ManagedBean
@ViewScoped
public class ComtroladorDetalleCuenta {
     private CDetalleCuenta objDetalle;
    private CDetalleCuenta selObjDetalle;
    private ArrayList<CDetalleCuenta> lstDetalleCuenta;
    private ArrayList<CCuenta> lstCuenta;
    private int cuenta;
    private int tipo;
    private ArrayList<CTipoTransacion> lstTipoTransaccion;

    public ComtroladorDetalleCuenta() throws Exception {
        
        this.objDetalle = new CDetalleCuenta();
        this.lstDetalleCuenta= new ArrayList<CDetalleCuenta>();
        this.selObjDetalle = new CDetalleCuenta();
        cargarCuenta();
        cargarTipo();
       
    }  

    public ComtroladorDetalleCuenta(CDetalleCuenta objDetalle, CDetalleCuenta selObjDetalle, ArrayList<CDetalleCuenta> lstDetalleCuenta, ArrayList<CCuenta> lstCuenta, int cuenta, int tipo, ArrayList<CTipoTransacion> lstTipoTransaccion) {
        this.objDetalle = objDetalle;
        this.selObjDetalle = selObjDetalle;
        this.lstDetalleCuenta = lstDetalleCuenta;
        this.lstCuenta = lstCuenta;
        this.cuenta = cuenta;
        this.tipo = tipo;
        this.lstTipoTransaccion = lstTipoTransaccion;
    }

    public CDetalleCuenta getObjDetalle() {
        return objDetalle;
    }

    public void setObjDetalle(CDetalleCuenta objDetalle) {
        this.objDetalle = objDetalle;
    }

    public CDetalleCuenta getSelObjDetalle() {
        return selObjDetalle;
    }

    public void setSelObjDetalle(CDetalleCuenta selObjDetalle) {
        this.selObjDetalle = selObjDetalle;
    }

    public ArrayList<CDetalleCuenta> getLstDetalleCuenta() {
        return lstDetalleCuenta;
    }

    public void setLstDetalleCuenta(ArrayList<CDetalleCuenta> lstDetalleCuenta) {
        this.lstDetalleCuenta = lstDetalleCuenta;
    }

    public ArrayList<CCuenta> getLstCuenta() {
        return lstCuenta;
    }

    public void setLstCuenta(ArrayList<CCuenta> lstCuenta) {
        this.lstCuenta = lstCuenta;
    }

    public int getCuenta() {
        return cuenta;
    }
public void cargarCuenta() throws Exception{

    ArrayList<CCuenta> lst=new ArrayList<CCuenta>();
    lst=Mcuenta.obtenerCuenta();
    lstCuenta=lst;
       
}
    
     public void cargarTipo() throws Exception{

    ArrayList<CTipoTransacion> lst=new ArrayList<CTipoTransacion>();
    lst=MTipoTransaccion.obtenertran();
    lstTipoTransaccion= lst;
       
}
    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ArrayList<CTipoTransacion> getLstTipoTransaccion() {
        return lstTipoTransaccion;
    }

    public void setLstTipoTransaccion(ArrayList<CTipoTransacion> lstTipoTransaccion) {
        this.lstTipoTransaccion = lstTipoTransaccion;
    }
    
     @PostConstruct
    public void reinit() {
        cargar();
    }
    
    
 public void cargar() {
        try {
            this.lstDetalleCuenta = MDetalleCuenta.obtenerDetalle();
            this.selObjDetalle=this.lstDetalleCuenta.get(0);
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }
 
  public void insertar() {
        try {
            objDetalle.setObjCuenta(Mcuenta.obtenerObjetoCuentaid(cuenta));
            objDetalle.setObjTipoTransacion(MTipoTransaccion.obtenerObjetoTra(tipo));
            if (MDetalleCuenta.insertarDetalleC(objDetalle)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglInsertar.hide()");//esto se debe cambiar deacuerdo a la interfaz del usuario
                cargar();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no insertados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
      public void actualizar() {
        try {
            if (MDetalleCuenta.modificarDetalle(selObjDetalle)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos actualizados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglUpdate.hide()");
                
               
                cargar();
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

