package tn.esprit.cs.g2.utilities;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.ExamType;
import tn.esprit.cs.g2.entities.Student;
import tn.esprit.cs.g2.entities.Teacher;
import tn.esprit.cs.g2.services.CourseManagementLocal;
import tn.esprit.cs.g2.services.UserManagementLocal;

/**
 * Session Bean implementation class Util
 */
@Singleton
@LocalBean
@Startup
public class Util {
	@EJB
	private UserManagementLocal userManagementLocal;
	@EJB
	private CourseManagementLocal courseManagementLocal;

	/**
	 * Default constructor.
	 */
	public Util() {
	}

	@PostConstruct
	public void initDB() {
		Student student = new Student("salah", "VIP");
		Student student2 = new Student("olfa", "VIP");
		Student student3 = new Student("rim", "VIP");
		Student student4 = new Student("ali", "VIP");
		Student student5 = new Student("sami", "VIP");

		Map<ExamType, Integer> map = new HashMap<>();
		map.put(ExamType.DS, 20);
		map.put(ExamType.EXAM, 80);
		Map<ExamType, Integer> map2 = new HashMap<>();
		map2.put(ExamType.TP, 50);
		map2.put(ExamType.PROJECT, 50);

		Teacher teacher = new Teacher("hmed", 10);
		Teacher teacher2 = new Teacher("saida", 20);

		Course course = new Course("java EE", map);
		course.setTeacher(teacher);
		Course course2 = new Course("SPRING", map2);
		course2.setTeacher(teacher2);

		userManagementLocal.saveOrUpdateUser(student);
		userManagementLocal.saveOrUpdateUser(student2);
		userManagementLocal.saveOrUpdateUser(student3);
		userManagementLocal.saveOrUpdateUser(student4);
		userManagementLocal.saveOrUpdateUser(student5);

		courseManagementLocal.saveOrUpdateCourse(course);
		courseManagementLocal.saveOrUpdateCourse(course2);
	}
}
