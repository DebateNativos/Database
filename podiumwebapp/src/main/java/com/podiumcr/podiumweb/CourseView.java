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
import static com.podiumcr.podiumwebapp.common.EntityListener.em;
import com.podiumcr.jpa.entities.Course;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;


/**
 *
 * @author Joss
 */
@ManagedBean(name="courseView")
@ViewScoped
public class CourseView implements Serializable {
     
    private int idCourse;
    private String name;
    private String courseCode;
    private int curseQuarter;
    private int curseYear;
    private List<User> users;
    private Professor professor;
    
    
     
    CourseData dCourse = new CourseData(em);
    UserData prof = new UserData(em);
  
     public CourseView() {
    }

    public CourseView(String name, String courseCode, int curseQuarter, int curseYear, List<User> users, Professor professor) {
        
        this.name = name;
        this.courseCode = courseCode;
        this.curseQuarter = curseQuarter;
        this.curseYear = curseYear;
        this.users = users;
        this.professor = professor;
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

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
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
     public void newCourse(){
     Course course = new Course();
     
       //dCourse.
      
       
       RequestContext.getCurrentInstance().closeDialog("El usuario ha sido registrado");
    }
   public void editCourse(String nameSelected){
      Course cor = null;
      cor.setCourseCode(courseCode);
      cor.setCurseQuarter(curseQuarter);
      cor.setCurseYear(curseYear);
      cor.setProfessor(professor);
      cor.setName(name);
      
      //dCourse.
   }
   
}

