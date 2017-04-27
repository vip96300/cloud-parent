package org.cloud.product.client.service.breaker;

import java.util.List;
import java.util.Map;

import org.cloud.product.client.model.AttGroup;
import org.cloud.product.client.service.AttGroupService;
import org.springframework.stereotype.Component;

@Component
public class AttGroupServiceBreaker implements AttGroupService{

	@Override
	public List<Map<String, List<Object>>> listAttributesAttValuesByCatid(long catId) {
		throw new RuntimeException();
	}

	@Override
	public void add(AttGroup attGroup) {
		throw new RuntimeException();
	}

	@Override
	public AttGroup getByGroid(long groid) {
		throw new RuntimeException();
	}

	@Override
	public void delByGroid(long groid) {
		throw new RuntimeException();
	}

	@Override
	public void updByGroid(AttGroup attGroup) {
		throw new RuntimeException();
	}


}
