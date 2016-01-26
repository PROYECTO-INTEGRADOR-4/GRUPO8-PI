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
public class CCuenta {
    private int idCuenta;
    private  String cedula;

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public CCuenta() {
    }

    public CCuenta(int idCuenta, String cedula) {
        this.idCuenta = idCuenta;
        this.cedula = cedula;
    }
    
    
    
}
