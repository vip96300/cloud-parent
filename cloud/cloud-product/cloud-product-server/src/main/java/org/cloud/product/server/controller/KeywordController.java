package org.cloud.product.server.controller;

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
		keywordService.add(keyword);
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
