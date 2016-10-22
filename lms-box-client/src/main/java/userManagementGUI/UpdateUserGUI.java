package userManagementGUI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.User;
import tn.esprit.cs.g2.services.UserManagementRemote;

public class UpdateUserGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/UserManagement!tn.esprit.cs.g2.services.UserManagementRemote");

		User userFound = userManagementRemote.findUserById(1);

		userFound.setName("newlook");

		userManagementRemote.saveOrUpdateUser(userFound);

	}

}
