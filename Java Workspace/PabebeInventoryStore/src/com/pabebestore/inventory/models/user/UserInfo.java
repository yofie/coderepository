package com.pabebestore.inventory.models.user;

public class UserInfo extends User{

	private String userNameErrorMessage;
	private String passwordErrorMessage;
	private String firstNameErrorMessage;
	private String lastNameErrorMessage;
	private String confirmPasswordErrorMessage;
	private String departmentErrorMessage;
	private boolean failedValidation;
	private String userRole;
	
	public String getUserNameErrorMessage() {
		return userNameErrorMessage;
	}
	public void setUserNameErrorMessage(String userNameErrorMessage) {
		this.userNameErrorMessage = userNameErrorMessage;
	}
	public String getPasswordErrorMessage() {
		return passwordErrorMessage;
	}
	public void setPasswordErrorMessage(String passwordErrorMessage) {
		this.passwordErrorMessage = passwordErrorMessage;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public boolean isFailedValidation() {
		return failedValidation;
	}
	public void setFailedValidation(boolean failedValidation) {
		this.failedValidation = failedValidation;
	}
	public String getFirstNameErrorMessage() {
		return firstNameErrorMessage;
	}
	public void setFirstNameErrorMessage(String firstNameErrorMessage) {
		this.firstNameErrorMessage = firstNameErrorMessage;
	}
	public String getLastNameErrorMessage() {
		return lastNameErrorMessage;
	}
	public void setLastNameErrorMessage(String lastNameErrorMessage) {
		this.lastNameErrorMessage = lastNameErrorMessage;
	}
	public String getDepartmentErrorMessage() {
		return departmentErrorMessage;
	}
	public void setDepartmentErrorMessage(String departmentErrorMessage) {
		this.departmentErrorMessage = departmentErrorMessage;
	}
	public String getConfirmPasswordErrorMessage() {
		return confirmPasswordErrorMessage;
	}
	public void setConfirmPasswordErrorMessage(String confirmPasswordErrorMessage) {
		this.confirmPasswordErrorMessage = confirmPasswordErrorMessage;
	}

}
