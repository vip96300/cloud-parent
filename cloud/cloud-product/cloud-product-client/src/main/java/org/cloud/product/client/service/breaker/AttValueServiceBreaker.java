package org.cloud.product.client.service.breaker;

import org.cloud.product.client.model.AttValue;
import org.cloud.product.client.service.AttValueService;
import org.springframework.stereotype.Component;

@Component
public class AttValueServiceBreaker implements AttValueService{

	@Override
	public void add(AttValue attValue) {
		throw new RuntimeException();
	}

	@Override
	public AttValue getByValid(long valid) {
		throw new RuntimeException();
	}

	@Override
	public void delByValid(long valid) {
		throw new RuntimeException();
	}

	@Override
	public void updByValid(AttValue attValue) {
		throw new RuntimeException();
	}


}
