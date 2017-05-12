package org.cloud.packet.server.service.impl;

import org.cloud.common.util.ValidUtil;
import org.cloud.packet.server.model.ColPacket;
import org.cloud.packet.server.model.ProductDTO;
import org.cloud.packet.server.repository.ColPacketRepository;
import org.cloud.packet.server.service.ColPacketService;
import org.cloud.packet.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColPacketServiceImpl implements ColPacketService{

	@Autowired
	private ColPacketRepository colPacketRepository;
	@Autowired
	private ProductService productService;
	
	@Override
	public void updByColid(long colid, long catid, long proid) {
		ColPacket colPacket=colPacketRepository.findByColidAndCatid(colid, catid);
		if(!ValidUtil.isValid(colPacket)){
			return;
		}
		if(colPacket.getProid()==proid){
			return;
		}
		if(proid!=0){
			ProductDTO product=productService.getByProid(proid);
			if(!ValidUtil.isValid(product)){
				return;
			}
			if(product.getCatid()!=colPacket.getCatid()){
				return;
			}
		}
		colPacket.setProid(proid);
		colPacketRepository.saveAndFlush(colPacket);
	}

	

}
