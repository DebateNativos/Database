/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.jpa.data.UserCourseData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Course;
import com.podiumcr.jpa.entities.User;
import com.podiumcr.jpa.entities.UserCourse;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

/**
 *
 * @author Joss
 */
@ManagedBean(name = "professorBean")
@SessionScoped

public class professorView implements Serializable {

   @ManagedProperty(value = "#{login}")
    private LoginAdmin login; 
    
   private List<Course> course;
   private List<UserCourse> students;
   private Course selectedCourse;
   
    public professorView() {
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }
    
    
    public void editProfessor(){
    EntityManager em = entityManagerFactory.createEntityManager();
    UserData ud = new UserData(em);
    User u = ud.getUserByEmail(this.login.getUser().getEmail());
   
        u.setIdUniversity(this.login.getUser().getIdUniversity());
        u.setName(this.login.getUser().getName());
        u.setLastName(this.login.getUser().getLastName());
        u.setLastName2(this.login.getUser().getLastName2());
        u.setPhone(this.login.getUser().getPhone());
        u.setAddress(this.login.getUser().getAddress());
        if (ud.updateUser(u)) {
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Editar", "Su perfil ha sido editado");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        } else {
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario No Editado", "Su perfil no ha sido editado");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        em.close();
        
        
    }
    
   
    public List<Course> listCourse(){
    EntityManager em = entityManagerFactory.createEntityManager();
    CourseData cData = new CourseData(em);
    Course c;
    course = cData.getAll();
    List<Course> professorList = new ArrayList<>();
    
    for(int x=0;x<course.size();x++) {
      c= course.get(x);
      
     if (c.getProfessor().equals(login.getUser())){
     professorList.add(c);
     em.close();
     }      
}

    return professorList;
    }
    
    public List<UserCourse> listPerCourse(){
    EntityManager em = entityManagerFactory.createEntityManager();
    UserCourseData uCD = new UserCourseData(em); 
    students = uCD.getCourseUsers(selectedCourse);
    em.close();
        
    return students;
    }
    
    public void saveGrade(){
    
    
    }
    
    
    
}
