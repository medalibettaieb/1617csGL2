package userManagementGUI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.User;
import tn.esprit.cs.g2.services.UserManagementRemote;

public class DeleteUserGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/UserManagement!tn.esprit.cs.g2.services.UserManagementRemote");

		User user = userManagementRemote.findUserById(2);
		userManagementRemote.deleteUser(user);

	}

}
