package userManagementGUI;

import java.util.List;

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

		List<Teacher> teachers = userManagementRemote.findMostProductiveTeachers();
		for (Teacher t : teachers) {
			System.out.println(t.getName());
		}
	}

}
