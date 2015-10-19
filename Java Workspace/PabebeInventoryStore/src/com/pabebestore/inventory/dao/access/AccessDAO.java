package com.pabebestore.inventory.dao.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pabebestore.inventory.dao.connection.DefaultConnectionDAO;
import com.pabebestore.inventory.models.user.UserInfo;

public class AccessDAO extends DefaultConnectionDAO{

	public AccessDAO() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		super();
	}
	
	public boolean isValidCredentials(Connection connection, UserInfo userInfo){
		String SQL = "SELECT username FROM users WHERE username = ? AND password = SHA1(?);";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, userInfo.getUserName());
			preparedStatement.setString(2, userInfo.getPassword());
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public ResultSet getUserAccessInfo(Connection connection, UserInfo userInfo){
		String SQL = "SELECT * FROM users WHERE username = ?;";
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, userInfo.getUserName());
			
			return preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
