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
public class CMenu {

    private int intMenuId;
    private String strMenuDescripcion;
    private Date dtFechaIngreso;
    private Date dtFechaServir;
    private int intCantMax;
    private int intCantDisponible;
    private CServicio objServicio;
    private CEstado objEstado;

    public CMenu() {
    }

    public CMenu(int intMenuId, String strMenuDescripcion, Date dtFechaServir, Date dtFechaIngreso, int intCantMax, int intCantDisponible, CServicio objServicio, CEstado objEstado) {
        this.intMenuId = intMenuId;
        this.strMenuDescripcion = strMenuDescripcion;
        this.dtFechaServir = dtFechaServir;
        this.dtFechaIngreso = dtFechaIngreso;
        this.intCantMax = intCantMax;
        this.intCantDisponible = intCantDisponible;
        this.objServicio = objServicio;
        this.objEstado = objEstado;
    }

    public int getIntMenuId() {
        return intMenuId;
    }

    public void setIntMenuId(int intMenuId) {
        this.intMenuId = intMenuId;
    }

    public String getStrMenuDescripcion() {
        return strMenuDescripcion;
    }

    public void setStrMenuDescripcion(String strMenuDescripcion) {
        this.strMenuDescripcion = strMenuDescripcion;
    }

    public Date getDtFechaServir() {
        return dtFechaServir;
    }

    public void setDtFechaServir(Date dtFechaServir) {
        this.dtFechaServir = dtFechaServir;
    }

    public Date getDtFechaIngreso() {
        return dtFechaIngreso;
    }

    public void setDtFechaIngreso(Date dtFechaIngreso) {
        this.dtFechaIngreso = dtFechaIngreso;
    }

    public int getIntCantMax() {
        return intCantMax;
    }

    public void setIntCantMax(int intCantMax) {
        this.intCantMax = intCantMax;
    }

    public int getIntCantDisponible() {
        return intCantDisponible;
    }

    public void setIntCantDisponible(int intCantDisponible) {
        this.intCantDisponible = intCantDisponible;
    }

    public CServicio getObjServicio() {
        return objServicio;
    }

    public void setObjServicio(CServicio objServicio) {
        this.objServicio = objServicio;
    }

    public CEstado getObjEstado() {
        return objEstado;
    }

    public void setObjEstado(CEstado objEstado) {
        this.objEstado = objEstado;
    }

}
