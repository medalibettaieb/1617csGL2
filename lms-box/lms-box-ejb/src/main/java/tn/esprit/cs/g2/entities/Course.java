package tn.esprit.cs.g2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity

public class Course implements Serializable {

	@Id
	private int id;
	private String name;

	@ManyToOne
	private User teacher;
	private static final long serialVersionUID = 1L;

	public Course() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	
}
