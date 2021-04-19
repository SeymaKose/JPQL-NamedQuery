package com.project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Product.findProducts", query = "SELECT p FROM Product p"),
	@NamedQuery(name = "Product.findProductById", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
	@NamedQuery(name = "Product.findProductDetails",
	            query = "SELECT new com.project.model.ProductDetails(p.name, p.unitPrice, p.available, p.brand.name, p.category.name) FROM Product p"),
})

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String name;
	
	private double unitPrice;
	
	public int available;
	
	@ManyToOne
	@JoinColumn(name = "brandId")
	private Brand brand;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	private Category category;
	
	private Date addDate;
	private Date updateDate;
	
	public Product() {
		
	}

	public Product(String name, double unitPrice, int available, Brand brand, Category category, Date addDate) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.available = available;
		this.brand = brand;
		this.category = category;
		this.addDate = addDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", unitPrice=" + unitPrice + ", available="
				+ available + ", brand=" + brand + ", category=" + category + ", addDate=" + addDate + ", updateDate="
				+ updateDate + "]";
	}
	
	
}
