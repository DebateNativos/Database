/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.ConfirmedUserData;
import com.podiumcr.jpa.entities.ConfirmedUser;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

/**
 *
 * @author Soler
 */
@ManagedBean(name = "ConfirmedUsersBean")
@SessionScoped
public class ConfirmedUsersView {

    @ManagedProperty(value = "#{debateBean}")
    private DebateView debateView;

    private EntityManager em = null;

    private List<ConfirmedUser> confUsers;

    public DebateView getDebateView() {
        return debateView;
    }

    public void setDebateView(DebateView debateView) {
        this.debateView = debateView;
    }

    public List<ConfirmedUser> getConfUsers() {
        return confUsers;
    }

    public void setConfUsers(List<ConfirmedUser> confUsers) {
        this.confUsers = confUsers;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void init() {
        ConfirmedUserData cud = new ConfirmedUserData(this.em); 
        if (this.confUsers == null) { 
            this.confUsers = cud.getUsersFromDebate(debateView.activeDebate()); 
        }

    }

    public void getUsersFromDebate() {

    }

}
