package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.services.CourseManagementLocal;

@ManagedBean
@ViewScoped
public class CourseManagementBean {
	private Course course = new Course();
	@EJB
	private CourseManagementLocal courseManagementLocal;
	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	public String doSaveOrUpdateCourse() {
		int idTeacher = identity.getUser().getId();
		courseManagementLocal.addCourseWithTeacher(course, idTeacher);
		return null;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
