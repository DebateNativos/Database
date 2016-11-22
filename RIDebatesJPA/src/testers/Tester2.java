package testers;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
				
				ConfirmedUserData cud = new ConfirmedUserData(em); 
				//DebateData dd = new DebateData();		
				//User u = ud.getUserByEmail("@gmail");
				List<User> listaUsuarios= ud.getUsers();			
			    List<Debate> listaDebates = dd.getDebates();	
			     User u = new User("latinapodiumcr@gmail.com","123", "San jose", "wdqf", "TESTER", "TESTERINO", 321, false, "7001-7001");
			    if(ud.registerUser(u)){
			    	System.out.println("Registrado" );
			    }else{
			    	
			    	System.out.println("NO Registrado" );
			    }
				/*TypedQuery<ConfirmedUser> getallCU = em.createNamedQuery("ConfirmedUser.findAll", ConfirmedUser.class);
				List<ConfirmedUser> cu = getallCU.getResultList();
				em.getTransaction().commit();
				entityManagerFactory.close();*/
			    
			    /*  
			    List<ConfirmedUser> cu = cud.getDebatesFromUser(ud.getUserByEmail("@gmail"));
			    
			    for (ConfirmedUser confirmedUser : cu) {
			    	 System.out.println("Usuarios " + confirmedUser.getUser().getName() +" ---- Ligado al debate " + confirmedUser.getDebate().getName() + " --- ROL " + confirmedUser.getRole().getName() );
				}*/
//			    System.out.println("Lista-- Usuarios" );
//				for (User user : listaUsuarios) {
//					System.out.println("Nombre: " + user.getName() + " ---- Email: " + user.getEmail() + "------ Password: " + user.getPassword());
//					System.out.println("Lista-- Debates: ");
//					for (Debate debate : cu.getDebatesFromUser(user)) {
//						System.out.println("Nombre: " + debate.getName() + " ---- Fecha: " + debate.getStartingDate());
//					}
//					
//				}
			 /*   System.out.println("FECHA: "+Calendar.getInstance().getTime());
				for (Debate debate : listaDebates) {
				System.out.println("Lista-- Debates: ");
				try {
					System.out.println("Nombre: " + debate.getName() + " ---- Fecha: " + debate.getStartingDate() + "------ Tipo: " + debate.getDebateType().getName());
				
					
				} catch (NullPointerException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				}
//				
*/				em.close();
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
