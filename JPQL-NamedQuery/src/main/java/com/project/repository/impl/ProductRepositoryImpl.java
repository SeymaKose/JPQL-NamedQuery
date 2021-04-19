package com.project.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.project.EntityManager.IJPAFactory;
import com.project.EntityManager.impl.JPAFactoryImpl;
import com.project.model.Brand;
import com.project.model.Category;
import com.project.model.Product;
import com.project.model.ProductDetails;
import com.project.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository{

	private IJPAFactory factory = new JPAFactoryImpl();
	private EntityManager entityManager = factory.getEntityManager();
	private EntityTransaction entityTransaction = factory.getTransaction();
	
	public Product saveProduct(Product product) {
		
		this.entityTransaction.begin();
		this.entityManager.persist(product);
		this.entityTransaction.commit();
		
		return product;
	}
	public Brand saveBrand(Brand brand) {
		
		this.entityTransaction.begin();
		this.entityManager.persist(brand);
		this.entityTransaction.commit();
		
		return brand;
	}
	public Category saveCategory(Category category) {
		
		this.entityTransaction.begin();
		this.entityManager.persist(category);
		this.entityTransaction.commit();
		
		return category;
	}
	
	public List<Product> findProducts() {
		
		TypedQuery<Product> typedQuery = this.entityManager.createNamedQuery("Product.findProducts", Product.class);
		List<Product> products = typedQuery.getResultList();
		
		return products;
	}

	public Product findProductById(int productId) {
		
		TypedQuery<Product> typedQuery = this.entityManager.createNamedQuery("Product.findProductById", Product.class);
		typedQuery.setParameter("productId", productId);
		Product product = typedQuery.getSingleResult();
		
		return product;
	}
	public List<ProductDetails> findProductDetails() {
		
		TypedQuery<ProductDetails> typedQuery = this.entityManager.createNamedQuery("Product.findProductDetails", ProductDetails.class);
		List<ProductDetails> productDetails = typedQuery.getResultList();
		
		return productDetails;
	}
	
}