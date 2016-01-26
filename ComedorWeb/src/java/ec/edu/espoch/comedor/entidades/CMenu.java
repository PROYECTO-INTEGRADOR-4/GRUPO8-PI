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
public class CMenu {
    
   private int codigoMenu;
  private String descripcionMenu;
  private java.util.Date fecha_generacion;

    public CMenu() {
    }

    public CMenu(int codigoMenu, String descripcionMenu, Date fecha_generacion) {
        this.codigoMenu = codigoMenu;
        this.descripcionMenu = descripcionMenu;
        this.fecha_generacion = fecha_generacion;
    }

    public int getCodigoMenu() {
        return codigoMenu;
    }

    public void setCodigoMenu(int codigoMenu) {
        this.codigoMenu = codigoMenu;
    }

    public String getDescripcionMenu() {
        return descripcionMenu;
    }

    public void setDescripcionMenu(String descripcionMenu) {
        this.descripcionMenu = descripcionMenu;
    }

    public Date getFecha_generacion() {
        return fecha_generacion;
    }

    public void setFecha_generacion(Date fecha_generacion) {
        this.fecha_generacion = fecha_generacion;
    }
  
  
    
}
