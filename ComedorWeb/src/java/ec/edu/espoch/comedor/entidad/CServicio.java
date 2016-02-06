/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.entidad;

/**
 *
 * @author SYSTEMarket-pc
 */
public class CServicio {
   private int codigoservicio;
  private String descripcionservicio;

    public CServicio() {
    }

    public CServicio(int codigoservicio, String descripcionservicio) {
        this.codigoservicio = codigoservicio;
        this.descripcionservicio = descripcionservicio;
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
    
}
