/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.entidad.CDetalle;
import ec.edu.espoch.comedor.modelo.MDetalle;
import ec.edu.espoch.comedor.modelo.mLogin;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.context.RequestContext;
import recursos.Util;
import wsInfoCarrera.Persona;
import wsSeguridad.RolCarrera;

/**
 *
 * @author Usuario
 */
public class ControladorCliente {

    private CDetalle objDetalle;
    private CDetalle selObjDetalle;
    private RolCarrera rolCarrera;
    private ArrayList<CDetalle> lstDetalle;
    private ArrayList<CDetalle> lstDetallado;

    private final HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private final ControladorUserLogin loginBean = (ControladorUserLogin) session.getAttribute("controladorUserLogin");

    /**
     * Creates a new instance of ControladorCliente
     */
    public ControladorCliente() {
        this.objDetalle = new CDetalle();
        this.selObjDetalle = new CDetalle();
        this.rolCarrera = new RolCarrera();
        this.lstDetalle = new ArrayList<>();
        this.lstDetallado = new ArrayList<>();
    }

    public CDetalle getObjDetalle() {
        return objDetalle;
    }

    public void setObjDetalle(CDetalle objDetalle) {
        this.objDetalle = objDetalle;
    }

    public CDetalle getSelObjDetalle() {
        return selObjDetalle;
    }

    public void setSelObjDetalle(CDetalle selObjDetalle) {
        this.selObjDetalle = selObjDetalle;
    }

    public RolCarrera getRolCarrera() {
        return rolCarrera;
    }

    public void setRolCarrera(RolCarrera rolCarrera) {
        this.rolCarrera = rolCarrera;
    }

    public ArrayList<CDetalle> getLstDetalle() {
        return lstDetalle;
    }

    public void setLstDetalle(ArrayList<CDetalle> lstDetalle) {
        this.lstDetalle = lstDetalle;
    }

    public ArrayList<CDetalle> getLstDetallado() {
        return lstDetallado;
    }

    public void setLstDetallado(ArrayList<CDetalle> lstDetallado) {
        this.lstDetallado = lstDetallado;
    }

    @PostConstruct
    public void reinit() {
        total();
        detallado();
    }

    /*
     Para saldo total
     */
    public void total() {
        try {
            // Initial value for valid boolean
            boolean valid = false;
            // Do some computation
            String strCedula = loginBean.getObjUserLogin().getCedula();
            if (!"".equals(strCedula) && loginBean.getRolCarrera().getNombreRol().equals("EST") && loginBean.getRolCarrera().getNombreRol().equals("DOC")) {
                lstDetalle.clear();
                valid = true;
                this.objDetalle.setObjPersona(mLogin.datosUsuario(loginBean.getRolCarrera().getCodigoCarrera(), strCedula));
                double saldo = MDetalle.saldoTotal(strCedula);
                if (saldo >= 1) {
                    saldo = Math.rint(saldo * 100) / 100;
                }
                this.objDetalle.setDblValor(saldo);
                this.lstDetalle.add(objDetalle);
            } else {
                if (!"".equals(strCedula)) {
                    lstDetalle.clear();
                    valid = true;
                    //this.objDetalle.setObjPersona(mLogin.datosUsuario(loginBean.getRolCarrera().getCodigoCarrera(), strCedula));
                    double saldo = MDetalle.saldoTotal(strCedula);
                    if (saldo >= 1) {
                        saldo = Math.rint(saldo * 100) / 100;
                    }
                    this.objDetalle.setDblValor(saldo);
                    this.lstDetalle.add(objDetalle);
                }

            }
            if (valid) {
                RequestContext.getCurrentInstance().update("TsaldoListForm");
            }
            if (!valid) {
                RequestContext.getCurrentInstance().update("TsaldoListForm");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void detallado() {
        try {
            objDetalle.setObjPersona(loginBean.getObjUserLogin());
            this.lstDetallado = (ArrayList<CDetalle>) MDetalle.cararPorCedula(objDetalle);
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
}
