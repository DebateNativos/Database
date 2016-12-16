/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.data.DebateTypeData;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Course;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.DebateType;
import com.podiumcr.jpa.entities.Professor;
import com.podiumcr.jpa.entities.User;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Joss
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginAdmin implements Serializable {

    EntityManager em = entityManagerFactory.createEntityManager();
    
    private String email;
    private String password;   
    private User user;
    private UIComponent component;
    private List<Debate> debates;
    private List<User> users;
    private List<Course> course;
    private List<DebateType> type;

    public LoginAdmin() {
    }

    public LoginAdmin(String email, String password, User user) {
        this.email = email;
        this.password = password;
        this.user = user;
    }

    public LoginAdmin(UIComponent component) {
        this.component = component;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
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

    public List<Debate> getDebates() {
        return debates;
    }

    public void setDebates(List<Debate> debates) {
        this.debates = debates;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public List<DebateType> getType() {
        return type;
    }

    public void setType(List<DebateType> type) {
        this.type = type;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void reloadTables() {
        UserData ud = new UserData(em);
        this.users = ud.getUsers();
        ;
    }
       
    public void loginSession(ActionEvent event) {

        User userToVerify = new User(email, password, "", "", "", "", 0, true, "");        
        RequestContext context = RequestContext.getCurrentInstance();
        UserData userdata = new UserData(em);
        DebateData dDta = new DebateData(em);
        CourseData cData = new CourseData(em);
        FacesMessage message = null;
        User userVerification = userdata.getUserByEmail(email);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

        boolean loggedIn = false;

        if (email.equals(userVerification.getEmail())) {
            if (password != null && userToVerify.getPassword().equals(userVerification.getPassword()) && userVerification.getIsAdmin() == true) {
                    this.user = userVerification;
                    this.users = userdata.getUsers();
                    this.course = cData.getAll();
                    this.debates = dDta.getDebates();
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", user.getName());
                try {
                    ec.redirect("menuPrincipal.xhtml");
                } catch (IOException ex) {                   
                    Logger.getLogger(LoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                    loggedIn = true;
               
            } else if(password != null && userToVerify.getPassword().equals(userVerification.getPassword()) && userVerification instanceof Professor){
                this.user = userVerification;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", user.getName());                    
                try {
                    ec.redirect("homeProf.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(LoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } 
            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al iniciar sesión", "Contraseña Inválida");
            }
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al iniciar sesión", "Correo Electronico Inválido");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }

    //Diferenciar profes, estdiantes y administradores.
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    public String roleSelected(User a) {
        String role = null;
        if (a instanceof Professor) {
            role = "Profesor";

        } else if (a.getIsAdmin() == true) {
            role = "Administrador";
        } else {
            role = "Estudiante";
        }
        return role;
    }

    public String activeDebate(Debate d) {
        String active = null;

        if (d.getIsActive() == true) {
            active = "Activo";
        } else {
            active = "Inactivo";
        }

        return active;
    }

    void sendResetPassword() {

    }

    public void deleteUser(ActionEvent event) {
        addMessage("Eliminar", "Usuario borrado");
    }

    public void deleteCourse(ActionEvent event) {
        addMessage("Eliminar", "Curso eliminado");
    }

    public void deleteDebate(ActionEvent event) {
        addMessage("Eliminar", "Debate eliminado");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
