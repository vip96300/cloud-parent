package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.AttValue;
import org.cloud.product.server.repository.AttValueRepository;
import org.cloud.product.server.service.AttValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttValueServiceImpl implements AttValueService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AttValueRepository attValueRepository;
	
	@Override
	public void add(AttValue attValue) {
		attValue.setTime(System.currentTimeMillis());
		attValueRepository.save(attValue);
	}

	@Override
	public AttValue getByValid(long valid) {
		AttValue attValue=attValueRepository.findOne(valid);
		return attValue;
	}

	@Override
	public void delByValid(long valid) {
		attValueRepository.delete(valid);
	}

	@Override
	public void updByValid(AttValue attValue) {
		attValueRepository.saveAndFlush(attValue);
	}

	@Override
	public List<AttValue> listByAttid(long attid) {
		List<AttValue> attValues=attValueRepository.findByAttid(attid);
		return attValues;
	}
}
