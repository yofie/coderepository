package com.pabebestore.inventory.servlet.maintenance.items;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pabebestore.inventory.controller.maintenance.items.ItemController;


import com.pabebestore.inventory.dao.maintenance.items.*;
import com.pabebestore.inventory.models.items.*;

/**
 * Servlet implementation class ItemListServlet
 */
@WebServlet({"/ItemList",""})
public class ItemListServlet extends HttpServlet {
	private static String LIST_ITEM = "/itemList.jsp";
	private HttpSession session;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ItemDAOImpl itemDAOImpl;
		try {
			itemDAOImpl = new ItemDAOImpl();
			RequestDispatcher view = req.getRequestDispatcher("/index.jsp");
	        req.setAttribute("items", itemDAOImpl.getAllItems(""));
	        view.forward(req, resp);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ItemDAOImpl itemDAOImpl;
		
		try {
			itemDAOImpl = new ItemDAOImpl();
	        request.setAttribute("items", itemDAOImpl.getAllItems(request.getParameter("searchkeyword")));
	        request.setAttribute("searchkeyword", request.getParameter("searchkeyword"));
	        request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
