package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.product.server.model.Attribute;
import org.cloud.product.server.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/attribute")
public class AttributeController {
	
	@Autowired
	private AttributeService attributeService;
	
    @RequestMapping(value="/list_catId",method=RequestMethod.GET)
    public List<Attribute> list_catId(@RequestParam(value="catId") Long catId){
    	List<Attribute> attributes=attributeService.listByCatId(catId);
    	System.out.println(attributes);
    	return attributes;
    }
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public void add(@ModelAttribute Attribute attribute){
    	attributeService.add(attribute);
    }
}
