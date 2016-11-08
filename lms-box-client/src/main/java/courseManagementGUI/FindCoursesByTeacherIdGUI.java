package courseManagementGUI;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.ExamType;
import tn.esprit.cs.g2.services.CourseManagementRemote;

public class FindCoursesByTeacherIdGUI {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CourseManagementRemote courseManagementRemote = (CourseManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/CourseManagement!tn.esprit.cs.g2.services.CourseManagementRemote");

		List<Course> courses = courseManagementRemote.findCoursesByTeacherId(1);
		for (Course c : courses) {
			System.out.println(c.getMapExamType().get(ExamType.DS));
		}
	}
}
