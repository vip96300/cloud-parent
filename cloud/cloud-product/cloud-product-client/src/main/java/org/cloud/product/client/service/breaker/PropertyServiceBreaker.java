package org.cloud.product.client.service.breaker;

import java.util.List;
import java.util.Map;

import org.cloud.product.client.model.AttValue;
import org.cloud.product.client.model.Property;
import org.cloud.product.client.service.PropertyService;
import org.springframework.stereotype.Component;

@Component
public class PropertyServiceBreaker implements PropertyService{

	@Override
	public Map<String, List<AttValue>> listAttValuesByProductid(long productid) {
		throw new RuntimeException();
	}

	@Override
	public Property getByProid(long proid) {
		throw new RuntimeException();
	}

	@Override
	public void updByProid(Property property) {
		throw new RuntimeException();
	}


}
