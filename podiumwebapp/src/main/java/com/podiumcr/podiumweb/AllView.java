/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.data.DebateTypeData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Course;

import com.podiumcr.jpa.entities.User;

import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.DebateType;
import com.podiumcr.jpa.entities.Professor;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author Joss
 */
@ManagedBean(name = "allView")
@SessionScoped
public class AllView implements Serializable {

    private List<User> user;
    private List<Debate> debate;
    private List<Course> course;
    private List<DebateType> type;
    

    public AllView() {
    }

    public void init() {
        EntityManager em = entityManagerFactory.createEntityManager();
        DebateData dDta = new DebateData(em);
        UserData data = new UserData(em);
        CourseData cData = new CourseData(em);
        DebateTypeData typedata = new DebateTypeData(em);
        this.user = data.getUsers();
        this.debate = dDta.getDebates();
        this.course = cData.getAll();
        this.type = typedata.getAll();
        em.close();
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Debate> getDebate() {
        return debate;
    }

    public void setDebate(List<Debate> debate) {
        this.debate = debate;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public List<DebateType> getType() {
        return type;
    }

    public void setType(List<DebateType> type) {
        this.type = type;
    }

    public String roleSelected(User a) {
        String role = null;
        if (a instanceof Professor) {
            role = "Profesor";

        } else if (a.getIsAdmin() == true) {
            role = "Administrador";
        } else {
            role = "Estudiante";
        }
        return role;
    }

}
