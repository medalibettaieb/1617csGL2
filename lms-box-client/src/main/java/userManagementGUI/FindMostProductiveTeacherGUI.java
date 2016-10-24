package userManagementGUI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.Teacher;
import tn.esprit.cs.g2.services.UserManagementRemote;

public class FindMostProductiveTeacherGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/UserManagement!tn.esprit.cs.g2.services.UserManagementRemote");

		Teacher teacher = userManagementRemote.findMostProductiveTeacher();
		System.out.println(teacher.getName());
	}

}
