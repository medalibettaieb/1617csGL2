package tn.esprit.cs.g2.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.Student;
import tn.esprit.cs.g2.entities.SubscriptionDetail;
import tn.esprit.cs.g2.entities.Teacher;
import tn.esprit.cs.g2.entities.User;

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

	@Override
	public void subscibeToCourse(int idCourse, int idStudent) {
		Course courseFound = findCourseById(idCourse);
		User userFound = userManagementLocal.findUserById(idStudent);

		SubscriptionDetail subscriptionDetail = new SubscriptionDetail(userFound, courseFound);
		entityManager.merge(subscriptionDetail);
	}

	@Override
	public List<Student> findAllStudentsByCourseId(int idCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAllCoursesByIdUser(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdateCourse(Course course) {
		entityManager.merge(course);
	}
}
