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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import com.podiumcr.jpa.entities.User;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import java.io.Serializable;
<<<<<<< Updated upstream
import java.util.List;
import javax.persistence.EntityManager;
import org.primefaces.context.RequestContext;
=======
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
>>>>>>> Stashed changes

/**
 *
 * @author Joss
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginAdmin implements Serializable {

    private String email;
    private String password;
<<<<<<< Updated upstream
    private User user;
    private UIComponent component;
    private List<Debate> debates;
    private List<User> users;
    private List<Course> course;
=======
    private User userVerification = new User();
    UserData userdata = new UserData(em);

    private UIComponent component;
>>>>>>> Stashed changes

    public LoginAdmin() {
    }

<<<<<<< Updated upstream
    public LoginAdmin(String email, String password, User user) {
        this.email = email;
        this.password = password;
        this.user = user;
=======
    public LoginAdmin(String email, String password) {
        this.email = email;
        this.password = password;
>>>>>>> Stashed changes
    }

    public LoginAdmin(UIComponent component) {
        this.component = component;
    }

<<<<<<< Updated upstream
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
=======
    public LoginAdmin(String email, String password, User user) {
        this.email = email;
        this.password = password;
        this.userVerification = user;
>>>>>>> Stashed changes
    }

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }
<<<<<<< Updated upstream
=======

    public User getUserVerification() {
        return userVerification;
    }

    public void setUserVerification(User userVerification) {
        this.userVerification = userVerification;
    }
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
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

    public void loginSession(ActionEvent event) {

        EntityManager em = entityManagerFactory.createEntityManager();

        User userToVerify = new User(email, password, "", "", "", "", 0, true, email);
        User userVerification = new User();
=======
    public void loginSession(ActionEvent event) {

        EntityManager em = entityManagerFactory.createEntityManager();
        User user = new User(email, password, "", "", "", "", 0, true, email);

>>>>>>> Stashed changes
        RequestContext context = RequestContext.getCurrentInstance();
        UserData userdata = new UserData(em);
        DebateData dDta = new DebateData(em);
        UserData data = new UserData(em);
        CourseData cData = new CourseData(em);
        FacesMessage message = null;
        this.userVerification = userdata.getUserByEmail(email);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
<<<<<<< Updated upstream
        boolean loggedIn = false;

        if (email.equals(userVerification.getEmail())) {
            if (password != null && userToVerify.getPassword().equals(userVerification.getPassword()) && userVerification.getIsAdmin() == true) {
                try {
                    this.user = userVerification;
                    this.users = data.getUsers();
                    this.course = cData.getAll();
                    this.debates = dDta.getDebates();
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", user.getName());
                    ec.redirect("menuPrincipal.xhtml");
                    loggedIn = true;
                } catch (IOException ex) {
                    ex.printStackTrace();
                    //Logger.getLogger(this.email).log(Level.SEVERE, null, ex);
                     loggedIn = false;
                }

            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al iniciar sesión", "Contraseña Inválida");
            }
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al iniciar sesión", "Correo Electronico Inválido");
=======
        boolean loggedIn;

        if (password != null && user.getPassword().equals(userVerification.getPassword()) && userVerification.getIsAdmin() == true) {
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
>>>>>>> Stashed changes
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        em.close();
    }

    //Diferenciar profes, estdiantes y administradores.
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

}
