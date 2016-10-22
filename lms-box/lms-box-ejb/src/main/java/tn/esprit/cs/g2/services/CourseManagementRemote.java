package tn.esprit.cs.g2.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.cs.g2.entities.Course;

@Remote
public interface CourseManagementRemote {
	void addCourseWithTeacher(Course course, int idTeacher);

	List<Course> findCoursesByTeacherId(int idTeacher);

}
