package tn.esprit.cs.g2.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity

public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ElementCollection(fetch = FetchType.EAGER)
	@Convert(converter = ExamTypeConverter.class, attributeName = "key")
	private Map<ExamType, Integer> mapExamType;

	@ManyToOne(targetEntity = User.class, cascade = CascadeType.MERGE)
	private User teacher;

	@OneToMany(mappedBy = "course")
	private List<SubscriptionDetail> subscriptionDetails;

	private static final long serialVersionUID = 1L;

	public Course() {
		super();
	}

	public Course(String name, Map<ExamType, Integer> mapExamType) {
		super();
		this.name = name;
		this.mapExamType = mapExamType;
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

	public Map<ExamType, Integer> getMapExamType() {
		return mapExamType;
	}

	public void setMapExamType(Map<ExamType, Integer> mapExamType) {
		this.mapExamType = mapExamType;
	}

	public List<SubscriptionDetail> getSubscriptionDetails() {
		return subscriptionDetails;
	}

	public void setSubscriptionDetails(List<SubscriptionDetail> subscriptionDetails) {
		this.subscriptionDetails = subscriptionDetails;
	}

}
