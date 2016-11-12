package courseManagementGUI;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.Student;
import tn.esprit.cs.g2.services.CourseManagementRemote;

public class _03TestFindAllStudentsByCourseId {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CourseManagementRemote courseManagementRemote = (CourseManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/CourseManagement!tn.esprit.cs.g2.services.CourseManagementRemote");

		List<Student> students = courseManagementRemote.findAllStudentsByCourseId(2);
		for (Student s : students) {
			System.out.println(s.getName());
		}

	}
}
