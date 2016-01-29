/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.entidad.CMenu;
import java.util.ArrayList;
import wsInfoCarrera.Parametro;

/**
 *
 * @author SYSTEMarket-pc
 */
public class MMenu {
    
     public static boolean insertarMenu(CMenu menu) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "Select * from fn_insert_tmenu(?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, menu.getDescripcionMenu()));
            lstpar.add(new Parametro(1, menu.getObjservicio().getCodigoservicio()));
            
           
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
