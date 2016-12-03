package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.ExamType;
import tn.esprit.cs.g2.services.CourseManagementLocal;

@ManagedBean
@ViewScoped
public class MarkBean {
	private Course course = new Course();
	private List<ExamType> keyList;
	@ManagedProperty(value = "#{courseManagementBean}")
	private CourseManagementBean courseManagementBean;
	@EJB
	private CourseManagementLocal courseManagementLocal;

	public Course getCourse() {
		course = courseManagementLocal.findCourseById(2);
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseManagementBean getCourseManagementBean() {
		return courseManagementBean;
	}

	public void setCourseManagementBean(CourseManagementBean courseManagementBean) {
		this.courseManagementBean = courseManagementBean;
	}

	public List<ExamType> getKeyList() {
		System.out.println(course.getName());
		keyList = new ArrayList<ExamType>(course.getMapExamType().keySet());
		return keyList;
	}

	public void setKeyList(List<ExamType> keyList) {
		this.keyList = keyList;
	}

}
