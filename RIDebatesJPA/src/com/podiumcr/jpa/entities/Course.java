package com.podiumcr.jpa.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.jpa.resources.CodeGenerator;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name = "course")
@NamedQueries(value = {
		@NamedQuery(name= "Course.findAll", query = "SELECT c FROM Course c"),
		@NamedQuery(name= "Course.findAllCodes", query = "SELECT c.courseCode FROM Course c"),
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
	private String classroom;
	private String schedule;
	private int curseQuarter;
	private int curseYear;
	private List<User> users;
	private Professor professor;
	private List<Comment> comments;

	public Course() {
	}

	public Course(String name, int curseQuarter, int curseYear, String classroom, String schedule) {
		CodeGenerator cd = new CodeGenerator();
		this.name = name;
		this.courseCode = cd.getToken(5);
		this.curseQuarter = curseQuarter;
		this.curseYear = curseYear;
		this.classroom = classroom;
		this.schedule = schedule;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@OneToMany (mappedBy="course", targetEntity= UserCourse.class, fetch = FetchType.LAZY)
	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="professor")
	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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

	@OneToMany (mappedBy="course", targetEntity= Comment.class, fetch = FetchType.LAZY)
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}