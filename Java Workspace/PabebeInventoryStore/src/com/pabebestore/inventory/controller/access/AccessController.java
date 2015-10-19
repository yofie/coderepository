package com.pabebestore.inventory.controller.access;

import java.sql.SQLException;

import com.pabebestore.inventory.dao.access.AccessDAOImpl;
import com.pabebestore.inventory.models.user.UserInfo;
import com.pabebestore.inventory.utils.validation.UserValidation;

public class AccessController {

	public UserInfo checkUserAccess(String userName, String password) throws SQLException{
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userName);
		userInfo.setPassword(password);
		
		try {
			AccessDAOImpl accessDAOImpl = new AccessDAOImpl();
			
			userInfo = UserValidation.validateUserAccess(userInfo);
			
			if(UserValidation.failedValidation){
				userInfo.setFailedValidation(true);
			}else{
				if(accessDAOImpl.isValidCredentials(userInfo)){

					userInfo.setFailedValidation(false);
					userInfo = accessDAOImpl.getUserAccessInfo(userInfo);
				}else{
					userInfo.setPasswordErrorMessage("Invalid Username/Password.");
					userInfo.setFailedValidation(true);
				}
				
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return userInfo;
	}
	
	public static void main(String[] args){
		AccessController accessController = new AccessController();
		String username = "", password = "";
		UserInfo userValidation;
		try {
			userValidation = accessController.checkUserAccess(username, password);
			System.out.println("isFailed access? "+userValidation.isFailedValidation());
			System.out.println("username error message: "+userValidation.getUserNameErrorMessage());
			System.out.println("username error message: "+userValidation.getPasswordErrorMessage());			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
