package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Product;
import org.cloud.product.server.repository.ProductRepository;
import org.cloud.product.server.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> listByCatid(long catid,Pageable pageable) {
		Page<Product> products=productRepository.findByCatid(catid, pageable);
		return products.getContent();
	}
}
