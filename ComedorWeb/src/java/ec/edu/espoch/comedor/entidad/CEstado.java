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
public class CEstado {
    
    private int estadId;
    private String Descripcion;

    public CEstado() {
    }

    public int getEstadId() {
        return estadId;
    }

    public void setEstadId(int estadId) {
        this.estadId = estadId;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public CEstado(int estadId, String Descripcion) {
        this.estadId = estadId;
        this.Descripcion = Descripcion;
    }
    
    
    
}
