package com.packt.webstore.exception;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3935230281455340039L;
	private String productId;

	public ProductNotFoundException(String profuctId) {
		// TODO Auto-generated constructor stub
		this.productId=profuctId;
	}
	public String getProductId() {
		return productId;
	}
}
