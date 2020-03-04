package dao;

import java.util.ArrayList;
import java.util.Date;

import model.User;

public class UserFakeDataDAO {

	static ArrayList<User> list = new ArrayList<User>() {
		private static final long serialVersionUID = 1L;
	{
		add(new User("thang", "123", "Thang", "Hoang", new Date(), "Hello"));
		add(new User("huy", "123", "Huy", "Van", new Date(), "Hello"));
		add(new User("dung", "123", "A", "Nguyen", new Date(), "Hello"));
		add(new User("thanh", "123", "B", "Phan", new Date(), "Hello"));
		add(new User("viet", "123", "C", "Hoang", new Date(), "Hello"));
	}};
	
	public ArrayList<User> getListUsers() {	
		return UserFakeDataDAO.list;
	}
}
