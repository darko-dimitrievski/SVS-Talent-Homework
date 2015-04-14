package com.seavus.aliexpress.menu;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.seavus.aliexpress.exceptions.NoSuchProduct;
import com.seavus.aliexpress.exceptions.OutOfProduct;
import com.seavus.aliexpress.model.Product;
import com.seavus.aliexpress.service.AliExpressProductService;

public class MenuImpl implements Menu {
	Scanner scanner;
	AliExpressProductService aliExpressService;

	@Autowired
	public MenuImpl(AliExpressProductService aliExpressService) {
		// TODO Auto-generated constructor stub
		this.aliExpressService = aliExpressService;
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("===============================");
		System.out.println("Menu");
		System.out.println("Press 1 for add new product");
		System.out.println("Press 2 to update product");
		System.out.println("Press 3 to list products");
		System.out.println("Press 4 to delete product");
		System.out.println("Press 5 for admin listing");
		System.out.println("Press 6 to buy some product");
		System.out.println("Press 7 to see you shopping basket");
		System.out.println("===============================");
	}

	@Override
	public void buySomeProduct() throws OutOfProduct, NoSuchProduct {
		System.out
				.println("Enter the name and the quantity of the article that you want:");
		scanner = new Scanner(System.in);
		String articleAndQuantity = scanner.nextLine();
		String name = articleAndQuantity.split(" ")[0];
		String quantity = articleAndQuantity.split(" ")[1];
		if (aliExpressService.checkProductByName(name)) {
			if (Integer.parseInt(quantity) < aliExpressService
					.getQuantityByName(name)) {
				Product p = new Product();
				p.setName(name);
				p.setQuantity(Integer.parseInt(quantity));
				aliExpressService.addProduct(p);;
			} else
				throw new OutOfProduct();
		} else
			throw new NoSuchProduct();
		showMenu();
	}

	@Override
	public void insertNewProduct() {
		// TODO Auto-generated method stub
		System.out
				.println("Insert key,name,quantity and price for the new product");
		scanner = new Scanner(System.in);
		String productParts = scanner.nextLine();
		String[] divideProductParts = productParts.split(" ");
		int idOfNewProduct = Integer.parseInt(divideProductParts[0]);
		String nameOfNewProduct = divideProductParts[1];
		if (!aliExpressService.checkProductById(idOfNewProduct)) {
			Product p = new Product();
			p.setKey(divideProductParts[0]);
			p.setName(nameOfNewProduct);
			p.setQuantity(Integer.parseInt(divideProductParts[2]));
			p.setPrice(Integer.parseInt(divideProductParts[3]));
			aliExpressService.addProduct(p);
		} else {
			System.out
					.println("That article already exists in the database. Do you want only to update the quantiy?");
			scanner = new Scanner(System.in);
			if (scanner.next().equals("YES")) {
				int quantity = Integer.parseInt(divideProductParts[2])
						+ aliExpressService.getQuantityById(idOfNewProduct);
				aliExpressService.updateProductQuantity(quantity,
						idOfNewProduct);
			} else {
				showMenu();
			}
		}
		showMenu();
	}

	@Override
	public void updateProduct() {
		// TODO Auto-generated method stub
		System.out
				.println("Insert quantity and the id for the product that you want to update");
		scanner = new Scanner(System.in);
		String parts = scanner.nextLine();
		aliExpressService.updateProductQuantity(
				Integer.parseInt(parts.split(" ")[0]),
				Integer.parseInt(parts.split(" ")[1]));
		aliExpressService.listAllProducts();
		showMenu();
	}

	@Override
	public void deleteProduct() {
		// TODO Auto-generated method stub
		System.out
				.println("Insert the id for the product that you want to delete");
		scanner = new Scanner(System.in);
		aliExpressService.deleteProductById(scanner.nextInt());
		aliExpressService.listAllProducts();
		showMenu();
	}

	@Override
	public void listProducts() {
		// TODO Auto-generated method stub
		for (Product p : aliExpressService.listAllProducts()) {
			System.out.println(p);
		}
		showMenu();
	}

	@Override
	public void adminListProducts() {
		// TODO Auto-generated method stub
		aliExpressService.adminListAllProducts();
		showMenu();
	}

	@Override
	public void openShoppingBasket() {
		// TODO Auto-generated method stub
		aliExpressService.showShoppingBasket();
		showMenu();
	}
}
