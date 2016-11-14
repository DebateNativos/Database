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

/*	@NamedQueries(value = {
			@NamedQuery(name= "Course.findAll", query = "SELECT c FROM Course c"),
			@NamedQuery(name= "Course.findById", query = "SELECT c FROM Course c WHERE c.idCourse = :id"),
			@NamedQuery(name= "Course.findByProfessor", query = "SELECT c FROM Course c WHERE c.professor = :professor"),
			@NamedQuery(name= "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
			@NamedQuery(name= "Course.findByCourseCode", query = "SELECT c FROM Course c WHERE c.courseCode = :courseCode"),
			@NamedQuery(name= "Course.findByQuarterYear", query = "SELECT c FROM Course c WHERE c.curseQuarter = :curseQuarter AND c.curseYear = :curseYear")
	})*/
	
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
}
