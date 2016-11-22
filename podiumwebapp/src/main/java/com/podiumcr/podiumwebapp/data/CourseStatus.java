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
public class CourseStatus {
    private String status;
    private ActiveCourse course;

    public CourseStatus() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ActiveCourse getCourse() {
        return course;
    }

    public void setCourse(ActiveCourse course) {
        this.course = course;
    }
    
    
}
