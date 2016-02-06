/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.entidad.CServicio;
import ec.edu.espoch.comedor.modelo.MServicio;
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
public class ControladorServicio implements Serializable {
    /*
     Atributos
     */

    private CServicio objServicio;
    private CServicio selObjServicio;
    private ArrayList<CServicio> lstServicios;
    private ArrayList<CServicio> filteredServicios;

    /**
     * Creates a new instance of ControladorServicio
     */
    public ControladorServicio() {
        this.objServicio = new CServicio();
        this.selObjServicio = new CServicio();
        this.lstServicios = new ArrayList<>();
    }

    /*
     */
    public CServicio getObjServicio() {
        return objServicio;
    }

    public void setObjServicio(CServicio objServicio) {
        this.objServicio = objServicio;
    }

    public CServicio getSelObjServicio() {
        return selObjServicio;
    }

    public void setSelObjServicio(CServicio selObjServicio) {
        this.selObjServicio = selObjServicio;
    }

    public ArrayList<CServicio> getLstServicios() {
        return lstServicios;
    }

    public void setLstServicios(ArrayList<CServicio> lstServicios) {
        this.lstServicios = lstServicios;
    }

    public ArrayList<CServicio> getFilteredServicios() {
        return filteredServicios;
    }

    public void setFilteredServicios(ArrayList<CServicio> filteredServicios) {
        this.filteredServicios = filteredServicios;
    }


    /*
     postonstructor se ejecuta luego del constructor
     */
    @PostConstruct
    public void reinit() {
        cargar();
    }

    //<editor-fold desc="Cargar Servicios">
    public void cargar() {
        try {
            this.lstServicios = (ArrayList<CServicio>) MServicio.cargar();
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold desc="Insertar">
    public void insertar() {
        try {
            if (MServicio.insertar(objServicio)) {
                cargar();
                DefaultRequestContext.getCurrentInstance().execute("PF('TservicioCreateDialog').hide()");
                Util.addSuccessMessage("Datos Insertados");
                this.objServicio = new CServicio();
            } else {
                Util.mostrarMensaje("Datos no insertados");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    //</editor-fold>

    public void actualizar() {
        try {
            if (MServicio.modificarServicio(getSelObjServicio())) {
                Util.addSuccessMessage("Datos Modificados");
                DefaultRequestContext.getCurrentInstance().execute("PF('TservicioEditDialog').hide()");
                cargar();

            } else {
                Util.mostrarMensaje("Datos no Modificadoss");
            }

            objServicio = null;
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }

    }

    public void eliminar() {
        try {
            if (MServicio.elimninarServicio(getSelObjServicio().getCodigoservicio())) {
                DefaultRequestContext.getCurrentInstance().execute("PF('TservicioDeleteDialog').hide()");
                Util.addSuccessMessage("Datos Eliminados");
                cargar();

            } else {
                Util.mostrarMensaje("Datos no Eliminados");
            }

            objServicio = null;
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }

    }

}
