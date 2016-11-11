package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.User;
import com.podiumcr.jpa.resources.SendEmail;

public class UserData {
	
	SendEmail se = new SendEmail();
	private EntityManager em;

	public UserData(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}

	public List<User> getUsers() {

		List<User> returnedList = new ArrayList<>();

		try {

			TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
			List<User> listaUsuarios = query.getResultList();
			returnedList = listaUsuarios;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}

	public User getUserByEmail(String email) {

		User returnedPerson = new User();

		try {

			TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
			query.setParameter("email", email);
			returnedPerson = query.getSingleResult();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedPerson;
	}

	public boolean registerUser(User user) {

		boolean returned = false;

		try {

				em.getTransaction().begin();
				em.persist(user);
				em.getTransaction().commit();
				try{
				se.SendWelcomeEmail(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
				returned = true;

				
		} catch (Exception e) {

			e.printStackTrace();
			returned=false;
		}

		return returned;

	}

}
