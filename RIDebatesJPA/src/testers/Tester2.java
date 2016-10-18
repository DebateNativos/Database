package testers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.riuldebates.data.UserData;
import com.riuldebates.entities.ConfirmedUser;
import com.riuldebates.entities.User;

public class Tester2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			/*EntityManagerFactory entityManagerFactory = null;
			EntityManager em = null;
			entityManagerFactory = Persistence.createEntityManagerFactory("RIDebatesJPA");
			
			em = entityManagerFactory.createEntityManager();
			
			em.getTransaction().begin();

			TypedQuery<User> query = em.createNamedQuery("User.findById", User.class);
			query.setParameter("id", 1);
			User returnedPerson = query.getSingleResult(); 
			
			TypedQuery<User> query2 = em.createNamedQuery("User.findByEmail", User.class);
			query2.setParameter("email", "@gmail");  
			User returnedPerson2 = query2.getSingleResult(); 
			*/
			/*TypedQuery<User> loginQuery = em.createNamedQuery("User.login", User.class);
			loginQuery.setParameter("email", "@gmail"); 
			loginQuery.setParameter("password", returnedPerson.hashPass("123"));
			User returnedPerson3 = loginQuery.getSingleResult(); */
			
			UserData ud = new UserData();
			List<User> listaUsuarios = ud.getUsers();
			
			/*TypedQuery<ConfirmedUser> getallCU = em.createNamedQuery("ConfirmedUser.findAll", ConfirmedUser.class);
			List<ConfirmedUser> cu = getallCU.getResultList();

			em.getTransaction().commit();
			entityManagerFactory.close();*/
			for (User user : listaUsuarios) {
				System.out.println("Lista-- Usuarios" );
				System.out.println("Nombre: " + user.getName() + " ---- Email: " + user.getEmail() + "------ Password: " + user.getPassword() + " ------TOKEN: " + user.getIdToken());
			}	
			
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
