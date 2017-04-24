package org.cloud.product.admin.service.breaker;

import org.cloud.product.admin.model.AttValue;
import org.cloud.product.admin.service.AttValueService;
import org.springframework.stereotype.Component;

@Component
public class AttValueServiceBreaker implements AttValueService{

	@Override
	public void add(AttValue attValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AttValue getByValid(long valid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delByValid(long valid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updByValid(AttValue attValue) {
		// TODO Auto-generated method stub
		
	}


}
