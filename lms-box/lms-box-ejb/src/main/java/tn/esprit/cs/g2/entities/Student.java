package tn.esprit.cs.g2.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.cs.g2.entities.User;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity

public class Student extends User implements Serializable {

	
	private String studentCard;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}   
	public String getStudentCard() {
		return this.studentCard;
	}

	public void setStudentCard(String studentCard) {
		this.studentCard = studentCard;
	}
   
}
