package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Category;
import org.cloud.product.server.repository.CategoryRepository;
import org.cloud.product.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> listByPid(long pid) {
		List<Category> categorys=categoryRepository.findByPid(pid);
		return categorys;
	}

}
