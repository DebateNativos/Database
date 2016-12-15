/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Professor;
import com.podiumcr.jpa.entities.User;
import com.podiumcr.jpa.entities.Course;

import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

/**
 *
 * @author Joss
 */
@ManagedBean(name = "courseBean")
@SessionScoped
public class CourseView implements Serializable {

    private int idCourse;
    private String name;
    private String schedule;
    private int curseQuarter;
    private int curseYear;
    private String classroom;
    private List<User> users;
    private Professor professor;

    private Course selectedCourse;

    public CourseView() {
    }

    public CourseView(String name, String courseCode, int curseQuarter, int curseYear, List<User> users, Professor professor, String classroom, String schedule) {

        this.name = name;
        this.curseQuarter = curseQuarter;
        this.curseYear = curseYear;
        this.users = users;
        this.professor = professor;
        this.schedule = schedule;
        this.classroom = classroom;

    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getCurseQuarter() {
        return curseQuarter;
    }

    public void setCurseQuarter(int curseQuarter) {
        this.curseQuarter = curseQuarter;
    }

    public int getCurseYear() {
        return curseYear;
    }

    public void setCurseYear(int curseYear) {
        this.curseYear = curseYear;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public void newCourse(ActionEvent event) {

        EntityManager em = entityManagerFactory.createEntityManager();
        CourseData courseN = new CourseData(em);

        selectedCourse = new Course(this.name, this.curseQuarter, this.curseYear, this.classroom, this.schedule);
        courseN.persistCourse(selectedCourse);

        if (courseN.persistCourse(selectedCourse)) {
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso insertado", this.name);
            FacesContext.getCurrentInstance().addMessage(null, message);
            em.close();
        }

    }

    public void editCourse(ActionEvent event) {
        EntityManager em = entityManagerFactory.createEntityManager();
        CourseData courseN = new CourseData(em);
        Course c = courseN.getCourseByCode(this.selectedCourse.getCourseCode());
        c.setClassroom(this.selectedCourse.getClassroom());
        c.setName(this.selectedCourse.getName());
        c.setCurseQuarter(this.selectedCourse.getCurseQuarter());
        c.setCurseYear(this.selectedCourse.getCurseYear());
        c.setSchedule(this.selectedCourse.getSchedule());
        c.setProfessor(this.selectedCourse.getProfessor());

        //no encontré un método para el update
        if (courseN.persistCourse(c)) {
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Editar", " El curso ha se modificado");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        em.close();

        //dCourse.
    }

    public void deleteCourse(ActionEvent event) {
        EntityManager em = entityManagerFactory.createEntityManager();
        CourseData courseN = new CourseData(em);
        Course c = courseN.getCourseByCode(this.selectedCourse.getCourseCode());
        if (courseN.removeCourse(c)) {
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso ha sido eliminado", c.getName());
            FacesContext.getCurrentInstance().addMessage(null, message);
            em.close();
        }

    }
    
    public List<Professor> listProfessor(){
    EntityManager em = entityManagerFactory.createEntityManager();
    UserData uD = new UserData(em);
    User u;
    users = uD.getUsers();
    List<Professor> professorList = new ArrayList<>();
    
    for(int x=0;x<users.size();x++) {
      u= users.get(x);
      
     if (u instanceof Professor){
         
     professorList.add((Professor) u);
     
     em.close();
     }      
}

    return professorList;
    }

}
