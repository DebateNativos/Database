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
public class ActiveComment {
    
    private ActiveUser user;
    private String text;

    public ActiveComment(ActiveUser user, String text) {
        this.user = user;
        this.text = text;
    }
   
    public ActiveUser getUser() {
        return user;
    }

    public void setUser(ActiveUser user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
