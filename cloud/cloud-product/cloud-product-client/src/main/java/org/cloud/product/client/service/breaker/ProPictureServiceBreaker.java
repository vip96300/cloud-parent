package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.ProPicture;
import org.cloud.product.client.service.ProPictureService;
import org.springframework.stereotype.Component;

@Component
public class ProPictureServiceBreaker implements ProPictureService{

	@Override
	public List<ProPicture> listByProid(long proid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProPicture> listByProidType(long proid, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProPicture getByPicid(long picid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(ProPicture picture) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delByPicid(long picid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updByPicid(ProPicture picture) {
		// TODO Auto-generated method stub
		
	}

}
