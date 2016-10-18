package tn.esprit.cs.g2.services;

import javax.ejb.Remote;

import tn.esprit.cs.g2.entities.User;

@Remote
public interface UserManagementRemote {
	void addUser(User user);

	void updateUser(User user);

	void deleteUserById(int idUser);

	void deleteUser(User user);

	User findUserById(int idUser);
}
