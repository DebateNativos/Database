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
	private int idDebateSection;
	private int sections;
	private int minutesPerUser;
	private DebateType debatetype;

	public DebateSection() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdDebateSection() {
		return this.idDebateSection;
	}

	public void setIdDebateSection(int idDebateSection) {
		this.idDebateSection = idDebateSection;
	}


	public int getSections() {
		return this.sections;
	}

	public void setSections(int sections) {
		this.sections = sections;
	}


	
	
	public int getMinutesPerUser() {
		return minutesPerUser;
	}


	public void setMinutesPerUser(int minutesPerUser) {
		this.minutesPerUser = minutesPerUser;
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