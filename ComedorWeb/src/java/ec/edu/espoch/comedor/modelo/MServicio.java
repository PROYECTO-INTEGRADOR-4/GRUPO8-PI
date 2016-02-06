/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import ec.edu.espoch.comedor.entidad.CServicio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tupac
 */
public class MServicio {

    //<editor-fold defaultstate="collapsed" desc="Metodo para cargar servicios">
    public static List<CServicio> cargar() throws Exception {
        List<CServicio> lstServicios = new ArrayList<>();
        try {
            String sql = "SELECT *from fn_select_tservicio();";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                CServicio objServicio = new CServicio();
                objServicio.setCodigoservicio(rs.getInt(0));
                objServicio.setDescripcionservicio(rs.getString(1));
                lstServicios.add(objServicio);
            }
            rs = null;
        } catch (Exception e) {
            lstServicios.clear();
            throw e;
        }
        return lstServicios;
    }
    //</editor-fold>

    //<editor-fold desc="Caragar servicio por id">
    public static CServicio cargarPorId(int intServicioId) throws Exception {
        CServicio objS = new CServicio();
        try {
            ArrayList<Parametro> lstParam = new ArrayList<>();
            String sql = "select *from fn_select_xid_tservicio(?);";
            lstParam.add(new Parametro(1, intServicioId));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParam);
            while (rs.next()) {
                objS.setCodigoservicio(rs.getInt(0));
                objS.setDescripcionservicio(rs.getString(1));
            }
        } catch (Exception e) {
            objS = null;
            throw e;
        }
        return objS;
    }
    //</editor-fold>

    //<editor-fold desc="Insertar">
    public static boolean insertar(CServicio objServicio) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamServicio = new ArrayList<>();
            String sql = "SELECT fn_insert_tservicio(?);";
            lstParamServicio.add(new Parametro(1, objServicio.getDescripcionservicio()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamServicio);
            while (rs.next()) {
                if (rs.getBoolean(0)) {
                    respuesta = true;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }
    //</editor-fold>

    public static boolean elimninarServicio(int codigo) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select * from fn_delete_tservicio(?)";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, codigo));
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

    public static boolean modificarServicio(CServicio servicio) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select *from fn_update_tservicio(?,?)";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, servicio.getCodigoservicio()));
            lstpar.add(new Parametro(2, servicio.getDescripcionservicio()));
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
