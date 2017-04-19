package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.Category;
import org.cloud.product.client.service.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceBreaker implements CategoryService{

	@Override
	public List<Category> listByPid(long pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
