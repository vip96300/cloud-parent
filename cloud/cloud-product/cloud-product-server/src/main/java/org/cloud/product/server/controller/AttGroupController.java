package org.cloud.product.server.controller;

import java.util.List;
import java.util.Map;

import org.cloud.product.server.model.AttGroup;
import org.cloud.product.server.service.AttGroupService;
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
@RequestMapping(value="/product/category/attribute/attGroup")
public class AttGroupController {
	
	private final Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AttGroupService attGroupService;
	
	@RequestMapping(value="/list_attributes_attValues_catid",method=RequestMethod.GET)
	public List<Map<String,List<Object>>> list_attributes_attValues_catid(@RequestParam(value="catid",required=true) long catid){
		List<Map<String,List<Object>>> attGroupsAttibutesAttValues=attGroupService.listAttributesAttValuesByCatid(catid);
		logger.debug("list_attributes_attValues_catid");
		return attGroupsAttibutesAttValues;
	}
	@Async
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@RequestBody AttGroup attGroup){
		attGroupService.add(attGroup);
	}
	
	@RequestMapping(value="/get_groid",method=RequestMethod.GET)
	public AttGroup get_groid(@RequestParam(value="groid",required=true)long groid){
		AttGroup attGroup=attGroupService.getByGroid(groid);
		return attGroup;
	}
	@Async
	@RequestMapping(value="/del_groid",method=RequestMethod.DELETE)
	public void del_groid(@RequestParam(value="groid",required=true)long groid){
		attGroupService.delByGroid(groid);
	}
	@Async
	@RequestMapping(value="/upd_groid",method=RequestMethod.PUT)
	public void upd_groid(@RequestBody AttGroup attGroup){
		attGroupService.updByGroid(attGroup);
	}
}
