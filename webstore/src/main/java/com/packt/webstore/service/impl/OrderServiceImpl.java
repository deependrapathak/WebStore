package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
@Autowired
private ProductRepository productRepository;
	public void processOrder(String productId, long quantity) {
		// TODO Auto-generated method stub
		Product productById=productRepository.getProductById(productId);
		if(productById.getUnitsInStock()<quantity){
			throw new IllegalArgumentException("out of stock");
			
		}
		productById.setUnitsInStock(productById.getUnitsInStock()-quantity);
				
		
	}

}
