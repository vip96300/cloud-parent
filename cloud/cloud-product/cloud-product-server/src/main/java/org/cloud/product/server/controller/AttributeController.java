package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.product.server.model.Attribute;
import org.cloud.product.server.service.AttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/attribute")
public class AttributeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AttributeService attributeService;

    @RequestMapping(value="/add")
    public void add(@ModelAttribute Attribute attribute){
    	logger.debug(this.getClass().getName());
    	attributeService.add(attribute);
    }
}
