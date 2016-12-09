package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.Question;
import com.podiumcr.jpa.entities.User;

/*
@NamedQueries(value = {
		@NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
		@NamedQuery(name= "Question.findByDebate", query = "SELECT q FROM Question q WHERE q.debate = :debate"),
		@NamedQuery(name= "Question.findByUser", query = "SELECT q FROM Question q WHERE q.user = :user"),
		@NamedQuery(name= "Question.findByActive", query = "SELECT q FROM Question q WHERE q.active = :active")
}) 
 */
public class QuestionData {

	private EntityManager em;

	public QuestionData(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}

	public List<Question> getQuestions() {

		List<Question> returnedList = new ArrayList<>();

		try {

			TypedQuery<Question> query = em.createNamedQuery("Question.findAll", Question.class);
			List<Question> listaQuestion = query.getResultList();
			returnedList = listaQuestion;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}

	public List<Question> getQuestionByDebate(Debate debate) {

		List<Question> returnedList = new ArrayList<>();

		try {

			TypedQuery<Question> query = em.createNamedQuery("Question.findByDebate", Question.class);
			query.setParameter("debate", debate);
			List<Question> listaQuestion = query.getResultList();
			returnedList = listaQuestion;
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}

	public List<Question> getQuestionByUser(User user) {

		List<Question> returnedList = new ArrayList<>();

		try {

			TypedQuery<Question> query = em.createNamedQuery("Question.findByUser", Question.class);
			query.setParameter("user", user);
			List<Question> listaQuestion = query.getResultList();
			returnedList = listaQuestion;
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}

	public List<Question> getQuestionByStatus(Boolean status) {

		List<Question> returnedList = new ArrayList<>();

		try {

			TypedQuery<Question> query = em.createNamedQuery("Question.findByActive", Question.class);
			query.setParameter("active", status);
			List<Question> listaQuestion = query.getResultList();
			returnedList = listaQuestion;
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}
	

	public List<Question> getQuestionByDebateStatus(Boolean status, Debate debate) {

		List<Question> returnedList = new ArrayList<>();

		try {

			TypedQuery<Question> query = em.createNamedQuery("Question.findActivesFromDebate", Question.class);
			query.setParameter("active", status);
			query.setParameter("debate", debate);
			List<Question> listaQuestion = query.getResultList();
			returnedList = listaQuestion;
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}
}
