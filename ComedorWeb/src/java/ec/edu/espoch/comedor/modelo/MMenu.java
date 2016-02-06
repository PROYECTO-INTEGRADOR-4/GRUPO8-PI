/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import ec.edu.espoch.comedor.entidad.CEstado;
import ec.edu.espoch.comedor.entidad.CMenu;
import ec.edu.espoch.comedor.entidad.CServicio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import wsInfoCarrera.Parametro;

/**
 *
 * @author Tupac
 */
public class MMenu {

    public static boolean insertarMenu(CMenu menu) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "Select * from fn_insert_tmenu(?,?,?,?,?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, menu.getObjServicio().getCodigoservicio()));
            lstpar.add(new Parametro(2, menu.getStrMenuDescripcion()));
            lstpar.add(new Parametro(3, menu.getIntCantMax()));
            lstpar.add(new Parametro(1, menu.getIntCantDisponible()));
            lstpar.add(new Parametro(1, menu.getDtFechaServir()));





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

    public static boolean modificarMenu(CMenu menu) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from fn_update_tmenu(?,?,?,?,?,?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, menu.getIntMenuId()));
            lstpar.add(new Parametro(1, menu.getObjServicio().getCodigoservicio()));
            lstpar.add(new Parametro(1, menu.getStrMenuDescripcion()));
            lstpar.add(new Parametro(1, menu.getIntCantMax()));
            lstpar.add(new Parametro(1, menu.getIntCantDisponible()));
            lstpar.add(new Parametro(1, menu.getObjServicio()));

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

    public static boolean elminarMenu(CMenu menu) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from fn_delete_tmenu(?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, menu.getIntMenuId()));
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

   

    //<editor-fold desc="Cargar precios">
     public static List<CMenu> cargar(int idservicio) throws Exception {
        List<CMenu> lstMenus = new ArrayList<>();
        try {
            String sql = "select *from fn_select_tmenuidserv(?);";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, idservicio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                CMenu objMenu = new CMenu();
                objMenu.setIntMenuId(rs.getInt(0));
                MServicio.cargarPorId(rs.getInt(1));
                objMenu.setDtFechaIngreso(rs.getTimeStamp(2));
                objMenu.setStrMenuDescripcion(rs.getString(3));
                objMenu.setIntCantMax(rs.getInt(4));
                objMenu.setIntCantDisponible(rs.getInt(5));
                MEstado.obtenerObjetoEstado(rs.getInt(6));
                objMenu.setDtFechaServir(rs.getTimeStamp(7));
                lstMenus.add(objMenu);
            }

        } catch (Exception e) {
            lstMenus.clear();
            throw e;
        }
        return lstMenus;
    }
}
