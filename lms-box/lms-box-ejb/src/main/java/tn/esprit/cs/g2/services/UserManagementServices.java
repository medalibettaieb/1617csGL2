package tn.esprit.cs.g2.services;

import javax.ejb.Stateless;

@Stateless
public class UserManagementServices implements UserManagementServicesLocal, UserManagementServicesRemote {

	@Override
	public void sayAhla(String name) {
		System.out.println("ahla w sahla : " + name);
	}

}
