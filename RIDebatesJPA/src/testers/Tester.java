package testers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.*;

import java.util.ArrayList;
import java.util.Calendar;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = null;
		EntityManager em = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("PodiumJPA");		
		em = entityManagerFactory.createEntityManager();
		
        try {
            em.getTransaction().begin();
            
            User u = new User("@gmail","123", "San jose", "Joe", "Fernandez", "Lozano", 321, true, "7001-7001");
            Course c = new Course("Basura politica", 2, 2016, "C1-4", "Viernes 3:00pm - 6:00pm");    
            Course c2 = new Course("Mi mama amasa la masa", 2, 2016, "C2-5", "Jueves 11:00pm - 5:00pm"); 
            DebateType dt = new DebateType("Modelos de 7 secciones", "Modelo Australiano");
            Debate d = new Debate("Quorum", Calendar.getInstance().getTime(), dt, Calendar.getInstance().getTime(), false, c, c2);
            Comment com = new Comment(d, u, "HOLAAAA", c);  
            Professor p = new Professor("@villalta","123", "CUBA","Jose Maria", "Villalta", "Solis", 6335, "800IZQUIERDA");
           /* User u2 = new User("@gmail.com","123", "San jose", "Carlos", "Perez", "Solis", 34562, false, "7234-7334");
            
            
            Debate d = new Debate("Luigui y su administracion", Calendar.getInstance().getTime(), dt, Calendar.getInstance().getTime(), false, c, c2);
            Debate d2 = new Debate("Trump presidente!", Calendar.getInstance().getTime(), dt, Calendar.getInstance().getTime(), true, c, c2);
            Debate d3 = new Debate("Trumpsito", Calendar.getInstance().getTime(), dt, Calendar.getInstance().getTime(), false, c, c2);
            Debate d4 = new Debate("Debatiendo debates", Calendar.getInstance().getTime(), dt, Calendar.getInstance().getTime(), false, c, c2);
            Debate d5 = new Debate("Perros o gatos", Calendar.getInstance().getTime(), dt, Calendar.getInstance().getTime(), false, c, c2);
            Role r = new Role("Debatiente", "Debatear!!!!");          
            Professor p = new Professor("@villalta","123", "CUBA","Jose Maria", "Villalta", "Solis", 6335, "800IZQUIERDA");
            c.setProfessor(p);
            ArrayList<User> ul = new ArrayList<>(); 
            ul.add(u);
            c.setUsers(ul);
            ConfirmedUser cu = new ConfirmedUser();
            		cu.setUser(u);
            		cu.setDebate(d);
           		cu.setRole(r);
            UserCourse uc = new UserCourse();
            uc.setUser(u);
            uc.setCourse(c);
            uc.setQualification(90.0);
            //Calendar.getInstance().getTime(), "@villalta", "Villalta", "Solis", "Jose Maria", "123", "800IZQUIERDA", Calendar.getInstance().getTime()
            //cambiar em por el dato que es
            
           // 
            * em.merge(u2);        
            em.persist(d2);
            em.persist(d3);
            em.persist(d4);
            em.persist(d5);
            em.persist(u);
            em.persist(u2);            
            em.persist(r);         
            em.persist(p);
            em.persist(uc);*/
            em.persist(d);
            em.persist(c);
            em.persist(c2);
            em.persist(u);
            em.persist(dt);
            em.persist(com);
            em.persist(p);
            
            em.getTransaction().commit();
            System.out.println("Actualizado!!!!!!!");
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            entityManagerFactory.close();
            e.printStackTrace();
        }
        finally{
        	entityManagerFactory.close();
        	System.out.println("Finalizo la coneccion!!!");
        }
 
        
		
	}

}
