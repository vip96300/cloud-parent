package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.Brand;
import org.cloud.product.client.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BrandServiceBreaker implements BrandService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Brand> listByCatid(long catid,int page,int size) {
		throw new RuntimeException();
	}

	@Override
	public void add(Brand brand) {
		throw new RuntimeException();
	}

	@Override
	public Brand getByBraid(long braid) {
		throw new RuntimeException();
	}

	@Override
	public void delByBraid(long braid) {
		throw new RuntimeException();
	}

	@Override
	public void updByBraid(Brand brand) {
		throw new RuntimeException();
	}

}
