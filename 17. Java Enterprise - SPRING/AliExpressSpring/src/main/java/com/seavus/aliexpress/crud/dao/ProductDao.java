package com.seavus.aliexpress.crud.dao;

import com.seavus.aliexpress.crud.model.Product;

public interface ProductDao {
	public void addProduct(Product p);
	public void listAllProducts();
	public void updateProductQuantity(int quantity,int id);
	public void deleteProductById(int id);

}
