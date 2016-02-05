/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.ResizeEvent;

/**
 *
 * @author Usuario
 */
public class resizableView {

    public void onResize(ResizeEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Image resized", "Width:" + event.getWidth() + ",Height:" + event.getHeight());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
