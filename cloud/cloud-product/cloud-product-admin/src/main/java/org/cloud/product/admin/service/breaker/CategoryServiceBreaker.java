package org.cloud.product.admin.service.breaker;

import java.util.List;

import org.cloud.product.admin.model.Category;
import org.cloud.product.admin.service.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceBreaker implements CategoryService{

	@Override
	public List<Category> listByPid(long pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getByCatid(long catid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delByCatid(long catid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updByCatid(Category category) {
		// TODO Auto-generated method stub
		
	}


}
