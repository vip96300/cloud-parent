package org.cloud.product.client.service.breaker;

import org.cloud.product.client.model.Attribute;
import org.cloud.product.client.service.AttributeService;
import org.springframework.stereotype.Component;

@Component
public class AttributeServiceBreaker implements AttributeService{

	@Override
	public void add(Attribute attribute) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Attribute getByAttid(long attid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updByAttid(Attribute attribute) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delByAttid(long attid) {
		// TODO Auto-generated method stub
		
	}


}
