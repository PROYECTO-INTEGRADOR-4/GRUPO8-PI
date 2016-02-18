/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.entidad;

import java.util.Date;

/**
 *
 * @author ANGELA
 */
public class CReporte {

    private Date fecha;
    private Integer cantidad;
    private double precio;
    private String cedula;

    public CReporte() {
    }

    public CReporte(Date fecha, Integer cantidad, double precio, String cedula) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio = precio;
        this.cedula = cedula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
