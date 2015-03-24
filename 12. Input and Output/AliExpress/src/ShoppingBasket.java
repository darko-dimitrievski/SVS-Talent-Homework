import java.util.HashMap;
import java.util.Map.Entry;

public class ShoppingBasket {
	HashMap<Integer, Product> shoppingBasket = new HashMap<Integer, Product>();
	
	public ShoppingBasket() {
		// TODO Auto-generated constructor stub
	}
	
	public void addProductInShoppingBasket(Integer quantity, Product product){
		shoppingBasket.put(quantity, product);
	}

}
