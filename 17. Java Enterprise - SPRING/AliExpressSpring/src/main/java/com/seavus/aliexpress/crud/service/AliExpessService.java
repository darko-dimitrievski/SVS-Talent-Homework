package com.seavus.aliexpress.crud.service;

import org.springframework.stereotype.Service;

import com.seavus.aliexpress.crud.dao.ProductDaoImpl;
import com.seavus.aliexpress.crud.model.Product;

@Service
public class AliExpessService {
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();

	public void addProduct(Product p) {
		productDaoImpl.addProduct(p);
	}

	public void listAllProducts() {
		productDaoImpl.listAllProducts();
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

	public boolean checkProduct(int id) {
		return productDaoImpl.checkProduct(id);
	}

	public int selectQuantity(int id) {
		return productDaoImpl.selectQuantity(id);
	}
}
