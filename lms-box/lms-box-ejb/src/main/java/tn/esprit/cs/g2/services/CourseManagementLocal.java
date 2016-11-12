package tn.esprit.cs.g2.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.cs.g2.entities.Course;

@Local
public interface CourseManagementLocal {
	void addCourseWithTeacher(Course course, int idTeacher);

	void saveOrUpdateCourse(Course course);

	List<Course> findCoursesByTeacherId(int idTeacher);

	Course findCourseById(int idCourse);
}
