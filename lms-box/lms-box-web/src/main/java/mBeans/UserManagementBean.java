package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.cs.g2.entities.Student;
import tn.esprit.cs.g2.services.UserManagementLocal;

@ManagedBean
public class UserManagementBean {
	private Student student = new Student();

	@EJB
	private UserManagementLocal userManagementLocal;

	public String doSaveOrUpdate() {
		userManagementLocal.saveOrUpdateUser(student);
		return null;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
