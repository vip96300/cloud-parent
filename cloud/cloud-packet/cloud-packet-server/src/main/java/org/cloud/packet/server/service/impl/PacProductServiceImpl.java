package org.cloud.packet.server.service.impl;

import org.cloud.packet.server.model.PacProduct;
import org.cloud.packet.server.repository.PacProductRepository;
import org.cloud.packet.server.service.PacProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PacProductServiceImpl implements PacProductService{
	
	@Autowired
	private PacProductRepository pacProductRepository;
	
	@Override
	public void add(PacProduct pacProduct) {
		pacProductRepository.save(pacProduct);
	}

	@Override
	public void delByProductid(long productid) {
		pacProductRepository.deleteByProductid(productid);
	}

}
