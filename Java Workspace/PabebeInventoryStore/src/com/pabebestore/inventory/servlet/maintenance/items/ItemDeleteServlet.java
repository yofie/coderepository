package com.pabebestore.inventory.servlet.maintenance.items;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pabebestore.inventory.controller.access.AccessController;
import com.pabebestore.inventory.controller.maintenance.items.ItemController;

import com.pabebestore.inventory.dao.maintenance.items.ItemDAO;
import com.pabebestore.inventory.dao.maintenance.items.ItemDAOImpl;
import com.pabebestore.inventory.models.items.Item;
import com.pabebestore.inventory.models.items.ItemInfo;
import com.pabebestore.inventory.models.user.UserInfo;

@WebServlet({"/DeleteItem"})
public class ItemDeleteServlet extends HttpServlet{
	
	private HttpSession session;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.session = req.getSession();
		//super.doGet(req, resp);
		req.getRequestDispatcher("/pages/item/itemDelete.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccessController accessController = new AccessController();
		UserInfo userInfo = new UserInfo();
		String pageRedirect = "";
		
		try{
			this.session = req.getSession();
			int id = Integer.parseInt(req.getParameter("id"));
			
			ItemController itemController = new ItemController();
			
			itemController.deleteItem(id);
			req.setAttribute("id", id);
			pageRedirect = "/";
			req.getRequestDispatcher(pageRedirect).forward(req, resp);
		} catch (Exception e){
			
			
		}
		
	}
	
	
}