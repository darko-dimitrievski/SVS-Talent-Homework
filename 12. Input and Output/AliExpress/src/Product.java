public class Product {
	private String key;
	private String name;
	private int price;
	private int quantity;

	public Product(String key, String name, int price, int quantity) {
		this.key = key;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-10s : %5d",name,price);
	}
	
	public String adminToString() {
		// TODO Auto-generated method stub
		return "The key "+key+", is for the product " +name +" with quantity of "+quantity + " and price of each product is " + price;
	}

}
