package org.cloud.product.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

import org.cloud.product.client.service.AttGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/attribute/attGroup")
public class AttGroupController {
	
	@Autowired
	private AttGroupService attGroupService;
	
	@ApiOperation(value="根据类目编号获取属性组及属性组以下的属性列表及属性值列表")
	@ApiImplicitParams({@ApiImplicitParam(name="类目编号",value="catId",required=true)})
	@RequestMapping(value="list_attributes_attValues_catId",method=RequestMethod.GET)
	public List<Map<String,List<Object>>> list_attributes_attValues(@RequestParam(value="catId",required=true) long catId){
		List<Map<String,List<Object>>> attGroupsAttibutesAttValues=attGroupService.listAttributesAttValuesByCatId(catId);
		return attGroupsAttibutesAttValues;
	}
}
