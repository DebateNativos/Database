/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.DebateType;
import static com.podiumcr.podiumwebapp.common.EntityListener.em;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import org.primefaces.context.RequestContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Joss
 */

@ManagedBean(name = "debateBean")
@SessionScoped
public class DebateView implements Serializable{
    
    private String id;

   
    private String name;
    private Date createdDate;
    private DebateType debateType;
    private Date startingDate;
    private Date hour;
    private int sanction; 
   
    
   
    private boolean isActive;
    
    
    private Debate selectedDebate; 
        
    public DebateView(String name, Date createdDate, DebateType debateType, Date startingDate, boolean isActive) {
        this.name = name;
        this.createdDate = createdDate;
        this.debateType = debateType;
        this.startingDate = startingDate;
        this.isActive = isActive;
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

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
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
     public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public int getSanction() {
        return sanction;
    }

    public void setSanction(int sanction) {
        this.sanction = sanction;
    }
    
    
    public void newDeb() {
        Debate newDebate = null;

        createdDate = Calendar.getInstance().getTime();

        if (startingDate == createdDate) {
            isActive = true;
        } else {
            isActive = false;
        }
       EntityManager em = entityManagerFactory.createEntityManager();
       DebateData dData = new DebateData(em);
       dData.persistDebate(newDebate);

        RequestContext.getCurrentInstance().closeDialog("El debate ha sido registrado");
    }
    
    public void sanctionUser(ActionEvent event){
        sanction++;
        FacesMessage message = null;
        message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Info", "Amonestación: " + sanction);
        FacesContext.getCurrentInstance().addMessage(null, message );
    
    }
    
    public boolean desableButton(){
    boolean desableB = true;
    if(sanction >= 3){
    desableB= true;
    }else{
    desableB= false;
    }
    return desableB;
            }
    
}
