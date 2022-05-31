package com.example.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
public class Form {

	private Integer productId;
	@NotBlank
    private String productName;
	@NotNull
    private Integer price;
    
    
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

    

}