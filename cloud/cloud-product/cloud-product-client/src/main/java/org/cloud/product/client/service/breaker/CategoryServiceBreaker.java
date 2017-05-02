package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.Category;
import org.cloud.product.client.service.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceBreaker implements CategoryService{

	@Override
	public List<Category> listByPid(long pid) {
		throw new RuntimeException();
	}

	@Override
	public void add(Category category) {
		throw new RuntimeException();
	}

	@Override
	public Category getByCatid(long catid) {
		throw new RuntimeException();
	}

	@Override
	public void delByCatid(long catid) {
		throw new RuntimeException();
	}

	@Override
	public void updByCatid(Category category) {
		throw new RuntimeException();
	}


}
