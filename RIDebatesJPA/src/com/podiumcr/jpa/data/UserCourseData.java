package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.Course;
import com.podiumcr.jpa.entities.User;
import com.podiumcr.jpa.entities.UserCourse;

public class UserCourseData {
	private EntityManager em;

	public UserCourseData(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}
	/*
	 * @NamedQuery(name = "UserCourse.findAll", query =
	 * "SELECT uc FROM UserCourse uc"),
	 * 
	 * @NamedQuery(name= "UserCourse.findCoursesByUser", query =
	 * "SELECT uc FROM UserCourse uc WHERE uc.user = :user"),
	 * 
	 * @NamedQuery(name= "UserCourse.findByUsersByCourse", query =
	 * "SELECT uc FROM UserCourse uc WHERE uc.course = :course")
	 */

	public List<UserCourse> getAll() {

		List<UserCourse> returnedList = new ArrayList<>();

		try {

			TypedQuery<UserCourse> querycourse = em.createNamedQuery("UserCourse.findAll", UserCourse.class);
			List<UserCourse> listaC = querycourse.getResultList();
			returnedList = listaC;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}

	public List<UserCourse> getUserCourses(User user) {

	List<UserCourse> returnedList = new ArrayList<>();

		try {

			TypedQuery<UserCourse> querycourse = em.createNamedQuery("UserCourse.findCoursesByUser", UserCourse.class);
			querycourse.setParameter("user", user);
			List<UserCourse> listaC = querycourse.getResultList();
			returnedList = listaC;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}

	public List<UserCourse> getCourseUsers(Course course) {

		List<UserCourse> returnedList = new ArrayList<>();

			try {

				TypedQuery<UserCourse> querycourse = em.createNamedQuery("UserCourse.findByUsersByCourse", UserCourse.class);
				querycourse.setParameter("course", course);
				List<UserCourse> listaC = querycourse.getResultList();
				returnedList = listaC;

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			return returnedList;
		}

	public boolean persistUserCourse(UserCourse userCourse) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.persist(userCourse);
			em.flush();
			em.getTransaction().commit();

			returned = true;

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			returned = false;
		}

		return returned;

	}

	public boolean removeUserCourse(UserCourse userCourse) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.remove(userCourse);
			em.flush();
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
