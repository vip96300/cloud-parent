package org.cloud.product.client.controller;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.Category;
import org.cloud.product.client.model.Keyword;
import org.cloud.product.client.model.Search;
import org.cloud.product.client.service.CategoryService;
import org.cloud.product.client.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/search")
public class SearchController {
	
	
	@Autowired
	private SearchService searchService;
	@Autowired
	private CategoryService categoryService;
	
	@ApiOperation(value="添加搜索标题")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="名称",required=true,dataType="String")})
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public void add(@RequestParam(value="catid",required=true)Long catid,@RequestParam(value="name",required=true)String name){
		Category category=categoryService.getByCatid(catid);
		if(!ValidUtil.isValid(category)){
			return;
		}
		Search search=new Search();
		search.setCatid(catid);
		search.setName(name);
		searchService.add(search);
	}
	
	@ApiOperation(value="根据类目编号获取搜索标题及以下关键词集合")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long")})
	@RequestMapping(value="/list_keywords_catid",method=RequestMethod.GET)
	public Result<List<Map<Search,List<Keyword>>>> list_keywords_catid(@RequestParam(value="catid",required=true)long catid){
		List<Map<Search,List<Keyword>>> searchsKeywords=searchService.listKeywordsByCatid(catid);
		return new Result<List<Map<Search,List<Keyword>>>>(200,null,searchsKeywords);
	}
	
	@ApiOperation(value="修改搜索标题")
	@ApiImplicitParams({@ApiImplicitParam(name="seaid",value="搜索编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="名称",required=true,dataType="String")})
	@RequestMapping(value="/upd_seaid",method=RequestMethod.GET)
	public void upd_seaid(@RequestParam(value="seaid",required=true)long seaid,@RequestParam(value="name",required=true)String name){
		Search search=searchService.getBySeaid(seaid);
		if(!ValidUtil.isValid(search)){
			return;
		}
		search.setName(name);
		searchService.updBySeaid(search);
	}
	
	@ApiOperation(value="删除搜索标题，会级联删除以下搜索关键字及产品关联")
	@ApiImplicitParams({@ApiImplicitParam(name="seaid",value="编号",required=true,dataType="long")})
	@RequestMapping(value="/del_seaid",method=RequestMethod.GET)
	public void del_seaid(@RequestParam(value="seaid",required=true)long seaid){
		searchService.delBySeaid(seaid);
	}
}
