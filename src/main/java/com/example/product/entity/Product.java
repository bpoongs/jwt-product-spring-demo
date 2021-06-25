package com.example.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="products")
public class Product {
	
	//@NotNull validates that the annotated property value is not null.
	//@AssertTrue validates that the annotated property value is true.
	//@Size validates that the annotated property value has a size between the attributes min and max; can be applied to String, Collection, Map, and array properties.
	//@Min validates that the annotated property has a value no smaller than the value attribute.
	//@Max validates that the annotated property has a value no larger than the value attribute.
	//@Email validates that the annotated property is a valid email address.

	@Id
	@GeneratedValue
	@Column(name="prod_id")
	int productId;
	
	@Column(name="prod_name")
	@NotNull(message = "Name cannot be null")
	String productName;

	@Column(name="prod_cost")
	@NotNull(message = "Cost cannot be null")
	String productCost;

	@Column(name="prod_desc")
	@NotNull(message = "Description cannot be null")
	String productDescription;

	@Column(name="prod_image_url")
	@NotNull(message = "Image url cannot be null")
	String productImageUrl;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, @NotNull(message = "Name cannot be null") String productName,
			@NotNull(message = "Cost cannot be null") String productCost,
			@NotNull(message = "Description cannot be null") String productDescription,
			@NotNull(message = "Image url cannot be null") String productImageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.productDescription = productDescription;
		this.productImageUrl = productImageUrl;
	}

	public Product(String string) {
		// TODO Auto-generated constructor stub
	}

	public Product(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCost() {
		return productCost;
	}

	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productDescription=" + productDescription + ", productImageUrl=" + productImageUrl + "]";
	}
	
	
}
