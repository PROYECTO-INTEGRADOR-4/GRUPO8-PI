/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.entidad;

import java.util.Date;
import wsInfoCarrera.Persona;

/**
 *
 * @author Tupac
 */
public class CDetalle {

    private int intDetalleId;
    private Persona objPersona;
    private Date dtFecha;
    private double dblValor;
    private CTipoTransacion objCTipoTransacion;

    public CDetalle() {
    }

    public int getIntDetalleId() {
        return intDetalleId;
    }

    public void setIntDetalleId(int intDetalleId) {
        this.intDetalleId = intDetalleId;
    }

    public Persona getObjPersona() {
        return objPersona;
    }

    public void setObjPersona(Persona objPersona) {
        this.objPersona = objPersona;
    }

    public Date getDtFecha() {
        return dtFecha;
    }

    public void setDtFecha(Date dtFecha) {
        this.dtFecha = dtFecha;
    }

    public double getDblValor() {
        return dblValor;
    }

    public void setDblValor(double dblValor) {
        this.dblValor = dblValor;
    }

    public CTipoTransacion getObjCTipoTransacion() {
        return objCTipoTransacion;
    }

    public void setObjCTipoTransacion(CTipoTransacion objCTipoTransacion) {
        this.objCTipoTransacion = objCTipoTransacion;
    }

}
