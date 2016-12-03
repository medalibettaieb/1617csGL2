package courseManagementGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.entities.ExamType;
import tn.esprit.cs.g2.services.CourseManagementRemote;

public class _06TestFindMapExamTypeByCourse {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CourseManagementRemote courseManagementRemote = (CourseManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/CourseManagement!tn.esprit.cs.g2.services.CourseManagementRemote");

		Course course = courseManagementRemote.findCourseById(2);
		Map<ExamType, Integer> map = course.getMapExamType();
		 List<ExamType> keyList = new ArrayList<ExamType>(map.keySet());

		for (ExamType e : keyList) {
			System.out.println(e);
		}
		
		keyList= new ArrayList<ExamType>(course.getMapExamType().keySet());
		System.out.println(keyList.size());
	}
}
