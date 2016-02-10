/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.modelo;

import ec.edu.espoch.comedor.accesodatos.AccesoDatos;
import ec.edu.espoch.comedor.accesodatos.ConjuntoResultado;
import ec.edu.espoch.comedor.accesodatos.Parametro;
import ec.edu.espoch.comedor.entidad.CDetalle;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tupac
 */
public class MDetalle {

    public static List<CDetalle> cararPorCedula(CDetalle objDetalle) throws Exception {
        List lstD = new ArrayList();
        try {
            String sql = "select *from fn_select_tdetallexcedula(?)";
            ArrayList<Parametro> lstP = new ArrayList<>();
            lstP.add(new Parametro(1, objDetalle.getObjPersona().getCedula()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                CDetalle objD = new CDetalle();
                objD.setIntDetalleId(rs.getInt(0));
                objD.setDtFecha(rs.getTimeStamp(2));
                objD.setDblValor(rs.getDouble(3));
                lstD.add(objD);
            }

        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }

    public static double saldoTotal(String strCedula) throws Exception {
        double total = 0;
        try {
            String sql = "select *from fn_tdetalle_valortotal(?);";
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, strCedula));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParam);
            while (rs.next()) {
                total = rs.getDouble(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return total;

    }

    public static boolean insertar(CDetalle objDetalle) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select *from fn_insert_tdetalle(?,?,?)";
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, objDetalle.getObjPersona().getCedula()));
            lstParam.add(new Parametro(2, objDetalle.getDblValor()));
            lstParam.add(new Parametro(3, objDetalle.getObjCTipoTransacion().getCodigoTransaccion()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParam);
            while (rs.next()) {
                if (rs.getString(0).equals("true")) {
                    respuesta = true;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }
}
