/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Professor;
import com.podiumcr.jpa.entities.Course;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    
    @ManagedProperty(value = "#{login}")
    private LoginAdmin login;

    private EntityManager em = null;
    
    private List<Course> courses;
    private int idCourse;
    private String name;
    private String schedule;
    private int curseQuarter;
    private int curseYear;
    private String classroom;
    private String profEmail;
    
    private Professor professor;
    private List<Professor> professorList;

    private Course selectedCourse;

    public CourseView() {
    }

    public CourseView(String name, int curseQuarter, int curseYear, Professor professor, String classroom, String schedule) {

        this.name = name;
        this.curseQuarter = curseQuarter;
        this.curseYear = curseYear;       
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

    public LoginAdmin getLogin() {
        return login;
    }

    public void setLogin(LoginAdmin login) {
        this.login = login;
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getProfEmail() {
        return profEmail;
    }

    public void setProfEmail(String profEmail) {
        this.profEmail = profEmail;
    }
 
    @PostConstruct
    public void init() {
        if (this.selectedCourse == null) {
            this.selectedCourse  = new Course();
        }
        if (this.em == null) { 
             this.em = login.em;
        }
        if (this.courses == null) {
        CourseData c = new CourseData(em);
        this.courses = c.getAll();      
        }
        if (this.professorList == null) {
         UserData p = new UserData(em);
         this.professorList = p.getProfesors();      
        }    
    }

    public void newCourse(ActionEvent event) {        
        CourseData cd = new CourseData(em);
        UserData ud = new UserData(em);
        FacesMessage message = null;
        Course c;
        c = new Course(this.name, this.curseQuarter, this.curseYear, this.classroom, this.schedule);
        for (Professor p : this.professorList) {
            if (p.getEmail().equals(this.profEmail)) {
              c.setProfessor(p);  
            }
        }       
        if (cd.persistCourse(c)) {  
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso insertado", this.name);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        this.courses = cd.getAll();

    }

    public void editCourse(ActionEvent event) {
        System.out.println("CURSO " + this.selectedCourse.getName());
        FacesMessage message = null;
        CourseData cd = new CourseData(em);
        UserData ud = new UserData(em);
        Course c = cd.getCourseByCode(this.selectedCourse.getCourseCode());
        c.setClassroom(this.selectedCourse.getClassroom());
        c.setName(this.selectedCourse.getName());
        c.setCurseQuarter(this.selectedCourse.getCurseQuarter());
        c.setCurseYear(this.selectedCourse.getCurseYear());
        c.setSchedule(this.selectedCourse.getSchedule());
        c.setProfessor((Professor) ud.getUserByEmail(this.selectedCourse.getProfessor().getEmail()));  

        if (cd.persistCourse(c)) {         
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Editar", "El curso: " + this.name + "ha sido editado");
            FacesContext.getCurrentInstance().addMessage(null, message);
            this.courses =  cd.getAll();
        } else {        
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Editar", "El curso: " + this.name + " NO ha sido editado");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }       
    }

    public void deleteCourse(ActionEvent event) {
        FacesMessage message = null;
        CourseData cd = new CourseData(em);
        Course c = cd.getCourseByCode(this.selectedCourse.getCourseCode());
        if (cd.removeCourse(c)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar", "El curso ha sido eliminado");
            FacesContext.getCurrentInstance().addMessage(null, message);
            this.courses = cd.getAll();
        }
    }
 }