package org.cloud.packet.client.service.breaker;

import java.util.List;

import org.cloud.packet.client.controller.model.Gift;
import org.cloud.packet.client.service.GiftService;
import org.springframework.stereotype.Component;
@Component
public class GiftServiceBreaker implements GiftService{

	@Override
	public void add(Gift gift) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Gift> list(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upd_gifid(long gifid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Gift getByGifid(long gifid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delByGifid(long gifid) {
		// TODO Auto-generated method stub
		
	}

}
