/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.data.DebateTypeData;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.DebateType;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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

    private String id;

    private String name;
    private Date createdDate;
    private DebateType debateType;
    private String startingDate;
    private String hour;
    private int sanction;

    private boolean isActive;

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

    public void newDeb() throws ParseException {

        EntityManager em = entityManagerFactory.createEntityManager();
        Calendar date1 = Calendar.getInstance();
        DebateData dD = new DebateData(em);
        DebateTypeData dTD = new DebateTypeData(em);
        DateFormat date2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String stringDate = this.startingDate + " " + this.hour;
        Date convert = date2.parse(stringDate);
        selectedDebate = new Debate(this.name, date1.getTime(), this.debateType, convert, false);
        dD.persistDebate(selectedDebate);
        if (dD.persistDebate(selectedDebate)) {
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nuevo", "Se ha agregado el debate: " + this.name);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        em.close();

    }

    public void editDeb() {

        EntityManager em = entityManagerFactory.createEntityManager();
        DebateData dD = new DebateData(em);
        Debate nD = dD.getDebateById(this.selectedDebate.getIdDebates());
        nD.setName(this.selectedDebate.getName());
        nD.setDebateType(this.selectedDebate.getDebateType());
        nD.setStartingDate(this.selectedDebate.getStartingDate());
        nD.setCourse1(this.selectedDebate.getCourse1());
        nD.setCourse2(this.selectedDebate.getCourse2());

        // no existe update
        if(dD.persistDebate(nD)) {
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nuevo", "Se ha agregado el debate: " + this.name);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        em.close();

    }

    public void delete() {
        EntityManager em = entityManagerFactory.createEntityManager();
        DebateData dD = new DebateData(em);
        dD.removeDebate(selectedDebate);
        if (dD.removeDebate(selectedDebate)) {
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Se ha elimindo el debate");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        em.close();

    }

    public void sanctionUser(ActionEvent event) {
        sanction++;
        FacesMessage message = null;
        message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Info", "Amonestación: " + sanction);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public boolean desableButton() {
        boolean disableB = true;
        if (sanction >= 3) {
            disableB = true;
        } else {
            disableB = false;
        }
        return disableB;
    }

}
