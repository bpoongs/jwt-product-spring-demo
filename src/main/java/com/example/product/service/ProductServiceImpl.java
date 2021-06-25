package com.example.product.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.product.controller.ProductController;
import com.example.product.entity.Product;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts(){
		logger.info("Entered service getAllProducts()");
		List<Product> allProducts = productRepository.findAll();
		if(allProducts.isEmpty()) {
			throw new ProductNotFoundException("No Products Found!!");
		}
		return allProducts;
	}
	
	public Product addProducts(Product product){
		logger.info("Entered service addProducts()");
		return productRepository.save(product);
	}
	
	public Product updateProducts(Product product){
		logger.info("Entered service updateProducts()");
		return productRepository.save(product);
	}
	
	public List<Product> deleteProducts(int productId){
		logger.info("Entered service deleteProducts()");
		productRepository.deleteById(productId);
		return productRepository.findAll();
	}
	
	public Product getProducts(int productId){
		logger.info("Entered service getProducts()");
		Optional<Product> optional = productRepository.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
