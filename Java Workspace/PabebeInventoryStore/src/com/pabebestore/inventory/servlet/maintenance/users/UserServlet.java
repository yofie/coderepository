package com.pabebestore.inventory.servlet.maintenance.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pabebestore.inventory.controller.maintenance.users.UserController;
import com.pabebestore.inventory.models.user.UserInfo;

@WebServlet({"/AddUser"})
public class UserServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/pages/user/adduser.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageRedirect = "";
		String userName = req.getParameter("username");
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmpassword");
		String department = req.getParameter("department");
			
		
		//get all info from page
		
		UserInfo user = new UserInfo();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setConfirmPassword(confirmPassword);
		user.setDepartment(department);	
		
		UserController userController = new UserController();
		
		user = userController.createNewUser(user);
		
		if(user.isFailedValidation()){
			req.setAttribute("username", userName);
			req.setAttribute("usernameerrmsg", user.getUserNameErrorMessage());
			req.setAttribute("firstname", firstName);
			req.setAttribute("firstnameerrmsg", user.getFirstNameErrorMessage());
			req.setAttribute("lastname", lastName);
			req.setAttribute("lastnameerrmsg", user.getLastNameErrorMessage());
			req.setAttribute("password", password);
			req.setAttribute("passworderrmsg", user.getPasswordErrorMessage());
			req.setAttribute("confirmpassword", confirmPassword);
			req.setAttribute("confirmpassworderrmsg", user.getConfirmPasswordErrorMessage());
			req.setAttribute("department", department);
			req.setAttribute("departmenterrmsg", user.getDepartmentErrorMessage());
			pageRedirect = "/pages/user/adduser.jsp";
			
		}else{
			pageRedirect = "/UserList";
		}
		
		req.getRequestDispatcher(pageRedirect).forward(req, resp);
	}

}
