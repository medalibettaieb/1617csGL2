package courseManagementGUI;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.ExamType;
import tn.esprit.cs.g2.services.CourseManagementRemote;

public class AddCourseWithTeacherGUI {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CourseManagementRemote courseManagementRemote = (CourseManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/CourseManagement!tn.esprit.cs.g2.services.CourseManagementRemote");
		Course course = new Course("java EE7");
		Map<String, Integer> mapExamType = new HashMap<String, Integer>();
		mapExamType.put(ExamType.DS.toString(), 20);
		mapExamType.put(ExamType.EXAM.toString(), 80);
		course.setMapExamType(mapExamType);

		courseManagementRemote.addCourseWithTeacher(course, 1);

	}
}
