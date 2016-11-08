package com.podiumcr.jpa.entities;

import javax.persistence.*;

import java.io.Serializable;


/**
 * The persistent class for the qualificationrubrics database table.
 * 
 */
@Entity
@Table(name="qualificationrubrics")
@NamedQueries(value = {
		@NamedQuery(name = "Qualificationrubric.findAll", query = "SELECT qr FROM Qualificationrubric qr"),
		@NamedQuery(name= "Qualificationrubric.findById", query = "SELECT qr FROM Qualificationrubric qr WHERE qr.idQualificationRubrics = :id")
})
public class Qualificationrubric implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idQualificationRubrics;
	private int course_idCourse;
	private String rubricName;
	private String rubricPercentage;
	private Professor professor;

	public Qualificationrubric() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdQualificationRubrics() {
		return this.idQualificationRubrics;
	}

	public void setIdQualificationRubrics(int idQualificationRubrics) {
		this.idQualificationRubrics = idQualificationRubrics;
	}


	public int getCourse_idCourse() {
		return this.course_idCourse;
	}

	public void setCourse_idCourse(int course_idCourse) {
		this.course_idCourse = course_idCourse;
	}


	public String getRubricName() {
		return this.rubricName;
	}

	public void setRubricName(String rubricName) {
		this.rubricName = rubricName;
	}


	public String getRubricPercentage() {
		return this.rubricPercentage;
	}

	public void setRubricPercentage(String rubricPercentage) {
		this.rubricPercentage = rubricPercentage;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="professor")
	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}