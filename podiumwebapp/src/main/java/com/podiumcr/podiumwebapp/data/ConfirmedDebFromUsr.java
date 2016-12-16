/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.data;

import com.podiumcr.jpa.entities.ConfirmedUser;

/**
 *
 * @author Soler
 */
public class ConfirmedDebFromUsr {

    private int role;
    private int debate;
    private int warning;
    private String team;
    private int minutesToTalk;
    private boolean isTalking;

    public ConfirmedDebFromUsr(int role, int debate, int warning, String team, int minutesToTalk, boolean isTalking) {
        this.role = role;
        this.debate = debate;
        this.warning = warning;
        this.team = team;
        this.minutesToTalk = minutesToTalk;
        this.isTalking = isTalking;
    }
     public ConfirmedDebFromUsr(ConfirmedUser cu) {
        this.role = cu.getRole().getIdRole();
        this.debate = cu.getDebate().getIdDebates();
        this.warning = cu.getWarnings();
        this.team = cu.getTeam();
        this.minutesToTalk = cu.getMinutesToTalk();
        this.isTalking = cu.isTalking();
    }
    
    public ConfirmedDebFromUsr() {

    }
     
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getDebate() {
        return debate;
    }

    public void setDebate(int debate) {
        this.debate = debate;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    public int getMinutesToTalk() {
        return minutesToTalk;
    }

    public void setMinutesToTalk(int minutesToTalk) {
        this.minutesToTalk = minutesToTalk;
    }

    public boolean isIsTalking() {
        return isTalking;
    }

    public void setIsTalking(boolean isTalking) {
        this.isTalking = isTalking;
    }

    
}
