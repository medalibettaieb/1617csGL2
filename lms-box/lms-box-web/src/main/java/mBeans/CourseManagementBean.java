package mBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.services.CourseManagementLocal;

@ManagedBean
@ViewScoped
public class CourseManagementBean {
	private Boolean displayF1 = true;
	private Boolean displayF2 = false;

	private Course course = new Course();
	private List<Course> coursesByTeacher;
	private List<Course> coursesByStudent;
	private List<Course> allCourses;
	@EJB
	private CourseManagementLocal courseManagementLocal;
	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	public String doSaveOrUpdateCourse() {
		int idTeacher = identity.getUser().getId();
		courseManagementLocal.addCourseWithTeacher(course, idTeacher);
		return null;
	}

	public String doSubscribe() {
		courseManagementLocal.subscibeToCourse(course.getId(), identity.getUser().getId());
		return "/pages/studentHome/home?faces-redirect=true";
	}

	public void select() {
		displayF1 = false;
		displayF2 = true;
	}

	public void cancel() {
		displayF1 = true;
		displayF2 = false;
	}

	public void doDeleteCourse() {
		courseManagementLocal.deleteCourse(course.getId());
		cancel();
	}

	public void doUpdateCourse() {
		courseManagementLocal.saveOrUpdateCourse(course);
		cancel();
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

	public List<Course> getCoursesByTeacher() {
		coursesByTeacher = courseManagementLocal.findCoursesByTeacherId(identity.getUser().getId());
		return coursesByTeacher;
	}

	public void setCoursesByTeacher(List<Course> coursesByTeacher) {
		this.coursesByTeacher = coursesByTeacher;
	}

	public Boolean getDisplayF1() {
		return displayF1;
	}

	public void setDisplayF1(Boolean displayF1) {
		this.displayF1 = displayF1;
	}

	public Boolean getDisplayF2() {
		return displayF2;
	}

	public void setDisplayF2(Boolean displayF2) {
		this.displayF2 = displayF2;
	}

	public List<Course> getAllCourses() {
		allCourses = courseManagementLocal.findAllCourses();
		return allCourses;
	}

	public void setAllCourses(List<Course> allCourses) {
		this.allCourses = allCourses;
	}

	public List<Course> getCoursesByStudent() {
		coursesByStudent = courseManagementLocal.findAllCoursesByIdUser(identity.getUser().getId());
		return coursesByStudent;
	}

	public void setCoursesByStudent(List<Course> coursesByStudent) {
		this.coursesByStudent = coursesByStudent;
	}

}
