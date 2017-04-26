package org.cloud.packet.client.service.breaker;

import org.cloud.packet.client.model.PacProduct;
import org.cloud.packet.client.service.PacProductService;
import org.springframework.stereotype.Component;
@Component
public class PacProductServiceBreaker implements PacProductService{

	@Override
	public void add(PacProduct pacProduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delByProductid(long productid) {
		// TODO Auto-generated method stub
		
	}

}
