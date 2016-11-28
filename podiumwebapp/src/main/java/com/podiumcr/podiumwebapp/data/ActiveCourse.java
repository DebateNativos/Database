/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.data;

import com.podiumcr.jpa.entities.Course;
import javax.ws.rs.Path;

/**
 *
 * @author Soler
 */
public class ActiveCourse {

    private int idCourse;
    private String name;
    private String courseCode;
    private String classroom;
    private String schedule;
    private int curseQuarter;
    private int curseYear;
    private String professor;


    public ActiveCourse() {
    }

    public ActiveCourse(int idCourse, String name, String classroom, String schedule, int curseQuarter, int curseYear, String professor) {

        this.idCourse = idCourse;
        this.name = name;
        this.classroom = classroom;
        this.schedule = schedule;
        this.curseQuarter = curseQuarter;
        this.curseYear = curseYear;
        this.professor = professor;

    }

    public ActiveCourse(Course c) {
        this.idCourse = c.getIdCourse();
        this.name = c.getName();
        this.classroom = c.getClassroom();
        this.schedule = c.getSchedule();
        this.curseQuarter = c.getCurseQuarter();
        this.curseYear = c.getCurseYear();
        this.professor = c.getProfessor().getName() + " " + c.getProfessor().getLastName();

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

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
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

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
    
     public void ConvertCourse(Course c) {
        this.idCourse = c.getIdCourse();
        this.name = c.getName();
        this.classroom = c.getClassroom();
        this.schedule = c.getSchedule();
        this.curseQuarter = c.getCurseQuarter();
        this.curseYear = c.getCurseYear();
    }

}
