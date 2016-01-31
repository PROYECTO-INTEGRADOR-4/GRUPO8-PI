/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import ec.edu.espoch.comedor.entidad.CCuenta;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SYSTEMarket-pc
 */
public class Mcuenta {
    
    
     public static boolean insertarCuenta(CCuenta cuenta) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "Select * from fn_insert_tcuenta(?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, cuenta.getCedula()));
           
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
public static boolean modificarCuenta(CCuenta cuenta) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select * from fn_update_tcuenta(?,?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, cuenta.getIdCuenta()));
            lstpar.add(new Parametro(2, cuenta.getCedula()));
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
    public static boolean elminarCuenta(CCuenta cuenta) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select * from fn_delete_tcuenta(?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, cuenta));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            while (rs.next()) {
                if (rs.getString(0).equals("true")) {
                    respuesta = true;
                }
            }

        } catch (SQLException e) {
            throw e;
        }
        return respuesta;
    }
    
    public static ArrayList<CCuenta> obtenerCuenta() throws Exception {
        ArrayList<CCuenta> lst = new ArrayList<CCuenta>();
        try {
             String sql = "SELECT * from fn_select_tcuenta()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCuenta(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<CCuenta> llenarCuenta(ConjuntoResultado rs) throws Exception {
        ArrayList<CCuenta> lst = new ArrayList<CCuenta>();
        CCuenta cuenta = null;
        try {
            while (rs.next()) {

                cuenta = new CCuenta(rs.getInt(0),
                        rs.getString(1));

                lst.add(cuenta);
            }
        } catch (Exception e) {
            lst.clear();
            //  integracion.auditoria.log ublog = new integracion.auditoria.log();
            // ublog.write("Modulo", "llenarModulos", e.getClass().getName(), e.getMessage());
            throw e;
        }
        return lst;
    }

    public static CCuenta obtenerObjetoCuentaid(int cuenta) throws Exception {
        CCuenta Cuenta= null;
        ArrayList<Parametro> lstP = new ArrayList<>();
        try {
            String sql = "select * from tcuenta where tcuenta.tcuentaid=?";
            
            lstP.add(new Parametro(1, cuenta));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                Cuenta = new CCuenta(rs.getInt(0),
                        rs.getString(1));
            }

        } catch (SQLException e) {
            throw e;
        }
        return Cuenta;
    }

    
    
   
    
}
