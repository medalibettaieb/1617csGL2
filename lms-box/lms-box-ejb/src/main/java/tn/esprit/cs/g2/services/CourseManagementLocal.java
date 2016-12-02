package tn.esprit.cs.g2.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.ExamType;
import tn.esprit.cs.g2.entities.Student;

@Local
public interface CourseManagementLocal {

	void saveOrUpdateCourse(Course course);

	Course findCourseById(int idCourse);

	void addCourseWithTeacher(Course course, int idTeacher);

	List<Course> findCoursesByTeacherId(int idTeacher);

	void subscibeToCourse(int idCourse, int idStudent);

	List<Student> findAllStudentsByCourseId(int idCourse);

	List<Course> findAllCoursesByIdUser(int idUser);

	List<Course> findAllCourses();

	void assignMarks(int idTeacher, int idCourse, int idStudent, ExamType typeOfTheEvaluation, Float mark,
			Date dateOfTheEvaluation);

	void deleteCourse(int courseId);
}
