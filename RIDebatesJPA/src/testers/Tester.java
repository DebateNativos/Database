package testers;

import model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = null;
		EntityManager em = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("RIDebatesJPA");
		
		em = entityManagerFactory.createEntityManager();
		
        try {
            em.getTransaction().begin();
 
            User u = new User("@gmail","123", "San jose", "Joe", "Fernandez", "Lozano", Calendar.getInstance().getTime(), 321, true, "7001-7001",Calendar.getInstance().getTime());
            User u2 = new User("@gmail.com","123", "San jose", "Carlos", "Perez", "Solis", Calendar.getInstance().getTime(), 34562, false, "7234-7334",Calendar.getInstance().getTime());
            DebateType dt = new DebateType("Modelos de 7 secciones", "Modelo Australiano");
            Debate d = new Debate("Luigui y su administracion", Calendar.getInstance().getTime(), dt, Calendar.getInstance().getTime(), true);
            Role r = new Role("Administrador Master", "Tiene acceso a todas las funcionalidades del sistema!");
            Course c = new Course("Basura politica", "32C", 2, 2016);
            Professor p = new Professor(Calendar.getInstance().getTime(), "@villalta", "Villalta", "Solis", "Jose Maria", "123", "800IZQUIERDA", Calendar.getInstance().getTime());
        
            //cambiar em por el dato que es
            //em.persist(u);
            u.setPassword(u2.hashPass("123"));
            //em.merge(u2);
            em.persist(u);
            em.persist(dt);
            em.persist(d);
            em.persist(r);
            em.persist(c);
            em.persist(p);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Actualizado!!!!!!!");
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
        	entityManagerFactory.close();
        	System.out.println("Finalizo la coneccion!!!");
        }
 
        
		
	}

}
