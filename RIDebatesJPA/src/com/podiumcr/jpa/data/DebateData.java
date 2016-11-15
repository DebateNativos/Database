package com.podiumcr.jpa.data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.Debate;

public class DebateData {

	private EntityManager em;

	/*
	 * @NamedQuery(name= "Debate.findAll", query = "SELECT d FROM Debate d"),
	 * 
	 * @NamedQuery(name= "Debate.findAllActive", query =
	 * "SELECT d FROM Debate d WHERE d.isActive = :active"),
	 * 
	 * @NamedQuery(name= "Debate.findByDebate", query =
	 * "SELECT d FROM Debate d WHERE d = :d"),
	 * 
	 * @NamedQuery(name= "Debate.findById", query =
	 * "SELECT d FROM Debate d WHERE d.idDebates = :id"),
	 * 
	 * @NamedQuery(name= "Debate.findByDate", query =
	 * "SELECT d FROM Debate d WHERE d.createdDate = :date"),
	 * 
	 * @NamedQuery(name= "Debate.findByType", query =
	 * "SELECT d FROM Debate d WHERE d.debateType.idDebateTypes = :idDebateType"
	 * )
	 */

	public DebateData(EntityManager em) {
		this.em = em;
	}
	
	public List<Debate> getDebates() {

		List<Debate> returnedList = new ArrayList<>();

		//Date end = cal.getTime();
		try {

			TypedQuery<Debate> getall = em.createNamedQuery("Debate.findAll", Debate.class);
			List<Debate> listaDebate = getall.getResultList();

			returnedList = listaDebate;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	

	public List<Debate> getActualDebates() {

		List<Debate> returnedList = new ArrayList<>();
		Calendar calend = Calendar.getInstance();
		calend.set(Calendar.YEAR, 2100);
		calend.set(Calendar.MONTH, 11); // 11 = december
		calend.set(Calendar.DAY_OF_MONTH, 31); // new years eve
		Calendar calstart = Calendar.getInstance();
		calstart.set(Calendar.HOUR_OF_DAY, 1);


		//Date end = cal.getTime();
		try {

			TypedQuery<Debate> getall = em.createNamedQuery("Debate.findByDate", Debate.class);
			getall.setParameter("startDate",calstart.getTime());
			getall.setParameter("endDate", calend.getTime());
			List<Debate> listaDebate = getall.getResultList();

			returnedList = listaDebate;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	
	public List<Debate> getHistoryDebates() {

		List<Debate> returnedList = new ArrayList<>();
		Calendar calend = Calendar.getInstance();
		calend.set(Calendar.YEAR, 2015);
		calend.set(Calendar.MONTH, 11); // 11 = december
		calend.set(Calendar.DAY_OF_MONTH, 31); // new years eve
		Calendar calstart = Calendar.getInstance();
		calstart.set(Calendar.HOUR_OF_DAY, 1);


		//Date end = cal.getTime();
		try {

			TypedQuery<Debate> getall = em.createNamedQuery("Debate.findByDate", Debate.class);
			getall.setParameter("startDate", calend.getTime());
			getall.setParameter("endDate", calstart.getTime());
			List<Debate> listaDebate = getall.getResultList();

			returnedList = listaDebate;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return returnedList;
	}
	
	public Debate getDebateById(int id) {

		Debate debate = new Debate();
		
		try {

			TypedQuery<Debate> getall = em.createNamedQuery("Debate.findById", Debate.class);
			getall.setParameter("id", id);
			debate = getall.getSingleResult();


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return debate;
	}

	public boolean persistDebate(Debate debate) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.persist(debate);
			em.getTransaction().commit();

			returned = true;

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			returned = false;
		}

		return returned;

	}

	public boolean removeDebate(Debate debate) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.remove(debate);
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
