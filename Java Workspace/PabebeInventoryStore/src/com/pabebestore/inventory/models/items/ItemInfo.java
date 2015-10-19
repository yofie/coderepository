package com.pabebestore.inventory.models.items;

public class ItemInfo extends Item {
	
	private String idErrorMessage;
	private String itemNameErrorMessage;
	private String itemDescriptionErrorMessage;
	private String itemPriceErrorMessage;
	private String itemQuantityErrorMessage;
	private String rawPrice;
	private String rawQuantity;
	private boolean failedValidation;

	
	public String getIdErrorMessage() {
		return idErrorMessage;
	}
	public void setIdErrorMessage(String
			idErrorMessage) {
		this.idErrorMessage = idErrorMessage;
	}
	public String getItemNameErrorMessage() {
		return itemNameErrorMessage;
	}
	public void setItemNameErrorMessage(String itemNameErrorMessage) {
		this.itemNameErrorMessage = itemNameErrorMessage;
	}
	public String getItemDescriptionErrorMessage() {
		return itemDescriptionErrorMessage;
	}
	public void setItemDescriptionErrorMessage(String itemDescriptionErrorMessage) {
		this.itemDescriptionErrorMessage = itemDescriptionErrorMessage;
	}
	public String getItemPriceErrorMessage() {
		return itemPriceErrorMessage;
	}
	public void setItemPriceErrorMessage(String itemPriceErrorMessage) {
		this.itemPriceErrorMessage = itemPriceErrorMessage;
	}
	public String getItemQuantityErrorMessage() {
		return itemQuantityErrorMessage;
	}
	public void setItemQuantityErrorMessage(String itemQuantityErrorMessage) {
		this.itemQuantityErrorMessage = itemQuantityErrorMessage;
	}
	
	
	public boolean isFailedValidation() {
		return failedValidation;
	}
	public void setFailedValidation(boolean failedValidation) {
		this.failedValidation = failedValidation;
	}
	public String getRawPrice() {
		return rawPrice;
	}
	public void setRawPrice(String rawPrice) {
		this.rawPrice = rawPrice;
	}
	public String getRawQuantity() {
		return rawQuantity;
	}
	public void setRawQuantity(String rawQuantity) {
		this.rawQuantity = rawQuantity;
	}

}
