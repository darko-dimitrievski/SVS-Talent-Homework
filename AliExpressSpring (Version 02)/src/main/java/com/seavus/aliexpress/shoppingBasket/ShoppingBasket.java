package com.seavus.aliexpress.shoppingBasket;

import java.util.List;

import com.seavus.aliexpress.model.Product;

public interface ShoppingBasket {
	public void addProductInShoppingBasket(Product p);
	public List<Product> showProductFromShoppingBasket();
}
