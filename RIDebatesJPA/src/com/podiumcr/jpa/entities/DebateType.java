package com.podiumcr.jpa.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the debatetypes database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="debatetypes")
@NamedQueries(value = {
		@NamedQuery(name= "DebateType.findAll", query = "SELECT dt FROM DebateType dt"),
		@NamedQuery(name= "DebateType.findById", query = "SELECT dt FROM DebateType dt WHERE dt.idDebateTypes = :id")
})

public class DebateType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idDebateTypes;
	private String description;
	private String name;
	private String rules;
	private int totalTimeInMinutes;
	private List<DebateSection> sections;

	public DebateType() {
	}

	public DebateType(String description, String name) {
		super();
		this.description = description;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdDebateTypes() {
		return this.idDebateTypes;
	}

	public void setIdDebateTypes(int idDebateTypes) {
		this.idDebateTypes = idDebateTypes;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany (mappedBy="debatetype", targetEntity=DebateSection.class, fetch = FetchType.EAGER)
	public List<DebateSection> getSections() {
		return sections;
	}

	public void setSections(List<DebateSection> sections) {
		this.sections = sections;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public int getTotalTimeInMinutes() {
		return totalTimeInMinutes;
	}

	public void setTotalTimeInMinutes(int totalTimeInMinutes) {
		this.totalTimeInMinutes = totalTimeInMinutes;
	}
	
}