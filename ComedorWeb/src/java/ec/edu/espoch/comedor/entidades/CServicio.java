/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.entidades;

/**
 *
 * @author SYSTEMarket-pc
 */
public class CServicio {
   private int codigoservicio;
  private String descripcionservicio;
  private int cantidad;
  private int disponible;
  CMenu objMenu;  

    public CServicio() {
    }

    public CServicio(int codigoservicio, String descripcionservicio, int cantidad, int disponible, CMenu objMenu) {
        this.codigoservicio = codigoservicio;
        this.descripcionservicio = descripcionservicio;
        this.cantidad = cantidad;
        this.disponible = disponible;
        this.objMenu = objMenu;
    }

    public int getCodigoservicio() {
        return codigoservicio;
    }

    public void setCodigoservicio(int codigoservicio) {
        this.codigoservicio = codigoservicio;
    }

    public String getDescripcionservicio() {
        return descripcionservicio;
    }

    public void setDescripcionservicio(String descripcionservicio) {
        this.descripcionservicio = descripcionservicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public CMenu getObjMenu() {
        return objMenu;
    }

    public void setObjMenu(CMenu objMenu) {
        this.objMenu = objMenu;
    }
  
    
}
