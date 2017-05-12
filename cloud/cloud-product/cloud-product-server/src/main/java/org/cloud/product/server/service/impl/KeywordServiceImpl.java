package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Keyword;
import org.cloud.product.server.repository.KeywordRepository;
import org.cloud.product.server.service.KeywordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class KeywordServiceImpl implements KeywordService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private KeywordRepository keywordRepository;
	
	@Override
	public void add(Keyword keyword) {
		keyword.setTime(System.currentTimeMillis());
		keywordRepository.save(keyword);
	}

	@Override
	public Keyword getByKeyid(long keyid) {
		Keyword keyword=keywordRepository.findOne(keyid);
		return keyword;
	}

	@Override
	public void updByKeyid(Keyword keyword) {
		keywordRepository.saveAndFlush(keyword);
	}

	@Override
	public void delByKeyid(long keyid) {
		keywordRepository.delete(keyid);
	}

	@Override
	public List<Keyword> listBySeaid(long seaid) {
		List<Keyword> keywords=keywordRepository.findBySeaid(seaid);
		return keywords;
	}

	@Override
	public List<Keyword> listByCatid(long catid) {
		List<Keyword> keywords=keywordRepository.findByCatid(catid);
		return keywords;
	}
	
}
