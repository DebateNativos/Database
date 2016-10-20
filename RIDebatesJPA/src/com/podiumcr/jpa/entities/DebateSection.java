package com.podiumcr.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the DebateSections database table.
 *
 */
@XmlRootElement
@Entity
@Table(name="debatesection")
@NamedQueries(value = {
		@NamedQuery(name= "DebateSection.findAll", query = "SELECT ds FROM DebateSection ds"),
})
public class DebateSection implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idDebateRules;
	private int sections;
	private String rules;
	private DebateType debatetype;

	public DebateSection() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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

	public String getRules() {
		return rules;
	}


	public void setRules(String rules) {
		this.rules = rules;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="debateype")
	public DebateType getDebatetype() {
		return debatetype;
	}


	public void setDebatetype(DebateType debatetype) {
		this.debatetype = debatetype;
	}
	
	
	
}