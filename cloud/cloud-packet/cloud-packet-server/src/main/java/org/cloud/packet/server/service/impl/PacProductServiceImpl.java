package org.cloud.packet.server.service.impl;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.packet.server.model.PacProduct;
import org.cloud.packet.server.repository.PacProductRepository;
import org.cloud.packet.server.service.PacProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class PacProductServiceImpl implements PacProductService{
	
	@Autowired
	private PacProductRepository pacProductRepository;
	
	@Override
	public void add(PacProduct pacProduct) {
		PacProduct hasPacProduct=pacProductRepository.findByProductid(pacProduct.getProductid());
		if(ValidUtil.isValid(hasPacProduct)){
			return;
		}
		pacProduct.setTime(System.currentTimeMillis());
		pacProductRepository.save(pacProduct);
	}

	@Override
	public void delByProductid(long productid) {
		PacProduct pacProduct=pacProductRepository.findByProductid(productid);
		if(ValidUtil.isValid(pacProduct)){
			pacProductRepository.delete(pacProduct);
		}
	}

	@Override
	public List<PacProduct> list(int page, int size) {
		List<PacProduct> pacProducts=pacProductRepository.findAll(new PageRequest(page, size)).getContent();
		return pacProducts;
	}

	@Override
	public List<PacProduct> listByCatid(long catid, int page, int size) {
		List<PacProduct> pacProducts=pacProductRepository.findByCatid(catid,new PageRequest(page,size));
		return pacProducts;
	}

}
