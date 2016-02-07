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
import java.util.List;

/**
 *
 * @author SYSTEMarket-pc
 */
public class MPrecio {

    //<editor-fold desc="Cargar precios">
    public static List<CPrecio> cargar() throws Exception {
        List<CPrecio> lstPrecios = new ArrayList();
        try {
            String sql = "SELECT *from fn_select_tprecio();";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                CPrecio objP = new CPrecio();
                CServicio objS = MServicio.cargarPorId(rs.getInt(0));
                objP.setObjServicio(objS);
                CTipo objTipo = MTipo.cargarPorId(rs.getInt(1));
                objP.setObjTipo(objTipo);
                objP.setDblValor(rs.getDouble(2));
                lstPrecios.add(objP);
            }
        } catch (Exception e) {
            lstPrecios.clear();
            throw e;
        }
        return lstPrecios;
    }
    //</editor-fold>

    public static boolean insertar(CPrecio precio) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "Select * from fn_insert_tprecio(?,?,?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, precio.getObjServicio().getCodigoservicio()));
            lstpar.add(new Parametro(2, precio.getObjTipo().getIntTipoId()));
            lstpar.add(new Parametro(3, precio.getDblValor()));

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

    public static boolean modificarPrecio(CPrecio precio) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from fn_update_tprecio(?,?,?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, precio.getObjServicio().getCodigoservicio()));
            lstpar.add(new Parametro(2, precio.getObjTipo().getIntTipoId()));
            lstpar.add(new Parametro(3, precio.getDblValor()));

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

    public static boolean elminarPrecio(CPrecio precio) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select * from fn_delete_tprecio(?,?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, precio.getObjTipo().getIntTipoId()));
            lstpar.add(new Parametro(2, precio.getObjServicio().getCodigoservicio()));
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

}
