/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.data;

import com.podiumcr.podiumwebapp.data.ActiveCourse;
import com.podiumcr.podiumwebapp.data.ActiveUser;

/**
 *
 * @author Soler
 */
public class ActiveUserCourse {
    
    private ActiveCourse course;
    private double qualification;

    public ActiveUserCourse(ActiveCourse course, double qualification) {
        this.course = course;
        this.qualification = qualification;
    }
   
    public ActiveCourse getCourse() {
        return course;
    }

    public void setCourse(ActiveCourse course) {
        this.course = course;
    }

    public double getQualification() {
        return qualification;
    }

    public void setQualification(double qualification) {
        this.qualification = qualification;
    }
    
    
}
