package com.podiumcr.jpa.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name = "role")
@NamedQueries(value = {
		@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
		@NamedQuery(name= "Role.findById", query = "SELECT r FROM Role r WHERE r.idRole = :id")
})

public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idRole;
	private String desciption;
	private String name;
	
	public Role() {
	}

	public Role(String name, String desciption) {
		super();
		this.name = name;
		this.desciption = desciption;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}


	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}