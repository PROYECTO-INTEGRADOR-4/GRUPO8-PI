/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import ec.edu.espoch.comedor.entidad.CDetalleCuenta;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SYSTEMarket-pc
 */
public class MDetalleCuenta {
    //<editor-fold desc="Insertar">
    public static boolean insertarDetalleC(CDetalleCuenta objDetalle) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamServicio = new ArrayList<>();
            String sql = "SELECT fn_insert_tdetallecuenta(?,?,?,?,?);";
           
            lstParamServicio.add(new Parametro(1, objDetalle.getObjCuenta().getIdCuenta()));
            lstParamServicio.add(new Parametro(2, objDetalle.getMonto()));
            lstParamServicio.add(new Parametro(3, objDetalle.getSaldo()));
            lstParamServicio.add(new Parametro(4, objDetalle.getFecha_tran().getTime()));
            lstParamServicio.add(new Parametro(5, objDetalle.getObjTipoTransacion().getCodigoTransaccion()));
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
    
    
    public static boolean modificarDetalle(CDetalleCuenta objDetalle) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from fn_update_tdetallecuneta(?,?,?,?,?)";
            ArrayList<Parametro> lstParamServicio = new ArrayList<>();
          lstParamServicio.add(new Parametro(1, objDetalle.getObjCuenta().getIdCuenta()));
            lstParamServicio.add(new Parametro(2, objDetalle.getMonto()));
            lstParamServicio.add(new Parametro(3, objDetalle.getSaldo()));
            lstParamServicio.add(new Parametro(4, objDetalle.getFecha_tran().getTime()));
            lstParamServicio.add(new Parametro(5, objDetalle.getObjTipoTransacion().getCodigoTransaccion()));
             ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamServicio);
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
    /*
    public static boolean elminarDetalle(CDetalleCuenta cuenta) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from fn_delete_tdetallecuenta(?)";
            ArrayList<Parametro> lstpar = new ArrayList<>();
            lstpar.add(new Parametro(1, cuenta.getCodigoDetalleCuenta()));
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
    
    */
    
      
    public static ArrayList<CDetalleCuenta> obtenerDetalle() throws Exception {
        ArrayList<CDetalleCuenta> lst = new ArrayList<CDetalleCuenta>();
        try {
             String sql = "SELECT * from fn_select_tdetallecuenta()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDetalle(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<CDetalleCuenta> llenarDetalle(ConjuntoResultado rs) throws Exception {
        ArrayList<CDetalleCuenta> lst = new ArrayList<CDetalleCuenta>();
        CDetalleCuenta detalle = null;
        try {
            while (rs.next()) {

                detalle = new CDetalleCuenta(
                        rs.getInt(0), 
                        Mcuenta.obtenerObjetoCuentaid(rs.getInt(1)),
                rs.getDouble(2),
                rs.getDouble(3),
                rs.getDate(4),
                MTipoTransaccion.obtenerObjetoTra(rs.getInt(5)));

                lst.add(detalle);
            }
        } catch (Exception e) {
            lst.clear();
           throw e;
        }
        return lst;
    }
}

