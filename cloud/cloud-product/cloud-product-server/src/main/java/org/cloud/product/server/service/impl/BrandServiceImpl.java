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
	public List<Brand> listByCatId(long catId,Pageable pageable) {
		logger.debug(this.getClass().getName());
		Page<Brand> brands=brandRepository.findByCatId(catId,pageable);
		return brands.getContent();
	}
	
	@Override
	public void add(Brand brand) {
		logger.debug(this.getClass().getName());
		brandRepository.save(brand);
	}

}
