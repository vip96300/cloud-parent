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
	public List<Brand> listByCatId(long catId,int page,int size) {
		logger.error("listByCatId error");
		return null;
	}

	@Override
	public void add(Brand brand) {
		logger.error("add error");
	}

}
