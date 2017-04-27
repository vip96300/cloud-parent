package org.cloud.packet.client.service.breaker;

import org.cloud.packet.client.model.Product;
import org.cloud.packet.client.service.ProductService;
import org.springframework.stereotype.Component;
@Component
public class ProductServiceBreaker implements ProductService{

	@Override
	public Product getByProid(long proid) {
		throw new RuntimeException();
	}

}
