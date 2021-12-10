package com.codingdojo.products_categories.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.products_categories.models.Category;
import com.codingdojo.products_categories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	
	List<Category> findAllByProduct(Product product);
	
	List<Category> findByProductNotContains(Product product);
	
	
}
