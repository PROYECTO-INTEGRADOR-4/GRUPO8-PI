/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.modelo;


import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import ec.edu.espoch.comedor.entidad.CPrecio;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author SYSTEMarket-pc
 */
public class MPrecio {
    
     public static boolean insertarPrecio(CPrecio precio) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "Select * from fn_insert_tprecio(?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, precio.getPreciomonto()));
            lstpar.add(new Parametro(1, precio.getPreciodescripcion()));
            lstpar.add(new Parametro(1, precio.getObjservicio().getCodigoservicio()));
           
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            while (rs.next()) {
                if (rs.getBoolean(0) == true) {
                    respuesta = true;
                }
            }
            rs = null;
            lstpar= null;
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

}
