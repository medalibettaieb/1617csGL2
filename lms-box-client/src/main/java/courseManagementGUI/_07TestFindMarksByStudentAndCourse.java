package courseManagementGUI;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.ExamType;
import tn.esprit.cs.g2.services.CourseManagementRemote;

public class _07TestFindMarksByStudentAndCourse {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CourseManagementRemote courseManagementRemote = (CourseManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/CourseManagement!tn.esprit.cs.g2.services.CourseManagementRemote");

		Map<ExamType, Float> map = courseManagementRemote.findMarksByStudentAndCourse(1, 2);

		for (Map.Entry<ExamType, Float> entry : map.entrySet()) {
			System.out.println("type exam :" + entry.getKey() + "\n mark : " + entry.getValue());
		}
		System.out.println(map.size());

	}
}
