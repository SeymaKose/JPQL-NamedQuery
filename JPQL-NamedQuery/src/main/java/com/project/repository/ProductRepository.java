package com.project.repository;

import java.util.List;

import com.project.model.Brand;
import com.project.model.Category;
import com.project.model.Product;
import com.project.model.ProductDetails;

public interface ProductRepository {

	Product saveProduct(Product product);
	
	Brand saveBrand(Brand brand);
	
	Category saveCategory(Category category);
	
	List<Product> findProducts();
	
	Product findProductById(int productId);
	
	List<ProductDetails> findProductDetails();
	
}


