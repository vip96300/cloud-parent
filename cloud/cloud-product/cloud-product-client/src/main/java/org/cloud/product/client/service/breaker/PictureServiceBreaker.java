package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.Picture;
import org.cloud.product.client.service.PictureService;
import org.springframework.stereotype.Component;

@Component
public class PictureServiceBreaker implements PictureService{

	@Override
	public List<Picture> listByProid(long proid) {
		// TODO Auto-generated method stub
		return null;
	}

}
