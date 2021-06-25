package com.example.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.Product;
import com.example.product.exception.GlobalExceptionHandler;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		logger.info("Entered getAllProducts()");
		List<Product> allProducts = productService.getAllProducts();
		return allProducts;
	}
	
	@PostMapping("/products")
	public List<Product> addProducts(@Valid @RequestBody Product product){
		logger.info("Entered addProducts()");
		productService.addProducts(product);
		List<Product> allProducts = productService.getAllProducts();
		return allProducts;
	}
	
	@PutMapping("/products")
	public List<Product> updateProducts(@RequestBody Product product){
		logger.info("Entered updateProducts()");
		productService.updateProducts(product);
		List<Product> allProducts = productService.getAllProducts();
		return allProducts;
	}
	
	@DeleteMapping("/products/{prodId}")
	public List<Product> deleteProducts(@PathVariable("prodId") int productId){
		logger.info("Entered deleteProducts()");
		return productService.deleteProducts(productId);
	}
	
	@GetMapping("/products/{prodId}")
	public Product getProducts(@PathVariable("prodId") int productId){
		return productService.getProducts(productId);
	}
	
	
	
}
