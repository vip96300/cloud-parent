package org.cloud.product.server.controller;


import java.util.List;
import java.util.Map;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.server.model.Category;
import org.cloud.product.server.model.Keyword;
import org.cloud.product.server.model.Search;
import org.cloud.product.server.service.CategoryService;
import org.cloud.product.server.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/search")
public class SearchController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SearchService searchService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@RequestBody Search search){
		searchService.add(search);
	}

	@RequestMapping(value="/get_seaid",method=RequestMethod.GET)
	public Search get_seaid(@RequestParam(value="seaid",required=true)long seaid) {
		Search search=searchService.getBySeaid(seaid);
		return search;
	}
	
	@RequestMapping(value="/list_keywords_catid",method=RequestMethod.GET)
	public List<Map<String,List<Keyword>>> list_keywords_catid(@RequestParam(value="catid",required=true)long catid){
		List<Map<String,List<Keyword>>> searchsKeywords=searchService.listKeywordsByCatid(catid);
		return searchsKeywords;
	}

	@RequestMapping(value="/upd_seaid",method=RequestMethod.PUT)
	public void upd_seaid(@RequestBody Search search){
		searchService.updBySeaid(search);
	}

	@RequestMapping(value="/del_seaid",method=RequestMethod.DELETE)
	public void del_seaid(@RequestParam(value="seaid",required=true)long seaid){
		searchService.delBySeaid(seaid);
	}
}
