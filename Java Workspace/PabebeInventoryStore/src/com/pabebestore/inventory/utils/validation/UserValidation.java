package com.pabebestore.inventory.utils.validation;

import com.pabebestore.inventory.dao.maintenance.users.UserDAOImpl;
import com.pabebestore.inventory.models.items.ItemInfo;
import com.pabebestore.inventory.models.user.UserInfo;

public class UserValidation {

	public static boolean failedValidation;
	
	public static UserInfo validateUserAccess(UserInfo userInfo){
		
		failedValidation = false;
		
		//User name validation
		try{
		if(userInfo.getUserName().length() == 0){
			userInfo.setUserNameErrorMessage("Usernname is required.");
			failedValidation = true;
		}else if(userInfo.getUserName().length() > 9){
			userInfo.setUserNameErrorMessage("Please enter maximum of 9 characters");
			failedValidation = true;
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//password
		if(userInfo.getPassword().length() == 0){
			userInfo.setPasswordErrorMessage("Password is required.");
			failedValidation = true;
		}
		
		return userInfo;
	}

	
	public static boolean negativeTesting;
	
	public static UserInfo validateUserRegistration(UserInfo userInfo){
		
		negativeTesting = false;
		
		UserDAOImpl userDAOImpl;
		try {
			userDAOImpl = new UserDAOImpl();

			//username validation
			if(userInfo.getUserName().length() == 0){
				userInfo.setUserNameErrorMessage("Username is required!");
				negativeTesting = true;
			}else if(userInfo.getUserName().length() > 45){
				userInfo.setUserNameErrorMessage("Username should not exceed to 45 characters!");
				negativeTesting = true;
			}else if(userDAOImpl.checkUsernameExists(userInfo)){
				userInfo.setUserNameErrorMessage("Username already exists");
				negativeTesting = true;
			}
			
			//password validation
			if(userInfo.getPassword().length() == 0){
				userInfo.setPasswordErrorMessage("Password is required!");
				negativeTesting = true;
			}
			
			
			//firstname validation
			if(userInfo.getFirstName().length() == 0){
				userInfo.setFirstNameErrorMessage("Firstname is required!");
				negativeTesting = true;
			}else if(userInfo.getFirstName().length() > 45){
				userInfo.setFirstNameErrorMessage("Firstname should not exceed to 45 characters!");
				negativeTesting = true;
			}else if(userInfo.getFirstName().matches("[a-zA-Z ]*\\d+.*")){
				userInfo.setFirstNameErrorMessage("Firstname should not contain numbers!");
				negativeTesting = true;
			}
			
			//lastname validation
			if(userInfo.getLastName().length() == 0){
				userInfo.setLastNameErrorMessage("Lastname is required!");
				negativeTesting = true;
			}else if(userInfo.getLastName().length() > 45){
				userInfo.setLastNameErrorMessage("Lastname should not exceed to 45 characters!");
				negativeTesting = true;
			}else if(userInfo.getLastName().matches("[a-zA-Z ]*\\d+.*")){
				userInfo.setLastNameErrorMessage("Lastname should not contain numbers!");
				negativeTesting = true;
			}
			
			
			//confirm password validation
			if(userInfo.getConfirmPassword().length() == 0){
				userInfo.setConfirmPasswordErrorMessage("Confirm password is required!");
				negativeTesting = true;
			}else if (!userInfo.getPassword().equals(userInfo.getConfirmPassword())){
				userInfo.setConfirmPasswordErrorMessage("Password did not match!");
				negativeTesting = true;   
			}
			
			
			//department validation
			if(userInfo.getDepartment().length() == 0){
				userInfo.setDepartmentErrorMessage("Department is required!");
				negativeTesting = true;
			}else if(userInfo.getDepartment().length() > 45){
				userInfo.setDepartmentErrorMessage("Department should not exceed to 45 characters!");
				negativeTesting = true;
			}
			userInfo.setFailedValidation(negativeTesting);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		
		return userInfo;
	}
	

	public static void main(String[] args){
		
		UserInfo ui = new UserInfo();
		
		ui.setUserName("");
		ui.setPassword("Andrea");
		ui.setFirstName("");
		ui.setLastName("");
		ui.setConfirmPassword("Yofie");
		ui.setDepartment("fdgsdag");
		
		UserValidation.validateUserRegistration(ui);
		
		
		System.out.println("Username: " + ui.getUserNameErrorMessage());
		System.out.println("Password: " + ui.getPasswordErrorMessage());
		System.out.println("Confirm Password: " + ui.getConfirmPasswordErrorMessage());
		System.out.println("Firstname: " + ui.getFirstNameErrorMessage());
		System.out.println("Lastname: " + ui.getLastNameErrorMessage());
		System.out.println("Department: " + ui.getDepartmentErrorMessage());
		
	}
	
	
}
