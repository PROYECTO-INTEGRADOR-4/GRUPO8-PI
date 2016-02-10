/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.entidad.CComprobante;
import ec.edu.espoch.comedor.modelo.MComprobante;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Usuario
 */
@ViewScoped
public class ControladorComprobante implements Serializable {

    private CComprobante objCS;
    private CComprobante selObjCS;

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

    public int num() {
        float a = (float) 4.5;
        return Math.round(a);
    }

    //<editor-fold desc="Insertar">
    public void insertar() {
        try {
            if (MComprobante.insertar(objCS)) {
                DefaultRequestContext.getCurrentInstance().execute("PF('TmenuCompraDialog').hide()");
                Util.addSuccessMessage("Compra exitosa");
                //   this.objCS = new CComprobante();
            } else {
                Util.mostrarMensaje("No se realizo la compra. ! Saldo insuficiente");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }

    }
//</editor-fold>

    public double total() {
        int cantidad = objCS.getIntCantidad();
        double precio = objCS.getDblPrecio();
        double total = cantidad * precio;

        return Math.rint(total * 100) / 100;
    }
}
