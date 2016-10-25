package testers;

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
		// TODO Auto-generated method stub
		try {
			
				UserData ud = new UserData();
				ConfirmedUserData cu = new ConfirmedUserData(); 
				DebateData dd = new DebateData();		
				//User u = ud.getUserByEmail("@gmail");
				//List<User> listaUsuarios = ud.getUsers();
				List<Debate> listaDebates = dd.getActiveDebates();;		
				/*TypedQuery<ConfirmedUser> getallCU = em.createNamedQuery("ConfirmedUser.findAll", ConfirmedUser.class);
				List<ConfirmedUser> cu = getallCU.getResultList();
				em.getTransaction().commit();
				entityManagerFactory.close();*/

				for (Debate debate : listaDebates) {
					
					System.out.println("Nombre: " + debate.getName() + "ID: " + debate.getIdDebates());
					
				}
				/*for (Debate debate : listaDebates) {
					System.out.println("Lista-- Debates del usuario: "+ u.getName());
					System.out.println("Nombre: " + debate.getName() + " ---- Fecha: " + debate.getStartingDate() + "------ Password: " + debate.getDebateType());
					
				}*/
				
				/*for (User user : listaUsuarios) {
					System.out.println("Lista-- Usuarios" );
					System.out.println("Nombre: " + user.getName() + " ---- Email: " + user.getEmail() + "------ Password: " + user.getPassword() + " ------TOKEN: " + user.getIdToken());
					
				}*/	
				
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
