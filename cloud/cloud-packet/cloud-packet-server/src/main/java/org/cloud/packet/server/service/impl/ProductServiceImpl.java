package org.cloud.packet.server.service.impl;

import org.cloud.packet.server.model.Product;
import org.cloud.packet.server.repository.ProductRepository;
import org.cloud.packet.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getByProid(long proid) {
		Product product=productRepository.findOne(proid);
		return product;
	}
	


}
