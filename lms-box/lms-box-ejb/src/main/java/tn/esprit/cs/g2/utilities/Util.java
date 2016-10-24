package tn.esprit.cs.g2.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.cs.g2.entities.Student;
import tn.esprit.cs.g2.entities.Teacher;
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

	/**
	 * Default constructor.
	 */
	public Util() {
	}

	@PostConstruct
	public void initDB() {
		Student student = new Student("salah", "VIP");
		Student student2 = new Student("olfa", "VIP");

		Teacher teacher = new Teacher("hmed", 100);
		Teacher teacher2 = new Teacher("saida", 200);

		userManagementLocal.saveOrUpdateUser(teacher);
		userManagementLocal.saveOrUpdateUser(teacher2);
		userManagementLocal.saveOrUpdateUser(student);
		userManagementLocal.saveOrUpdateUser(student2);
	}
}
