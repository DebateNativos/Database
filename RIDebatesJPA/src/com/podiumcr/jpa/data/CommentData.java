package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.Comment;
import com.podiumcr.jpa.entities.Course;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.User;


/*@NamedQueries(value = {
		@NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
		@NamedQuery(name= "Comment.findByDebate", query = "SELECT c FROM Comment c WHERE c.debate = :debate"),
		@NamedQuery(name= "Comment.findByUser", query = "SELECT c FROM Comment c WHERE c.user = :user"),
		@NamedQuery(name= "Comment.findByCourse", query = "SELECT c FROM Comment c WHERE c.course = :course")
		@NamedQuery(name= "Comment.findByDebate&Course", query = "SELECT c FROM Comment c WHERE c.course = :course AND c.debate = :debate")
})*/
public class CommentData {
	private EntityManager em;

	public CommentData(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}

	public List<Comment> getComments() {

		List<Comment> returnedList = new ArrayList<>();

		try {

			TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
			List<Comment> listaComment = query.getResultList();
			returnedList = listaComment;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}

	public List<Comment> getCommentByDebate(Debate debate) {

		List<Comment> returnedList = new ArrayList<>();

		try {

			TypedQuery<Comment> query = em.createNamedQuery("Comment.findByDebate", Comment.class);
			query.setParameter("debate", debate);
			List<Comment> listaComment = query.getResultList();
			returnedList = listaComment;
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}

	public List<Comment> getCommentByUser(User user) {

		List<Comment> returnedList = new ArrayList<>();

		try {

			TypedQuery<Comment> query = em.createNamedQuery("Comment.findByUser", Comment.class);
			query.setParameter("user", user);
			List<Comment> listaComment = query.getResultList();
			returnedList = listaComment;
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}

	public List<Comment> getCommentByCourse(Course course) {

		List<Comment> returnedList = new ArrayList<>();

		try {

			TypedQuery<Comment> query = em.createNamedQuery("Comment.findByCourse", Comment.class);
			query.setParameter("course", course);
			List<Comment> listaComment = query.getResultList();
			returnedList = listaComment;
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}
	
	public List<Comment> getCommentByDebateCourse(Course course, Debate debate) {

		List<Comment> returnedList = new ArrayList<>();

		try {

			TypedQuery<Comment> query = em.createNamedQuery("Comment.findByDebate&Course", Comment.class);
			query.setParameter("course", course);
			query.setParameter("debate", debate);
			List<Comment> listaComment = query.getResultList();
			returnedList = listaComment;
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}
	
	public boolean persistComment(Comment comment) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.persist(comment);
			em.getTransaction().commit();

			returned = true;

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			returned = false;
		}

		return returned;

	}
}
