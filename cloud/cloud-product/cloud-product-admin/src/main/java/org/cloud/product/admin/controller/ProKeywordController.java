package org.cloud.product.admin.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.admin.model.ProKeyword;
import org.cloud.product.admin.model.Product;
import org.cloud.product.admin.service.ProKeywordService;
import org.cloud.product.admin.service.ProductService;
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
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="添加产品关键字")
	@ApiImplicitParams({@ApiImplicitParam(name="proid",value="产品编号",required=true,dataType="long"),
		@ApiImplicitParam(name="keywordids",value="关键字编号集合",required=true,dataType="List<long>")})
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public void add(@RequestParam(value="keywordids",required=true)List<Long> keywordids,@RequestParam(value="proid",required=true)long proid){
		Product product=productService.getByProid(proid);
		if(!ValidUtil.isValid(product)){
			return;
		}
		List<ProKeyword> proKeywords=new ArrayList<ProKeyword>();
		for(Long keywordid:keywordids){
			ProKeyword proKeyword=new ProKeyword();
			proKeyword.setProid(proid);
			proKeyword.setKeywordid(keywordid);
			proKeywords.add(proKeyword);
		}
		proKeywordService.add(proKeywords);
	}
	
	@ApiOperation(value="根据编号批量删除")
	@ApiImplicitParams({@ApiImplicitParam(name="keyids",value="产品关联表编号",required=true,dataType="long")})
	@RequestMapping(value="/del_keyids",method=RequestMethod.GET)
	public void del_keyids(@RequestParam(value="keyids",required=true)List<Long> keyids){
		if(keyids.isEmpty()){
			return;
		}
		proKeywordService.delByKeyids(keyids);
	}
}
