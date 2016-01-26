/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.accesodatos;

import java.net.URL;

/**
 *
 * @author root
 */
public class Ruta {

    // AQUI VA EL PATH RELATIVO DEL ARCHIVO PROPERTIES
    private final String dbPostgres = "/propiedades/dbpostgres.properties";

    public URL getFileDbPostgres() {
        return getClass().getResource(dbPostgres);
    }

}
