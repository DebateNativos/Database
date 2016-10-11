package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the qualificationrubrics database table.
 * 
 */
@Entity
@Table(name="qualificationrubrics")
@NamedQuery(name="Qualificationrubric.findAll", query="SELECT q FROM Qualificationrubric q")
public class Qualificationrubric implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idQualificationRubrics;
	private int course_idCourse;
	private String rubricName;
	private String rubricPercentage;

	public Qualificationrubric() {
	}


	@Id
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

}