/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.entidades;

import java.util.Date;

/**
 *
 * @author SYSTEMarket-pc
 */
public class CServicioCliente {
  private int   codigoServicioCliente;
  private double costo;
   private java.util.Date fechaServicioCliente;
  private int cantidad;
  CServicio objServicio;
  CCuenta objCuenta;

    public CServicioCliente(int codigoServicioCliente, double costo, Date fechaServicioCliente, int cantidad, CServicio objServicio, CCuenta objCuenta) {
        this.codigoServicioCliente = codigoServicioCliente;
        this.costo = costo;
        this.fechaServicioCliente = fechaServicioCliente;
        this.cantidad = cantidad;
        this.objServicio = objServicio;
        this.objCuenta = objCuenta;
    }

    public CServicioCliente() {
    }

    public int getCodigoServicioCliente() {
        return codigoServicioCliente;
    }

    public void setCodigoServicioCliente(int codigoServicioCliente) {
        this.codigoServicioCliente = codigoServicioCliente;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
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
