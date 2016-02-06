/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import ec.edu.espoch.comedor.entidad.CTipoTransacion;
import static ec.edu.espoch.comedor.modelo.Mcuenta.llenarCuenta;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SYSTEMarket-pc
 */
public class MTipoTransaccion {
      public static ArrayList<CTipoTransacion> obtenertran() throws Exception {
        ArrayList<CTipoTransacion> lst = new ArrayList<CTipoTransacion>();
        try {
             String sql = "SELECT * from fn_select_ttipotransaccion()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenartipo(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
      
       public static ArrayList<CTipoTransacion> llenartipo(ConjuntoResultado rs) throws Exception {
        ArrayList<CTipoTransacion> lst = new ArrayList<CTipoTransacion>();
        CTipoTransacion tipo = null;
        try {
            while (rs.next()) {

                tipo = new CTipoTransacion(rs.getInt(0),
                        rs.getString(1));

                lst.add(tipo);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

  public static CTipoTransacion obtenerObjetoTra(int codigo) throws Exception {
    CTipoTransacion tipo=null;
    ArrayList<Parametro> lstP = new ArrayList<>();
try {
            String sql = "select *from ttipotransaccion  where ttipotransaccionid=?";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
         while(rs.next()){
         tipo = new CTipoTransacion(rs.getInt(0),
                   rs.getString(1));
         }

        } catch (SQLException e) {
            throw  e;
        }
       return tipo;
    }  
}
