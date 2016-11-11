package tn.esprit.cs.g2.entities;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: SubscriptionDetail
 *
 */
@Entity

public class SubscriptionDetail implements Serializable {
	@EmbeddedId
	private SubscriptionDetailId subscriptionDetailId;
	@ElementCollection
	@Convert(converter = ExamTypeConverter.class, attributeName = "key")
	private Map<ExamType, Float> mapMarks;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Course course;
	
	private static final long serialVersionUID = 1L;

	public SubscriptionDetail() {
		super();
	}

	public Map<ExamType, Float> getMapMarks() {
		return mapMarks;
	}

	public void setMapMarks(Map<ExamType, Float> mapMarks) {
		this.mapMarks = mapMarks;
	}

	public SubscriptionDetailId getSubscriptionDetailId() {
		return subscriptionDetailId;
	}

	public void setSubscriptionDetailId(SubscriptionDetailId subscriptionDetailId) {
		this.subscriptionDetailId = subscriptionDetailId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
