/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.data.DebateTypeData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Course;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.DebateType;
import com.podiumcr.jpa.entities.User;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Joss
 */
@ManagedBean(name = "debateBean")
@SessionScoped
public class DebateView implements Serializable {
     @ManagedProperty(value = "#{login}")
    private LoginAdmin login;
    
     EntityManager em = null;
    private String id;
    
    private List<Debate> debates;
    private String name;
    private Date createdDate;
    private DebateType debateType;
    private String startingDate;
    private String hour;
    private Course course1;
    private Course course2;
    private int sanction;

    private boolean isActive;
    private boolean buttonDisable; 
    private Debate selectedDebate;

    public DebateView(String name, Date createdDate, DebateType debateType, String startingDate, String hour, boolean isActive) {
        this.name = name;
        this.createdDate = createdDate;
        this.debateType = debateType;
        this.startingDate = startingDate;
        this.isActive = isActive;
        this.hour = hour;
    }

    /**
     * Creates a new instance of DebateNew
     */
    public DebateView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public DebateType getDebateType() {
        return debateType;
    }

    public void setDebateType(DebateType debateType) {
        this.debateType = debateType;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Debate getSelectedDebate() {
        return selectedDebate;
    }

    public void setSelectedDebate(Debate selectedDebate) {
        this.selectedDebate = selectedDebate;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getSanction() {
        return sanction;
    }

    public void setSanction(int sanction) {
        this.sanction = sanction;
    }

    public LoginAdmin getLogin() {
        return login;
    }

    public void setLogin(LoginAdmin login) {
        this.login = login;
    }
     public List<Debate> getDebates() {
        return debates;
    }

    public void setDebates(List<Debate> debates) {
        this.debates = debates;
    }

    public boolean isButtonDisable() {
        return buttonDisable;
    }

    public void setButtonDisable(boolean buttonDisable) {
        this.buttonDisable = buttonDisable;
    }

    public Course getCourse1() {
        return course1;
    }

    public void setCourse1(Course course1) {
        this.course1 = course1;
    }

    public Course getCourse2() {
        return course2;
    }

    public void setCourse2(Course course2) {
        this.course2 = course2;
    }
    
    
    
    @PostConstruct
    public void init() {
        if (this.selectedDebate == null) {
            this.selectedDebate  = new Debate();
        }
        if (this.debateType == null) {
            this.debateType  = new DebateType();
        }
        if (this.course1 == null) {
            this.course1  = new Course();
        }
         if (this.course2 == null) {
            this.course2  = new Course();
        }
        if (this.em==null) {
             this.em = login.em;
        }
        if (this.debates == null) {
        DebateData dd = new DebateData(em);
        this.debates = dd.getDebates();      
        }
        if (this.buttonDisable) {
        
        this.buttonDisable =  desableButton();    
        }
       
    }

    public void newDeb(ActionEvent event)  {
        FacesMessage message = null;
        Calendar date1 = Calendar.getInstance();
        DateFormat date2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String stringDate = this.startingDate + " " + this.hour;
        Date convert = null;
         try {
             convert = date2.parse(stringDate);
         } catch (ParseException ex) {
             Logger.getLogger(DebateView.class.getName()).log(Level.SEVERE, null, ex);
         }

        DebateData dD = new DebateData(em);
        DebateTypeData dTD = new DebateTypeData(em);
        Debate d;
      
        d = new Debate(this.name, date1.getTime(), this.debateType, convert, false);
       
        if (dD.persistDebate(d)) {
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nuevo", "Se ha agregado el debate: " + this.name);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } 

    }

    public void editDeb(ActionEvent event) {
        FacesMessage message = null;
        
        DebateData dd = new DebateData(em);
        Debate d = dd.getDebateById(this.selectedDebate.getIdDebates());
        d.setName(this.selectedDebate.getName());
        d.setDebateType(this.selectedDebate.getDebateType());
        
        DateFormat date2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String stringDate = this.startingDate + " " + this.hour;
        Date convert = null;
         try {
             convert = date2.parse(stringDate);
         } catch (ParseException ex) {
             Logger.getLogger(DebateView.class.getName()).log(Level.SEVERE, null, ex);
         }
        this.selectedDebate.setStartingDate(convert);
        
        d.setStartingDate(this.selectedDebate.getStartingDate());
        d.setCourse1(this.selectedDebate.getCourse1());
        d.setCourse2(this.selectedDebate.getCourse2());

        
        if (dd.persistDebate(d)) {
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nuevo", "Se ha editado el debate: " + this.name);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        } else {

            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se ha editado el debate: " + this.name);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }


    }

    public void deleteDeb(ActionEvent event) {
        FacesMessage message = null;
       
        DebateData dd = new DebateData(em);
        Debate nd = dd.getDebateById(this.selectedDebate.getIdDebates());
        if (dd.removeDebate(nd)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Se ha elimindo el debate");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

       

    }

   

    
    public void sanctionUser(ActionEvent event) {
        sanction++;
        FacesMessage message = null;
        message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Info", "Amonestación: " + sanction);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public boolean desableButton() {
      
        if (sanction > 3) {
            this.buttonDisable= true;
        } else {
            this.buttonDisable = false;
        }
        return this.buttonDisable;
    }

}
