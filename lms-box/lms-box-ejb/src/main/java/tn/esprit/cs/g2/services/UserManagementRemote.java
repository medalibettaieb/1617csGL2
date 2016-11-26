package tn.esprit.cs.g2.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.Student;
import tn.esprit.cs.g2.entities.SubscriptionDetail;
import tn.esprit.cs.g2.entities.Teacher;
import tn.esprit.cs.g2.entities.User;

@Remote
public interface UserManagementRemote {
	void subscribeToLmsBox(String name, String email);

	void saveOrUpdateUser(User user);

	void deleteUserById(int idUser);

	void deleteUser(User user);

	User findUserById(int idUser);

	void assignCoursesToUser(int idUser, List<Course> courses);

	List<Teacher> findMostProductiveTeachers();

	Teacher findTeacherByCourseId(int idCourse);

	Teacher checkTeacherByCourseId(int idCourse, int idTeacher);

	List<User> findAllUsers();

	Student checkIfStudentIsSuscribed(int studentId, int courseId);

	SubscriptionDetail findSubscriptionOfStudentInCourse(int studentId, int courseId, Date dateOfTheSubscription);

	User login(String login, String password);
}
