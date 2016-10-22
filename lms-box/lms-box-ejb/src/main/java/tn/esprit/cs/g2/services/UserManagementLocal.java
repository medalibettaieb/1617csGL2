package tn.esprit.cs.g2.services;

import javax.ejb.Local;

import tn.esprit.cs.g2.entities.User;

@Local
public interface UserManagementLocal {
	void saveOrUpdateUser(User user);

	void deleteUserById(int idUser);

	void deleteUser(User user);

	User findUserById(int idUser);
}
