package tn.esprit.cs.g2.entities;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity(name = "Student")

public class Student extends User implements Serializable {

	private String studentCard;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}

	public Student(String name, String studentCard) {
		super(name);
		this.studentCard = studentCard;
	}

	public String getStudentCard() {
		return this.studentCard;
	}

	public void setStudentCard(String studentCard) {
		this.studentCard = studentCard;
	}

}
