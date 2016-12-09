package com.podiumcr.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@XmlRootElement
@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
		@NamedQuery(name= "Comment.findByDebate", query = "SELECT c FROM Comment c WHERE c.debate = :debate"),
		@NamedQuery(name= "Comment.findByUser", query = "SELECT c FROM Comment c WHERE c.user = :user"),
		@NamedQuery(name= "Comment.findByCourse", query = "SELECT c FROM Comment c WHERE c.course = :course"),
		@NamedQuery(name= "Comment.findByDebate&Course", query = "SELECT c FROM Comment c WHERE c.course = :course AND c.debate = :debate")
})
public class Comment implements Serializable {

	private int idComment;
	private Debate debate;
	private User user;
	private String text;
	private Course course;
	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}

	public Comment(Debate debate, User user, String text, Course course) {
		super();
		this.debate = debate;
		this.user = user;
		this.text = text;
		this.course = course;
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="debate", nullable=false)
	public Debate getDebate() {
		return debate;
	}

	public void setDebate(Debate debate) {
		this.debate = debate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user", nullable=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="course", nullable=false)
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
   
	
}
