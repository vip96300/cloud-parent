package org.cloud.packet.server.service.breaker;

import java.util.List;

import org.cloud.packet.server.model.ProductDTO;
import org.cloud.packet.server.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceBreaker implements ProductService{

	@Override
	public ProductDTO getByProid(long proid) {
		throw new RuntimeException();
	}

	@Override
	public List<ProductDTO> listByProids(List<Long> proids) {
		throw new RuntimeException();
	}

}
