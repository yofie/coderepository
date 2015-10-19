package com.pabebestore.inventory.dao.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pabebestore.inventory.models.user.UserInfo;

public class AccessDAOImpl extends AccessDAO{

	public AccessDAOImpl() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		super();
	}
	
	public boolean isValidCredentials(UserInfo userInfo){
		
		Connection connection;
		boolean result = false;
		
		try {
			super.setConnection();
			connection = super.getConnection();
			result = super.isValidCredentials(connection, userInfo);
			
			connection.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public UserInfo getUserAccessInfo(UserInfo userInfo) throws SQLException{
		
		Connection connection;
		ResultSet resultSet = null;
		super.setConnection();
		connection = super.getConnection();

		try {
			
			resultSet = super.getUserAccessInfo(connection, userInfo);			
			if(resultSet.next()){
				userInfo.setFirstName(resultSet.getString("FIRSTNAME"));
				userInfo.setLastName(resultSet.getString("LASTNAME"));
				userInfo.setDepartment(resultSet.getString("DEPARTMENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
				
		return userInfo;
	}

}
