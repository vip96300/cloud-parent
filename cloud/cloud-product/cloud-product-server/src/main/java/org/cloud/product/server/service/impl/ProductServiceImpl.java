package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Attribute;
import org.cloud.product.server.model.Product;
import org.cloud.product.server.model.Property;
import org.cloud.product.server.repository.AttributeRepository;
import org.cloud.product.server.repository.ProductRepository;
import org.cloud.product.server.repository.PropertyRepository;
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
	@Autowired
	private AttributeRepository attributeRepository;
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Override
	public List<Product> listByCatid(long catid,Pageable pageable) {
		Page<Product> products=productRepository.findByCatidAndIsdel(catid,0, pageable);
		return products.getContent();
	}

	@Override
	public Product getByProid(long proid) {
		Product product=productRepository.findOne(proid);
		return product;
	}

	@Override
	public List<Product> listByProids(List<Long> proids) {
		List<Product> products=productRepository.findByProids(proids,0);
		return products;
	}

	@Override
	public void add(Product product) {
		product.setIsdel(0);
		product.setTime(System.currentTimeMillis());
		productRepository.save(product);
		List<Attribute> attributes=attributeRepository.findByCatid(product.getCatid());
		Property property=null;
		for(Attribute attribute:attributes){
			property=new Property();
			property.setAttid(attribute.getAttid());
			property.setProductid(product.getProid());
			property.setGroid(attribute.getGroid());
			property.setAttribute(attribute.getName());
			property.setType(attribute.getType());
			property.setValue("");
			property.setTime(System.currentTimeMillis());
			propertyRepository.save(property);
		}
	}

	@Override
	public void updByProid(Product product) {
		productRepository.saveAndFlush(product);
	}

	@Override
	public void delByProid(long proid) {
		Product product=productRepository.findOne(proid);
		if(product.getIsdel()==1){
			return;
		}
		product.setIsdel(1);
		productRepository.saveAndFlush(product);
	}
}
