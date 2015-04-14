package com.seavus.aliexpress.menu;

import java.util.List;

import com.seavus.aliexpress.exceptions.NoSuchProduct;
import com.seavus.aliexpress.exceptions.OutOfProduct;
import com.seavus.aliexpress.model.Product;

public interface Menu {
	public void showMenu();
	public void buySomeProduct() throws OutOfProduct, NoSuchProduct;
	public void insertNewProduct();
	public void updateProduct();
	public void deleteProduct();
	public void listProducts();
	public void adminListProducts();
	public void openShoppingBasket();
}
