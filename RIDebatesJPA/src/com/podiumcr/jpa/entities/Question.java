package com.podiumcr.jpa.entities;

import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.User;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Question
 *
 */
@XmlRootElement
@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
		@NamedQuery(name= "Question.findByDebate", query = "SELECT q FROM Question q WHERE q.debate = :debate"),
		@NamedQuery(name= "Question.findByUser", query = "SELECT q FROM Question q WHERE q.user = :user"),
		@NamedQuery(name= "Question.findByActive", query = "SELECT q FROM Question q WHERE q.active = :active"),
		@NamedQuery(name= "Question.findActivesFromDebate", query = "SELECT q FROM Question q WHERE q.active = :active AND q.debate = :debate")
})

public class Question implements Serializable {

	private int idQuestion;
	private Debate debate;
	private User user;
	private String text;
	private Boolean active;
	private static final long serialVersionUID = 1L;

	public Question() {

	}

	public Question(Debate debate, User user, String text, Boolean active) {
		super();
		this.debate = debate;
		this.user = user;
		this.text = text;
		this.active = active;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}


}
