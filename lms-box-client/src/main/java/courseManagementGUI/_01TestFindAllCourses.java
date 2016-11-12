package courseManagementGUI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.ExamType;
import tn.esprit.cs.g2.services.CourseManagementRemote;

public class _01TestFindAllCourses {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CourseManagementRemote courseManagementRemote = (CourseManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/CourseManagement!tn.esprit.cs.g2.services.CourseManagementRemote");

		List<Course> courses = courseManagementRemote.findAllCourses();
		Map<ExamType, Integer> map=new HashMap<>();
		for (Course c : courses) {
			System.out.println(c.getName());
			map=c.getMapExamType();
			System.out.println(map);
		}
	}
}
