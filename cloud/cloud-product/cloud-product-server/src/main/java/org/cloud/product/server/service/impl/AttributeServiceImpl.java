package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Attribute;
import org.cloud.product.server.repository.AttValueRepository;
import org.cloud.product.server.repository.AttributeRepository;
import org.cloud.product.server.repository.PropertyRepository;
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
	@Autowired
	private AttValueRepository attValueRepository;
	@Autowired
	private PropertyRepository propertyRepository;

	@Override
	public void add(Attribute attribute) {
		logger.debug(this.getClass().getName());
		attribute.setTime(System.currentTimeMillis());
		attributeRepository.save(attribute);
	}

	@Override
	public Attribute getByAttid(long attid) {
		Attribute attribute=attributeRepository.findOne(attid);
		return attribute;
	}

	@Override
	public void updByAttid(Attribute attribute) {
		attributeRepository.saveAndFlush(attribute);
	}

	@Override
	public void delByAttid(long attid) {
		attributeRepository.delete(attid);
		attValueRepository.deleteByAttid(attid);
		propertyRepository.deleteByAttid(attid);
	}

	@Override
	public List<Attribute> listByGroid(long groid) {
		List<Attribute> attributes=attributeRepository.findByGroid(groid);
		return attributes;
	}

	@Override
	public List<Attribute> listByCatid(long catid) {
		List<Attribute> attributes=attributeRepository.findByCatid(catid);
		return attributes;
	}

}
