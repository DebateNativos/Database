package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.ConfirmedUser;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.User;

/*@NamedQuery(name= "ConfirmedUser.findAll", query = "SELECT cu FROM ConfirmedUser cu"),
@NamedQuery(name= "ConfirmedUser.findByUser", query = "SELECT cu FROM ConfirmedUser cu WHERE cu.user = :user"),
@NamedQuery(name= "ConfirmedUser.findByDebate", query = "SELECT cu FROM ConfirmedUser cu WHERE cu.debate = :debate"),
@NamedQuery(name= "ConfirmedUser.findByRole", query = "SELECT cu FROM ConfirmedUser cu WHERE cu.role = :role")*/
public class ConfirmedUserData {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PodiumJPA");;
	private EntityManager em = entityManagerFactory.createEntityManager();

	public List<Debate> getConfirmedDebatesFromUser(User user){
		
		List<Debate> returnedList = new ArrayList<>();
		
		try{
				
			em.getTransaction().begin();

			TypedQuery<ConfirmedUser> query = em.createNamedQuery("ConfirmedUser.findByUser", ConfirmedUser.class);
			query.setParameter("user", user);
			List<ConfirmedUser> listaUsuarios = query.getResultList();
		
			for (ConfirmedUser confirmedUser : listaUsuarios) {
				returnedList.add(confirmedUser.getDebate());
			}
			
			em.getTransaction().commit();
			entityManagerFactory.close();
			
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	
public List<User> getUsers(){
		
		ArrayList<User> returnedList = new ArrayList<>();
		
		try{
			
			TypedQuery<ConfirmedUser> queryCU = em.createNamedQuery("ConfirmedUser.findByDebate", ConfirmedUser.class);
			queryCU.setParameter("user", null);
			List<ConfirmedUser> listaCU = queryCU.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	
}
