package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the debates database table.
 * 
 */
@Entity
@Table(name="debates")
@NamedQuery(name="Debate.findAll", query="SELECT d FROM Debate d")
public class Debate implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idDebates;
	private String name;
	private Date createdDate;
	private DebateType debateType;
	private Date startingDate;
	private List<Course> courses;
	private List<User> users;
	private Debaterule debaterule;
	private boolean isActive;
	
	public Debate() {
	}

	public Debate(String name, Date createdDate, DebateType debateType, Date startingDate,
			boolean isActive) {
		this.name = name;
		this.createdDate = createdDate;
		this.debateType = debateType;
		this.startingDate = startingDate;
		this.isActive = isActive;
	}

	@Id
	@GeneratedValue
	public int getIdDebates() {
		return this.idDebates;
	}

	public void setIdDebates(int idDebates) {
		this.idDebates = idDebates;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getStartingDate() {
		return this.startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	
	@OneToOne
	@JoinColumn(name="debete_type")
	public DebateType getDebateType() {
		return this.debateType;
	}

	public void setDebateType(DebateType debateType) {
		this.debateType = debateType;
	}
	
	@ManyToMany(mappedBy="courseDebates")
	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@ManyToMany(mappedBy="debates")
	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@OneToOne
	@JoinColumn(name="debete_rule")
	public Debaterule getDebaterule() {
		return this.debaterule;
	}

	public void setDebaterule(Debaterule debaterule) {
		this.debaterule = debaterule;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	

}