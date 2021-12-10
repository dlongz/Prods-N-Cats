package com.codingdojo.products_categories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.products_categories.models.Product;
import com.codingdojo.products_categories.models.Category;
import com.codingdojo.products_categories.services.ECommerceService;

@Controller
public class ProductController {
	
	@Autowired
	private ECommerceService eService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("productForm") Product prod) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("productForm") Product prod, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			this.eService.createProduct(prod);
			return "redirect:/products";
		}
	}
	
	@GetMapping("/products")
	public String Products(Model model) {
		model.addAttribute("prod", this.eService.findAllProducts());
		return "products.jsp";
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product prodShow = this.eService.findProduct(id);
		model.addAttribute("catsLeft", this.eService.findCatNotProd(prodShow));
		model.addAttribute("prod", prodShow);
		return "showProduct.jsp";
	}
	
	@PostMapping("/catToProd/{id}")
	public String addCatToProd(@RequestParam("cats") Long catId, @PathVariable("id") Long prodId){
		Product prodToCat = this.eService.findProduct(prodId);
		Category catToProd = this.eService.findCategory(catId);
		this.eService.addCatToProd(prodToCat, catToProd);
		return "redirect:/products/{id}";
	}
	
}
