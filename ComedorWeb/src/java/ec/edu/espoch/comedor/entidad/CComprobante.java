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
 * @author SYSTEMarket-pc
 */
public class CComprobante {

    private int idId;
    private int intNum;
    private Persona objCliente;
    private CServicio objServicio;
    private Date dtFecha;
    private int intCantidad;
    private double dblPrecio;

    public CComprobante() {
    }

    public CComprobante(int idId, int intNum, Persona objCliente, CServicio objServicio, Date dtFecha, int intCantidad, double dblPrecio) {
        this.idId = idId;
        this.intNum = intNum;
        this.objCliente = objCliente;
        this.objServicio = objServicio;
        this.dtFecha = dtFecha;
        this.intCantidad = intCantidad;
        this.dblPrecio = dblPrecio;
    }

    public int getIdId() {
        return idId;
    }

    public void setIdId(int idId) {
        this.idId = idId;
    }

    public int getIntNum() {
        return intNum;
    }

    public void setIntNum(int intNum) {
        this.intNum = intNum;
    }

    public Persona getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Persona objCliente) {
        this.objCliente = objCliente;
    }

    public CServicio getObjServicio() {
        return objServicio;
    }

    public void setObjServicio(CServicio objServicio) {
        this.objServicio = objServicio;
    }

    public Date getDtFecha() {
        return dtFecha;
    }

    public void setDtFecha(Date dtFecha) {
        this.dtFecha = dtFecha;
    }

    public int getIntCantidad() {
        return intCantidad;
    }

    public void setIntCantidad(int intCantidad) {
        this.intCantidad = intCantidad;
    }

    public double getDblPrecio() {
        return dblPrecio;
    }

    public void setDblPrecio(double dblPrecio) {
        this.dblPrecio = dblPrecio;
    }

}
