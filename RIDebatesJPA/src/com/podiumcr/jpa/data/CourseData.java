package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.Course;

public class CourseData {

	private EntityManager em;

	public CourseData(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}

	public List<Course> getAll() {

		List<Course> returnedList = new ArrayList<>();

		try {

			TypedQuery<Course> querycourse = em.createNamedQuery("Course.findAll", Course.class);
			List<Course> listaC = querycourse.getResultList();
			returnedList = listaC;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}

	public Course getCourseByCode(String courseCode) {

		Course returnedList = new Course();

		try {

			TypedQuery<Course> querycourse = em.createNamedQuery("Course.findByCourseCode", Course.class);
			querycourse.setParameter("courseCode", courseCode);
			Course listaC = querycourse.getSingleResult();
			returnedList = listaC;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	
	public Course getCourseById(int id) {

		Course returnedList = new Course();

		try {

			TypedQuery<Course> querycourse = em.createNamedQuery("Course.findById", Course.class);
			querycourse.setParameter("id", id);
			Course listaC = querycourse.getSingleResult();
			returnedList = listaC;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	
	public boolean persistDebate(Course course) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.persist(course);
			em.getTransaction().commit();

			returned = true;

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			returned = false;
		}

		return returned;

	}

	public boolean removeDebate(Course course) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.remove(course);
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
