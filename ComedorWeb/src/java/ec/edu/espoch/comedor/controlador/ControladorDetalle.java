/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.entidad.CDetalle;
import ec.edu.espoch.comedor.entidad.CTipoTransacion;
import ec.edu.espoch.comedor.modelo.MDetalle;
import ec.edu.espoch.comedor.modelo.mLogin;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.context.RequestContext;
import recursos.Util;
import wsInfoCarrera.Persona;
import wsSeguridad.RolCarrera;

/**
 *
 * @author Tupac
 */
@ViewScoped
public class ControladorDetalle implements Serializable {

    private CDetalle objDetalle;
    private CDetalle selObjDetalle;
    private RolCarrera rolCarrera;
    private ArrayList<CDetalle> lstDetalle;

    private final HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private final ControladorUserLogin loginBean = (ControladorUserLogin) session.getAttribute("controladorUserLogin");

    /**
     * Creates a new instance of ControladorDetalle
     */
    public ControladorDetalle() {
        this.objDetalle = new CDetalle();
        this.selObjDetalle = new CDetalle();
        this.rolCarrera = new RolCarrera();
        this.lstDetalle = new ArrayList<>();
    }

    public CDetalle getObjDetalle() {
        return objDetalle;
    }

    public void setObjDetalle(CDetalle objDetalle) {
        this.objDetalle = objDetalle;
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

    public CDetalle getSelObjDetalle() {
        return selObjDetalle;
    }

    public void setSelObjDetalle(CDetalle selObjDetalle) {
        this.selObjDetalle = selObjDetalle;
    }

    @PostConstruct
    public void reinit() {

        CTipoTransacion objCTipoTransacion = new CTipoTransacion();
        this.objDetalle.setObjCTipoTransacion(objCTipoTransacion);
        this.selObjDetalle.setObjCTipoTransacion(objCTipoTransacion);

        Persona objPersona = new Persona();
        this.objDetalle.setObjPersona(objPersona);
        this.selObjDetalle.setObjPersona(objPersona);
    }

    //<editor-fold desc="Buscar cliente">
    public void buscar(int opMessage) {
        try {
            // Initial value for valid boolean
            boolean valid = false;
            // Do some computation
            FacesMessage message = null;
            String strCedula = objDetalle.getObjPersona().getCedula();
            if (!"".equals(strCedula)) {
                ArrayList<RolCarrera> lstRoles;
                lstRoles = (ArrayList<RolCarrera>) mLogin.buscar(strCedula);
                if (lstRoles.size() > 0) {
                    lstDetalle.clear();
                    valid = true;
                    rolCarrera = lstRoles.get(0);
                    this.objDetalle.setObjPersona(mLogin.datosUsuario(rolCarrera.getCodigoCarrera(), strCedula));

                    //  double saldo = Math.rint(MDetalle.saldoTotal(strCedula) * 1000) / 1000;
                    double saldo = MDetalle.saldoTotal(strCedula);
                    if (saldo >= 1) {
                        saldo = Math.rint(saldo * 100) / 100;
                    }
                    this.objDetalle.setDblValor(saldo);
                    this.lstDetalle.add(objDetalle);
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Búsqueda exitosa", "Cliente si forma parte de la ESPOCH");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No válido", "Cliente no forma parte de la ESPOCH");
                    lstDetalle.clear();
                    this.objDetalle = new CDetalle();

                }
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese numero de cédula");
                lstDetalle.clear();
                this.objDetalle = new CDetalle();
            }
            // Acquire Request Context instance
            RequestContext context = RequestContext.getCurrentInstance();
            // Add isValid parameter
            context.addCallbackParam("isValid", valid);
            // If valid equal true, render accepted message
            if (valid) {
                if (opMessage == 0) {
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
                // Acquire RequestContext singleton and update desired components
                RequestContext.getCurrentInstance().update("acceptedMessage");
                RequestContext.getCurrentInstance().update("TsaldoListForm");

            }
            // else If valid equal false, render refused message
            if (!valid) {
                // Add message into your FacesContext
                FacesContext.getCurrentInstance().addMessage(null, message);

// Acquire RequestContext singleton and update desired components
                RequestContext.getCurrentInstance().update("refusedMessage");
                RequestContext.getCurrentInstance().update("TsaldoListForm");

                lstDetalle.clear();
                this.objDetalle = new CDetalle();
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
//</editor-fold>

    public void insertar() {
        try {
            this.objDetalle.getObjCTipoTransacion().setCodigoTransaccion(2);
            this.objDetalle.setDblValor(this.selObjDetalle.getDblValor());
            if (MDetalle.insertar(objDetalle)) {
                buscar(1);
                DefaultRequestContext.getCurrentInstance().execute("PF('TsaldoRecargarDialog').hide()");
                Util.addSuccessMessage("Recarga exitosa");

            } else {
                Util.mostrarMensaje("Error");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
}
