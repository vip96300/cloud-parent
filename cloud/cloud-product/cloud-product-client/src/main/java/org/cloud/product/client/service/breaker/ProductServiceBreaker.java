package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.Product;
import org.cloud.product.client.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceBreaker implements ProductService{

	@Override
	public List<Product> listByCatid(long catid,int page,int size) {
		throw new RuntimeException();
	}

	@Override
	public Product getByProid(long proid) {
		throw new RuntimeException();
	}

	@Override
	public void add(Product product) {
		throw new RuntimeException();
	}


}
