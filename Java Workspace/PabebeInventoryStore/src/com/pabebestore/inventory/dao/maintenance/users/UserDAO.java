package com.pabebestore.inventory.dao.maintenance.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pabebestore.inventory.dao.connection.DefaultConnectionDAO;
import com.pabebestore.inventory.models.items.Item;
import com.pabebestore.inventory.models.user.User;
import com.pabebestore.inventory.models.user.UserInfo;

public class UserDAO extends DefaultConnectionDAO{

	public UserDAO() throws InstantiationException, IllegalAccessException,
	ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean createNewUser(Connection connection, UserInfo userInfo){	
		String SQL = "INSERT INTO users (username,firstname,lastname,password,department) values (?,?,?,SHA1(?),?)";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, userInfo.getUserName());
			preparedStatement.setString(2, userInfo.getFirstName());
			preparedStatement.setString(3, userInfo.getLastName());
			preparedStatement.setString(4, userInfo.getPassword());
			preparedStatement.setString(5, userInfo.getDepartment());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return false;
	}	

	public boolean updateUser(Connection connection, User user){
		String SQL = "UPDATE users SET username=?, firstname=?, lastname=?, password=SHA1(?), department=? where id = ?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(SQL);	
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getDepartment());
			preparedStatement.setInt(6, user.getId());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public void deleteUser(Connection connection, int userId){
		String SQL = "DELETE FROM users where id = ?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, userId);

			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public List<User> getAllUsers(Connection connection, String searchKeyword) {
		List<User> users = new ArrayList<User>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String SQL ="SELECT * FROM users ";
		if(searchKeyword != null && searchKeyword.length() > 0){
			SQL = SQL + "WHERE username LIKE ? or firstname LIKE ? or lastname LIKE ? or department LIKE ?";
		}
		try {
			statement = connection.prepareStatement(SQL);
			if(searchKeyword != null && searchKeyword.length() > 0){
				statement.setString(1, "%"+searchKeyword+"%");
				statement.setString(2, "%"+searchKeyword+"%");
				statement.setString(3, "%"+searchKeyword+"%");
				statement.setString(4, "%"+searchKeyword+"%");
			}
			
			rs = statement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("ID"));
				user.setUserName(rs.getString("username"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDepartment(rs.getString("department"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;	
	}
	public User viewUser(Connection connection, int userId){
		String SQL = "SELECT * FROM users where id = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		User user = new User();
		try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, userId);

			rs = preparedStatement.executeQuery();

			if(rs.next()){
				user.setId(userId);
				user.setUserName(rs.getString("username"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setPassword(rs.getString("password"));
				user.setDepartment(rs.getString("department"));
			}

			return user;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public boolean checkUsernameExists(Connection connection, UserInfo userInfo) throws Exception{	
		String SQL = "SELECT * FROM users WHERE username = ? AND id != ?";
		PreparedStatement preparedStatement = null;

    	try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, userInfo.getUserName());
			preparedStatement.setInt(2, userInfo.getId());
			ResultSet rs = preparedStatement.executeQuery();

			return rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return false;
	}
}



