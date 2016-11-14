package com.podiumcr.jpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.entities.Role;

public class RoleData {


	private EntityManager em;

	public RoleData(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}
/*	@NamedQueries(value = {
			@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
			@NamedQuery(name= "Role.findById", query = "SELECT r FROM Role r WHERE r.idRole = :id")
	})*/
	public Role getRoleById(int id) {

		Role role = new Role();
		
		try {

			TypedQuery<Role> getall = em.createNamedQuery("Role.findById", Role.class);
			getall.setParameter("id", id);
			role = getall.getSingleResult();


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return role;
	}
	
	public List<Role> getAll() {

		List<Role> role = new ArrayList<>();
		
		try {

			TypedQuery<Role> getall = em.createNamedQuery("Role.findById", Role.class);
			role = getall.getResultList();


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return role;
	}

	public boolean persistRole(Role role) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.persist(role);
			em.getTransaction().commit();

			returned = true;

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			returned = false;
		}

		return returned;

	}
	
	public boolean removeRole(Role role) {

		boolean returned = false;

		try {

			em.getTransaction().begin();
			em.remove(role);
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
