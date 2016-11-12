package userManagementGUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.entities.SubscriptionDetail;
import tn.esprit.cs.g2.services.UserManagementRemote;

public class TestFindSubscriptionDetailByStudentAndCourse {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("lms-box-ear/lms-box-ejb/UserManagement!tn.esprit.cs.g2.services.UserManagementRemote");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfTheSubscription = dateFormat.parse("2016-11-12");
		SubscriptionDetail subscriptionDetail = userManagementRemote.findSubscriptionOfStudentInCourse(1, 1,
				dateOfTheSubscription);
		System.out.println(subscriptionDetail.getStateOfValidation());
	}

}
