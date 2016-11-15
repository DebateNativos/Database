/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.data;

/**
 *
 * @author Soler
 */
public class ActiveDebateSections {
    
    private int sectionNUmber;
    private int minutesPerUser;
    private boolean activeSection;

    public ActiveDebateSections(int sectionNUmber, int minutesPerUser, boolean activeSection) {
        this.sectionNUmber = sectionNUmber;
        this.minutesPerUser = minutesPerUser;
        this.activeSection = activeSection;
    }

    public int getSectionNUmber() {
        return sectionNUmber;
    }

    public void setSectionNUmber(int sectionNUmber) {
        this.sectionNUmber = sectionNUmber;
    }

    public int getMinutesPerUser() {
        return minutesPerUser;
    }

    public void setMinutesPerUser(int minutesPerUser) {
        this.minutesPerUser = minutesPerUser;
    }

    public boolean isActiveSection() {
        return activeSection;
    }

    public void setActiveSection(boolean isActiveSection) {
        this.activeSection = isActiveSection;
    }
    
    
}
