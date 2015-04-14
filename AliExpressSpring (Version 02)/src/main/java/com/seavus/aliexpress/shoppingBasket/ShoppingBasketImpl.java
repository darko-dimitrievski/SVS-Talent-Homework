package com.seavus.aliexpress.shoppingBasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.seavus.aliexpress.model.Product;

public class ShoppingBasketImpl implements ShoppingBasket{
	List<Product> shoppingBasket = new ArrayList<Product>();
	
	public ShoppingBasketImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProductInShoppingBasket(Product p) {
		// TODO Auto-generated method stub
		shoppingBasket.add(p);
	}

	@Override
	public List<Product> showProductFromShoppingBasket() {
		// TODO Auto-generated method stub
		return shoppingBasket;
	}
	
	

}
