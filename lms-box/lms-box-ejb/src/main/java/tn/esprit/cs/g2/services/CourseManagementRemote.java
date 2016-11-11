package tn.esprit.cs.g2.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.Student;

@Remote
public interface CourseManagementRemote {
	void addCourseWithTeacher(Course course, int idTeacher);

	List<Course> findCoursesByTeacherId(int idTeacher);

	void subscibeToCourse(int idCourse, int idStudent);

	List<Student> findAllStudentsByCourseId(int idCourse);

	List<Course> findAllCoursesByIdUser(int idUser);
	

}
