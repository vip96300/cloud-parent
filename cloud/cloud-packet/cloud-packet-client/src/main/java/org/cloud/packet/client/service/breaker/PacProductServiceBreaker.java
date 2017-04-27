package org.cloud.packet.client.service.breaker;

import org.cloud.packet.client.model.PacProduct;
import org.cloud.packet.client.service.PacProductService;
import org.springframework.stereotype.Component;
@Component
public class PacProductServiceBreaker implements PacProductService{

	@Override
	public void add(PacProduct pacProduct) {
		throw new RuntimeException();
	}

	@Override
	public void delByProductid(long productid) {
		throw new RuntimeException();
	}

}
