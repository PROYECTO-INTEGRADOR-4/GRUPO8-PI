/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import ec.edu.espoch.comedor.entidad.CMenu;
import ec.edu.espoch.comedor.entidad.CServicio;
import java.sql.SQLException;
import java.util.ArrayList;
//import wsInfoCarrera.Parametro;

/**
 *
 * @author SYSTEMarket-pc
 */
public class MMenu {
    
    
    public static boolean insertarMenu(CMenu menu) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "Select * from fn_insert_tcuenta(?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, menu.getCodigoMenu()));
            lstpar.add(new Parametro(2, menu.getDescripcionMenu()));
            lstpar.add(new Parametro(3, menu.getObjservicio()));
           
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
    
    public static boolean modificarMenu(CMenu menu) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from fn_update_tmenu(?,?,?,?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, menu.getCodigoMenu()));
            lstpar.add(new Parametro(2, menu.getObjservicio().getCodigoservicio()));
            lstpar.add(new Parametro(3, menu.getFecha_menu()));
            lstpar.add(new Parametro(4, menu.getDescripcionMenu()));
           ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            while(rs.next())
            {
                if(rs.getString(0).equals("true"))
                    respuesta=true;
            }
        } catch (SQLException e) {
            throw  e;
        }
        return respuesta;
}
    
    public static ArrayList<CMenu> obtenerMenu() throws Exception {
        ArrayList<CMenu> lst = new ArrayList<CMenu>();
        try {
             String sql = "SELECT * from fn_select_tcuenta()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarMenu(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static ArrayList<CMenu> llenarMenu(ConjuntoResultado rs) throws Exception {
        ArrayList<CMenu> lst = new ArrayList<CMenu>();
        CServicio objservicio=new CServicio(); //por favor revisar esta parte este correcta 
       CMenu menu = null;
        try {
            while (rs.next()) {

                menu = new CMenu(rs.getInt(0),
                        rs.getString(1),objservicio, rs.getDate(3));

                lst.add(menu);
            }
        } catch (Exception e) {
            lst.clear();
            //  integracion.auditoria.log ublog = new integracion.auditoria.log();
            // ublog.write("Modulo", "llenarModulos", e.getClass().getName(), e.getMessage());
            throw e;
        }
        return lst;
    }
           
}
