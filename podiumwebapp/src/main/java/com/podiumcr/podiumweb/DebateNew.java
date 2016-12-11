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
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Joss
 */

@Named(value = "debateNew")
@SessionScoped
public class DebateNew implements Serializable{
    
    private String id;

   
    private String name;
    private Date createdDate;
    private DebateType debateType;
    private Date startingDate;
    private Date hour;
   
    
   
    private boolean isActive;
    
    
    private Debate selectedDebate; 
        
    public DebateNew(String name, Date createdDate, DebateType debateType, Date startingDate, boolean isActive) {
        this.name = name;
        this.createdDate = createdDate;
        this.debateType = debateType;
        this.startingDate = startingDate;
        this.isActive = isActive;
    }

    
    /**
     * Creates a new instance of DebateNew
     */
    public DebateNew() {
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
    
    
}
