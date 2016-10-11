package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the confirmed_users database table.
 * 
 */
@Entity
@Table(name="confirmed_users")
@NamedQueries(value = {
		@NamedQuery(name= "ConfirmedUser.findAll", query = "SELECT cu FROM Course cu")
})
public class ConfirmedUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private ConfirmedUserPK id;
	private Role role;

	public ConfirmedUser() {
	}


	@Id
	public ConfirmedUserPK getId() {
		return this.id;
	}

	public void setId(ConfirmedUserPK id) {
		this.id = id;
	}


	//bi-directional one-to-one association to Role
	@OneToOne
	@JoinColumn(name="user_role")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}