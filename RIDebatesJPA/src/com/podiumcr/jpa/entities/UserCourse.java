package com.podiumcr.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.podiumcr.jpa.entities.Course;
import com.podiumcr.jpa.entities.User;

/**
 * Entity implementation class for Entity: UsersCourse
 *
 */
@Entity
@Table(name = "user_course")
@NamedQueries(value = {
		@NamedQuery(name = "UserCourse.findAll", query = "SELECT uc FROM UserCourse uc"),
		@NamedQuery(name= "UserCourse.findById", query = "SELECT uc FROM UserCourse uc WHERE uc.user = :user"),
		@NamedQuery(name= "UserCourse.findByUser", query = "SELECT uc FROM UserCourse uc WHERE uc.course = :course")
})
public class UserCourse implements Serializable {

	
	private int id;
	private User user;
	private Course course;
	private double qualification;   
	private static final long serialVersionUID = 1L;

	public UserCourse() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}  
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="course")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}  
	
	public double getQualification() {
		return this.qualification;
	}

	public void setQualification(double qualification) {
		this.qualification = qualification;
	}   
	

}
