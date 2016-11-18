package courseManagementGUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.ExamType;
import tn.esprit.cs.g2.services.CourseManagementRemote;

public class _04TestAssignMark {
	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		CourseManagementRemote courseManagementRemote = (CourseManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/CourseManagement!tn.esprit.cs.g2.services.CourseManagementRemote");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfTheEvaluation = dateFormat.parse("2016-11-18");

		courseManagementRemote.assignMarks(6, 1, 1, ExamType.EXAM, 18F, dateOfTheEvaluation);
	}
}
