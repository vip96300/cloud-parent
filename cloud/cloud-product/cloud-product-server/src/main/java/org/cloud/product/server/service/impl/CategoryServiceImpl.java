package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Category;
import org.cloud.product.server.repository.CategoryRepository;
import org.cloud.product.server.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> listByPid(long pid) {
		List<Category> categorys=categoryRepository.findByPid(pid);
		return categorys;
	}

	@Override
	public void add(Category category) {
		category.setTime(System.currentTimeMillis());
		categoryRepository.save(category);
	}

	@Override
	public Category getByCatid(long catid) {
		Category category=categoryRepository.findOne(catid);
		return category;
	}

	@Override
	public void delByCatid(long catid) {
		categoryRepository.delete(catid);
	}

	@Override
	public void updByCatid(Category category) {
		categoryRepository.saveAndFlush(category);
	}



}
