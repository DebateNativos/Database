/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.data;

import com.podiumcr.jpa.entities.DebateType;
import java.util.Date;

/**
 *
 * @author Soler
 */
public class ActiveDebate {

    private int idDebates;
    private String name;
    private DebateType debateType;
    private Date startingDate;
    private boolean isActive;

    public ActiveDebate() {
    }

    public int getIdDebates() {
        return idDebates;
    }

    public void setIdDebates(int idDebates) {
        this.idDebates = idDebates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    

}
