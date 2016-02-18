/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.entidad.*;
import ec.edu.espoch.comedor.modelo.MReporte;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ANGELA
 */
@ManagedBean
@ViewScoped
@Named("controladorReporte")
public class ControladorReporte implements Serializable {

    /**
     * Creates a new instance of ControladorReporte
     */
    private CReporte objRep;// st objeto para insertar
    private CReporte selRep;//st objeto seleccionar
    private ArrayList<CReporte> lstRep;

    public ControladorReporte() {
        this.objRep = new CReporte();
        this.selRep = new CReporte();
        this.lstRep = new ArrayList<>();
    }

    public CReporte getObjRep() {
        return objRep;
    }

    public void setObjRep(CReporte objRep) {
        this.objRep = objRep;
    }

    public CReporte getSelRep() {
        return selRep;
    }

    public void setSelRep(CReporte selRep) {
        this.selRep = selRep;
    }

    public ArrayList<CReporte> getLstRep() {
        return lstRep;
    }

    public void setLstRep(ArrayList<CReporte> lstRep) {
        this.lstRep = lstRep;
    }

    @PostConstruct
    public void reinit() {
      //  cargarAlmuerzo();
        // cargarDesayuno();
    }

    public void cargarAlmuerzo() {
        try {
            this.lstRep = MReporte.obtenerAlmuerzo();
        } catch (Exception e) {
            System.out.println("e" + e.getMessage().toString());
        }
    }

    public void cargarDesayuno() {
        try {
            this.lstRep = MReporte.obtenerDesayuno();
        } catch (Exception e) {
            System.out.println("e" + e.getMessage().toString());
        }
    }

}
