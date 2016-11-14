package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.DebateType;

public class DebateTypeData {

/*	@NamedQueries(value = {
			@NamedQuery(name= "DebateType.findAll", query = "SELECT dt FROM DebateType dt"),
			@NamedQuery(name= "DebateType.findById", query = "SELECT dt FROM DebateType dt WHERE dt.idDebateTypes = :id")
	})*/
	private EntityManager em;

	public DebateTypeData(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}
	
	public DebateType getDebateTypeById(int id) {

		DebateType debateType = new DebateType();
		
		try {

			TypedQuery<DebateType> getall = em.createNamedQuery("DebateType.findById", DebateType.class);
			getall.setParameter("id", id);
			debateType = getall.getSingleResult();


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return debateType;
	}
	
	public List<DebateType> getAll() {

		List<DebateType> debateType = new ArrayList<>();
		
		try {

			TypedQuery<DebateType> getall = em.createNamedQuery("DebateType.findById", DebateType.class);
			debateType = getall.getResultList();


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return debateType;
	}

	public boolean persistDebateType(DebateType debateType) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.persist(debateType);
			em.getTransaction().commit();

			returned = true;

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			returned = false;
		}

		return returned;

	}
	
	public boolean removeDebateType(DebateType debateType) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.remove(debateType);
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

