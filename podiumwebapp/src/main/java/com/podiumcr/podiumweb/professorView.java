/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.jpa.entities.Course;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
   private Course selectedCourse;
   
    public professorView() {
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
    
    
    
}
