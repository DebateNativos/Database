package com.podiumcr.jpa.entities;

import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.User;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity

public class Question implements Serializable {


	private int idQuestion;
	private Debate debate;
	private User user;
	private String question;
	private static final long serialVersionUID = 1L;

	public Question() {
		
	}  
	
	public Question(Debate debate, User user, String question) {
		super();
		this.debate = debate;
		this.user = user;
		this.question = question;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	public Debate getDebate() {
		return this.debate;
	}

	public void setDebate(Debate debate) {
		this.debate = debate;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}   
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}   

   
}
