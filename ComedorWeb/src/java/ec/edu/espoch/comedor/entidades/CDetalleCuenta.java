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
public class CDetalleCuenta {
    
    private int codigoDetalleCuenta;
    CCuenta objCuenta;
    private double monto;
  private double saldo;
   CTipoTransacion objTipoTransacion;

    public CDetalleCuenta() {
    }

    public CDetalleCuenta(int codigoDetalleCuenta, CCuenta objCuenta, double monto, double saldo, CTipoTransacion objTipoTransacion) {
        this.codigoDetalleCuenta = codigoDetalleCuenta;
        this.objCuenta = objCuenta;
        this.monto = monto;
        this.saldo = saldo;
        this.objTipoTransacion = objTipoTransacion;
    }

    public int getCodigoDetalleCuenta() {
        return codigoDetalleCuenta;
    }

    public void setCodigoDetalleCuenta(int codigoDetalleCuenta) {
        this.codigoDetalleCuenta = codigoDetalleCuenta;
    }

    public CCuenta getObjCuenta() {
        return objCuenta;
    }

    public void setObjCuenta(CCuenta objCuenta) {
        this.objCuenta = objCuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public CTipoTransacion getObjTipoTransacion() {
        return objTipoTransacion;
    }

    public void setObjTipoTransacion(CTipoTransacion objTipoTransacion) {
        this.objTipoTransacion = objTipoTransacion;
    }
   
    
}
