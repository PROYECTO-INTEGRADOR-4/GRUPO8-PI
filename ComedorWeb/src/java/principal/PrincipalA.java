/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import ec.edu.espoch.comedor.handler.LogMessageHandler;
import ec.edu.espoch.comedor.modelo.mLogin;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import wsInfoCarrera.Estudiante;
import wsInfoCarrera.Persona;
import wsInfoGeneral.ArrayOfInstitucionEstudiante;
import wsInfoGeneral.ArrayOfUnidadAcademica;
import wsInfoGeneral.InstitucionEstudiante;
import wsSeguridad.ArrayOfRolCarrera;
import wsSeguridad.RolCarrera;
import wsWSInterop.DatosUsuarioResponse;
import wsWSInterop.Empleado;

/**
 *
 * @author Usuario
 */
public class PrincipalA {

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

    private static ArrayOfInstitucionEstudiante getInstitucionEstudiante(java.lang.String strcedula) {
        wsInfoGeneral.InfoGeneral service = new wsInfoGeneral.InfoGeneral();
        wsInfoGeneral.InfoGeneralSoap port = service.getInfoGeneralSoap();

        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);

        return port.getInstitucionEstudiante(strcedula);
    }

    public static void main(String arg[]) {

        // ArrayOfRolCarrera carrera = getRolUsuarioCarrera("180419297-7");
        List<wsWSInterop.Administrativo> objE = getAdministrativos();
        objE.stream().forEach((Empleado) -> {
            System.out.println("\nCedula: " + Empleado.getStrCedula());
            System.out.println("Nombre: " + Empleado.getStrNombres());
            System.out.println("Rol: " + Empleado.getStrCargo());
        });
        /*
         ArrayOfInstitucionEstudiante estudiante = getInstitucionEstudiante("180419297-7");
         List<InstitucionEstudiante> datosEstudiante = estudiante.getInstitucionEstudiante();
         datosEstudiante.stream().forEach((datosE) -> {
         System.out.println("Cedula: " + datosE.getStrCedula());
         System.out.println("Cedula: " + datosE.getStrCedula());
         System.out.println("Apellidos: " + datosE.getStrApellidos());
         System.out.println("Nombre: " + datosE.getStrNombres());

         ArrayOfRolCarrera carrera = getRolUsuarioCarrera(datosE.getStrCedula());
         List<RolCarrera> rol = carrera.getRolCarrera();
         rol.stream().forEach((Rol) -> {
         System.out.println("Carrera: " + Rol.getCodigoCarrera());
         System.out.println("Rol: " + Rol.getNombreRol());
         });
         });
         Estudiante est = getDatosCompletosEstudiante("180510830-3");
         System.out.println("Nombre: " + est.getNombres());
         System.out.println("Apellidos: " + est.getApellidos());
         System.out.println("Correo: " + est.getEmail());
         System.out.println("Padre: " + est.getPadre());

         ArrayOfUnidadAcademica carreras = getTodasCarreras();
         List<UnidadAcademica> ca = carreras.getUnidadAcademica();
         ca.stream().forEach((Carrera) -> {
         System.out.println("Cod Escuela: " + Carrera.getCodEscuela());
         System.out.println("Nombre: " + Carrera.getNombre());
         });
         
         ArrayOfRolCarrera carrera = getRolUsuarioCarrera("180419297-7");
         List<RolCarrera> rol = carrera.getRolCarrera();
         for (RolCarrera Rol : rol) {
         System.out.println("Carrera: " + Rol.getCodigoCarrera());
         System.out.println("Rol: " + Rol.getNombreRol());
         }
         */
        /*
         Si el usuario al menos tiene un rol, quiere decir que se encutra
         registrado como estudiante o docente de la poli.
        
         System.out.print("Ingrese su numero de cedula con guion:");
         Scanner c = new Scanner(System.in);
         String cedula = c.nextLine();
         System.out.print("Password:");
         Scanner p = new Scanner(System.in);
         String password = p.nextLine();

         ArrayList<RolCarrera> lstRoles;
         lstRoles = new ArrayList<>();

         Persona objPersona = new Persona();  //Variable de InfoCarrera
         lstRoles = (ArrayList<RolCarrera>) mLogin.loginUsuario(cedula, password);
         if (lstRoles.size() > 0) {
         System.out.println("\n Credenciales correctos: ");
         String strCarreraCod = lstRoles.get(0).getCodigoCarrera();
         objPersona = mLogin.datosUsuario(strCarreraCod, cedula);
         System.out.println("\n Datos Usuario: ");
         System.out.println("Cedula: " + objPersona.getCedula());
         }
         */
        /*
         Persona objPerson = getDatosUsuarioCarrera("EIS", "172292236-4");
         System.out.println("\nNombre: " + objPerson.getNombres());
         System.out.println("\nApellido: " + objPerson.getApellidos());
         */
    }

    private static Estudiante getDatosCompletosEstudiante(java.lang.String strCedula) {
        wsInfoCarrera.InfoCarrera service = new wsInfoCarrera.InfoCarrera();
        wsInfoCarrera.InfoCarreraSoap port = service.getInfoCarreraSoap();

        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);

        return port.getDatosCompletosEstudiante(strCedula);
    }

    private static ArrayOfUnidadAcademica getTodasCarreras() {
        wsInfoGeneral.InfoGeneral service = new wsInfoGeneral.InfoGeneral();
        wsInfoGeneral.InfoGeneralSoap port = service.getInfoGeneralSoap();

        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);

        return port.getTodasCarreras();
    }

    private static Persona getDatosUsuarioCarrera(java.lang.String codCarrera, java.lang.String cedula) {
        wsInfoCarrera.InfoCarrera service = new wsInfoCarrera.InfoCarrera();
        wsInfoCarrera.InfoCarreraSoap port = service.getInfoCarreraSoap();

        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);

        return port.getDatosUsuarioCarrera(codCarrera, cedula);

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

    private static java.util.List<wsWSInterop.AdministrativoJefe> getAdministrativosJefe() {
        wsWSInterop.WSInterop service = new wsWSInterop.WSInterop();
        wsWSInterop.WSInteropSoap port = service.getWSInteropSoap();

        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);

        return port.getAdministrativosJefe();
    }

    /*
     Empleados 
     */
    private static DatosUsuarioResponse getEmpleado(java.lang.String cedula) {
        wsWSInterop.WSInterop service = new wsWSInterop.WSInterop();
        wsWSInterop.WSInteropSoap port = service.getWSInteropSoap();

        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);

        return port.getEmpleado(cedula);
    }

}
