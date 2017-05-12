package org.cloud.packet.client.service.breaker;

import org.cloud.packet.client.model.Category;
import org.cloud.packet.client.service.CategoryService;
import org.springframework.stereotype.Component;
@Component
public class CategoryServiceBreaker implements CategoryService{

	@Override
	public Category getByCatid(long catid) {
		throw new RuntimeException();
	}

}
