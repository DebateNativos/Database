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
public class LoginStatus {
    
    private String status;
    private String token;
    private ActiveUser user;

    public LoginStatus() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ActiveUser getUser() {
        return user;
    }

    public void setUser(ActiveUser user) {
        this.user = user;
    }
    
    
    
}
