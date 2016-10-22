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

		List<Course> courses = new ArrayList<Course>();
		courses.add(course);
		courses.add(course2);

		userManagementRemote.assignCoursesToUser(1, courses);

	}

}
