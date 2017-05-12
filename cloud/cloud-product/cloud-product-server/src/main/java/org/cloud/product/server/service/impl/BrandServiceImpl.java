package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Brand;
import org.cloud.product.server.repository.BrandRepository;
import org.cloud.product.server.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public List<Brand> listByCatid(long catid,Pageable pageable) {
		Page<Brand> brands=brandRepository.findByCatid(catid,pageable);
		return brands.getContent();
	}
	
	@Override
	public void add(Brand brand) {
		brand.setTime(System.currentTimeMillis());
		brandRepository.save(brand);
	}

	@Override
	public Brand getByBraid(long braid) {
		Brand brand=brandRepository.findByBraid(braid);
		return brand;
	}

	@Override
	public void delByBraid(long braid) {
		brandRepository.delete(braid);
	}

	@Override
	public void updByBraid(Brand brand) {
		brandRepository.saveAndFlush(brand);
	}

}
