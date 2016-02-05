/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class MFecha {

    public static Date fechaActual() throws Exception {
        Date fecha = null;
        try {
            String sql = "select *from current_date;";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                fecha = rs.getDate(0);
            }
            rs = null;
        } catch (Exception e) {
            throw e;
        }
        return fecha;
    }

}
