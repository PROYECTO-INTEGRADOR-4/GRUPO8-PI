/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;

import ec.edu.espoch.comedor.entidad.CComprobante;

/**
 *
 * @author SYSTEMarket-pc
 */
public class MComprobante {

    public static boolean insertar(CComprobante objC) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select *from fn_insert_tcomprobante(?,?,?,?,?,?,?);";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, objC.getIntNum()));
            lstpar.add(new Parametro(2, objC.getObjMenu().getDtFechaServir()));
            lstpar.add(new Parametro(3, objC.getIntCantidad()));
            lstpar.add(new Parametro(4, objC.getDblPrecio()));
            lstpar.add(new Parametro(5, objC.getObjMenu().getObjServicio().getCodigoservicio()));
            lstpar.add(new Parametro(6, objC.getObjCliente().getCedula()));
            lstpar.add(new Parametro(7, objC.getObjMenu().getIntMenuId()));

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
    /*
     public static boolean modificarCuentaServicio(CComprobante cuentaser) throws Exception {
     boolean respuesta = false;
     try {
     String sql = "select * from fn_update_tcuentaservicio(?,?,?,?,?)";
     ArrayList<Parametro> lstpar = new ArrayList<>();
     lstpar.add(new Parametro(1, cuentaser.getCodigoServicioCliente()));
     lstpar.add(new Parametro(2, cuentaser.getObjCuenta().getIdCuenta()));
     lstpar.add(new Parametro(2, cuentaser.getFechaServicioCliente()));
     lstpar.add(new Parametro(2, cuentaser.getCantidad()));
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
     }*/

    public static boolean elimninarCuentaServicio(int cuentaservicio) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select * from fn_delete_tcuentaservicio(?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, cuentaservicio));
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

    public static ArrayList<CComprobante> obtenerCuentaServicio() throws Exception {
        ArrayList<CComprobante> lst = new ArrayList<CComprobante>();
        try {
            String sql = "SELECT * from fn_select_tcuentaservicio()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = llenarCuentaServicio(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
