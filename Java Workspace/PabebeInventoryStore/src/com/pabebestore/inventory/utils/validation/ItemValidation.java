package com.pabebestore.inventory.utils.validation;

import com.pabebestore.inventory.dao.maintenance.items.ItemDAOImpl;
import com.pabebestore.inventory.models.items.ItemInfo;



public class ItemValidation {

	public static boolean negativeTesting;

	public static ItemInfo validateItem(ItemInfo itemInfo){

		negativeTesting = false;

		//item name validation		
		try {
			ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
			
			if(itemInfo.getItemName().length() == 0){
				itemInfo.setItemNameErrorMessage("Item Name is required!");
				negativeTesting = true;
			}else if(itemInfo.getItemName().length() > 45){
				itemInfo.setItemNameErrorMessage("Item name should not exceed to 45 characters!");
				negativeTesting = true;
			}else if(itemDAOImpl.checkItemnameExists(itemInfo)){
				itemInfo.setItemNameErrorMessage("Item name exists!");
				negativeTesting = true;				
			}
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//item description validation
		if(itemInfo.getItemDescription().length() == 0){
			itemInfo.setItemDescriptionErrorMessage("Item Description is required!");
			negativeTesting = true;
		}else if(itemInfo.getItemDescription().length() > 100){
			itemInfo.setItemDescriptionErrorMessage("Item Description should not exceed to 100 characters!");
			negativeTesting = true;
		}
		
		//item price validation		
		if(itemInfo.getRawPrice().length() > 0){
			try{
				double itemprice = Double.parseDouble(itemInfo.getRawPrice());
				if(itemInfo.getItemPrice() == 0){
					itemInfo.setItemPriceErrorMessage("Item Price is required!");
					negativeTesting = true;
				}
				else if(itemInfo.getItemPrice() < 0){
					itemInfo.setItemPriceErrorMessage("Item Price does not accept negative values!");
					negativeTesting = true;
				}
			}catch(Exception e){
				itemInfo.setItemPriceErrorMessage("Please enter numerical values only!");
				negativeTesting = true;			
			}
		}else{
			itemInfo.setItemPriceErrorMessage("Item Price is required!");
			negativeTesting = true;			
		}
		//item quantity validation
		if(itemInfo.getRawQuantity().length() > 0){
			try{
				int itemquantity = Integer.parseInt(itemInfo.getRawQuantity());
				if(itemInfo.getItemQuantity() == 0){
					itemInfo.setItemQuantityErrorMessage("Item Quantity is required!");
					negativeTesting = true;
				}
				else if(itemInfo.getItemQuantity() < 0){
					itemInfo.setItemQuantityErrorMessage("Item Quantity does not accept negative values!");
					negativeTesting = true;
				}
			}catch (Exception e){
				itemInfo.setItemQuantityErrorMessage("Please enter numerical values only!");
				negativeTesting = true;				
			}
		}else{
			itemInfo.setItemQuantityErrorMessage("Item Quantity is required!");
			negativeTesting = true;			
		}
		itemInfo.setFailedValidation(negativeTesting);

		return itemInfo;

	}


	public static void main(String[] args){

		ItemInfo ii = new ItemInfo();
		ii.setId(0);
		ii.setItemName("");
		ii.setItemDescription("2132132");
		ii.setItemPrice(-1);
		ii.setItemQuantity(-1);


		ItemValidation.validateItem(ii);

		System.out.println(ItemValidation.negativeTesting);
		System.out.println("ID: " + ii.getIdErrorMessage());
		System.out.println("Item Name: " + ii.getItemNameErrorMessage());
		System.out.println("Item Description: " + ii.getItemDescriptionErrorMessage());
		System.out.println("Item Price: " + ii.getItemPriceErrorMessage());
		System.out.println("Item Quantity: " + ii.getItemQuantityErrorMessage());

	}
}
