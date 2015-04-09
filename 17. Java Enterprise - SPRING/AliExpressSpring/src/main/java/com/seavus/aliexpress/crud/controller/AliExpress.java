package com.seavus.aliexpress.crud.controller;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.seavus.aliexpress.crud.model.Product;
import com.seavus.aliexpress.crud.service.AliExpessService;

@EnableAutoConfiguration
public class AliExpress implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AliExpress.class);
		app.setShowBanner(false);
		app.run(args);
	}

	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		AliExpessService aliExpressService = new AliExpessService();
		menu();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			switch (scanner.nextInt()) {
			case 1:

				System.out.println("Insert key,name,quantity and price for the new product");
				scanner = new Scanner(System.in);
				String productParts = scanner.nextLine();
				String[] divideProductParts = productParts.split(" ");
				int id = Integer.parseInt(divideProductParts[0]);
				if (!aliExpressService.checkProduct(id)) {
					Product p = new Product();
					p.setKey(divideProductParts[0]);
					p.setName(divideProductParts[1]);
					p.setQuantity(Integer.parseInt(divideProductParts[2]));
					p.setPrice(Integer.parseInt(divideProductParts[3]));
					aliExpressService.addProduct(p);
				} else
					System.out
							.println("That article already exists in the database. Do you want only to update the quantiy?");
				scanner = new Scanner(System.in);
				switch (scanner.next()) {
				case "YES":
					aliExpressService.updateProductQuantity(
							Integer.parseInt(divideProductParts[2])+aliExpressService.selectQuantity(id),id);
					break;
				default:
					menu();
					break;
				}
				menu();
				break;
			case 2:
				aliExpressService.updateProductQuantity(1000, 15);
				aliExpressService.listAllProducts();
				menu();
				break;
			case 3:
				aliExpressService.listAllProducts();
				menu();
				break;
			case 4:
				aliExpressService.deleteProductById(3);
				aliExpressService.listAllProducts();
				menu();
				break;
			case 5:
				aliExpressService.adminListAllProducts();
				menu();
				break;
			}
		}
	}

	public static void menu() {
		System.out.println("===============================");
		System.out.println("Menu");
		System.out.println("Press 1 for add new product");
		System.out.println("Press 2 to update product");
		System.out.println("Press 3 to list products");
		System.out.println("Press 4 to delete product");
		System.out.println("Press 5 for admin listing");
		System.out.println("===============================");
	}
}
