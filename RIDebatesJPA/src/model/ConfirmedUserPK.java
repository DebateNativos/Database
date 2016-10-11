package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The primary key class for the confirmed_users database table.
 * 
 */
@Embeddable
public class ConfirmedUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int users_idUsers;
	private int debates_idDebates;

	public ConfirmedUserPK() {
	}

	@Column(insertable=false, updatable=false)
	public int getUsers_idUsers() {
		return this.users_idUsers;
	}
	public void setUsers_idUsers(int users_idUsers) {
		this.users_idUsers = users_idUsers;
	}

	@Column(insertable=false, updatable=false)
	public int getDebates_idDebates() {
		return this.debates_idDebates;
	}
	public void setDebates_idDebates(int debates_idDebates) {
		this.debates_idDebates = debates_idDebates;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConfirmedUserPK)) {
			return false;
		}
		ConfirmedUserPK castOther = (ConfirmedUserPK)other;
		return 
			(this.users_idUsers == castOther.users_idUsers)
			&& (this.debates_idDebates == castOther.debates_idDebates);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.users_idUsers;
		hash = hash * prime + this.debates_idDebates;
		
		return hash;
	}
}