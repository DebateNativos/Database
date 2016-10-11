package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the debaterules database table.
 *
 */
@Entity
@Table(name="debaterules")
@NamedQueries(value = {
		@NamedQuery(name= "Debaterule.findAll", query = "SELECT dr FROM Debaterule dr"),
		@NamedQuery(name= "Debaterule.findById", query = "SELECT dr FROM Debaterule dr WHERE dr.idDebateRules = :id")
})
public class Debaterule implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idDebateRules;
	private int sections;

	public Debaterule() {
	}


	@Id
	@GeneratedValue
	public int getIdDebateRules() {
		return this.idDebateRules;
	}

	public void setIdDebateRules(int idDebateRules) {
		this.idDebateRules = idDebateRules;
	}


	public int getSections() {
		return this.sections;
	}

	public void setSections(int sections) {
		this.sections = sections;
	}


}