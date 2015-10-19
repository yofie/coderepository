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

@WebServlet({"/AddItem"})
public class ItemServlet extends HttpServlet{
	private HttpSession session;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.session = req.getSession();
		req.getRequestDispatcher("/pages/item/itemInput.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageRedirect = "";
		
		try{
			this.session = req.getSession();

			String itemname = req.getParameter("itemname");
			String itemdescription = req.getParameter("itemdescription");
			double itemprice = 0.00;
			int itemquantity = 0;
			try{
				itemprice = Double.parseDouble(req.getParameter("itemprice"));
				
			}catch (Exception e){
				//nothing to do...
			}
			try{
				itemquantity = Integer.parseInt(req.getParameter("itemquantity"));
			}catch (Exception e){
				//nothing to do...
			}				
			
			ItemController itemController = new ItemController();
			
			ItemInfo itemInfo = itemController.insertNewItem(itemname, itemdescription, itemprice, itemquantity, req.getParameter("itemprice"), req.getParameter("itemquantity"));

			if(itemInfo.isFailedValidation()){
				req.setAttribute("itemname", itemname);
				req.setAttribute("itemnameerrmsg", itemInfo.getItemNameErrorMessage());
				req.setAttribute("itemdescription", itemdescription);
				req.setAttribute("itemdescriptionerrmsg", itemInfo.getItemDescriptionErrorMessage());
				req.setAttribute("itemprice", req.getParameter("itemprice"));
				req.setAttribute("itempriceerrmsg", itemInfo.getItemPriceErrorMessage());
				req.setAttribute("itemquantity", req.getParameter("itemquantity"));
				req.setAttribute("itemquantityerrmsg", itemInfo.getItemQuantityErrorMessage());
				
				pageRedirect = "/pages/item/itemInput.jsp";

			}else{
				req.setAttribute("success", true);
				pageRedirect = "/ItemList";

			}
			req.getRequestDispatcher(pageRedirect).forward(req, resp);
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
}