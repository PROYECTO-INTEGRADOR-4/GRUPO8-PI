/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import wsInfoCarrera.Persona;
import wsSeguridad.RolCarrera;

/**
 *
 * @author Tupac
 */
@ManagedBean
@SessionScoped
@Named("controladorUserLogin")
public class ControladorUserLogin implements Serializable {

    /*
     Atributos
     */
    private static final long serialVersionUID = -2152389656664659476L;
    private String username;
    private String password;
    private Persona objUserLogin;
    private RolCarrera rolCarrera;
    private boolean logeado = false;

    /**
     * Creates a new instance of ControladorUserLogin
     */
    public ControladorUserLogin() {
        this.objUserLogin = new Persona();
        this.rolCarrera = new RolCarrera();
    }

    public boolean estaLogeado() {
        return logeado;
    }

    public RolCarrera getRolCarrera() {
        return rolCarrera;
    }
    /*
     Getters and Setters
     */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getObjUserLogin() {
        return objUserLogin;
    }

    public void setObjUserLogin(Persona objUserLogin) {
        this.objUserLogin = objUserLogin;
    }

    @PostConstruct
    public void reinit() {
    }

    /*
     Login
     */
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        /*
         if (username != null && password != null) {
         ArrayList<RolCarrera> lstRoles;
         lstRoles = new ArrayList<>();
         lstRoles = (ArrayList<RolCarrera>) mLogin.loginUsuario(username, password);
         if (lstRoles.size() > 0) {
         logeado = true;
         rolCarrera = lstRoles.get(0);
         this.objUserLogin = mLogin.datosUsuario(rolCarrera.getCodigoCarrera(), username);
         message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", objUserLogin.getNombres() + " " + objUserLogin.getApellidos());
         } else {
         logeado = false;
         message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Credenciales no válidas");
         }
         }
         */

        //Por el momento para administrador
        if (username != null && password != null) {
            //  ArrayList<RolCarrera> lstRoles;
            //lstRoles = new ArrayList<>();
            //lstRoles = (ArrayList<RolCarrera>) mLogin.loginUsuario(username, password);
            if (username.equals("0200949113") && password.equals("0200949113")) {
                logeado = true;
                // rolCarrera = lstRoles.get(0);
                //this.objUserLogin = mLogin.datosUsuario(rolCarrera.getCodigoCarrera(), username);
                this.rolCarrera.setNombreRol("Administrador");
                this.objUserLogin.setCedula(username);
                this.objUserLogin.setApellidos("Sanchez");
                this.objUserLogin.setNombres("Zoila");
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", objUserLogin.getNombres() + " " + objUserLogin.getApellidos());
            } else {
                logeado = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Credenciales no válidas");
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("logeado", logeado);
        if (logeado) {
            redireccionarPaginas(context);
            //context.addCallbackParam("view", "UsuarioNormal/bienvenida/inicio.xhtml");
        }
    }

    private void redireccionarPaginas(RequestContext context) {
        switch (this.rolCarrera.getNombreRol()) {
            case "Administrador":
                context.addCallbackParam("view", "Administrador/bienvenida/inicio.xhtml");
                break;
            case "Secretaria":
                context.addCallbackParam("view", "Secretaria/bienvenida/inicio.xhtml");
                break;
            default:
                context.addCallbackParam("view", "UsuarioNormal/bienvenida/inicio.xhtml");
        }
    }

    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        logeado = false;
    }
}
