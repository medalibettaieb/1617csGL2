package courseManagementGUI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.services.CourseManagementRemote;

public class _02TestSubscribeToCourse {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CourseManagementRemote courseManagementRemote = (CourseManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/CourseManagement!tn.esprit.cs.g2.services.CourseManagementRemote");

		courseManagementRemote.subscibeToCourse(1, 1);
		courseManagementRemote.subscibeToCourse(1, 2);
		courseManagementRemote.subscibeToCourse(2, 3);
		courseManagementRemote.subscibeToCourse(2, 4);
		courseManagementRemote.subscibeToCourse(2, 5);

	}
}
