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
public class CTipo {
    /*
     Atributos
     */

    private int intTipoId;
    private String strTipoDescripcion;

    public CTipo() {
    }

    public int getIntTipoId() {
        return intTipoId;
    }

    public void setIntTipoId(int intTipoId) {
        this.intTipoId = intTipoId;
    }

    public String getStrTipoDescripcion() {
        return strTipoDescripcion;
    }

    public void setStrTipoDescripcion(String strTipoDescripcion) {
        this.strTipoDescripcion = strTipoDescripcion;
    }

}
