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

/**
 *
 * @author Tupac
 */
public class MMenu {

    public static boolean insertarMenu(CMenu menu) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select *from fn_insert_tmenu(?,?,?,?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            java.sql.Date fechaCosumo = new java.sql.Date(menu.getDtFechaServir().getTime());
            lstpar.add(new Parametro(1, menu.getStrMenuDescripcion()));
            lstpar.add(new Parametro(2, fechaCosumo));
            lstpar.add(new Parametro(3, menu.getIntCantMax()));
            lstpar.add(new Parametro(4, menu.getObjServicio().getCodigoservicio()));

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
            String sql = "SELECT * from fn_update_tmenu(?,?,?,?)";
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

    public static boolean elminarMenu(CMenu cuenta) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from fn_delete_tmenu(?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, cuenta.getIntMenuId()));
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

    public static ArrayList<CMenu> obtenerMenu(int intServicioId) throws Exception {
        ArrayList<CMenu> lst = new ArrayList<CMenu>();
        try {
            String sql = "select *from fn_select_tmenuidserv(?)";
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, intServicioId));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParam);

            while (rs.next()) {
                CMenu objMenu = new CMenu();
                objMenu.setIntMenuId(rs.getInt(0));
                objMenu.setStrMenuDescripcion(rs.getString(1));
                objMenu.setDtFechaIngreso(rs.getTimeStamp(2));
                objMenu.setDtFechaServir(rs.getDate(3));
                objMenu.setIntCantMax(rs.getInt(4));
                objMenu.setIntCantDisponible(rs.getInt(5));

                CServicio objServicio = MServicio.cargarPorId(rs.getInt(6));
                objMenu.setObjServicio(objServicio);

                CEstado objEstado = MEstado.obtenerObjetoEstado(rs.getInt(7));
                objMenu.setObjEstado(objEstado);

                lst.add(objMenu);
            }
            rs = null;
        } catch (SQLException exConec) {
            lst.clear();
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
