package com.riuldebates.data;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ConectionSingleton {

	  	public static ConectionSingleton instance;
	 
	 	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RIDebatesJPA");;
		private EntityManager em = entityManagerFactory.createEntityManager();
		
		//em.getTransaction().commit();
		
	    private ConectionSingleton() throws ClassNotFoundException, SQLException{
	        em.getTransaction().begin();
	        	
	    }
	    //synchronized permite la lista de espera si muchos desean conectarse al mismo tiempo

	    public synchronized static ConectionSingleton connectionState() throws ClassNotFoundException, SQLException{
	        if (instance == null) {
	            instance = new ConectionSingleton();
	        }
	        return instance;
	    }


		public EntityManagerFactory getEntityManagerFactory() {
			return entityManagerFactory;
		}
		public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
			this.entityManagerFactory = entityManagerFactory;
		}
		public EntityManager getEm() {
			return em;
		}
		public void setEm(EntityManager em) {
			this.em = em;
		}

}

