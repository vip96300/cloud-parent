package org.cloud.product.client.service.breaker;

import java.util.List;
import java.util.Map;

import org.cloud.product.client.service.AttGroupService;
import org.springframework.stereotype.Component;

@Component
public class AttGroupServiceBreaker implements AttGroupService{

	@Override
	public List<Map<String, List<Object>>> listAttributesAttValuesByCatId(long catId) {
		// TODO Auto-generated method stub
		return null;
	}


}
