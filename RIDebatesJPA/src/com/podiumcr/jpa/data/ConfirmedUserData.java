package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.ConfirmedUser;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.User;

/*@NamedQuery(name= "ConfirmedUser.findAll", query = "SELECT cu FROM ConfirmedUser cu"),
@NamedQuery(name= "ConfirmedUser.findByUser", query = "SELECT cu FROM ConfirmedUser cu WHERE cu.user = :user"),
@NamedQuery(name= "ConfirmedUser.findByDebate", query = "SELECT cu FROM ConfirmedUser cu WHERE cu.debate = :debate"),
@NamedQuery(name= "ConfirmedUser.findByRole", query = "SELECT cu FROM ConfirmedUser cu WHERE cu.role = :role")*/
public class ConfirmedUserData {
	
	private EntityManager em;

	public ConfirmedUserData(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}

	public List<ConfirmedUser> getAll() {

		List<ConfirmedUser> returnedList = new ArrayList<>();

		try {

			TypedQuery<ConfirmedUser> queryCU = em.createNamedQuery("ConfirmedUser.findAll", ConfirmedUser.class);
			List<ConfirmedUser> listaCU = queryCU.getResultList();
			returnedList = listaCU;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}

	public List<ConfirmedUser> getUsersFromDebate(Debate debate) {

		List<ConfirmedUser> returnedList = new ArrayList<>();

		try {

			TypedQuery<ConfirmedUser> queryCU = em.createNamedQuery("ConfirmedUser.findUsersFromDebate", ConfirmedUser.class);
			queryCU.setParameter("debate", debate);
			List<ConfirmedUser> listaCU = queryCU.getResultList();
			returnedList = listaCU;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}

	public List<ConfirmedUser> getDebatesFromUser(User user) {

		List<ConfirmedUser> returnedList = new ArrayList<>();

		try {

			TypedQuery<ConfirmedUser> queryCU = em.createNamedQuery("ConfirmedUser.findDebatesFromUser",
					ConfirmedUser.class);
			queryCU.setParameter("user", user);
			List<ConfirmedUser> listaCU = queryCU.getResultList();
			returnedList = listaCU;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	
	public ConfirmedUser getActualFeed(User user, Debate debate) {

		ConfirmedUser returnedList = new ConfirmedUser();

		try {

			TypedQuery<ConfirmedUser> queryCU = em.createNamedQuery("ConfirmedUser.findFeed", ConfirmedUser.class);
			queryCU.setParameter("user", user);
			queryCU.setParameter("debate", debate);
			ConfirmedUser listaCU = queryCU.getSingleResult();
			returnedList = listaCU;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}

	public boolean updateConfirmedUser(ConfirmedUser user) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		/*	try {
				se.SendInformationChangedEmail(user);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			returned = true;

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			returned = false;
		}

		return returned;

	}

}
