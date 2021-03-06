/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.ConfirmedUserData;
import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.data.DebateTypeData;
import com.podiumcr.jpa.entities.ConfirmedUser;
import com.podiumcr.jpa.entities.Course;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.DebateType;
import com.podiumcr.jpa.entities.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;
import java.util.List;
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
    private Date std;
    private String startingDate;
    private String hour;
    private Course course1;
    private Course course2;
    private String code;
    private String code2;
    private int sanction;
    private Debate active;
    private List<ConfirmedUser> confUsers;
    private List<ConfirmedUser> group1;
    private List<ConfirmedUser> group2;

    private boolean isActive;
    private boolean buttonDisable;
    private Debate selectedDebate;
    private ConfirmedUser userSelected;

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

    public Date getStd() {
        return std;
    }

    public void setStd(Date std) {
        this.std = std;
    }

    public Debate getActive() {
        return active;
    }

    public void setActive(Debate active) {
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public List<ConfirmedUser> getConfUsers() {
        return confUsers;
    }

    public void setConfUsers(List<ConfirmedUser> confUsers) {
        this.confUsers = confUsers;
    }

    public List<ConfirmedUser> getGroup1() {
        return group1;
    }

    public void setGroup1(List<ConfirmedUser> group1) {
        this.group1 = group1;
    }

    public List<ConfirmedUser> getGroup2() {
        return group2;
    }

    public void setGroup2(List<ConfirmedUser> group2) {
        this.group2 = group2;
    }

    public ConfirmedUser getUserSelected() {
        return userSelected;
    }

    public void setUserSelected(ConfirmedUser userSelected) {
        this.userSelected = userSelected;
    }
    

    @PostConstruct
    public void init() {
        if (this.selectedDebate == null) {
            this.selectedDebate = new Debate();
        }

        if (this.debateType == null) {
            this.debateType = new DebateType();
        }
        if (this.course1 == null) {
            this.course1 = new Course();
        }
        if (this.course2 == null) {
            this.course2 = new Course();
        }
        if (this.em == null) {
            this.em = login.em;
        }
        if (this.debates == null) {
            DebateData dd = new DebateData(em);
            this.debates = dd.getDebates();
        }
        if (this.buttonDisable) {
            this.buttonDisable = desableButton();
        }
        if (this.active == null) {
            this.active = this.activeDebate();
        }
         if (this.userSelected == null) {
            this.userSelected = new ConfirmedUser();
        }
          if (this.group1 == null) {
            this.group1 = new ArrayList<>();
        }
          if (this.group2 == null) {
            this.group2 = new ArrayList<>();
        }
        if (this.confUsers == null) {
            ConfirmedUserData cud = new ConfirmedUserData(this.em);
            this.confUsers = cud.getUsersFromDebate(this.active);
        }
  
    }

    public void newDebate() {
        System.out.println("sirve?");
        FacesMessage message = null;
        Calendar date1 = Calendar.getInstance();
        DebateData dD = new DebateData(em);
        CourseData cd = new CourseData(em);
        DebateTypeData dTD = new DebateTypeData(em);
        Debate d;
        d = new Debate(this.name, date1.getTime(), dTD.getDebateTypeById(1), this.std, false, cd.getCourseByCode(code), cd.getCourseByCode(code2));
        if (dD.persistDebate(d)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nuevo", "Se ha agregado el debate: " + this.name);
            FacesContext.getCurrentInstance().addMessage(null, message);
            this.debates = dD.getDebates();
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "No se ha agregado el debate");
            FacesContext.getCurrentInstance().addMessage(null, message);

        }
    }

    public void editDeb() {
        System.out.println("TESSSSSSSSTTTTTTT " + this.selectedDebate.getIdDebates() + " ---------------");

        CourseData cd = new CourseData(em);
        DebateData dd = new DebateData(em);
        Debate d = dd.getDebateById(this.selectedDebate.getIdDebates());
        d.setName(this.selectedDebate.getName());
        d.setDebateType(this.selectedDebate.getDebateType());
        d.setStartingDate(this.selectedDebate.getStartingDate());

        if (dd.persistDebate(d)) {

            this.debates = dd.getDebates();
        } else {
            System.out.println("TESSSSSSSSTTTTTTT " + this.selectedDebate.getIdDebates());
        }

    }

    public void deleteDeb(ActionEvent event) {
        FacesMessage message = null;
        System.out.println("sirve?");
        DebateData dd = new DebateData(em);
        Debate nd = dd.getDebateById(this.selectedDebate.getIdDebates());
        if (dd.removeDebate(nd)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Se ha elimindo el debate");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void sanctionUser() {
        
        for (ConfirmedUser cu: this.confUsers) {
            if (userSelected.equals(cu)) {
                int warnings = cu.getWarnings();
                warnings++;
                cu.setWarnings(warnings);
                
            }
        }
    }
    
    public void startUser() {
        ConfirmedUserData cud = new ConfirmedUserData(this.em);
        for (ConfirmedUser cu: this.confUsers) {
            if (userSelected.equals(cu)) {
                
                cu.setTalking(true);
                cud.updateConfirmedUser(cu);
            }
        }
    }


    public boolean desableButton() {

        if (sanction > 3) {
            this.buttonDisable = true;
        } else {
            this.buttonDisable = false;
        }
        return this.buttonDisable;
    }

    public Debate activeDebate() {
        for (Debate debate : this.debates) {
            if (debate.getIsActive() == true) {
                active = debate;
            }
        }
        return active;
    }

    public void startDebate() {
        FacesMessage message = null;

        DebateData dd = new DebateData(em);
        Debate d = dd.getDebateById(this.selectedDebate.getIdDebates());
        for (Debate deb : this.debates) {
            if (deb.equals(d)) {
                d.setIsActive(true);
                if (dd.persistDebate(d)) { 
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inicio", "Se ha iniciado el debate: " + d.getName());
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    active = d;
                    this.debates = dd.getDebates();
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se ha iniciado el debate: " + d.getName());
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            } else {
                deb.setIsActive(false);
                dd.persistDebate(deb);
            }
        }

    }

    public void stopDebate() {
        FacesMessage message = null;
        DebateData dd = new DebateData(em);
        Debate d = dd.getDebateById(this.active.getIdDebates());
        d.setIsActive(false);
        if (dd.persistDebate(d)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Deneter", "Se ha detenido el debate: " + d.getName());
            FacesContext.getCurrentInstance().addMessage(null, message);
            active = d;
            this.debates = dd.getDebates();
        }
    }
    
    public void getGroups() {
        ConfirmedUserData cud = new ConfirmedUserData(this.em);
            this.confUsers = cud.getUsersFromDebate(this.active);
            for (ConfirmedUser confUser : confUsers) {
                if (confUser.getTeam().equals(this.active.getCourse1().getCourseCode())) {
                    this.group1.add(confUser);
                } else if (confUser.getTeam().equals(this.active.getCourse2().getCourseCode())) {
                    this.group2.add(confUser);
                }
            }
    }
    
    
}
