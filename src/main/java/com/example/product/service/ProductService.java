package com.example.product.service;

import java.util.List;

import com.example.product.entity.Product;
import com.example.product.exception.ProductNotFoundException;

public interface ProductService {
	public List<Product> getAllProducts();
	
	public Product addProducts(Product product);
	
	public Product updateProducts(Product product);
	
	public List<Product> deleteProducts(int productId);
	
	public Product getProducts(int productId);
}
