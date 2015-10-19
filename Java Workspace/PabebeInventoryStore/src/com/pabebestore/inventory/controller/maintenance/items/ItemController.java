package com.pabebestore.inventory.controller.maintenance.items;

import java.sql.*;


import com.pabebestore.inventory.dao.maintenance.items.ItemDAOImpl;
import com.pabebestore.inventory.models.items.Item;
import com.pabebestore.inventory.models.items.ItemInfo;
import com.pabebestore.inventory.utils.validation.ItemValidation;
import com.pabebestore.inventory.models.items.*;

import java.util.*;
import java.io.*;
public class ItemController{
	 
	public ItemInfo checkItemAccess(String itemName, String itemDescription, double itemPrice, int itemQuantity) throws SQLException{

		ItemInfo itemInfo = new ItemInfo();
		itemInfo.setItemName(itemName);
		itemInfo.setItemDescription(itemDescription);
		itemInfo.setItemPrice(itemPrice);
		itemInfo.setItemQuantity(itemQuantity);

		return itemInfo;
	}

	public ItemInfo insertNewItem(String itemName, String itemDescription, double itemPrice, int itemQuantity, String rawPrice, String rawQuantity){
		ItemInfo itemInfo = new ItemInfo();
		try {

			itemInfo.setItemName(itemName);
			itemInfo.setItemDescription(itemDescription);
			itemInfo.setItemPrice(itemPrice);
			itemInfo.setItemQuantity(itemQuantity);
			itemInfo.setRawPrice(rawPrice);
			itemInfo.setRawQuantity(rawQuantity);

			itemInfo = ItemValidation.validateItem(itemInfo);

			if(!ItemValidation.negativeTesting){
				Item item = new Item();

				item.setItemName(itemName);
				item.setItemDescription(itemDescription);
				item.setItemPrice(itemPrice);
				item.setItemQuantity(itemQuantity);

				ItemDAOImpl itemDAOImpl = new ItemDAOImpl();

				itemDAOImpl.insertNewItem(item);				
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemInfo;

	}

	public ItemInfo updateItem(Integer id,String itemName, String itemDescription, double itemPrice, int itemQuantity, String rawPrice, String rawQuantity){
		ItemInfo itemInfo = new ItemInfo();
		try {
			itemInfo.setId(id);
			itemInfo.setItemName(itemName);
			itemInfo.setItemDescription(itemDescription);
			itemInfo.setItemPrice(itemPrice);
			itemInfo.setItemQuantity(itemQuantity);
			itemInfo.setRawPrice(rawPrice);
			itemInfo.setRawQuantity(rawQuantity);
			
			itemInfo = ItemValidation.validateItem(itemInfo);
			
			if(!ItemValidation.negativeTesting){
				Item item = new Item();
				item.setId(id);
				item.setItemName(itemName);
				item.setItemDescription(itemDescription);
				item.setItemPrice(itemPrice);
				item.setItemQuantity(itemQuantity);
	
				ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
	
				itemDAOImpl.updateItem(item);
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemInfo;

	}

	public boolean deleteItem(int id){

		try {

			ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
			itemDAOImpl.deleteItem(id);

			return true;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
