package org.cloud.product.admin.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.admin.model.Keyword;
import org.cloud.product.admin.model.Search;
import org.cloud.product.admin.service.KeywordService;
import org.cloud.product.admin.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/search/keyword")
public class KeywordController {
	
	@Autowired
	private KeywordService keywordService;
	@Autowired
	private SearchService searchService;
	
	@ApiOperation(value="添加关键字")
	@ApiImplicitParams({@ApiImplicitParam(name="seaid",value="搜索编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="关键字名称",required=true,dataType="String")})
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public void add(@RequestParam(value="seaid",required=true)long seaid,@RequestParam(value="name",required=true)String name){
		Search search=searchService.getBySeaid(seaid);
		if(!ValidUtil.isValid(search)){
			return;
		}
		Keyword keyword=new Keyword();
		keyword.setSeaid(seaid);
		keyword.setName(name);
		keywordService.add(keyword);
	}
	
	@ApiOperation(value="修改")
	@ApiImplicitParams({@ApiImplicitParam(name="keyid",value="关键字编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="关键字",required=true,dataType="String")})
	@RequestMapping(value="/upd_keyid",method=RequestMethod.GET)
	public void upd_keyid(@RequestParam(value="keyid",required=true)long keyid,@RequestParam(value="name",required=true)String name){
		Keyword keyword=keywordService.getByKeyid(keyid);
		if(!ValidUtil.isValid(keyword)){
			return;
		}
		keyword.setName(name);
		keywordService.updByKeyid(keyword);
	}
	
	@ApiOperation(value="根据编号删除，会删除产品的关联关系")
	@ApiImplicitParams({@ApiImplicitParam(name="keyid",value="编号",required=true,dataType="long")})
	@RequestMapping(value="/del_keyid",method=RequestMethod.GET)
	public void del_keyid(@RequestParam(value="keyid",required=true)long keyid){
		keywordService.delByKeyid(keyid);
	}
}
