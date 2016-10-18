package tn.esprit.cs.g2.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.Teacher;

/**
 * Session Bean implementation class CourseManagement
 */
@Stateless
public class CourseManagement implements CourseManagementRemote, CourseManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private UserManagementLocal userManagementLocal;

	/**
	 * Default constructor.
	 */
	public CourseManagement() {
	}

	@Override
	public void addCourseWithTeacher(Course course, int idTeacher) {
		Teacher teacher = (Teacher) userManagementLocal.findUserById(idTeacher);
		course.setTeacher(teacher);

		entityManager.persist(course);

	}

}
