package com.podiumcr.jpa.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;


/**
 * The persistent class for the confirmed_users database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="confirmed_users")
@NamedQueries(value = {
		@NamedQuery(name= "ConfirmedUser.findAll", query = "SELECT cu FROM ConfirmedUser cu"),
		@NamedQuery(name= "ConfirmedUser.findDebatesFromUser", query = "SELECT cu FROM ConfirmedUser cu WHERE cu.user = :user"),
		@NamedQuery(name= "ConfirmedUser.findUsersFromDebate", query = "SELECT cu FROM ConfirmedUser cu WHERE cu.debate = :debate"),
		@NamedQuery(name= "ConfirmedUser.findByRole", query = "SELECT cu FROM ConfirmedUser cu WHERE cu.role = :role"),
		@NamedQuery(name= "ConfirmedUser.findRoleByDebate", query = "SELECT cu.role FROM ConfirmedUser cu WHERE cu.debate = :debate AND cu.user = :user")
})
public class ConfirmedUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private User user;
	private Debate debate;
	private Role role;
	private int warnings;

	public ConfirmedUser() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user")
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="debate")
	public Debate getDebate() {
		return debate;
	}


	public void setDebate(Debate debate) {
		this.debate = debate;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public int getWarnings() {
		return warnings;
	}


	public void setWarnings(int warnings) {
		this.warnings = warnings;
	}
	
	
}