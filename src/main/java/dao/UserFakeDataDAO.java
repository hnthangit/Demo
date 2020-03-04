package dao;

import java.util.ArrayList;
import java.util.Date;

import model.User;

public class UserFakeDataDAO {

	public static ArrayList<User> list = new ArrayList<User>() {
		private static final long serialVersionUID = 1L;
		{
			add(new User("thang", "123", "Thang", "Hoang", null, "Hello"));
			add(new User("huy", "123", "Huy", "Van", new Date(), "Hello"));
			add(new User("dung", "123", "A", "Nguyen", null, "Hello"));
			add(new User("thanh", "123", "B", "Phan", new Date(), "Hello"));
			add(new User("viet", "123", "C", "Hoang", new Date(), "Hello"));
		}
	};

	public ArrayList<User> getListUsers() {
		return UserFakeDataDAO.list;
	}

	public User getOneUser(String username) {
		for (User user : list) {
			if (user.getUsername().equals(username))
				return user;
		}
		return null;
	}

	public void updateUser(String username, String firstName, String lastName, Date birthDate, String description) {
		for (User user : list) {
			if (user.getUsername().equals(username)) {
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setBirthDate(birthDate);
				user.setDescription(description);
				break;
			}		
		}
	}

	public void deleteUser(String username) {
		int count=0;
		for (User user : list) {
			if (user.getUsername().equals(username)) 
				break;
			else 
				count++;
		}
		list.remove(count);
	}

	public void addUser(User user) {
		list.add(user);
	}
	
	public boolean login(String username, String password) {
		for (User user : list) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return true;			
		}
		return false;
	}
}
