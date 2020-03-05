package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.User;

public class UserSqlDAO {

	ConnectDB connectDb = new ConnectDB();

	public ArrayList<User> getListUsers() {
		ArrayList<User> list = new ArrayList<>();
		try {
			connectDb.connect();
			String sql = "select * from user";
			PreparedStatement cmd = ConnectDB.connect.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getString(6));
				list.add(user);
			}

			rs.close();
			ConnectDB.connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public User getOneUser(String username) {
		User user = null;
		try {
			connectDb.connect();
			String sql = "select * from user where username = ?";
			PreparedStatement ps = ConnectDB.connect.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getString(6));
			}

			rs.close();
			ConnectDB.connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updateUser(String username, String firstName, String lastName, Date birthDate, String description) {

		try {
			connectDb.connect();

			String sql = "update user set firstName=?, lastName=?, birthDate=?, description=? where username = ?";
			PreparedStatement ps = ConnectDB.connect.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			
			if (birthDate == null)
				ps.setDate(3, null);
			else {
				java.sql.Date date = new java.sql.Date(birthDate.getTime());
				ps.setDate(3, date);
			}

			ps.setString(4, description);
			ps.setString(5, username);
			ps.executeUpdate();

			ConnectDB.connect.close();
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(String username) {

		try {
			connectDb.connect();

			String sql = "delete from user where username=?";
			PreparedStatement ps = ConnectDB.connect.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
			ConnectDB.connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean addUser(User user) {
		if (getOneUser(user.getUsername()) != null)
			return false;
		else {

			try {
				connectDb.connect();

				String sql = "insert into user(username, password, firstName, lastName, birthDate, description) values (?, ?, ?, ?, ?, ?)";
				PreparedStatement ps;

				ps = ConnectDB.connect.prepareStatement(sql);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getFirstName());
				ps.setString(4, user.getLastName());
				
				if (user.getBirthDate() == null)
					ps.setDate(5, null);
				else {
					java.sql.Date date = new java.sql.Date(user.getBirthDate().getTime());
					ps.setDate(5, date);
				}
				
				ps.setString(6, user.getDescription());
				ps.executeUpdate();

				ConnectDB.connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return true;
		}

	}

	public boolean login(String username, String password) {

		try {
			connectDb.connect();

			String sql = "select * from user where username = ? and password = ?";
			PreparedStatement ps = ConnectDB.connect.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				rs.close();
				ConnectDB.connect.close();
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
