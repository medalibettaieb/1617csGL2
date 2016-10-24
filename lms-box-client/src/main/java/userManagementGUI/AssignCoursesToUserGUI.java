package userManagementGUI;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.services.UserManagementRemote;

public class AssignCoursesToUserGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/UserManagement!tn.esprit.cs.g2.services.UserManagementRemote");

		Course course = new Course("PHP");
		Course course2 = new Course("LINUX");
		Course course3 = new Course("PYTHON");

		List<Course> courses = new ArrayList<Course>();
		courses.add(course);
		courses.add(course2);

		List<Course> courses2 = new ArrayList<Course>();
		courses2.add(course3);

		userManagementRemote.assignCoursesToUser(1, courses);
		userManagementRemote.assignCoursesToUser(2, courses2);

	}

}
