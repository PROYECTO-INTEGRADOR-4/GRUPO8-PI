/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import ec.edu.espoch.comedor.entidad.CServicio;
import ec.edu.espoch.comedor.modelo.MServicio;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import wsInfoCarrera.Persona;
import wsSeguridad.RolCarrera;

/**
 *
 * @author Usuario
 */
public class ControladorMenuView {

    private MenuModel model;
    private Persona objUser;
    private RolCarrera objRolCarrera;
    private ArrayList<CServicio> lstS;
    private final HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private final ControladorUserLogin loginBean = (ControladorUserLogin) session.getAttribute("controladorUserLogin");

    public ControladorMenuView() {
        this.lstS = new ArrayList<>();
        this.objUser = new Persona();
    }

    public ArrayList<CServicio> getLstS() {
        return lstS;
    }

    @PostConstruct
    public void init() {
        menus();
    }

    public void menus() {

        if (loginBean.estaLogeado() == true) {
            objUser = loginBean.getObjUserLogin();
            objRolCarrera = loginBean.getRolCarrera();
            if (objRolCarrera.getNombreRol().equals("Administrador")) {
                menuAdmin();
            } else {
                menuCliente();
            }
        } else {
            menuPrincipal();
        }

    }

    public void menuAdmin() {
        model = new DefaultMenuModel();
        //Primer submenu
        DefaultSubMenu primerSubmenu = new DefaultSubMenu(objUser.getApellidos() + " " + objUser.getNombres());
        DefaultMenuItem item = new DefaultMenuItem("Inicio");
        item.setIcon("ui-icon-home");
        //  item.setCommand("#{menuView.save}"); Esto ejecuta un metodo en el controlador
        item.setOutcome("/Administrador/bienvenida/inicio.xhtml");
        primerSubmenu.addElement(item);

        item = new DefaultMenuItem("Mis Datos");
        item.setIcon("ui-icon-person");
        item.setCommand("#");
        item.setAjax(false);
        primerSubmenu.addElement(item);

        item = new DefaultMenuItem("Salir");
        item.setIcon("ui-icon-power");
        item.setCommand("#{controladorUserLogin.logout}");
        item.setOncomplete("logout(xhr, status, args)");
        primerSubmenu.addElement(item);

        //Segundo submenu
        cargarS();
        DefaultSubMenu segundoSubmenu = new DefaultSubMenu("Gestionar");

        item = new DefaultMenuItem("Servicio");
        item.setIcon("");
        item.setOutcome("/Administrador/servicio/listar.xhtml");
        segundoSubmenu.addElement(item);

        item = new DefaultMenuItem("Precio");
        item.setIcon("");
        item.setOutcome("/Administrador/precio/listar.xhtml");
        segundoSubmenu.addElement(item);

        DefaultSubMenu menuSubmenu = new DefaultSubMenu("Menu");
        for (CServicio objS : lstS) {
            item = new DefaultMenuItem(objS.getDescripcionservicio());
            item.setIcon("");
            item.setOutcome("/Administrador/menu/listar.xhtml");
            item.setParam("id", objS.getCodigoservicio());
            // item.setCommand("#{param.get('id')}");
            item.setParam("servicio", objS.getDescripcionservicio());

            // item.setCommand("#{controladorMenu.asignarId( param.get('id') )}");
            menuSubmenu.addElement(item);
        }
        segundoSubmenu.addElement(menuSubmenu);

        model.addElement(primerSubmenu);
        model.addElement(segundoSubmenu);
    }

    public void menuCliente() {
        model = new DefaultMenuModel();

        DefaultSubMenu primerSubmenu = new DefaultSubMenu();
        primerSubmenu.setLabel(objUser.getApellidos() + " " + objUser.getNombres());

        DefaultMenuItem item = new DefaultMenuItem("Inicio");
        item.setIcon("ui-icon-home");
        item.setOutcome("/UsuarioNormal/bienvenida/inicio.xhtml");
        primerSubmenu.addElement(item);

        item = new DefaultMenuItem("Mis Datos");
        item.setIcon("ui-icon-person");
        item.setCommand("#");
        item.setAjax(false);
        primerSubmenu.addElement(item);

        item = new DefaultMenuItem("Salir");
        item.setIcon("ui-icon-power");
        item.setCommand("#{controladorUserLogin.logout}");
        item.setOncomplete("logout(xhr, status, args)");
        primerSubmenu.addElement(item);

        model.addElement(primerSubmenu);

        DefaultSubMenu segundoSubmenu = new DefaultSubMenu("Servicios");
        cargarS();
        for (CServicio objS : lstS) {
            item = new DefaultMenuItem(objS.getDescripcionservicio());
            item.setIcon("");
            item.setOutcome("/UsuarioNormal/menu/listar.xhtml");
            item.setParam("id", objS.getCodigoservicio());
            item.setParam("servicio", objS.getDescripcionservicio());
            segundoSubmenu.addElement(item);
        }
        model.addElement(segundoSubmenu);
    }

    public void menuPrincipal() {
        model = new DefaultMenuModel();
        //Primer submenu
        DefaultSubMenu primerSubmenu = new DefaultSubMenu("Autenticación");
        DefaultMenuItem item = new DefaultMenuItem("Iniciar Sesión");
        item.setIcon("ui-icon-key");
        item.setOncomplete("PF('dlgLogin').show()");
        item.setUpdate("dialogLogin");
        primerSubmenu.addElement(item);

        //Segundo submenu
        DefaultSubMenu segundoSubmenu = new DefaultSubMenu("Nosotros");

        item = new DefaultMenuItem("Misión");
        item.setIcon("");
        item.setOutcome("/Administrador/servicio/listar.xhtml");
        segundoSubmenu.addElement(item);

        item = new DefaultMenuItem("Visión");
        item.setIcon("");
        item.setOutcome("/Administrador/precio/listar.xhtml");
        segundoSubmenu.addElement(item);

        model.addElement(primerSubmenu);
        model.addElement(segundoSubmenu);
    }

    private void cargarS() {
        try {
            lstS = (ArrayList<CServicio>) MServicio.cargar();
        } catch (Exception e) {
        }
    }

    /*
     Ojo esto esta ya para hacer con redireccionamiento dinamico
     */
    public void redireccionar() {

        if (objRolCarrera.getNombreRol().equals("Administrador")) {

        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
