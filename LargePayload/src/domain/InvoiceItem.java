package domain;

public class InvoiceItem {

	String itemName;
	String description;
	double price;
	
	/**
	 * @param itemName
	 * @param description
	 * @param price
	 */
	public InvoiceItem(String itemName, String description, double price) {
		super();
		this.itemName = itemName;
		this.description = description;
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
