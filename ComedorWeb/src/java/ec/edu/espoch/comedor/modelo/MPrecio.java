/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import ec.edu.espoch.comedor.entidad.*;
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
            lstpar = null;
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    public static boolean modificarCuenta(CPrecio precio) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from fn_update_tprecio(?,?,?,?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, precio.getIdprecio()));
            lstpar.add(new Parametro(3, precio.getPreciomonto()));
            lstpar.add(new Parametro(2, precio.getPreciodescripcion()));
            lstpar.add(new Parametro(4, precio.getObjservicio()));

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

    public static boolean elminarCuenta(CPrecio precio) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select * from fn_delete_tcuenta(?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, precio.getIdprecio()));
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

    public static ArrayList<CPrecio> obtenerCuenta() throws Exception {
        ArrayList<CPrecio> lst = new ArrayList<CPrecio>();
        try {
            String sql = "SELECT * from fn_select_tcuenta()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPrecio(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<CPrecio> llenarPrecio(ConjuntoResultado rs) throws Exception {
        ArrayList<CPrecio> lst = new ArrayList<CPrecio>();
        CServicio objprecio = new CServicio();
        CPrecio precio = null;
        try {
            while (rs.next()) {

                precio = new CPrecio(rs.getInt(0),
                        rs.getString(1), rs.getDouble(2), objprecio);

                lst.add(precio);
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
