package tn.esprit.cs.g2.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findCoursesByTeacherId(int idTeacher) {
		String jpql = "SELECT c FROM Course c WHERE c.teacher.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idTeacher);
		return query.getResultList();
	}

	@Override
	public Course findCourseById(int idCourse) {
		return entityManager.find(Course.class, idCourse);
	}

}
