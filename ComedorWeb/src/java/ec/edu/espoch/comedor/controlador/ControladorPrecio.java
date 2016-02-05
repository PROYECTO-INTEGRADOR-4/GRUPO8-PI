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
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
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
                //this.objCPrecio = new CPrecio();
                cargar();
            } else {
                Util.addErrorMessage("Datos no insertados");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
}
