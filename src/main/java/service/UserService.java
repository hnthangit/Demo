package service;

import java.util.ArrayList;
import java.util.Date;

import dao.UserFakeDataDAO;
import model.User;

public class UserService {
	UserFakeDataDAO userDAO = new UserFakeDataDAO();
	// UserSqlDAO userDAO = new UserSqlDAO();

	public ArrayList<User> getListUsers() {
		return userDAO.getListUsers();
	}

	public User getOneUser(String username) {
		return userDAO.getOneUser(username);
	}

	public void updateUser(String username, String firstName, String lastName, Date birthDate, String description) {
		userDAO.updateUser(username, firstName, lastName, birthDate, description);
	}

	public void deleteUser(String username) {
		userDAO.deleteUser(username);
	}

	public void addUser(User user) {
		userDAO.addUser(user);
	}
}
