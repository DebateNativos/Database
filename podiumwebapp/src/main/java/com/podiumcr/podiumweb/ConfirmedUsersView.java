/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.ConfirmedUserData;
import com.podiumcr.jpa.entities.ConfirmedUser;
import com.podiumcr.jpa.entities.Course;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.Role;
import com.podiumcr.jpa.entities.User;
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
    private List<ConfirmedUser> group1;
    private List<ConfirmedUser> group2;
    private User user;
    private ConfirmedUser selectedUser;
    private Course course;
    private Role role;
    private int warnings;

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

    public List<ConfirmedUser> getGroup1() {
        return group1;
    }

    public void setGroup1(List<ConfirmedUser> group1) {
        this.group1 = group1;
    }

    public List<ConfirmedUser> getGroup2() {
        return group2;
    }

    public void setGroup2(List<ConfirmedUser> group2) {
        this.group2 = group2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ConfirmedUser getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(ConfirmedUser selectedUser) {
        this.selectedUser = selectedUser;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getWarnings() {
        return warnings;
    }

    public void setWarnings(int warnings) {
        this.warnings = warnings;
    }
    
    

    public void init() {
        ConfirmedUserData cud = new ConfirmedUserData(this.em);
        Debate deb = debateView.activeDebate();
        if (this.confUsers == null) { 
            this.confUsers = cud.getUsersFromDebate(deb);
            for (ConfirmedUser confUser : confUsers) {
                if (confUser.getTeam().equals(deb.getCourse1().getCourseCode())) {
                    this.group1.add(confUser);
                }else if (confUser.getTeam().equals(deb.getCourse2().getCourseCode())) {
                    this.group2.add(confUser);
                }
            }
        }

    }

    public void giveWordTo() {
        ConfirmedUserData cud = new ConfirmedUserData(this.em);
        
        
    }

}
