package com.podiumcr.jpa.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the debates database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="debates")
@NamedQueries(value = {
		@NamedQuery(name= "Debate.findAll", query = "SELECT d FROM Debate d"),
		@NamedQuery(name= "Debate.findByDate", query = "SELECT d FROM Debate d WHERE d.startingDate BETWEEN :startDate AND :endDate ORDER BY d.startingDate"),
		@NamedQuery(name= "Debate.findAllActive", query = "SELECT d FROM Debate d WHERE d.isActive = :active"),
		@NamedQuery(name= "Debate.findByDebate", query = "SELECT d FROM Debate d WHERE d = :d"),
		@NamedQuery(name= "Debate.findById", query = "SELECT d FROM Debate d WHERE d.idDebates = :id"),
		@NamedQuery(name= "Debate.findByType", query = "SELECT d FROM Debate d WHERE d.debateType.idDebateTypes = :idDebateType")
})
public class Debate implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private Date createdDate;
	private DebateType debateType;
	private Date startingDate;
	private boolean isActive;
	private Course course1;
	private Course course2;
	private List<User> users;
	
	public Debate() {
	}

	public Debate(String name, Date createdDate, DebateType debateType, Date startingDate,
			boolean isActive , Course course1, Course course2) {
		this.name = name;
		this.createdDate = createdDate;
		this.debateType = debateType;
		this.startingDate = startingDate;
		this.isActive = isActive;
		this.course1 = course1;
		this.course2 = course2;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdDebates() {
		return this.id;
	}

	public void setIdDebates(int idDebates) {
		this.id = idDebates;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
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
	
	@Temporal(TemporalType.TIMESTAMP)
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

	@OneToMany (mappedBy="debate", targetEntity=ConfirmedUser.class, fetch = FetchType.LAZY)
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@OneToOne
	@JoinColumn(name="Course_1")
	public Course getCourse1() {
		return course1;
	}

	public void setCourse1(Course course1) {
		this.course1 = course1;
	}
	
	@OneToOne
	@JoinColumn(name="Course_2")
	public Course getCourse2() {
		return course2;
	}

	public void setCourse2(Course course2) {
		this.course2 = course2;
	}
	
}