package courseManagementGUI;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Random {
	public static void main(String[] args) {
		SecureRandom random=new SecureRandom();
		String login= new BigInteger(90, random).toString(32);
		
		System.out.println(login);
	}
}
