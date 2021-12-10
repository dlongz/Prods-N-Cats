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

import com.codingdojo.products_categories.models.Category;
import com.codingdojo.products_categories.models.Product;
import com.codingdojo.products_categories.services.ECommerceService;

@Controller
public class CategoryCaontroller {
	
	@Autowired
	private ECommerceService eService;
	
	@GetMapping("/category/new")
	public String newCategory(@ModelAttribute("categoryForm") Category cat) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/category/new")
	public String createCategory(@Valid @ModelAttribute("categoryForm") Category cat, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			this.eService.createCategory(cat);
		} return "redirect:/categories";
	}
	
	@GetMapping("/categories")
	public String categories(Model model) {
		model.addAttribute("cat", this.eService.findAllCategories());
		return "categories.jsp";
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id,Model model) {
		Category catShow = this.eService.findCategory(id);
		model.addAttribute("prodsLeft", this.eService.findProdNotCat(catShow));
		model.addAttribute("cat", catShow);
		return "showCategory.jsp";
	}
	
	@PostMapping("/prodToCat/{id}")
	public String addProdToCat(@RequestParam("prods") Long prodId, @PathVariable("id") Long catId) {
		Product prodToCat = this.eService.findProduct(prodId);
		Category catToProd = this.eService.findCategory(catId);
		this.eService.addProdToCat(prodToCat, catToProd);
		return "redirect:/categories/{id}";
	}
}	
