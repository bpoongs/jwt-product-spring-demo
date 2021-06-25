package com.example.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.product.entity.Product;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import com.example.product.service.ProductServiceImpl;

@SpringBootTest
public class ProductServiceTest {
	
	@InjectMocks
	//ProductServiceImpl productService;
	ProductService productService = new ProductServiceImpl();
	
	@Mock
	ProductRepository productRepository;
	

	@Test
	public void testGetAllProducts() {
		List<Product> mockProducts = new ArrayList<>();
		mockProducts.add(new Product());
		mockProducts.add(new Product());
		mockProducts.add(new Product());
		mockProducts.add(new Product());
		
		Mockito.when(productRepository.findAll()).thenReturn(mockProducts);
		
		assertEquals(4, productService.getAllProducts().size());
	}
	
	@Test
	public void testGetAllProductsException(){
		List<Product> mockProducts = new ArrayList<>();
		
		Mockito.when(productRepository.findAll()).thenReturn(mockProducts);
		
		Exception exception = assertThrows(ProductNotFoundException.class, () -> productService.getAllProducts());
		assertEquals("No Products Found!!", exception.getMessage());
	}
	
	@Test
	public void testAddProduct() {
		Product mockReturnProduct = new Product(500, "Television", null, null, null);
		Product mockArgumentProduct = new Product("Television");
		
		Mockito.when(productRepository.save(mockArgumentProduct)).thenReturn(mockReturnProduct);
		
		assertEquals(500, productService.addProducts(mockArgumentProduct).getProductId());
	}
	
	@Test
	public void testGetProduct() {
		Product mockReturnProduct = new Product(500, "Television");
		
		Mockito.when(productRepository.findById(500)).thenReturn(Optional.of(mockReturnProduct));
		
		//assertNotNull(productService.getProducts(500)); //or
		assertEquals(500, productService.getProducts(500).getProductId());
	}
	
	@Test
	public void testGetProductNotFound() {
		
		Mockito.when(productRepository.findById(1234)).thenReturn(Optional.empty());
		
		assertNull(productService.getProducts(1234)); 
	}
	
	@Test
	public void testDeleteProduct() {
       Mockito.doNothing().when(productRepository).deleteById(5);
       productService.deleteProducts(5);
       Mockito.verify(productRepository, Mockito.times(1)).deleteById(5);
	}
	
	@Test
	public void testUpdateProduct() {
		
		Product mockReturnProduct = new Product(500, "Television", null, null, null);
		Product mockArgumentProduct = new Product(500, "TV");
		
		Mockito.when(productRepository.save(mockArgumentProduct)).thenReturn(mockReturnProduct);
		
		productService.updateProducts(mockArgumentProduct);
		//assertEquals(500, productService.updateProducts(mockArgumentProduct).getProductId());
		Mockito.verify(productRepository, Mockito.times(1)).save(mockArgumentProduct);
	}
	
}
