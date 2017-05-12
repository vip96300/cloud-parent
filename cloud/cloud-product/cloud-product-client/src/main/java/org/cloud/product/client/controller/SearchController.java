package org.cloud.product.client.controller;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.Keyword;
import org.cloud.product.client.model.Search;
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
	
	@ApiOperation(value="添加搜索标题")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="名称",required=true,dataType="String")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(@RequestParam(value="catid",required=true)Long catid,@RequestParam(value="name",required=true)String name){
		Search search=new Search();
		search.setCatid(catid);
		search.setName(name);
		searchService.add(search);
		return new Result<Object>(200,null,null);
	}
	@ApiOperation(value="根据类目编号获取搜索集合")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long")})
	@RequestMapping(value="/list_catid",method=RequestMethod.POST)
	public Result<List<Search>> list_catid(@RequestParam(value="catid",required=true)long catid){
		List<Search> searchs=searchService.listByCatid(catid);
		return new Result<List<Search>>(200,null,searchs);
	}
	@ApiOperation(value="根据类目编号获取搜索标题及以下关键词集合")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long")})
	@RequestMapping(value="/list_keywords_catid",method=RequestMethod.POST)
	public Result<Map<Search,List<Keyword>>> list_keywords_catid(@RequestParam(value="catid",required=true)long catid){
		Map<String,List<Keyword>> searchsKeywords=searchService.listKeywordsByCatid(catid);
		return new Result<Map<Search,List<Keyword>>>(200,null,searchsKeywords);
	}
	
	@ApiOperation(value="修改搜索标题")
	@ApiImplicitParams({@ApiImplicitParam(name="seaid",value="搜索编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="名称",required=true,dataType="String")})
	@RequestMapping(value="/upd_seaid",method=RequestMethod.POST)
	public Result<Object> upd_seaid(@RequestParam(value="seaid",required=true)long seaid,@RequestParam(value="name",required=true)String name){
		Search search=searchService.getBySeaid(seaid);
		if(!ValidUtil.isValid(search)){
			return null;
		}
		search.setName(name);
		searchService.updBySeaid(search);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="删除搜索标题，会级联删除以下搜索关键字及产品关联")
	@ApiImplicitParams({@ApiImplicitParam(name="seaid",value="编号",required=true,dataType="long")})
	@RequestMapping(value="/del_seaid",method=RequestMethod.POST)
	public Result<Object> del_seaid(@RequestParam(value="seaid",required=true)long seaid){
		searchService.delBySeaid(seaid);
		return new Result<Object>(200,null,null);
	}
}
