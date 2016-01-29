/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.entidad;

/**
 *
 * @author ANGELA
 */
public class CPrecio {
    
    private  Integer idprecio;
    private  String preciodescripcion;
    private double preciomonto;
    CServicio objservicio;

    public CPrecio() {
    }

    public CPrecio(Integer idprecio, String preciodescripcion, double preciomonto, CServicio objservicio) {
        this.idprecio = idprecio;
        this.preciodescripcion = preciodescripcion;
        this.preciomonto = preciomonto;
        this.objservicio = objservicio;
    }

    public Integer getIdprecio() {
        return idprecio;
    }

    public void setIdprecio(Integer idprecio) {
        this.idprecio = idprecio;
    }

    public String getPreciodescripcion() {
        return preciodescripcion;
    }

    public void setPreciodescripcion(String preciodescripcion) {
        this.preciodescripcion = preciodescripcion;
    }

    public double getPreciomonto() {
        return preciomonto;
    }

    public void setPreciomonto(double preciomonto) {
        this.preciomonto = preciomonto;
    }

    public CServicio getObjservicio() {
        return objservicio;
    }

    public void setObjservicio(CServicio objservicio) {
        this.objservicio = objservicio;
    }
    
    
}
