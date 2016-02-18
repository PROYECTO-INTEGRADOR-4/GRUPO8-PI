/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.modelo;

import java.util.List;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import ec.edu.espoch.comedor.handler.LogMessageHandler;
import java.util.ArrayList;
import wsInfoCarrera.Persona;
import wsSeguridad.ArrayOfRolCarrera;
import wsSeguridad.RolCarrera;
import wsWSInterop.Administrativo;
import wsWSInterop.Empleado;

/**
 *
 * @author Tupac
 */
public class mLogin {

    /*
     Autenticar Usuario
     */
    public static List<RolCarrera> loginUsuario(String strUsuarioCedula, String strUsuarioPassword) {
        List<RolCarrera> roles = new ArrayList<>();
        try {
            ArrayOfRolCarrera usuario = autenticarUsuarioCarrera(strUsuarioCedula, strUsuarioPassword);
            if (usuario != null) {
                List<RolCarrera> rol = usuario.getRolCarrera();
                for (RolCarrera Rol : rol) {
                    /*
                     System.out.println("\nCod Carrera: " + Rol.getCodigoCarrera());
                     System.out.println("Rol: " + Rol.getNombreRol());
                     */

                    roles.add(Rol);
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return roles;
    }
    /*
     Login Administrador
     */

    public static Administrativo loginAdmin(String strCedula) {
        Administrativo objAdmin = null;
        try {
            List<Administrativo> ltsAdmin = getAdministrativos();
            for (Administrativo objDatos : ltsAdmin) {
                if (strCedula.equals(objDatos.getStrCedula())) {
                    objAdmin = new Administrativo();
                    objAdmin.setStrCedula(objDatos.getStrCedula());
                    objAdmin.setStrNombres(objDatos.getStrNombres());
                    objAdmin.setStrCargo(objDatos.getStrCargo());
                    objAdmin.setStrClave(objDatos.getStrClave());

                    return objAdmin;
                }
            }
        } catch (Exception e) {
            throw e;

        }
        return objAdmin;
    }

    /*
     Login Empleado
     */
    public static Empleado loginEmpleado(String strCedula) {
        Empleado objEmpleado = null;
        try {
            List<Empleado> objE = getEmpleados();
            for (Empleado obj : objE) {
                if (strCedula.equals(obj.getStrCedula())) {
                    objEmpleado = new Empleado();
                    objEmpleado.setStrCedula(obj.getStrCedula());
                    objEmpleado.setStrNombres(obj.getStrNombres());
                    objEmpleado.setStrClave(obj.getStrClave());

                    return objEmpleado;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return objEmpleado;
    }
    /*
     Consumir servicio para autenticar  
     */

    private static ArrayOfRolCarrera autenticarUsuarioCarrera(java.lang.String login, java.lang.String password) {
        wsSeguridad.Seguridad service = new wsSeguridad.Seguridad();
        wsSeguridad.SeguridadSoap port = service.getSeguridadSoap();

        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);

        return port.autenticarUsuarioCarrera(login, password);
    }

    /*
     Consumo servico para recoger datos de la persona al autenticar
     */
    public static Persona datosUsuario(String strCarreraCod, String strUsuarioCedula) {
        Persona usuPersona = new Persona();
        try {
            usuPersona = getDatosUsuarioCarrera(strCarreraCod, strUsuarioCedula);
        } catch (Exception e) {
            throw e;
        }
        return usuPersona;
    }

    private static wsInfoCarrera.Persona getDatosUsuarioCarrera(java.lang.String codCarrera, java.lang.String cedula) {
        wsInfoCarrera.InfoCarrera service = new wsInfoCarrera.InfoCarrera();
        wsInfoCarrera.InfoCarreraSoap port = service.getInfoCarreraSoap();
        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);
        return port.getDatosUsuarioCarrera(codCarrera, cedula);
    }

    //Buscar cliente
    public static List<RolCarrera> buscar(String strCedula) throws Exception {
        List<RolCarrera> ltsRoles = new ArrayList<>();
        try {
            ArrayOfRolCarrera objArrayOfRolCarrera = getRolUsuarioCarrera(strCedula);
            if (objArrayOfRolCarrera != null) {
                List<RolCarrera> objRolCarrera = objArrayOfRolCarrera.getRolCarrera();
                ltsRoles = objRolCarrera;
            } else {
                ltsRoles.clear();
            }
        } catch (Exception e) {
            ltsRoles.clear();
            throw e;
        }
        return ltsRoles;
    }

    private static ArrayOfRolCarrera getRolUsuarioCarrera(java.lang.String login) {
        wsSeguridad.Seguridad service = new wsSeguridad.Seguridad();
        wsSeguridad.SeguridadSoap port = service.getSeguridadSoap();

        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);

        return port.getRolUsuarioCarrera(login);
    }

    private static java.util.List<wsWSInterop.Administrativo> getAdministrativos() {
        wsWSInterop.WSInterop service = new wsWSInterop.WSInterop();
        wsWSInterop.WSInteropSoap port = service.getWSInteropSoap();

        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);

        return port.getAdministrativos();
    }

    private static java.util.List<wsWSInterop.Empleado> getEmpleados() {
        wsWSInterop.WSInterop service = new wsWSInterop.WSInterop();
        wsWSInterop.WSInteropSoap port = service.getWSInteropSoap();

        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);

        return port.getEmpleados();
    }

}
