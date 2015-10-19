package com.pabebestore.inventory.dao.maintenance.items;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.pabebestore.inventory.models.items.Item;
import com.pabebestore.inventory.models.items.ItemInfo;
import com.pabebestore.inventory.models.user.UserInfo;

public class ItemDAOImpl extends ItemDAO{

	public ItemDAOImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		super();
	}
	
	public boolean insertNewItem(Item item){
		Connection connection = null;
		super.setConnection();
		try{
			connection = super.getConnection();

			super.insertNewItem(connection, item);
			return true;

		} catch(Exception e){
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateItem(Item item){
		Connection connection = null;
		super.setConnection();
		try{
			connection = super.getConnection();

			super.updateItem(connection, item);
			return true;

		} catch(Exception e){
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteItem(int itemId){
		Connection connection = null;
		super.setConnection();
		try{
			connection = super.getConnection();

			super.deleteItem(connection, itemId);
			return true;

		} catch(Exception e){
			e.printStackTrace();
		}

		return false;
	}	

	public List<Item> getAllItems(String keyword) {
		List<Item> items = new ArrayList<Item>();
		Connection connection = null;
		super.setConnection();

		connection = super.getConnection();

		items = super.getAllItems(connection, keyword);

		return items;
	}
	
	public Item viewItem(int itemId){

		Connection connection = null;
		super.setConnection();
		connection = super.getConnection();

		return super.viewItem(connection, itemId);

	}
	
	public boolean checkItemnameExists(ItemInfo itemInfo){
		Connection connection = null;
		super.setConnection();
		
		connection = super.getConnection();
		try {
			return super.checkItemnameExists(connection, itemInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
