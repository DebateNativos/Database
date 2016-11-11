package testers;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.podiumcr.jpa.data.ConfirmedUserData;
import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.ConfirmedUser;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.User;

public class Tester2 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PodiumJPA");
	 	EntityManager em = entityManagerFactory.createEntityManager();
		// TODO Auto-generated method stub
		try {
				
						
				UserData ud = new UserData(em);
				DebateData dd = new DebateData(em);
				
				//ConfirmedUserData cu = new ConfirmedUserData(); 
				//DebateData dd = new DebateData();		
				//User u = ud.getUserByEmail("@gmail");
				List<User> listaUsuarios= ud.getUsers();			
			    List<Debate> listaDebates = dd.getActiveDebates();	
			    User u = new User("soler@gmail","123", "San jose", "Jorge", "Soler", "Jimenez", 321, false, "7001-7001");
			    if(ud.registerUser(u)){
			    	System.out.println("Registrado" );
			    }else{
			    	
			    	System.out.println("NO Registrado" );
			    }
				/*TypedQuery<ConfirmedUser> getallCU = em.createNamedQuery("ConfirmedUser.findAll", ConfirmedUser.class);
				List<ConfirmedUser> cu = getallCU.getResultList();
				em.getTransaction().commit();
				entityManagerFactory.close();*/
			    System.out.println("Lista-- Usuarios" );
				for (User user : listaUsuarios) {
					
					System.out.println("Nombre: " + user.getName() + " ---- Email: " + user.getEmail() + "------ Password: " + user.getPassword() + " ------TOKEN: " + user.getIdToken());
					
				}
				
				for (Debate debate : listaDebates) {
				System.out.println("Lista-- Debates: ");
					System.out.println("Nombre: " + debate.getName() + " ---- Fecha: " + debate.getStartingDate() + "------ Tipo: " + debate.getDebateType().getName());
				
				}
				
				em.close();
				entityManagerFactory.close();
				
				//System.out.println("Usuario encontrado: " );
				//System.out.println("Nombre: " + u.getName() + " ---- Email: " + u.getEmail() + "------ Password: " + u.getPassword() + " ------TOKEN: " + u.getIdToken() + " ----- Debate: " );
				
				/*for (ConfirmedUser user : cu) {
					System.out.println("Lista-- Debates" );
					System.out.println("Nombre: " + user.getUser().getName()+ " ---- Debate: " + user.getDebate().getName() + " ---- Role: " + user.getRole().getName());
				}	
				*/
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
