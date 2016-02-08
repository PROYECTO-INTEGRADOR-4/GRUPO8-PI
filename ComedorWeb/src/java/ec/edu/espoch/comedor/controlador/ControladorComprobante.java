/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.entidad.CComprobante;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Usuario
 */
@ViewScoped
public class ControladorComprobante implements Serializable {

    private CComprobante objCS;
    private CComprobante selObjCS;
    private int precio;

    /**
     * Creates a new instance of ControladorClienteServicio
     */
    public ControladorComprobante() {
        this.objCS = new CComprobante();
        this.selObjCS = new CComprobante();

    }

    public CComprobante getObjCS() {
        return objCS;
    }

    public void setObjCS(CComprobante objCS) {
        this.objCS = objCS;
    }

    public CComprobante getSelObjCS() {
        return selObjCS;
    }

    public void setSelObjCS(CComprobante selObjCS) {
        this.selObjCS = selObjCS;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int num() {
        float a = (float) 4.5;
        return Math.round(a);
    }
}
