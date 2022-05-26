package com.example.demo.entity;

public class Product {
    private Integer productId;
    private String productName;
    private String price;

    public Product() {

    }

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductInfo() {
        return "product_id=" + productId + ", product_name=" + productName + ", price=" + price;
    }

}
