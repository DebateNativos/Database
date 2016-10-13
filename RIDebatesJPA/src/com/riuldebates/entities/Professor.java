package com.riuldebates.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the professor database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries(value = {
		@NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")

})
public class Professor extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Qualificationrubric> qualificationrubrics;

	public Professor(){
		
		
	}
	
	public Professor(String email, String password, String address, String name, String lastName, String lastName2,
			Date birthday, int idUniversity, boolean isAdmin, String phone, Date timeStamp) {
		super(email, password, address, name, lastName, lastName2, birthday, idUniversity, isAdmin, phone, timeStamp);	

	}

	@OneToMany (mappedBy="professor", targetEntity=Qualificationrubric.class)
	public List<Qualificationrubric> getQualificationrubrics() {
		return qualificationrubrics;
	}
	
	public void setQualificationrubrics(List<Qualificationrubric> qualificationrubrics) {
		this.qualificationrubrics = qualificationrubrics;
	}

}