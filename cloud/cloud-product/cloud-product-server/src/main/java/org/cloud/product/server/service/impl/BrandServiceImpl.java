package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Brand;
import org.cloud.product.server.repository.BrandRepository;
import org.cloud.product.server.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandRepository brandRepository;
	@Override
	public List<Brand> listByCatId(long catId) {
		List<Brand> brands=brandRepository.findByCatId(catId);
		return brands;
	}
	
	@Override
	public void add(Brand brand) {
		brandRepository.save(brand);
	}

}
