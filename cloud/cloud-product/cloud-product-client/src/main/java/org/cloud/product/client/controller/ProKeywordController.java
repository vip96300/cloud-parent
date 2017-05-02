package org.cloud.product.client.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.ProKeyword;
import org.cloud.product.client.model.Product;
import org.cloud.product.client.service.ProKeywordService;
import org.cloud.product.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/product/keyword")
public class ProKeywordController {
	
	@Autowired
	private ProKeywordService proKeywordService;
	
	@ApiOperation(value="添加产品关键字")
	@ApiImplicitParams({@ApiImplicitParam(name="proid",value="产品编号",required=true,dataType="long"),
		@ApiImplicitParam(name="keywordids",value="关键字编号集合",required=true,dataType="List<long>")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(@RequestParam(value="keywordids",required=true)List<Long> keywordids,@RequestParam(value="proid",required=true)long proid){
		List<ProKeyword> proKeywords=new ArrayList<ProKeyword>();
		for(Long keywordid:keywordids){
			ProKeyword proKeyword=new ProKeyword();
			proKeyword.setProid(proid);
			proKeyword.setKeywordid(keywordid);
			proKeywords.add(proKeyword);
		}
		proKeywordService.add(proKeywords);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="根据编号批量删除")
	@ApiImplicitParams({@ApiImplicitParam(name="keyids",value="产品关联表编号",required=true,dataType="long")})
	@RequestMapping(value="/del_keyids",method=RequestMethod.POST)
	public Result<Object> del_keyids(@RequestParam(value="keyids",required=true)List<Long> keyids){
		if(keyids.isEmpty()){
			return null;
		}
		proKeywordService.delByKeyids(keyids);
		return new Result<Object>(200,null,null);
	}
}
