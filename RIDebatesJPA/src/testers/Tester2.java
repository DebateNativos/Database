package testers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.riuldebates.data.ConfirmedUserData;
import com.riuldebates.data.UserData;
import com.riuldebates.entities.ConfirmedUser;
import com.riuldebates.entities.Debate;
import com.riuldebates.entities.User;

public class Tester2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
				UserData ud = new UserData();
				ConfirmedUserData cu = new ConfirmedUserData();
						
				//User u = ud.getUserByEmail("@gmail");
				List<User> listaUsuarios = ud.getUsers();
				//List<Debate> listaDebates = cu.getConfirmedDebatesFromUser(u);		
				/*TypedQuery<ConfirmedUser> getallCU = em.createNamedQuery("ConfirmedUser.findAll", ConfirmedUser.class);
				List<ConfirmedUser> cu = getallCU.getResultList();
	
				em.getTransaction().commit();
				entityManagerFactory.close();*/
				
				/*for (Debate debate : listaDebates) {
					System.out.println("Lista-- Debates del usuario: "+ u.getName());
					System.out.println("Nombre: " + debate.getName() + " ---- Fecha: " + debate.getStartingDate() + "------ Password: " + debate.getDebateType());
					
				}*/
				
				for (User user : listaUsuarios) {
					System.out.println("Lista-- Usuarios" );
					System.out.println("Nombre: " + user.getName() + " ---- Email: " + user.getEmail() + "------ Password: " + user.getPassword() + " ------TOKEN: " + user.getIdToken());
					
				}	
				
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
