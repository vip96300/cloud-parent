package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Attribute;
import org.cloud.product.server.repository.AttributeRepository;
import org.cloud.product.server.service.AttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl implements AttributeService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AttributeRepository attributeRepository;

	@Override
	public void add(Attribute attribute) {
		logger.debug(this.getClass().getName());
		attributeRepository.save(attribute);
	}

}
