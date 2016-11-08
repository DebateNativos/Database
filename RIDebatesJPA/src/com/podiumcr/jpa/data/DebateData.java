package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.Debate;

public class DebateData{
	
	private EntityManager em;

/*	@NamedQuery(name= "Debate.findAll", query = "SELECT d FROM Debate d"),
    @NamedQuery(name= "Debate.findAllActive", query = "SELECT d FROM Debate d WHERE d.isActive = :active"),
	@NamedQuery(name= "Debate.findByDebate", query = "SELECT d FROM Debate d WHERE d = :d"),
	@NamedQuery(name= "Debate.findById", query = "SELECT d FROM Debate d WHERE d.idDebates = :id"),
	@NamedQuery(name= "Debate.findByDate", query = "SELECT d FROM Debate d WHERE d.createdDate = :date"),
	@NamedQuery(name= "Debate.findByType", query = "SELECT d FROM Debate d WHERE d.debateType.idDebateTypes = :idDebateType")*/

	public DebateData(EntityManager em) {	
		this.em = em;
	}

	public List<Debate> getDebates(){
		
		List<Debate> returnedList = new ArrayList<>();
		
		try{
				
			TypedQuery<Debate> getall = em.createNamedQuery("Debate.findAll", Debate.class);
			List<Debate> listaDebate = getall.getResultList();
				
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
				
			TypedQuery<Debate> getall = em.createNamedQuery("Debate.findAllActive", Debate.class);
			getall.setParameter("active", true);
			List<Debate> listaDebate = getall.getResultList();
				
			returnedList = listaDebate;
			
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	
}
