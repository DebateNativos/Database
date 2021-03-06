package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.Course;
import com.podiumcr.jpa.resources.CodeGenerator;

public class CourseData {

	private EntityManager em;

	public CourseData(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}

	public List<String> getAllCodes() {

		List<String> returnedList = new ArrayList<>();

		try {

			TypedQuery<String> querycourse = em.createNamedQuery("Course.findAllCodes", String.class);
			List<String> listaC = querycourse.getResultList();
			returnedList = listaC;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
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
			returnedList = null;
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

	public boolean persistCourse(Course course) {

		boolean returned = false;

		do {
			
			try {

				em.getTransaction().begin();
				em.persist(course);
				em.flush();
				em.getTransaction().commit();

				returned = true;

			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
				returned = false;
				CodeGenerator cd = new CodeGenerator();
				course.setCourseCode(cd.getToken(5));
			}
			
		} while (returned = false);

		return returned;

	}
	
	public boolean updateCourse(Course course) {

		boolean returned = false;

		do {
			
			try {
				Course c = this.getCourseByCode(course.getCourseCode());
				em.getTransaction().begin();
				c.setName(course.getName());
				c.setProfessor(course.getProfessor());
				c.setSchedule(course.getSchedule());
				c.setCurseQuarter(course.getCurseQuarter());
				c.setCurseYear(course.getCurseYear());
				c.setClassroom(course.getClassroom());
				em.getTransaction().commit();

				returned = true;

			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
				returned = false;
			}
			
		} while (returned = false);

		return returned;

	}


	public boolean removeCourse(Course course) {

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
