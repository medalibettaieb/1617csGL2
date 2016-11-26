package tn.esprit.cs.g2.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "User")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String login;
	private String password;

	@OneToMany(mappedBy = "teacher", cascade = CascadeType.MERGE, targetEntity = Course.class)
	private List<Course> courses;

	@OneToMany(mappedBy = "user")
	private List<SubscriptionDetail> subscriptionDetails;

	private static final long serialVersionUID = 1L;

	public User() {
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public User(String name, String login, String password) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void linkCoursesWithThisUser(List<Course> courses) {
		this.courses = courses;
		for (Course c : courses) {
			c.setTeacher(this);
		}
	}

	public List<SubscriptionDetail> getSubscriptionDetails() {
		return subscriptionDetails;
	}

	public void setSubscriptionDetails(List<SubscriptionDetail> subscriptionDetails) {
		this.subscriptionDetails = subscriptionDetails;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
