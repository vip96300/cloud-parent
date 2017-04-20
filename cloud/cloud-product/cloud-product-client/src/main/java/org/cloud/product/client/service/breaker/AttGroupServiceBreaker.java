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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(AttGroup attGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AttGroup getByGroid(long groid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delByGroid(long groid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updByGroid(AttGroup attGroup) {
		// TODO Auto-generated method stub
		
	}


}
