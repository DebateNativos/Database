package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.DebateSection;
import com.podiumcr.jpa.entities.DebateType;

public class DebateSectionData {
	private EntityManager em;

	public DebateSectionData(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}
	
	public DebateSection getDebateSection(int id) {

		DebateSection debateType = new DebateSection();
		
		try {

			TypedQuery<DebateSection> getall = em.createNamedQuery("DebateSection.findById", DebateSection.class);
			getall.setParameter("id", id);
			debateType = getall.getSingleResult();


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return debateType;
	}

	public List<DebateSection> getAllBydebate(DebateType debatetype) {

		List<DebateSection> debateSection = new ArrayList<>();
		
		try {

			TypedQuery<DebateSection> getall = em.createNamedQuery("DebateSection.findByDebate", DebateSection.class);
			getall.setParameter("debatetype", debatetype);
			debateSection = getall.getResultList();


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return debateSection;
	}
	public List<DebateSection> getAll() {

		List<DebateSection> debateSection = new ArrayList<>();
		
		try {

			TypedQuery<DebateSection> getall = em.createNamedQuery("DebateSection.findAll", DebateSection.class);
			debateSection = getall.getResultList();


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return debateSection;
	}

	public boolean persistDebateSection(DebateSection debateSection) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.persist(debateSection);
			em.getTransaction().commit();

			returned = true;

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			returned = false;
		}

		return returned;

	}
	
	public boolean removeDebateSection(DebateSection debateSection) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.remove(debateSection);
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
