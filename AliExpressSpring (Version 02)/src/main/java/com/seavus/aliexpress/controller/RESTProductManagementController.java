package com.seavus.aliexpress.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seavus.aliexpress.crud.daoimpl.ProductDaoImpl;
import com.seavus.aliexpress.model.Product;
import com.seavus.aliexpress.service.AliExpressProductService;

@RestController
@RequestMapping("/rest")
public class RESTProductManagementController {
	@Autowired static AliExpressProductService productService = new AliExpressProductService(new ProductDaoImpl());
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> listProducts() {
		return productService.listAllProducts();
	}
}
