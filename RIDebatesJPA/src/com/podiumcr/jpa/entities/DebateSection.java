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
		@NamedQuery(name= "DebateSection.findByDebate", query = "SELECT ds FROM DebateSection ds WHERE ds.debatetype = :debatetype")
})
public class DebateSection implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idDebateSection;
	private int section;
	private int minutesPerUser;
	private boolean isActiveSection;
	private DebateType debatetype;
	private String sectionName;

	public DebateSection() {
	}

	public DebateSection(int section, int minutesPerUser, DebateType debatetype, String sectionName) {
		super();
		this.section = section;
		this.minutesPerUser = minutesPerUser;
		this.debatetype = debatetype;
		this.isActiveSection = false;
		this.sectionName = sectionName;
		
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdDebateSection() {
		return this.idDebateSection;
	}

	public void setIdDebateSection(int idDebateSection) {
		this.idDebateSection = idDebateSection;
	}

	
	public boolean getIsActiveSection() {
		return isActiveSection;
	}



	public void setIsActiveSection(boolean isActiveSection) {
		this.isActiveSection = isActiveSection;
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



	public int getSection() {
		return section;
	}



	public void setSection(int section) {
		this.section = section;
	}



	public String getSectionName() {
		return sectionName;
	}



	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}



	public void setActiveSection(boolean isActiveSection) {
		this.isActiveSection = isActiveSection;
	}
	
	
	
}