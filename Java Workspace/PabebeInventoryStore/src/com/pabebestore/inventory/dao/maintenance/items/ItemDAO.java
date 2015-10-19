package com.pabebestore.inventory.dao.maintenance.items;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pabebestore.inventory.dao.connection.DefaultConnectionDAO;
import com.pabebestore.inventory.models.items.Item;
import com.pabebestore.inventory.models.items.ItemInfo;
import com.pabebestore.inventory.models.user.UserInfo;

public class ItemDAO extends DefaultConnectionDAO{

	public ItemDAO() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		super();
	}
	
	public boolean insertNewItem(Connection connection, Item item){
		String SQL = "INSERT INTO items (itemname,itemdescription,itemprice,itemquantity) values (?,?,?,?)";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, item.getItemName());
			preparedStatement.setString(2, item.getItemDescription());
			preparedStatement.setDouble(3, item.getItemPrice());
			preparedStatement.setInt(4, item.getItemQuantity());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateItem(Connection connection, Item item){
		String SQL = "UPDATE items SET itemname=?, itemdescription=?, itemprice=?, itemquantity=? where id = ?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(SQL);

			preparedStatement.setString(1, item.getItemName());
			preparedStatement.setString(2, item.getItemDescription());
			preparedStatement.setDouble(3, item.getItemPrice());
			preparedStatement.setInt(4, item.getItemQuantity());
			preparedStatement.setInt(5, item.getId());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	public void deleteItem(Connection connection, int itemId){
		String SQL = "DELETE FROM items where id = ?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, itemId);
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Item> getAllItems(Connection connection, String searchKeyword) {
		List<Item> items = new ArrayList<Item>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String SQL ="SELECT * FROM items ";
		if(searchKeyword != null && searchKeyword.length() > 0){
			SQL = SQL + "WHERE itemname LIKE ? or itemdescription LIKE ? ";
		}
		try {
			statement = connection.prepareStatement(SQL);
			if(searchKeyword != null && searchKeyword.length() > 0){
				statement.setString(1, "%"+searchKeyword+"%");
				statement.setString(2, "%"+searchKeyword+"%");
			}
			rs = statement.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt("ID"));
				item.setItemName(rs.getString("itemname"));
				item.setItemDescription(rs.getString("itemdescription"));
				item.setItemPrice(rs.getDouble("itemprice"));
				item.setItemQuantity(rs.getInt("itemquantity"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return items;
	}
	public Item viewItem(Connection connection, int itemId){
		String SQL = "SELECT * FROM items where id = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Item item = new Item();
		try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, itemId);

			rs = preparedStatement.executeQuery();

			if(rs.next()){
				item.setId(itemId);
				item.setItemName(rs.getString("itemname"));
				item.setItemDescription(rs.getString("itemdescription"));
				item.setItemPrice(rs.getDouble("itemprice"));
				item.setItemQuantity(rs.getInt("itemquantity"));
			}

			return item;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public boolean checkItemnameExists(Connection connection, ItemInfo itemInfo) throws Exception{	
		String SQL = "SELECT * FROM items WHERE itemname = ? AND id != ?";
		PreparedStatement preparedStatement = null;

    	try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, itemInfo.getItemName());
			preparedStatement.setInt(2, itemInfo.getId());

			ResultSet rs = preparedStatement.executeQuery();

			return rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return false;
	}
	
}
