/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.comedor.controlador;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class UtilitiesManagedBean {

    public String validate() {
        // Initial value for valid boolean
        boolean valid = false;
        // Do some computation
        if (Math.floor(Math.random() * 10) % 2 == 0) {
            valid = true;
        }
        // Acquire Request Context instance
        RequestContext context = RequestContext.getCurrentInstance();
        // Add isValid parameter
        context.addCallbackParam("isValid", valid);
        // If valid equal true, render accepted message
        if (valid) {
            // Add message into your FacesContext
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Your request is accepeted ! Congrats"));
            // Acquire RequestContext singleton and update desired components
            RequestContext.getCurrentInstance().update("acceptedMessage");
        }
        // else If valid equal false, render refused message
        if (!valid) {
            // Add message into your FacesContext
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Your request is refused ! Sorry"));
            // Acquire RequestContext singleton and update desired components
            RequestContext.getCurrentInstance().update("refusedMessage");
        }
        return "";
    }
}
