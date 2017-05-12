package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.Attribute;
import org.cloud.product.client.service.AttributeService;
import org.springframework.stereotype.Component;

@Component
public class AttributeServiceBreaker implements AttributeService{

	@Override
	public void add(Attribute attribute) {
		throw new RuntimeException();
	}

	@Override
	public Attribute getByAttid(long attid) {
		throw new RuntimeException();
	}

	@Override
	public void updByAttid(Attribute attribute) {
		throw new RuntimeException();
	}

	@Override
	public void delByAttid(long attid) {
		throw new RuntimeException();
	}

	@Override
	public List<Attribute> listByGroid(long groid) {
		throw new RuntimeException();
	}

	@Override
	public List<Attribute> listByCatid(long catid) {
		throw new RuntimeException();
	}


}
