package com.seavus.aliexpress.crud.dao;

import java.util.List;

import com.seavus.aliexpress.model.Product;

public interface ProductDao {
	public void addProduct(Product p);
	public List<Product> listAllProducts();
	public void updateProductQuantity(int quantity,int id);
	public void deleteProductById(int id);

}
