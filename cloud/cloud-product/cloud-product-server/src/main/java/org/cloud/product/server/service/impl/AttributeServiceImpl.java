package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Attribute;
import org.cloud.product.server.repository.AttributeRepository;
import org.cloud.product.server.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl implements AttributeService{
	
	@Autowired
	private AttributeRepository attributeRepository;
	
	@Override
	public List<Attribute> listByCatId(long catId) {
		List<Attribute> attributes=attributeRepository.findByCatId(catId);
		return attributes;
	}

	@Override
	public void add(Attribute attribute) {
		attributeRepository.save(attribute);
	}

}
