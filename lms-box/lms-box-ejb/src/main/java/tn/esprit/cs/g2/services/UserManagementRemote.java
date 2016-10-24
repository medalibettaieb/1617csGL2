package tn.esprit.cs.g2.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.Teacher;
import tn.esprit.cs.g2.entities.User;

@Remote
public interface UserManagementRemote {

	void saveOrUpdateUser(User user);

	void deleteUserById(int idUser);

	void deleteUser(User user);

	User findUserById(int idUser);

	void assignCoursesToUser(int idUser, List<Course> courses);

	List<Teacher> findMostProductiveTeachers();

	List<User> findAllUsers();
}
