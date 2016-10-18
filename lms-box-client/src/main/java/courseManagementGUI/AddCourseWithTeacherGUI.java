package courseManagementGUI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.services.CourseManagementRemote;

public class AddCourseWithTeacherGUI {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CourseManagementRemote courseManagementRemote = (CourseManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/CourseManagement!tn.esprit.cs.g2.services.CourseManagementRemote");
		Course course = new Course("java EE7");

		courseManagementRemote.addCourseWithTeacher(course, 1);

	}
}
