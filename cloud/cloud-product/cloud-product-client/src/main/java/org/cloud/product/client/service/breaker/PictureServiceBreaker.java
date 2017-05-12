package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.Picture;
import org.cloud.product.client.service.PictureService;
import org.springframework.stereotype.Component;

@Component
public class PictureServiceBreaker implements PictureService{

	@Override
	public List<Picture> listByProid(long proid) {
		throw new RuntimeException();
	}

	@Override
	public List<Picture> listByProidType(long proid, int type) {
		throw new RuntimeException();
	}

	@Override
	public Picture getByPicid(long picid) {
		throw new RuntimeException();
	}

	@Override
	public void add(Picture picture) {
		throw new RuntimeException();
	}

	@Override
	public void delByPicid(long picid) {
		throw new RuntimeException();
	}

	@Override
	public void updByPicid(Picture picture) {
		throw new RuntimeException();
	}

}
