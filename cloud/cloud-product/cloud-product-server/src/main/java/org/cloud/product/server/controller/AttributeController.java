package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.server.model.Attribute;
import org.cloud.product.server.service.AttributeService;
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
@RequestMapping(value="/product/category/attribute")
public class AttributeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AttributeService attributeService;
	@Async
    @RequestMapping(value="/add")
    public void add(@RequestBody Attribute attribute){
    	logger.debug(this.getClass().getName());
    	attributeService.add(attribute);
    }
    
    @RequestMapping(value="get_attid",method=RequestMethod.GET)
    public Attribute get_attid(@RequestParam(value="attid",required=true)long attid){
    	Attribute attribute=attributeService.getByAttid(attid);
    	return attribute;
    }
    
    @Async
	@RequestMapping(value="/upd_attid",method={RequestMethod.PUT})
	public void upd_attid(@RequestBody Attribute attribute){
		attributeService.updByAttid(attribute);
	}
    @Async
	@RequestMapping(value="/del_attid",method={RequestMethod.DELETE})
	public void del_attid(@RequestParam(value="attid")long attid){
		attributeService.delByAttid(attid);
	}
}
