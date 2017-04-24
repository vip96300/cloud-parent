package org.cloud.product.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cloud.product.server.model.Keyword;
import org.cloud.product.server.model.Search;
import org.cloud.product.server.repository.KeywordRepository;
import org.cloud.product.server.repository.ProKeywordRepository;
import org.cloud.product.server.repository.SearchRepository;
import org.cloud.product.server.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SearchServiceImpl implements SearchService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SearchRepository searchRepository;
	@Autowired
	private KeywordRepository keywordRepository;
	@Autowired
	private ProKeywordRepository proKeywordRepository;
	
	@Override
	public void add(Search search) {
		searchRepository.save(search);
	}

	@Override
	public List<Map<Search, List<Keyword>>> listKeywordsByCatid(long catid) {
		List<Search> searchs=searchRepository.findByCatid(catid);
		if(searchs.isEmpty()){
			return null;
		}
		List<Keyword> keywords=keywordRepository.findByCatid(catid);
		//集合<搜索：集合<关键字>>
		List<Map<Search,List<Keyword>>> searchsKeywords=new ArrayList<Map<Search,List<Keyword>>>();
		//搜索：集合<关键字>
		Map<Search,List<Keyword>> searchKeywordsMap=new HashMap<Search,List<Keyword>>();
		for(Search search:searchs){
			List<Keyword> keywordsBySearch=new ArrayList<Keyword>();
			for(Keyword keyword:keywords){
				if(keyword.getSeaid()==search.getSeaid()){
					keywordsBySearch.add(keyword);
				}
			}
			searchKeywordsMap.put(search, keywordsBySearch);
			searchsKeywords.add(searchKeywordsMap);
		}
		return searchsKeywords;
	}

	@Override
	public Search getBySeaid(long seaid) {
		Search search=searchRepository.findOne(seaid);
		return search;
	}

	@Override
	public void updBySeaid(Search search) {
		searchRepository.saveAndFlush(search);
	}

	@Override
	public void delBySeaid(long seaid) {
		searchRepository.delete(seaid);
		List<Keyword> keywords=keywordRepository.findBySeaid(seaid);
		for(Keyword keyword:keywords){
			proKeywordRepository.deleteBySeaid(seaid);
			keywordRepository.delete(keyword);
		}
	}
	
}
