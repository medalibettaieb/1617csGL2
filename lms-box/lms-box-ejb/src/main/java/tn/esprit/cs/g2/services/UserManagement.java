package tn.esprit.cs.g2.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.Teacher;
import tn.esprit.cs.g2.entities.User;

/**
 * Session Bean implementation class UserManagement
 */
@Stateless
public class UserManagement implements UserManagementRemote, UserManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	private CourseManagementLocal courseManagementLocal;

	/**
	 * Default constructor.
	 */
	public UserManagement() {
	}

	@Override
	public void saveOrUpdateUser(User user) {
		entityManager.merge(user);

	}

	@Override
	public void deleteUserById(int idUser) {
		entityManager.remove(findUserById(idUser));

	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(entityManager.merge(user));

	}

	@Override
	public User findUserById(int idUser) {
		return entityManager.find(User.class, idUser);
	}

	@Override
	public void assignCoursesToUser(int idUser, List<Course> courses) {
		Teacher teacher = (Teacher) findUserById(idUser);
		teacher.linkCoursesWithThisUser(courses);

		saveOrUpdateUser(teacher);

	}

	@Override
	public List<Teacher> findMostProductiveTeachers() {
		List<User> teachers = findAllUsers();
		Teacher theOne = new Teacher();
		List<Teacher> teachersElected = new ArrayList<>();
		for (User u : teachers) {
			if (u instanceof Teacher && u != null) {
				try {
					int sizeOf = courseManagementLocal.findCoursesByTeacherId(u.getId()).size();
					int theOneSize = courseManagementLocal.findCoursesByTeacherId(theOne.getId()).size();
					if (sizeOf == theOneSize) {
						theOne = (Teacher) u;
						teachersElected.add(theOne);
					}
					if (sizeOf > theOneSize) {
						theOne = (Teacher) u;
						teachersElected = new ArrayList<>();
						teachersElected.add(theOne);
					}

				} catch (Exception e) {
					System.out.println("the one is NULL");
				}

			} else {
				System.out.println("not a teacher");
			}
		}
		return teachersElected;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		return entityManager.createQuery("select u from User u").getResultList();
	}

	@Override
	public Teacher findTeacherByCourseId(int idCourse) {
		Teacher teacher = null;
		Course course = courseManagementLocal.findCourseById(idCourse);
		String qlString = "select u from User u where :param1 member of u.courses";
		Query query = entityManager.createQuery(qlString);
		query.setParameter("param1", course);
		try {
			teacher = (Teacher) query.getSingleResult();
		} catch (Exception e) {
		}
		return teacher;
	}

}
