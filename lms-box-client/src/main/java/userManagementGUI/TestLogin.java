package userManagementGUI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.Student;
import tn.esprit.cs.g2.entities.Teacher;
import tn.esprit.cs.g2.entities.User;
import tn.esprit.cs.g2.services.UserManagementRemote;

public class TestLogin {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/UserManagement!tn.esprit.cs.g2.services.UserManagementRemote");

		User userFound = userManagementRemote.login("saida", "saida");

		if (userFound instanceof Student) {
			System.out.println("i am a student");
		} else if (userFound instanceof Teacher) {
			System.out.println("i am a teacher");
		} else {
			System.out.println("not a user");
		}

	}

}
