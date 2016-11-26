package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.cs.g2.services.UserManagementLocal;

@ManagedBean
public class SubscriptionBean {
	private String name;
	private String email;
	@EJB
	private UserManagementLocal userManagementLocal;

	public String doSubscribeToLmsBox() {
		userManagementLocal.subscribeToLmsBox(name, email);
		return "/login";

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
