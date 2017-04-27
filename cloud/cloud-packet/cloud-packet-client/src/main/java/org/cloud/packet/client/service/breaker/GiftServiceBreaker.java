package org.cloud.packet.client.service.breaker;

import java.util.List;

import org.cloud.packet.client.model.Gift;
import org.cloud.packet.client.service.GiftService;
import org.springframework.stereotype.Component;
@Component
public class GiftServiceBreaker implements GiftService{

	@Override
	public void add(Gift gift) {
		throw new RuntimeException();
	}

	@Override
	public List<Gift> list(int page, int size) {
		throw new RuntimeException();
	}

	@Override
	public void updByGifid(Gift gift) {
		throw new RuntimeException();
	}

	@Override
	public Gift getByGifid(long gifid) {
		throw new RuntimeException();
	}

	@Override
	public void delByGifid(long gifid) {
		throw new RuntimeException();
	}

}
