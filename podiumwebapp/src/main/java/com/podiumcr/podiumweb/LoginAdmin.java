/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import javax.faces.event.ActionEvent;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.User;
import static com.podiumcr.podiumwebapp.common.EntityListener.em;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import java.io.Serializable;
import javax.persistence.EntityManager;


/**
 *
 * @author Joss
 */
@ManagedBean(name="login")
@SessionScoped
public class LoginAdmin implements Serializable {

   String email;
   String password;
  
   private UIComponent component;

    public LoginAdmin(UIComponent component) {
        this.component = component;
    }

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }
   
    public LoginAdmin() {
    }
    
    public LoginAdmin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
 
 public void loginSession(ActionEvent event) {
        
        EntityManager em = entityManagerFactory.createEntityManager(); 
        User user = new User(email, password, "", "", "", "", 0, true, email);
        User userVerification = new User();
  
        UserData userdata = new UserData(em);
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        userVerification = userdata.getUserByEmail(email);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        boolean loggedIn;
        
        if(password!= null && user.getPassword().equals(userVerification.getPassword()) && userVerification.getIsAdmin()== true) {
            loggedIn = true;
            try {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", userVerification.getName());
                ec.redirect("menuPrincipal.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            loggedIn = false;
            
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al iniciar sesión", "Credenciales inválidas");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        em.close();
    } 
    
 public String userName(){
     UserData userdata = new UserData(em);
     User user = userdata.getUserByEmail(email);
     String name = user.getName() + " " + user.getLastName();
         return name;
 }
    //Diferenciar profes, estdiantes y administradores.
    
    public String logout(){
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    return "/index.xhtml?faces-redirect=true";
    }

}
