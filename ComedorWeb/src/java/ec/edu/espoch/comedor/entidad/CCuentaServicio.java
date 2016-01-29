/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.entidad;

import java.util.Date;

/**
 *
 * @author SYSTEMarket-pc
 */
public class CCuentaServicio {
  private int   codigoServicioCliente;
   private java.util.Date fechaServicioCliente;
  private int cantidad;
  CServicio objServicio;
  CCuenta objCuenta;

    public CCuentaServicio(int codigoServicioCliente, Date fechaServicioCliente, int cantidad, CServicio objServicio, CCuenta objCuenta) {
        this.codigoServicioCliente = codigoServicioCliente;
        
        this.fechaServicioCliente = fechaServicioCliente;
        this.cantidad = cantidad;
        this.objServicio = objServicio;
        this.objCuenta = objCuenta;
    }

    public CCuentaServicio() {
    }

    public int getCodigoServicioCliente() {
        return codigoServicioCliente;
    }

    public void setCodigoServicioCliente(int codigoServicioCliente) {
        this.codigoServicioCliente = codigoServicioCliente;
    }

    public Date getFechaServicioCliente() {
        return fechaServicioCliente;
    }

    public void setFechaServicioCliente(Date fechaServicioCliente) {
        this.fechaServicioCliente = fechaServicioCliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public CServicio getObjServicio() {
        return objServicio;
    }

    public void setObjServicio(CServicio objServicio) {
        this.objServicio = objServicio;
    }

    public CCuenta getObjCuenta() {
        return objCuenta;
    }

    public void setObjCuenta(CCuenta objCuenta) {
        this.objCuenta = objCuenta;
    }
  
    
}
