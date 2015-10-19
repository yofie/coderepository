package com.pabebestore.inventory.dao.maintenance.users;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.pabebestore.inventory.dao.connection.DefaultConnectionDAO;
import com.pabebestore.inventory.models.items.Item;
import com.pabebestore.inventory.models.user.*;

public class UserDAOImpl extends UserDAO{

	
	public UserDAOImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		super();
	}
	
	public boolean createNewUser(UserInfo user){
		Connection connection = null;
		super.setConnection();
		try{
			connection = super.getConnection();
			
			super.createNewUser(connection, user);
			return true;
			
		} catch(Exception e){
			e.printStackTrace();
		}

		return false;

	}
	
	public boolean deleteUser(int userId){
		Connection connection = null;
		super.setConnection();
		try{
			connection = super.getConnection();

			super.deleteUser(connection, userId);
			return true;

		} catch(Exception e){
			e.printStackTrace();
		}

		return false;
	}	
	
	public List<User> getAllUsers(String keyword) {
		List<User> items = new ArrayList<User>();
		Connection connection = null;
		super.setConnection();

		connection = super.getConnection();

		items = super.getAllUsers(connection, keyword);

		return items;
	}
	public boolean updateUser(User user){
		Connection connection = null;
		super.setConnection();
		try{
			connection = super.getConnection();

			super.updateUser(connection, user);
			return true;

		} catch(Exception e){
			e.printStackTrace();
		}

		return false;
	}
	public User viewUser(int userId){

		Connection connection = null;
		super.setConnection();
		connection = super.getConnection();

		return super.viewUser(connection, userId);

	}
	
	public boolean checkUsernameExists(UserInfo user){
		Connection connection = null;
		super.setConnection();
		
		connection = super.getConnection();
		try {
			return super.checkUsernameExists(connection, user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
