package com.seavus.aliexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seavus.aliexpress.model.Account;
import com.seavus.aliexpress.model.Product;
import com.seavus.aliexpress.service.AliExpressAccountService;
import com.seavus.aliexpress.service.AliExpressProductService;
import com.seavus.aliexpress.shoppingBasket.ShoppingBasket;

@Controller
public class AliExpressManagementController {
	AliExpressProductService productService = new AliExpressProductService();
	AliExpressAccountService accountService = new AliExpressAccountService();
//
//	@Autowired
//	public AliExpressManagementController(
//			AliExpressProductService productService,
//			AliExpressAccountService accountService) {
//		this.productService = productService;
//		this.accountService = accountService;
//	}

	@ModelAttribute("product")
	public Product getProduct() {
		return new Product();
	}

	@ModelAttribute("account")
	public Account getAccount() {
		return new Account();
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView lisProducts() {
		ModelAndView mav = new ModelAndView("ProductManagement");
		List<Product> listProducts = productService.listAllProducts();
		mav.addObject("products", listProducts);
		return mav;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String addProduct(Product product, Model model) {
		model.addAttribute("product", getProduct());
		productService.addProduct(product);
		return "redirect:/products";
	}

	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public ModelAndView createAccount() {
		ModelAndView mav = new ModelAndView("AccountManagement");
		return mav;
	}

	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public String addAccount(Account account, Model model) {
		model.addAttribute("account", getAccount());
		accountService.addAccount(account);
		return "redirect:/products";
	}

	@RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
	public String addToBucket(@PathVariable("id") int id, Model model) {
		Product product = productService.findProductById(id);
		productService.putElementInShoppingBasket(product);
		return "redirect:/products";
	}

	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String getShoppingBasket(Model model) {
		int suma = 0;
		for (Product p : productService.showShoppingBasket()) {
			suma += p.getPrice();
		}
		model.addAttribute("shoppingBasket",
				productService.showShoppingBasket());
		model.addAttribute("suma", suma);
		return "ShoppingBasket";
	}
}
