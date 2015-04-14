package com.seavus.aliexpress.controller;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.seavus.aliexpress.crud.daoimpl.ProductDaoImpl;
import com.seavus.aliexpress.menu.MenuImpl;
import com.seavus.aliexpress.service.AliExpressProductService;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Application implements CommandLineRunner {
	static MenuImpl menu;
	Scanner scanner;
	
	@Autowired static AliExpressProductService service = new AliExpressProductService(new ProductDaoImpl());
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
