package com.seavus.aliexpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seavus.aliexpress.crud.daoimpl.ProductDaoImpl;
import com.seavus.aliexpress.model.Product;
import com.seavus.aliexpress.shoppingBasket.ShoppingBasketImpl;

@Service
public class AliExpressProductService {
	
	private ProductDaoImpl productDaoImpl;
	ShoppingBasketImpl shoppingBasket = new ShoppingBasketImpl();
	
	@Autowired
	public AliExpressProductService(ProductDaoImpl productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}


	public void addProduct(Product p) {
		productDaoImpl.addProduct(p);
	}

	public List<Product> listAllProducts() {
		return productDaoImpl.listAllProducts();
	}

	public void updateProductQuantity(int quantity, int id) {
		productDaoImpl.updateProductQuantity(quantity, id);
	}

	public void deleteProductById(int id) {
		productDaoImpl.deleteProductById(id);
	}

	public void adminListAllProducts() {
		productDaoImpl.adminListAllProducts();
	}

	public boolean checkProductById(int id) {
		return productDaoImpl.checkProductById(id);
	}
	
	public boolean checkProductByName(String name){
		return productDaoImpl.checkProductByName(name);
	}

	public int getQuantityById(int id) {
		return productDaoImpl.getQuantityById(id);
	}
	
	public int getQuantityByName(String name){
		return productDaoImpl.getQuantityByName(name);
	}
	
	public void putElementInShoppingBasket(Product p){
		shoppingBasket.addProductInShoppingBasket(p);
	}
	
	public List<Product> showShoppingBasket(){
		return shoppingBasket.showProductFromShoppingBasket();
	}
	
	public Product findProductById(final int id) {
		return productDaoImpl.findProductById(id);
	}
	
	
}
