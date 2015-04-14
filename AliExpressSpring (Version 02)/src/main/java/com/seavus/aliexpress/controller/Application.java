package com.seavus.aliexpress.controller;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seavus.aliexpress.menu.MenuImpl;
import com.seavus.aliexpress.service.AliExpressProductService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	static MenuImpl menu;
	Scanner scanner;
	static AliExpressProductService service;
	
	
	public static void main(String[] args) {
		System.out.println("Ali Express Springificated");
		menu = new MenuImpl(service);
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		menu.showMenu();
		scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			switch (scanner.nextInt()) {
			case 1:
				menu.insertNewProduct();
				break;
			case 2:
				menu.updateProduct();
				break;
			case 3:
				menu.listProducts();
				break;
			case 4:
				menu.deleteProduct();
				break;
			case 5:
				menu.adminListProducts();
				break;
			case 6:
				menu.buySomeProduct();
				break;
			case 7:
				menu.openShoppingBasket();
				break;
			}
		}
	}

}
