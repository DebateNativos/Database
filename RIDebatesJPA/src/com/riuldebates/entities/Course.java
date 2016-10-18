package com.riuldebates.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name = "course")
@NamedQueries(value = {
		@NamedQuery(name= "Course.findAll", query = "SELECT c FROM Course c"),
		@NamedQuery(name= "Course.findById", query = "SELECT c FROM Course c WHERE c.idCourse = :id"),
		@NamedQuery(name= "Course.findByProfessor", query = "SELECT c FROM Course c WHERE c.professor = :professor"),
		@NamedQuery(name= "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
		@NamedQuery(name= "Course.findByCourseCode", query = "SELECT c FROM Course c WHERE c.courseCode = :courseCode"),
		@NamedQuery(name= "Course.findByQuarterYear", query = "SELECT c FROM Course c WHERE c.curseQuarter = :curseQuarter AND c.curseYear = :curseYear")
})
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCourse;
	private String name;
	private String courseCode;
	private int curseQuarter;
	private int curseYear;
	private double finalQualification;
	private List<User> users;
	private Professor professor;

	public Course() {
	}

	public Course(String name, String courseCode, int curseQuarter, int curseYear) {
		this.name = name;
		this.courseCode = courseCode;
		this.curseQuarter = curseQuarter;
		this.curseYear = curseYear;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdCourse() {
		return this.idCourse;
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

	@Column(unique=true)
	public String getCourseCode() {
		return this.courseCode;
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

	public double getFinalQualification() {
		return this.finalQualification;
	}

	public void setFinalQualification(double finalQualification) {
		this.finalQualification = finalQualification;
	}
	
	@OneToMany (mappedBy="course", targetEntity= UserCourse.class, fetch = FetchType.LAZY)
	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="course_professor")
	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}