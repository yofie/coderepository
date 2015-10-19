package com.pabebestore.inventory.controller.maintenance.users;

import com.pabebestore.inventory.dao.maintenance.users.UserDAOImpl;
import com.pabebestore.inventory.models.user.User;
import com.pabebestore.inventory.models.user.UserInfo;
import com.pabebestore.inventory.utils.validation.UserValidation;

public class UserController {
	
	public UserInfo createNewUser(UserInfo user){
		
		UserDAOImpl userDAOImpl;
		
		try {
			user = UserValidation.validateUserRegistration(user);
			if(!UserValidation.negativeTesting){
				userDAOImpl = new UserDAOImpl();
				userDAOImpl.createNewUser(user);
			}
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}
	public UserInfo updateUser(UserInfo user){

		try {
			user = UserValidation.validateUserRegistration(user);
			
			if(!UserValidation.negativeTesting){
				UserDAOImpl userDAOImpl = new UserDAOImpl();
				userDAOImpl.updateUser(user);
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}
}
