package tn.esprit.cs.g2.utilities;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class RandomGenerator
 */
@Singleton
@LocalBean
@Startup
public class RandomGenerator {

	/**
	 * Default constructor.
	 */
	public RandomGenerator() {
	}

	public String generate() {
		SecureRandom random = new SecureRandom();
		String password = new BigInteger(90, random).toString(32);
		return password;

	}
}
