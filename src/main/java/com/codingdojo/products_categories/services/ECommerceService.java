package com.codingdojo.products_categories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products_categories.models.Category;
import com.codingdojo.products_categories.models.Product;
import com.codingdojo.products_categories.repositories.CategoryRepository;
import com.codingdojo.products_categories.repositories.ProductRepository;

@Service
public class ECommerceService {
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private CategoryRepository catRepo;

	
	//CRUD
	//Create
	public Product createProduct(Product prod) {
		return this.prodRepo.save(prod);
	}
	public Category createCategory(Category cat) {
		return this.catRepo.save(cat);
	}
	
	//Retrieve
	
	public List<Product> findAllProducts(){
		return this.prodRepo.findAll();
	}
	
	public List<Category> findAllCategories(){
		return this.catRepo.findAll();
	}
	
	public Product findProduct(Long id) {
		return this.prodRepo.findById(id).orElse(null);
	}
	public Category findCategory(Long id) {
		return this.catRepo.findById(id).orElse(null);
	}
	
	// Relationships
	
	public void addProdToCat(Product prod, Category cat) {
		List<Category> existingCats = prod.getCategory();
		existingCats.add(cat);
		this.prodRepo.save(prod);
	}
	
	public void addCatToProd(Product prod, Category cat) {
		List<Product> existingProds = cat.getProduct();
		existingProds.add(prod);
		this.catRepo.save(cat);
	}
	
	public List<Category> findCatNotProd(Product prod){
		return this.catRepo.findByProductNotContains(prod);
	}
	
	public List<Product> findProdNotCat(Category cat){
		return this.prodRepo.findByCategoryNotContains(cat);
	}
	
	//Update
	public Product updateProduct(Product prod) {
		return this.prodRepo.save(prod);
	}
	public Category updateCategory(Category cat) {
		return this.catRepo.save(cat);
	}
	
	//Delete
	public void deleteProduct(Long id) {
		this.prodRepo.deleteById(id);
	}
	public void deleteCategory(Long id) {
		this.catRepo.deleteById(id);
	}
	
}
