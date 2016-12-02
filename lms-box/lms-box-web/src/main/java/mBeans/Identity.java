package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.cs.g2.entities.Student;
import tn.esprit.cs.g2.entities.Teacher;
import tn.esprit.cs.g2.entities.User;
import tn.esprit.cs.g2.services.UserManagementLocal;

@ManagedBean
@SessionScoped
public class Identity {
	private User user = new User();
	private Boolean isLogged = false;
	private Boolean loggedInAsTeacher = false;
	private Boolean loggedInAsStudent = false;
	@EJB
	private UserManagementLocal userManagementLocal;

	public String doLogin() {
		String navigateTo = null;
		User userLoggedIn = userManagementLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			isLogged = true;
			if (userLoggedIn instanceof Teacher) {
				loggedInAsTeacher = true;
				navigateTo = "/pages/teacherHome/home?faces-redirect=true";
			} else if (userLoggedIn instanceof Student) {
				loggedInAsStudent = true;
				navigateTo = "/pages/studentHome/home?faces-redirect=true";
			}
		} else {
			navigateTo = "/fail?faces-redirect=true";
		}
		return navigateTo;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedInAsTeacher() {
		return loggedInAsTeacher;
	}

	public void setLoggedInAsTeacher(Boolean loggedInAsTeacher) {
		this.loggedInAsTeacher = loggedInAsTeacher;
	}

	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Boolean getLoggedInAsStudent() {
		return loggedInAsStudent;
	}

	public void setLoggedInAsStudent(Boolean loggedInAsStudent) {
		this.loggedInAsStudent = loggedInAsStudent;
	}

}
