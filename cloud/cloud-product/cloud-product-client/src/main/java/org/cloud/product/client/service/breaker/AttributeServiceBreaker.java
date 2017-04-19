package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.Attribute;
import org.cloud.product.client.service.AttributeService;
import org.springframework.stereotype.Component;

@Component
public class AttributeServiceBreaker implements AttributeService{

	@Override
	public List<Attribute> listByCatId(long catId) {
		System.out.println("server error!");
		return null;
	}

	@Override
	public void add(Attribute attribute) {
		// TODO Auto-generated method stub
		
	}


}
