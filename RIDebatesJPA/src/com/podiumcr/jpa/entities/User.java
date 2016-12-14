package com.podiumcr.jpa.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the users database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name = "users")
@NamedQueries(value = {
		@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name= "User.findById", query = "SELECT u FROM User u WHERE u.idUsers = :id"),
		@NamedQuery(name= "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
		@NamedQuery(name= "User.login", query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password"),
		@NamedQuery(name= "User.findByToken", query = "SELECT u FROM User u WHERE u.idToken = :token")
})

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long idUsers;
	private String address;
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
	private String idToken;
	private List<Debate> debates;
	private List<Comment> comments;
	private List<Question> question;
	
	public User() {
		
	}
	
	public User(String email, String password, String address, String name, String lastName, String lastName2, int idUniversity, String phone) {		
		
		this.address = address;
		this.email = email;
		this.idUniversity = idUniversity;
		this.isAdmin = false;
		this.lastName = lastName;
		this.lastName2 = lastName2;
		this.name = name;
		this.password = encryptPass(password);
		this.phone = phone;
		this.timeStamp = Calendar.getInstance().getTime();
		this.idToken = createIdToken(this.email);
		
	}
	 
	public User(String email, String password, String address, String name, String lastName, String lastName2, int idUniversity, boolean isAdmin, String phone) {		
		
		this.address = address;
		this.email = email;
		this.idUniversity = idUniversity;
		this.isAdmin = isAdmin;
		this.lastName = lastName;
		this.lastName2 = lastName2;
		this.name = name;
		this.password = encryptPass(password);
		this.phone = phone;
		this.timeStamp = Calendar.getInstance().getTime();
		this.idToken = createIdToken(this.email);
		
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(long idUsers) {
		this.idUsers = idUsers;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(unique=true)
	public String getEmail() {
		return this.email;
	}

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

	@OneToMany (mappedBy="user", targetEntity=UserCourse.class, fetch = FetchType.LAZY)
	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getIdToken() {
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@OneToMany (mappedBy="user", targetEntity=ConfirmedUser.class, fetch = FetchType.EAGER)
	public List<Debate> getDebates() {
		return debates;
	}

	public void setDebates(List<Debate> debates) {
		this.debates = debates;
	}
	
	@OneToMany (mappedBy="user", targetEntity= Comment.class, fetch = FetchType.LAZY)
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@OneToMany (mappedBy="user", targetEntity= Question.class, fetch = FetchType.LAZY)
	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	
	public String createIdToken(String email) 
    {
		
        String generatedToken = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(email.getBytes());
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
            generatedToken = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        
        return generatedToken;
    }
	
	public String encryptPass(String password){
		
        String generatedPass = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x600, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPass = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        
        return generatedPass;
    }
	

}