package org.cloud.product.server.controller;

import java.util.List;
import java.util.Map;

import org.cloud.product.server.model.AttGroup;
import org.cloud.product.server.service.AttGroupService;
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
	
	@RequestMapping(value="list_attributes_attValues_catId",method=RequestMethod.GET)
	public List<Map<AttGroup,List<Object>>> list_attributes_attValues(@RequestParam(value="catId",required=true) long catId){
		List<Map<AttGroup,List<Object>>> attGroupsAttibutesAttValues=attGroupService.listAttributesAttValuesByCatId(catId);
		return attGroupsAttibutesAttValues;
	}
}
