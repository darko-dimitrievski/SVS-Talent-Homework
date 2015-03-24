import java.util.HashMap;

public class Warehouse {
	HashMap<String, Product> products = new HashMap<String, Product>();

	public Warehouse() {

	}
	public void addProduct(String key, Product p) {
		products.put(key, p);
	}
	
	public void listAllProducts() {
		// TODO Auto-generated method stub
		for(Product p : products.values()){
			System.out.println(p);
		}
	}
	
	public void adminlistAllProducts() {
		// TODO Auto-generated method stub
		for(Product p : products.values()){
			System.out.println(p.adminToString());
		}
	}
}
