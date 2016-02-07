/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.entidad;

/**
 *
 * @author Tupac
 */
public class CPrecio {

    private CServicio objServicio;
    private CTipo objTipo;
    private double dblValor;

    public CPrecio() {
    }

    public CPrecio(CServicio objServicio, CTipo objTipo, double dblValor, int precioid) {
        this.objServicio = objServicio;
        this.objTipo = objTipo;
        this.dblValor = dblValor;
    }

    public CServicio getObjServicio() {
        return objServicio;
    }

    public void setObjServicio(CServicio objServicio) {
        this.objServicio = objServicio;
    }

    public CTipo getObjTipo() {
        return objTipo;
    }

    public void setObjTipo(CTipo objTipo) {
        this.objTipo = objTipo;
    }

    public double getDblValor() {
        return dblValor;
    }

    public void setDblValor(double dblValor) {
        this.dblValor = dblValor;
    }

}
