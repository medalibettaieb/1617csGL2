package tn.esprit.cs.g2.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.Student;
import tn.esprit.cs.g2.entities.SubscriptionDetail;
import tn.esprit.cs.g2.entities.SubscriptionDetailId;
import tn.esprit.cs.g2.entities.Teacher;
import tn.esprit.cs.g2.entities.User;
import tn.esprit.cs.g2.utilities.MailSender;
import tn.esprit.cs.g2.utilities.RandomGenerator;

/**
 * Session Bean implementation class UserManagement
 */
@Stateless
public class UserManagement implements UserManagementRemote, UserManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private MailSender mailSender;
	@EJB
	private RandomGenerator randomGenerator;

	@EJB
	private CourseManagementLocal courseManagementLocal;
	private String topic = "subscription to LMS-BOX";
	private String textMessage = "hello \n You have been registred to our platform your credentials are : \n ";

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

	@Override
	public Teacher checkTeacherByCourseId(int idCourse, int idTeacher) {
		Teacher courseOwner = null;
		Course course = courseManagementLocal.findCourseById(idCourse);
		String qlString = "select u from User u where :param1 member of u.courses";
		Query query = entityManager.createQuery(qlString);
		query.setParameter("param1", course);
		try {
			courseOwner = (Teacher) query.getSingleResult();
		} catch (Exception e) {
		}
		if (courseOwner.getId() == idTeacher) {
			return courseOwner;
		} else {
			return null;
		}

	}

	@Override
	public Student checkIfStudentIsSuscribed(int studentId, int courseId) {
		List<Student> students = courseManagementLocal.findAllStudentsByCourseId(courseId);
		Student studentFound = (Student) findUserById(studentId);
		if (students.contains(studentFound)) {
			return studentFound;
		} else {
			return null;
		}

	}

	@Override
	public SubscriptionDetail findSubscriptionOfStudentInCourse(int studentId, int courseId,
			Date dateOfTheSubscription) {
		SubscriptionDetailId subscriptionDetailId = new SubscriptionDetailId(studentId, courseId,
				dateOfTheSubscription);

		return entityManager.find(SubscriptionDetail.class, subscriptionDetailId);
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:param1 AND u.password=:param2");
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("user not found");
		}
		return user;
	}

	@Override
	public void subscribeToLmsBox(String name, String email) {
		String password = randomGenerator.generate();
		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setLogin(email);
		student.setPassword(password);

		entityManager.merge(student);

		mailSender.send(email, topic,
				textMessage + "password :" + password + "\n login : " + email + "\n thanks to LMS-TEAM 2017");

	}

}
