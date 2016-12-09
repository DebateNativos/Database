package testers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
import com.podiumcr.jpa.data.CommentData;

import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Comment;
import com.podiumcr.jpa.entities.Course;

public class Tester2 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PodiumJPA");
	 	EntityManager em = entityManagerFactory.createEntityManager();
		// TODO Auto-generated method stub
		try {
				
						
				UserData ud = new UserData(em);
				DebateData dd = new DebateData(em);
				CourseData cd = new CourseData(em);
			    CommentData com = new CommentData(em);
			    Course c = new Course("CursoPrueba1",2,2016,"C3-3","Viernes Noche");
			    
			    if (cd.persistCourse(c)) {
			    	 for (Course c2 :cd.getAll()) {		
					    	System.out.println("TEST: " + c2.getName() + " " + c2.getCourseCode());
						}
				}
			    

			    
			    List<String> ls =cd.getAllCodes();
			    for (String s : ls) {		
			    	System.out.println("TEST: " + s);
				}
			    //Comment c = new Comment(1, dd.getDebateById(1), ud.getUserByEmail("@gmail"), "HOLAAAA", cd.getCourseByCode("6O1J4"));  
			    //em.persist(c);
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
