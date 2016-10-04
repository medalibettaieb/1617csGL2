package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.cs.g2.services.DisplaySchedulerRemote;

public class TestDisplayScheduler {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			DisplaySchedulerRemote displaySchedulerRemote = (DisplaySchedulerRemote) context
					.lookup("lms-box-ear/lms-box-ejb/DisplayScheduler!tn.esprit.cs.g2.services.DisplaySchedulerRemote");

			System.out.println(displaySchedulerRemote.requestForScheduler());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
