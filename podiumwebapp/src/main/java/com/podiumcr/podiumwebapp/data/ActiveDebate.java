/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.data;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Soler
 */
public class ActiveDebate {

    private int idDebates;
    private String name;
    private String debateType;
    private int debateTypeId;
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

    public String getDebateType() {
        return debateType;
    }

    public void setDebateType(String debateType) {
        this.debateType = debateType;
    }

    public int getDebateTypeId() {
        return debateTypeId;
    }

    public void setDebateTypeId(int debateTypeId) {
        this.debateTypeId = debateTypeId;
    }

    

}
