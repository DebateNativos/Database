/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Professor;
import com.podiumcr.jpa.entities.User;
import static com.podiumcr.podiumwebapp.common.EntityListener.em;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import org.primefaces.event.CellEditEvent;


/**
 *
 * @author Joss
 */

@ManagedBean(name = "dialogView")
@SessionScoped
public class UserView implements Serializable {
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
 

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
           
   
   UserData user = new UserData(em);
    /**
     * Creates a new instance of DialogView
     */
   
    public UserView()  {
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

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    
    
   public void newUser1(ActionEvent event) {

        EntityManager em = entityManagerFactory.createEntityManager();
        UserData ud = new UserData(em);
       
       switch (role) {
           case 0:
               selectedUser = new User(this.email, this.password, this.address, this.name, this.lastName,this.secondLastname, this.idUniversity,true, this.phone);
              ud.registerUser(this.selectedUser);
                  if (ud.registerUser(this.selectedUser)) {
                    FacesMessage message = null;
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Administrador Insertado", this.email);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
               break;
           case 1:
               selectedUser = new Professor(this.email, this.password, this.address, this.name, this.lastName, this.secondLastname, this.idUniversity,phone);
               
               selectedUser.setAdmin(false);
                
                if (ud.registerUser(this.selectedUser)) {
                    FacesMessage message = null;
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor Insertado", this.email);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
                break;
               
           case 2:
            selectedUser = new User(this.email, this.password, this.address, this.name, this.lastName, this.secondLastname, this.idUniversity,false, this.phone);
            
               selectedUser.setAdmin(false);
                if (ud.registerUser(this.selectedUser)) {
                    FacesMessage message = null;
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Estudiante Insertado", this.email);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            break;
       }
       
 
        em.close();

    }
    public void editUser1(){
     
     User editUser = null;
       
    }

    //Terminar
  public void deleteUser() {
     
        //user.remove(selectedUser);
        selectedUser = null;
    }
  
  //Informar

  
     

}
