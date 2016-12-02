/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.common;

/**
 *
 * @author Soler
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
 
public class EntityListener implements ServletContextListener, ServletRequestListener {
 
    public static final String EM_NAME = "em";
    public static EntityManagerFactory entityManagerFactory = null;
    public static EntityManager em = null;

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("............Inicializando parametros de JPA............");
///-------JpaManager.initEntityManagerFactory(); Remplazar esto para el startEntityManager de los componentes...
        this.entityManagerFactory = Persistence.createEntityManagerFactory("PodiumJPA");
       
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("............Terminando parametros de JPA...............");

//------JpaManager.EndEntityManagerFactory(); Remplazar esto para el startEntityManager de los componentes...
        this.entityManagerFactory.close();
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        EntityManager em = (EntityManager) sre.getServletRequest().getAttribute(EntityListener.EM_NAME);

        if (em != null && !em.isOpen()) {
            em.close();
            em = null;
        }
    }

    public void requestInitialized(ServletRequestEvent sre) {
        
       if (em == null) {
             this.em = entityManagerFactory.createEntityManager(); 
        }
    }
    /*
* public void requestInitialized(ServletRequestEvent sre) { EntityManager
* realem = JpaManager.getServerEntityManager();
* sre.getServletRequest().setAttribute("realem", realem);
* sre.getServletRequest().setAttribute(EntityListener.nombreEm, realem); }
     */
}
