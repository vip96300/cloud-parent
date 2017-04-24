package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.ProKeyword;
import org.cloud.product.server.repository.ProKeywordRepository;
import org.cloud.product.server.service.ProKeywordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProKeywordServiceImpl implements ProKeywordService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProKeywordRepository proKeywordRepository;
	
	@Override
	public void add(List<ProKeyword> proKeywords) {
		proKeywordRepository.save(proKeywords);
	}

	@Override
	public void delByKeyids(List<Long> keyids) {
		for(Long keyid:keyids){
			proKeywordRepository.delete(keyid);
		}
	}
	
}
