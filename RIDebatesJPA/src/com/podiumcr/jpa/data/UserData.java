package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.User;

public class UserData {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PodiumJPA");;
	private EntityManager em = entityManagerFactory.createEntityManager();
	//private Session session = em.unwrap(Session.class);

	public List<User> getUsers(){
		
		List<User> returnedList = new ArrayList<>();
		
		try{
			em.getTransaction().begin();

			TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
			List<User> listaUsuarios = query.getResultList();
		
			em.getTransaction().commit();
			entityManagerFactory.close();
			
			returnedList = listaUsuarios;
			
			} catch (Exception e) {

			e.printStackTrace();
		}

		return returnedList;
	}
	
	public User getUserByEmail(String email){
		
		User returnedPerson = new User();

		try{

			em.getTransaction().begin();
	
			TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
			query.setParameter("email", email);
			returnedPerson = query.getSingleResult();
		
		em.getTransaction().commit();
		entityManagerFactory.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return returnedPerson;
	}


}