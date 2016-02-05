/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.modelo.MFecha;
import java.util.Date;
import javax.annotation.PostConstruct;

/**
 *
 * @author Usuario
 */
public class ControladorFecha {

    private Date fecha;

    /**
     * Creates a new instance of ControladorFecha
     */
    public ControladorFecha() {

    }

    public Date getFecha() {
        return fecha;
    }

    @PostConstruct
    public void init() {
        fechaActual();
    }

    public void fechaActual() {
        try {
            this.fecha = MFecha.fechaActual();
        } catch (Exception e) {
        }

    }
}
