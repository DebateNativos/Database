package com.riuldebates.entities;

import com.riuldebates.entities.Course;
import com.riuldebates.entities.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UsersCourse
 *
 */
@Entity

public class UsersCourse implements Serializable {

	
	private User user;
	private Course course;
	private double qualification;   
	@Id
	private int id;
	private static final long serialVersionUID = 1L;

	public UsersCourse() {
		super();
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}   
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
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
}
