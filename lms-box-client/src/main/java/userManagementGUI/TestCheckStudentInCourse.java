package userManagementGUI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.Student;
import tn.esprit.cs.g2.services.UserManagementRemote;

public class TestCheckStudentInCourse {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/UserManagement!tn.esprit.cs.g2.services.UserManagementRemote");

		Student student = userManagementRemote.checkIfStudentIsSuscribed(1, 2);
		System.out.println(student.getName());

	}

}
