/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Professor;
import com.podiumcr.jpa.entities.User;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

/**
 *
 * @author Joss
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserView implements Serializable {

    @ManagedProperty(value = "#{login}")
    private LoginAdmin login;

    EntityManager em = null;
    private List<User> users;
    private int id;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String secondLastname;
    private Boolean admin;
    private int idUniversity;
    private String phone;
    private int role;
    private String address;
    private User selectedUser;

    /**
     * Creates a new instance of DialogView
     */
    public UserView() {
    }
    //hacer la instancia según el rol

    public UserView(String email, String password, String name, String lastName, String secondLastname, Boolean admin, int idUniversity, String phone, int role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.secondLastname = secondLastname;
        this.admin = admin;
        this.idUniversity = idUniversity;
        this.phone = phone;
        this.role = role;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LoginAdmin getLogin() {
        return login;
    }

    public void setLogin(LoginAdmin login) {
        this.login = login;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @PostConstruct
    public void init() {
        if (this.selectedUser == null) {
            this.selectedUser  = new User();
        }
        if (this.em==null) {
             this.em = login.em;
        }
        if (this.users == null) {
        UserData ud = new UserData(em);
        this.users = ud.getUsers();      
        }
        
    }

    public void newUser(ActionEvent event) {

        UserData ud = new UserData(em);
        FacesMessage message = null;
        User u;
        switch (role) {
            case 0:
                u = new User(this.email, this.password, this.address, this.name, this.lastName, this.secondLastname, this.idUniversity, true, this.phone);
                if (ud.registerUser(u)) {                   
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Administrador Insertado", this.email);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
                this.users = ud.getUsers();
                break;

            case 1:
                Professor p = new Professor(this.email, this.password, this.address, this.name, this.lastName, this.secondLastname, this.idUniversity, phone);
                p.setAdmin(false);
                if (ud.registerUser(p)) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor Insertado", this.email);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
                this.users = ud.getUsers();
                break;

            case 2:
                u = new User(this.email, this.password, this.address, this.name, this.lastName, this.secondLastname, this.idUniversity, false, this.phone);
                if (ud.registerUser(u)) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Estudiante Insertado", this.email);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
                this.users = ud.getUsers();
                break;
        }

    }

    public void editUser(ActionEvent event) {
        UserData ud = new UserData(em);
        User u = ud.getUserByEmail(this.selectedUser.getEmail());
        u.setEmail(this.selectedUser.getEmail());
        u.setAdmin(this.selectedUser.getIsAdmin());
        u.setIdUniversity(this.selectedUser.getIdUniversity());
        u.setName(this.selectedUser.getName());
        u.setLastName(this.selectedUser.getLastName());
        u.setLastName2(this.selectedUser.getLastName2());
        u.setPhone(this.selectedUser.getPhone());
        if (ud.updateUser(u)) {
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Editado", this.email);
            FacesContext.getCurrentInstance().addMessage(null, message);
            this.users = ud.getUsers();
        } else {
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario No Editado", this.email);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
    }

    //Terminar
    public void deleteUser() {

        //user.remove(selectedUser);
        selectedUser = null;
    }

    //Informar
}
