package testers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
 
            User u = new User("@gmail","123", "San jose", "Joe", "Fernandez", "Lozano", Calendar.getInstance().getTime(), 321, true, "7001-7001");
//            User u2 = new User("@gmail.com","123", "San jose", "Carlos", "Perez", "Solis", Calendar.getInstance().getTime(), 34562, false, "7234-7334");
            DebateType dt = new DebateType("Modelos de 7 secciones", "Modelo Australiano");
            Debate d = new Debate("Luigui y su administracion", Calendar.getInstance().getTime(), dt, Calendar.getInstance().getTime(), true);
//            Role r = new Role("Debatiente", "Debatear!!!!");
//            Course c = new Course("Basura politica", "32C", 2, 2016);       
//            Professor p = new Professor("@villalta","123", "CUBA","Jose Maria", "Villalta", "Solis", Calendar.getInstance().getTime(), 6335, false, "800IZQUIERDA");
//            c.setProfessor(p);
//            ArrayList<User> ul = new ArrayList<>(); 
//            ul.add(u);
//            c.setUsers(ul);
//            ConfirmedUser cu = new ConfirmedUser();
//            		cu.setUser(u);
//            		cu.setDebate(d);
//            		cu.setRole(r);
//            UserCourse uc = new UserCourse();
//            uc.setUser(u);
//            uc.setCourse(c);
//            uc.setQualification(90.0);
            //Calendar.getInstance().getTime(), "@villalta", "Villalta", "Solis", "Jose Maria", "123", "800IZQUIERDA", Calendar.getInstance().getTime()
            //cambiar em por el dato que es
            
           //em.merge(u2);
            em.persist(dt);
            em.persist(d);
            em.persist(u);
//            em.persist(r);
//            em.persist(c);
//            em.persist(p);
//            em.persist(uc);
//            em.persist(cu);
            
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
