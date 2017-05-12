package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.server.model.Keyword;
import org.cloud.product.server.model.Search;
import org.cloud.product.server.service.KeywordService;
import org.cloud.product.server.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/search/keyword")
public class KeywordController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private KeywordService keywordService;
	@Autowired
	private SearchService searchService;
	@Async
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@RequestBody Keyword keyword){
		Search search=searchService.getBySeaid(keyword.getSeaid());
		if(!ValidUtil.isValid(search)){
			return;
		}
		keyword.setCatid(search.getCatid());
		keywordService.add(keyword);
	}
	@RequestMapping(value="/get_keyid",method=RequestMethod.GET)
	public Keyword get_keyid(@RequestParam(value="keyid",required=true)long keyid){
		Keyword keyword=keywordService.getByKeyid(keyid);
		return keyword;
	}
	@RequestMapping(value="/list_seaid",method=RequestMethod.GET)
	public List<Keyword> list_seaid(@RequestParam(value="seaid",required=true)long seaid) {
		List<Keyword> keywords=keywordService.listBySeaid(seaid);
		return keywords;
	}
	@RequestMapping(value="/list_catid",method=RequestMethod.GET)
	public List<Keyword> list_catid(@RequestParam(value="catid",required=true)long catid){
		List<Keyword> keywords=keywordService.listByCatid(catid);
		return keywords;
	}
	@Async
	@RequestMapping(value="/upd_keyid",method=RequestMethod.PUT)
	public void upd_keyid(@RequestBody Keyword keyword){
		keywordService.updByKeyid(keyword);
	}
	@Async
	@RequestMapping(value="/del_keyid",method=RequestMethod.DELETE)
	public void del_keyid(@RequestParam(value="keyid",required=true)long keyid){
		keywordService.delByKeyid(keyid);
	}
}
