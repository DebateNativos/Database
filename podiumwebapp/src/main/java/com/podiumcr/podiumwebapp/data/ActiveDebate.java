/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.data;

import java.util.Date;

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
    private String course1;
    private String course2;
    

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

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    

}
