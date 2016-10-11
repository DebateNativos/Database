package testers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;

public class Tester2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			EntityManagerFactory entityManagerFactory = null;
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
			
			TypedQuery<User> loginQuery = em.createNamedQuery("User.login", User.class);
			loginQuery.setParameter("email", "joe@gmail"); 
			loginQuery.setParameter("password", returnedPerson.hashPass("123"));
			User returnedPerson3 = loginQuery.getSingleResult(); 
			
			TypedQuery<User> getll = em.createNamedQuery("User.findAll", User.class);
			List<User> listaUsuarios = getll.getResultList();

			em.getTransaction().commit();
			entityManagerFactory.close();
			
			System.out.println("Nombre: " + returnedPerson.getName() + " ---- Email: " + returnedPerson.getEmail());
			System.out.println("Nombre: " + returnedPerson2.getName() + " ---- Email: " + returnedPerson2.getEmail());
			System.out.println("Nombre: " + returnedPerson3.getName() + " ---- Email: " + returnedPerson3.getEmail());

			for (User user : listaUsuarios) {
				System.out.println("Lista-- " );
				System.out.println("Nombre: " + user.getName() + " ---- Email: " + user.getEmail());
			}	
			
	}catch (Exception e) {
		e.printStackTrace();
	}
	


	}
}
