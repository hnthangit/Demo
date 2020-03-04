package service;

import java.util.ArrayList;

import dao.UserFakeDataDAO;
import dao.UserSqlDAO;
import model.User;

public class UserService {
	UserFakeDataDAO userDAO = new UserFakeDataDAO();
	//UserSqlDAO userDAO = new UserSqlDAO();
	
	public ArrayList<User> getListUsers() {	
		return userDAO.getListUsers();
	}
}
