package userManagementGUI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.User;
import tn.esprit.cs.g2.services.UserManagementRemote;

public class FindUserByIdGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/UserManagement!tn.esprit.cs.g2.services.UserManagementRemote");

		User userFound = userManagementRemote.findUserById(1);

		System.out.println(userFound.getName());
		
		System.out.println(userFound.getCourses().get(0).getName());
		

	}

}
