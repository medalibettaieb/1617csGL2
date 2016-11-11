package tn.esprit.cs.g2.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SubscriptionDetailId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idUser;
	private int idCourse;

	public SubscriptionDetailId() {
	}

	public SubscriptionDetailId(int idUser, int idCourse) {
		super();
		this.idUser = idUser;
		this.idCourse = idCourse;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCourse;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubscriptionDetailId other = (SubscriptionDetailId) obj;
		if (idCourse != other.idCourse)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

}
