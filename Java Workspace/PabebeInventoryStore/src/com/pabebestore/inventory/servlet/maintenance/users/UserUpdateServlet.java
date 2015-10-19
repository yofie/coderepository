package com.pabebestore.inventory.servlet.maintenance.users;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pabebestore.inventory.controller.access.AccessController;
import com.pabebestore.inventory.controller.maintenance.users.*;
import com.pabebestore.inventory.dao.maintenance.users.*;
import com.pabebestore.inventory.models.user.User;
import com.pabebestore.inventory.models.user.UserInfo;
import com.pabebestore.inventory.utils.validation.UserValidation;

@WebServlet({"/UpdateUser","/ViewUser"})
public class UserUpdateServlet extends HttpServlet{
	
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageRedirect = "";
		int id = Integer.parseInt(req.getParameter("id"));

		UserDAOImpl userDAOImpl;
		try {
			userDAOImpl = new UserDAOImpl();
			User user = new User();
			user = userDAOImpl.viewUser(id);
			
			req.setAttribute("id", id);
			req.setAttribute("username", user.getUserName());
			req.setAttribute("firstname", user.getFirstName());
			req.setAttribute("lastname", user.getLastName());
			req.setAttribute("department", user.getDepartment());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//super.doGet(req, resp);

		pageRedirect = "/pages/user/userUpdate.jsp";
		resp.setHeader("Location", "/");
		req.getRequestDispatcher(pageRedirect).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getServletPath().replaceAll("/", "").replaceAll("#", "");
		AccessController accessController = new AccessController();
		UserInfo userInfo = new UserInfo();
		String pageRedirect = "";
		UserDAOImpl userDAOImpl;
		int id = Integer.parseInt(req.getParameter("id"));

		try{
			
			if(actionName.equals("ViewUser")){
				userDAOImpl = new UserDAOImpl();
				User user = new User();
				user = userDAOImpl.viewUser(id);
				
				req.setAttribute("id", id);
				req.setAttribute("username", user.getUserName());
				req.setAttribute("firstname", user.getFirstName());
				req.setAttribute("lastname", user.getLastName());
				req.setAttribute("department", user.getDepartment());
				
				pageRedirect = "/pages/user/userUpdate.jsp";
			
			}else if(actionName.equals("UpdateUser")){

				this.session = req.getSession();
				String userName = req.getParameter("username");
				String firstName = req.getParameter("firstname");
				String lastName = req.getParameter("lastname");
				String password = req.getParameter("password");
				String confirmPassword = req.getParameter("confirmpassword");
				String department = req.getParameter("department");
	
				UserController userController = new UserController();
				UserInfo user = new UserInfo();
				user.setId(id);
				user.setUserName(userName);
				user.setPassword(password);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setConfirmPassword(confirmPassword);
				user.setDepartment(department);
				
				user = userController.updateUser(user);
				if(user.isFailedValidation()){
		
					req.setAttribute("id", id);
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
					
					pageRedirect = "/pages/user/userUpdate.jsp";
				}else{
					req.setAttribute("id", id);
					req.setAttribute("username", userName);
					req.setAttribute("firstname", firstName);
					req.setAttribute("lastname", lastName);
					req.setAttribute("password", password);
					req.setAttribute("confirmpassword", confirmPassword);
					req.setAttribute("department", department);
					
					req.setAttribute("success", true);
					pageRedirect = "/UserList";
				}
				resp.setHeader("Location", "/");
			}
			req.getRequestDispatcher(pageRedirect).forward(req, resp);
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}