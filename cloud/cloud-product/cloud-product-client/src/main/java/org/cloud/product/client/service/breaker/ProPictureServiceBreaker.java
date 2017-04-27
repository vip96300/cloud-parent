package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.ProPicture;
import org.cloud.product.client.service.ProPictureService;
import org.springframework.stereotype.Component;

@Component
public class ProPictureServiceBreaker implements ProPictureService{

	@Override
	public List<ProPicture> listByProid(long proid) {
		throw new RuntimeException();
	}

	@Override
	public List<ProPicture> listByProidType(long proid, int type) {
		throw new RuntimeException();
	}

	@Override
	public ProPicture getByPicid(long picid) {
		throw new RuntimeException();
	}

	@Override
	public void add(ProPicture picture) {
		throw new RuntimeException();
	}

	@Override
	public void delByPicid(long picid) {
		throw new RuntimeException();
	}

	@Override
	public void updByPicid(ProPicture picture) {
		throw new RuntimeException();
	}

}
