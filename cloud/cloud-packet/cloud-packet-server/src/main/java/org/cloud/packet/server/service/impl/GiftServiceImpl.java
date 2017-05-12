package org.cloud.packet.server.service.impl;

import java.util.List;

import org.cloud.packet.server.model.Gift;
import org.cloud.packet.server.repository.GiftRepository;
import org.cloud.packet.server.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class GiftServiceImpl implements GiftService{
	
	@Autowired
	private GiftRepository giftRepository;
	
	@Override
	public void add(Gift gift) {
		gift.setTime(System.currentTimeMillis());
		gift.setIsdel(0);
		giftRepository.save(gift);
	}

	@Override
	public List<Gift> list(Pageable pageable) {
		List<Gift> gifts=giftRepository.findByIsdel(pageable,0);
		return gifts;
	}

	@Override
	public void updByGifid(Gift gift) {
		giftRepository.saveAndFlush(gift);
	}

	@Override
	public Gift getByGifid(long gifid) {
		Gift gift=giftRepository.getOne(gifid);
		return gift;
	}

	@Override
	public void delByGifid(long gifid) {
		Gift gift=giftRepository.findOne(gifid);
		if(gift.getIsdel()==1){
			return;
		}
		gift.setIsdel(1);
		giftRepository.saveAndFlush(gift);
	}


}
