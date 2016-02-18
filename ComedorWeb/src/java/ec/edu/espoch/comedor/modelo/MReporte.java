/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import ec.edu.espoch.comedor.entidad.CReporte;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ANGELA
 */
public class MReporte {

    public static ArrayList<CReporte> obtenerAlmuerzo() throws Exception {
        ArrayList<CReporte> lst = new ArrayList<CReporte>();
        try {
            String sql = "select tc.clientecedula, tc.tcomprobantefechageneracion,tc.tcomprobantecantidad,tc.tcomprobanteprecio from tcomprobante as tc \n"
                    + "inner join tservicio on tc.tservicioid =tservicio.tservicioid \n"
                    + "inner join tmenu on tservicio.tservicioid=tmenu.tservicioid  \n"
                    + "where tserviciodescripcion='Almuerzo'and tmenufechaconsumo=current_date and tcomprobantefechaservicio=current_date";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    public static ArrayList<CReporte> obtenerDesayuno() throws Exception {
        ArrayList<CReporte> lst = new ArrayList<CReporte>();
        try {
            String sql = "select tc.clientecedula, tc.tcomprobantefechageneracion,tc.tcomprobantecantidad,tc.tcomprobanteprecio from tcomprobante as tc \n"
                    + "inner join tservicio on tc.tservicioid =tservicio.tservicioid \n"
                    + "inner join tmenu on tservicio.tservicioid=tmenu.tservicioid  \n"
                    + "where tserviciodescripcion='Desayuno'and tmenufechaconsumo=current_date and tcomprobantefechaservicio=current_date";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    public static ArrayList<CReporte> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<CReporte> lst = new ArrayList<CReporte>();
        try {
            while (rs.next()) {
                CReporte objRepo = new CReporte();
                objRepo.setCedula(rs.getString(0));
                objRepo.setFecha(rs.getTimeStamp(1));
                objRepo.setCantidad(rs.getInt(2));
                objRepo.setPrecio(rs.getDouble(3));
                lst.add(objRepo);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

}
