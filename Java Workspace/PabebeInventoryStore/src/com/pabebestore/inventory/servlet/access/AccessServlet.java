package com.pabebestore.inventory.servlet.access;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pabebestore.inventory.controller.access.AccessController;
import com.pabebestore.inventory.dao.maintenance.items.ItemDAOImpl;
import com.pabebestore.inventory.models.user.UserInfo;


@WebServlet({"/ValidateLogin", "/Login", "/LogOut"})
public class AccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getServletPath().replaceAll("/", "");
		this.session = request.getSession();
		this.session.setAttribute("user", null);
		
		request.setAttribute("errorMessage", "");
		if(actionName.equals("Login")){
			request.getRequestDispatcher("/pages/access/login.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String pageRedirect = "";
		
		AccessController accessController = new AccessController();
		UserInfo userInfo;
		try {
			userInfo = accessController.checkUserAccess(username, password);
			boolean isFailedLogin = userInfo.isFailedValidation();

			request.setAttribute("username", username);
			request.setAttribute("usernameerrmsg", userInfo.getUserNameErrorMessage());
			request.setAttribute("password", password);
			request.setAttribute("passworderrmsg", userInfo.getPasswordErrorMessage());
			
			if (isFailedLogin) {
				pageRedirect = "/pages/access/login.jsp";
			} else {
				this.session.setAttribute("user", userInfo);
				pageRedirect = "/index.jsp";
				response.setHeader("Location", "/");
			}
			
			ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
			request.setAttribute("items", itemDAOImpl.getAllItems(""));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher(pageRedirect).forward(request, response);
	}
}
