/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import ec.edu.espoch.comedor.handler.LogMessageHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import wsWSInterop.Administrativo;
import wsWSInterop.AdministrativoJefe;
import wsWSInterop.DatosUsuario;
import wsWSInterop.DatosUsuarioMail;
import wsWSInterop.DatosUsuarioResponse;
import wsWSInterop.Empleado;
import wsWSInterop.EmpleadoDos;
import wsWSInterop.EmpleadoSMedico;

/**
 *
 * @author Usuario
 */
public class Principal {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.print("Cedula: ");
        s = sc.nextLine();
        /*
         System.out.println("Administrativos ------------------------------");
         List<Administrativo> objAdmin = getAdministrativos();
         for (Administrativo objE : objAdmin) {

         if (s.equals(objE.getStrCedula())) {
         System.out.println("\nCedula: " + objE.getStrCedula());
         System.out.println("Nombre: " + objE.getStrNombres());
         System.out.println("Cargo: " + objE.getStrCargo());
         System.out.println("Clave: " + objE.getStrClave());

         return;
         }
         }
         */
        /*
         Administrativo objDatos = loginAdmin(s);
         System.out.println("\nNombres: " + objDatos.getStrNombres());
         System.out.println("Cargo: " + objDatos.getStrCargo());
         
         Empleado obEmpleado = loginEmpleado(s);
         System.out.println("\nNombres: " + obEmpleado.getStrNombres());
         System.out.println("Cargo: " + obEmpleado.getStrClave());


         */
        System.out.println("Empleados ------------------------------");
        List<Empleado> objE = getEmpleados();
        for (Empleado obj : objE) {

            System.out.println("\nCedula: " + obj.getStrCedula());
            System.out.println("Nombre: " + obj.getStrNombres());
            System.out.println("Clave: " + obj.getStrClave());

        }

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
     Validar
     */
    private static DatosUsuarioResponse validarAdministrativo(wsWSInterop.DatosUsuario datosUsuario) {
        wsWSInterop.WSInterop service = new wsWSInterop.WSInterop();
        wsWSInterop.WSInteropSoap port = service.getWSInteropSoap();

        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);

        return port.validarAdministrativo(datosUsuario);
    }

    /*
     Obtener empleado por Apellido
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

    /*
     Login Administrador
     */
    public static Administrativo loginAdmin(String strCedula) {
        Administrativo objAdmin = new Administrativo();
        try {
            List<Administrativo> ltsAdmin = getAdministrativos();
            for (Administrativo objDatos : ltsAdmin) {
                if (strCedula.equals(objDatos.getStrCedula())) {
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
        Empleado objEmpleado = new Empleado();
        try {
            List<Empleado> objE = getEmpleados();
            for (Empleado obj : objE) {
                if (strCedula.equals(obj.getStrCedula())) {
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

    private static EmpleadoSMedico getEmpleadoSMedico(java.lang.String strCedula) {
        wsWSInterop.WSInterop service = new wsWSInterop.WSInterop();
        wsWSInterop.WSInteropSoap port = service.getWSInteropSoap();

        return port.getEmpleadoSMedico(strCedula);
    }
}
