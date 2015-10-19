package com.pabebestore.inventory.servlet.maintenance.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.pabebestore.inventory.dao.maintenance.users.*;


/**
 * Servlet implementation class ItemListServlet
 */
@WebServlet({"/UserList","/DeleteUser"})
public class UserListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAOImpl userDAOImpl;

		try {
			userDAOImpl = new UserDAOImpl();
			req.setAttribute("users", userDAOImpl.getAllUsers(""));
			req.getRequestDispatcher("/pages/user/userList.jsp").forward(req, resp);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionName = request.getServletPath().replaceAll("/", "").replaceAll("#", "");
		UserDAOImpl userDAOImpl;

		try {

			userDAOImpl = new UserDAOImpl();
			
			if(actionName.equals("DeleteUser")){
				int userId = Integer.parseInt(request.getParameter("id"));
				userDAOImpl.deleteUser(userId);
				request.setAttribute("users", userDAOImpl.getAllUsers(""));
			}else{
				request.setAttribute("users", userDAOImpl.getAllUsers(request.getParameter("searchkeyword")));
				request.setAttribute("searchkeyword", request.getParameter("searchkeyword"));				
			}
						
			request.getRequestDispatcher("/pages/user/userList.jsp").forward(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
