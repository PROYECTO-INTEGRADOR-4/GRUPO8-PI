/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.entidad.CPrecio;
import ec.edu.espoch.comedor.entidad.CServicio;
import ec.edu.espoch.comedor.entidad.CTipo;
import ec.edu.espoch.comedor.modelo.MPrecio;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Tupac
 */
@ManagedBean
@ViewScoped
public class ControladorPrecio implements Serializable {
    /*
     Atributos
     */

    private CPrecio objCPrecio;
    private CPrecio selObjPrecio;
    private ArrayList<CPrecio> lstPrecios;
    private ArrayList<CPrecio> filteredPrecios;
    private final HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private final ControladorUserLogin loginBean = (ControladorUserLogin) session.getAttribute("controladorUserLogin");

    /**
     * Creates a new instance of ControladorPrecio
     */
    public ControladorPrecio() {
        this.objCPrecio = new CPrecio();
        this.selObjPrecio = new CPrecio();
        this.lstPrecios = new ArrayList<>();
    }

    public CPrecio getObjCPrecio() {
        return objCPrecio;
    }

    public void setObjCPrecio(CPrecio objCPrecio) {
        this.objCPrecio = objCPrecio;
    }

    public CPrecio getSelObjPrecio() {
        return selObjPrecio;
    }

    public void setSelObjPrecio(CPrecio selObjPrecio) {
        this.selObjPrecio = selObjPrecio;
    }

    public ArrayList<CPrecio> getLstPrecios() {
        return lstPrecios;
    }

    public void setLstPrecios(ArrayList<CPrecio> lstPrecios) {
        this.lstPrecios = lstPrecios;
    }

    public ArrayList<CPrecio> getFilteredPrecios() {
        return filteredPrecios;
    }

    public void setFilteredPrecios(ArrayList<CPrecio> filteredPrecios) {
        this.filteredPrecios = filteredPrecios;
    }

    @PostConstruct
    public void reinit() {
        CServicio objS = new CServicio();
        this.objCPrecio.setObjServicio(objS);
        this.selObjPrecio.setObjServicio(objS);
        CTipo objT = new CTipo();
        this.objCPrecio.setObjTipo(objT);
        this.selObjPrecio.setObjTipo(objT);
        cargar();
    }

    public void cargar() {
        try {
            this.lstPrecios = (ArrayList<CPrecio>) MPrecio.cargar();
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {

            if (MPrecio.insertar(objCPrecio)) {

                DefaultRequestContext.getCurrentInstance().execute("PF('TprecioCreateDialog').hide()");
                Util.addSuccessMessage("Datos Insertados");
                objCPrecio.setDblValor(0);
                cargar();
            } else {
                Util.addErrorMessage("Datos no insertados");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            if (MPrecio.modificarPrecio(selObjPrecio)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos actualizados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("PF('TprecioEditDialog').hide()");
                objCPrecio.setDblValor(0);
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

    public void eliminar() {
        try {
            if (MPrecio.elminarPrecio(selObjPrecio)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos eliminados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("PF('TprecioDeleteDialog').hide()");
                objCPrecio.setDblValor(0);
                cargar();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no eliminados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }

    public String precio(int intSevicioId) {
        String precio = "";
        try {
            int intTipoId = 0;
            if (loginBean.getRolCarrera().getNombreRol().equals("EST")) //Si es estudiante
            {
                intTipoId = 1;
            } else {
                intTipoId = 2;
            }
            precio = Double.toString(MPrecio.precio(intSevicioId, intTipoId));
            if (precio.equals("0.0")) {
                precio = "No definido";
            } else {
                precio = "$ " + precio;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return precio;
    }

    public double precioVent(int intSevicioId) {
        double precio = 0;
        try {
            int intTipoId = 0;
            if (loginBean.getRolCarrera().getNombreRol().equals("EST")) //Si es estudiante
            {
                intTipoId = 1;
            } else {  //No esestudiante
                intTipoId = 2;
            }
            precio = MPrecio.precio(intSevicioId, intTipoId);

        } catch (Exception e) {
            e.getMessage();
        }
        return precio;
    }
}
