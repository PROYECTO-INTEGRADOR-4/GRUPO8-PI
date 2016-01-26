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
public class CTipoTransacion {
   private int   codigoTransaccion;
  private String escripcionTransaccion; 

    public CTipoTransacion() {
    }

    public CTipoTransacion(int codigoTransaccion, String escripcionTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
        this.escripcionTransaccion = escripcionTransaccion;
    }

    public int getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(int codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public String getEscripcionTransaccion() {
        return escripcionTransaccion;
    }

    public void setEscripcionTransaccion(String escripcionTransaccion) {
        this.escripcionTransaccion = escripcionTransaccion;
    }
  

    
}
