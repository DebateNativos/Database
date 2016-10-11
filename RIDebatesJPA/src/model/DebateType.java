package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the debatetypes database table.
 * 
 */
@Entity
@Table(name="debatetypes")
@NamedQuery(name="Debatetype.findAll", query="SELECT d FROM DebateType d")
public class DebateType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idDebateTypes;
	private String description;
	private String name;

	public DebateType() {
	}

	public DebateType(String description, String name) {
		super();
		this.description = description;
		this.name = name;
	}

	@Id
	@GeneratedValue
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

}