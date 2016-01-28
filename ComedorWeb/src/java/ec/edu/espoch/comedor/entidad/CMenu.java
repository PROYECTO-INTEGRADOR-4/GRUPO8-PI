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
    
   private int codigoMenu;
  private String descripcionMenu;
  CServicio objservicio;

    public CMenu() {
    }

    public CMenu(int codigoMenu, String descripcionMenu, CServicio objservicio) {
        this.codigoMenu = codigoMenu;
        this.descripcionMenu = descripcionMenu;
        this.objservicio = objservicio;
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

    public CServicio getObjservicio() {
        return objservicio;
    }

    public void setObjservicio(CServicio objservicio) {
        this.objservicio = objservicio;
    }

   
  
  
    
}
