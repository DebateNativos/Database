package model;

import javax.persistence.*;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQueries(value = {
		@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name= "User.findById", query = "SELECT u FROM User u WHERE u.idUsers = :id"),
		@NamedQuery(name= "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
		@NamedQuery(name= "User.login", query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUsers;
	private String address;
	private Date birthday;
	private String email;
	private int idUniversity;
	private boolean isAdmin;
	private String lastName;
	private String lastName2;
	private String name;
	private String password;
	private String phone;
	private Date timeStamp;
	private List<Course> courses;
	private List<Debate> debates;
	
	public User() {
	}
	
	public User(String email, String password, String address, String name, String lastName, String lastName2,
			Date birthday, int idUniversity, boolean isAdmin, String phone, Date timeStamp) {		
		
		this.address = address;
		this.birthday = birthday;
		this.email = email;
		this.idUniversity = idUniversity;
		this.isAdmin = isAdmin;
		this.lastName = lastName;
		this.lastName2 = lastName2;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.timeStamp = timeStamp;
	}



	@Id
	@GeneratedValue
	public int getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	@Column(unique=true)
	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdUniversity() {
		return this.idUniversity;
	}

	public void setIdUniversity(int idUniversity) {
		this.idUniversity = idUniversity;
	}

	public boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName2() {
		return this.lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Temporal(TemporalType.DATE)
	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	// bi-directional many-to-many association to Course
	@ManyToMany(cascade={CascadeType.ALL}, mappedBy = "users")
	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	// bi-directional many-to-many association to Debate
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name = "confirmed_users", joinColumns = { @JoinColumn(name = "Users_idUsers") }, inverseJoinColumns = {
			@JoinColumn(name = "Debates_idDebates") } )
	public List<Debate> getDebates() {
		return this.debates;
	}

	public void setDebates(List<Debate> debates) {
		this.debates = debates;
	}
	
	 public String hashPass(String password) 
	    {
	        String passwordToHash = password;
	        String generatedPassword = null;
	        try {
	            // Create MessageDigest instance for MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //Add password bytes to digest
	            md.update(passwordToHash.getBytes());
	            //Get the hash's bytes 
	            byte[] bytes = md.digest();
	            //This bytes[] has bytes in decimal format;
	            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x606, 16).substring(1));
	            }
	            //Get complete hashed password in hex format
	            generatedPassword = sb.toString();
	        } 
	        catch (NoSuchAlgorithmException e) 
	        {
	            e.printStackTrace();
	        }
	        System.out.println(generatedPassword);
	        
	        return generatedPassword;
	    }

}