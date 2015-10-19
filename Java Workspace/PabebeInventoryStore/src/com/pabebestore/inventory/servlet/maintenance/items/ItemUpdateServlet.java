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

@WebServlet({"/UpdateItem","/ViewItem"})
public class ItemUpdateServlet extends HttpServlet{
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageRedirect = "";
		int id = Integer.parseInt(req.getParameter("id"));

		ItemDAOImpl itemDAOImpl;
		try {
			itemDAOImpl = new ItemDAOImpl();
			Item item = new Item();

			item = itemDAOImpl.viewItem(id);

			req.setAttribute("id", id);
			req.setAttribute("itemname", item.getItemName());
			req.setAttribute("itemdescription", item.getItemDescription());
			req.setAttribute("itemprice", item.getItemPrice());
			req.setAttribute("itemquantity", item.getItemQuantity());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//super.doGet(req, resp);

		pageRedirect = "/pages/item/itemUpdate.jsp";
		resp.setHeader("Location", "/");
		req.getRequestDispatcher(pageRedirect).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getServletPath().replaceAll("/", "").replaceAll("#", "");
		AccessController accessController = new AccessController();
		UserInfo userInfo = new UserInfo();
		String pageRedirect = "";
		try{
			
			if(actionName.equals("ViewItem")){
				int id = Integer.parseInt(req.getParameter("id"));
				ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
				Item item = new Item();

				item = itemDAOImpl.viewItem(id);

				req.setAttribute("id", id);
				req.setAttribute("itemname", item.getItemName());
				req.setAttribute("itemdescription", item.getItemDescription());
				req.setAttribute("itemprice", item.getItemPrice());
				req.setAttribute("itemquantity", item.getItemQuantity());
				
				pageRedirect = "/pages/item/itemUpdate.jsp";
				
			}else if(actionName.equals("UpdateItem")){

				this.session = req.getSession();
				int id = Integer.parseInt(req.getParameter("id"));
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
	
				ItemInfo itemInfo = itemController.updateItem(id,itemname, itemdescription, itemprice, itemquantity, req.getParameter("itemprice"), req.getParameter("itemquantity"));
				
				if(itemInfo.isFailedValidation()){
					req.setAttribute("id", id);
					req.setAttribute("itemname", itemname);
					req.setAttribute("itemnameerrmsg", itemInfo.getItemNameErrorMessage());
					req.setAttribute("itemdescription", itemdescription);
					req.setAttribute("itemdescriptionerrmsg", itemInfo.getItemDescriptionErrorMessage());
					req.setAttribute("itemprice", req.getParameter("itemprice"));
					req.setAttribute("itempriceerrmsg", itemInfo.getItemPriceErrorMessage());
					req.setAttribute("itemquantity", req.getParameter("itemquantity"));
					req.setAttribute("itemquantityerrmsg", itemInfo.getItemQuantityErrorMessage());
					
					pageRedirect = "/pages/item/itemUpdate.jsp";

				}else{

					req.setAttribute("id", id);
					req.setAttribute("itemname", itemname);
					req.setAttribute("itemdescription", itemdescription);
					req.setAttribute("itemprice", itemprice);
					req.setAttribute("itemquantity", itemquantity);
					
					req.setAttribute("success", true);
					pageRedirect = "/ItemList";

				}

				resp.setHeader("Location", "/");
			}
			req.getRequestDispatcher(pageRedirect).forward(req, resp);
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}