/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.entidad.CEstado;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SYSTEMarket-pc
 */
public class MEstado {
     public static ArrayList<CEstado> obtenerEstado() throws Exception {
        ArrayList<CEstado> lst = new ArrayList<CEstado>();
        try {
             String sql = "SELECT * from fn_select_testado()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEstado(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
public static ArrayList<CEstado> llenarEstado(ConjuntoResultado rs) throws Exception {
        ArrayList<CEstado> lst = new ArrayList<CEstado>();
        CEstado estado = null;
        try {
            while (rs.next()) {

                estado = new CEstado(rs.getInt(0),
                        rs.getString(1));

                lst.add(estado);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
 

}

