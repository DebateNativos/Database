package com.riuldebates.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.riuldebates.entities.User;

public class UserData {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RIDebatesJPA");;
	private EntityManager em = entityManagerFactory.createEntityManager();

	public List<User> getUsers(){
		
		ArrayList<User> returnedList = new ArrayList<>();
		
		try{
			em.getTransaction().begin();

			TypedQuery<User> getall = em.createNamedQuery("User.findAll", User.class);
			List<User> listaUsuarios = getall.getResultList();
		
			em.getTransaction().commit();
			entityManagerFactory.close();
			
			returnedList = (ArrayList<User>) listaUsuarios;
			
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	
	public User getUserByEmail(String email){
		
		User returnedPerson = new User();		
		try{

	
		TypedQuery<User> query = em.createNamedQuery("findUserByEmail", User.class);
		query.setParameter("userEmail", email);
		returnedPerson = query.getSingleResult();
		
		em.getTransaction().commit();
		entityManagerFactory.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return returnedPerson;
	}
	
	public void setUser(User user){
		
		try{
			em.getTransaction().begin();
	
			em.persist(user);
			em.flush();
		
			em.getTransaction().commit();
			entityManagerFactory.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
