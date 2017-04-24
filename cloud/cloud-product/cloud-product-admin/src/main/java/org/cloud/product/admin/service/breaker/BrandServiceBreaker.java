package org.cloud.product.admin.service.breaker;

import java.util.List;

import org.cloud.product.admin.model.Brand;
import org.cloud.product.admin.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BrandServiceBreaker implements BrandService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Brand> listByCatid(long catid,int page,int size) {
		logger.error("listByCatId error");
		return null;
	}

	@Override
	public void add(Brand brand) {
		logger.error("add error");
	}

	@Override
	public Brand getByBraid(long braid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delByBraid(long braid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updByBraid(Brand brand) {
		// TODO Auto-generated method stub
		
	}

}
