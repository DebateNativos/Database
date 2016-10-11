package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the professor database table.
 * 
 */
@Entity
@NamedQuery(name="Professor.findAll", query="SELECT p FROM Professor p")
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idProfessor;
	private Date birthday;
	private String email;
	private String lastName;
	private String lastName2;
	private String name;
	private String password;
	private String phone;
	private Date timestamp;
	private Course course;
	private Qualificationrubric qualificationrubric;

	public Professor() {
	}

	public Professor(Date birthday, String email, String lastName, String lastName2, String name, String password,
			String phone, Date timestamp) {
		this.birthday = birthday;
		this.email = email;
		this.lastName = lastName;
		this.lastName2 = lastName2;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.timestamp = timestamp;
	}

	@Id
	@GeneratedValue
	public int getIdProfessor() {
		return this.idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
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

	public void setEmail(String email) {
		this.email = email;
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
	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@OneToOne
	@JoinColumn(name="idProfessor", referencedColumnName="Professor_idProfessor")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@OneToOne
	@JoinColumn(name="qualificationrubric")
	public Qualificationrubric getQualificationrubric() {
		return this.qualificationrubric;
	}

	public void setQualificationrubric(Qualificationrubric qualificationrubric) {
		this.qualificationrubric = qualificationrubric;
	}
}