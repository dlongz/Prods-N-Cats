package com.codingdojo.products_categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.products_categories.models.Category;
import com.codingdojo.products_categories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();

	void save(Category cat);
	
	List<Product> findAllByCategory(Category category);
	
	List<Product> findByCategoryNotContains(Category category);
}
