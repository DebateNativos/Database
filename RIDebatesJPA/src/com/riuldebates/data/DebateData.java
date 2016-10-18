package com.riuldebates.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.riuldebates.entities.Debate;

public class DebateData {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RIDebatesJPA");;
	private EntityManager em = entityManagerFactory.createEntityManager();
	//private Session session = em.unwrap(Session.class);
	
/*	@NamedQuery(name= "Debate.findAll", query = "SELECT d FROM Debate d"),
    @NamedQuery(name= "Debate.findAllActive", query = "SELECT d FROM Debate d WHERE d.isActive = :active"),
	@NamedQuery(name= "Debate.findByDebate", query = "SELECT d FROM Debate d WHERE d = :d"),
	@NamedQuery(name= "Debate.findById", query = "SELECT d FROM Debate d WHERE d.idDebates = :id"),
	@NamedQuery(name= "Debate.findByDate", query = "SELECT d FROM Debate d WHERE d.createdDate = :date"),
	@NamedQuery(name= "Debate.findByType", query = "SELECT d FROM Debate d WHERE d.debateType.idDebateTypes = :idDebateType")*/

	public List<Debate> getDebates(){
		
		List<Debate> returnedList = new ArrayList<>();
		
		try{
				
			em.getTransaction().begin();

			TypedQuery<Debate> getall = em.createNamedQuery("Debate.findAll", Debate.class);
			List<Debate> listaDebate = getall.getResultList();
		
			em.getTransaction().commit();
			entityManagerFactory.close();
			
			returnedList = listaDebate;
			
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	
public List<Debate> getActiveDebates(){
		
		List<Debate> returnedList = new ArrayList<>();
		
		try{
				
			em.getTransaction().begin();

			TypedQuery<Debate> getall = em.createNamedQuery("Debate.findAllActive", Debate.class);
			getall.setParameter("active", true);
			List<Debate> listaDebate = getall.getResultList();
		
			em.getTransaction().commit();
			entityManagerFactory.close();
			
			returnedList = listaDebate;
			
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	
}
