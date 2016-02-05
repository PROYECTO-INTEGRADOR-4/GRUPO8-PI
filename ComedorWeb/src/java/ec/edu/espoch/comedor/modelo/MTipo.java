/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import ec.edu.espoch.comedor.entidad.CTipo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tupac
 */
public class MTipo {

    //<editor-fold desc="Cargar tipo">
    public static List<CTipo> cargar() throws Exception {
        List<CTipo> lstTipos = new ArrayList<>();
        try {
            String sql = "select *from fn_select_ttipo();";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                CTipo objTipo = new CTipo();
                objTipo.setIntTipoId(rs.getInt(0));
                objTipo.setStrTipoDescripcion(rs.getString(1));
                lstTipos.add(objTipo);
            }

        } catch (Exception e) {
            lstTipos.clear();
            throw e;
        }
        return lstTipos;
    }
    //</editor-fold>

    //<editor-fold desc="Cargar tipo por id">
    public static CTipo cargarPorId(int intIdTipo) throws Exception {
        CTipo objT = new CTipo();
        try {
            String sql = "select *from fn_select_xid_ttipo(?);";
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, intIdTipo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParam);
            while (rs.next()) {
                objT.setIntTipoId(rs.getInt(0));
                objT.setStrTipoDescripcion(rs.getString(1));
            }
        } catch (Exception e) {
            objT = null;
            throw e;
        }
        return objT;
    }
    //</editor-fold>
}
