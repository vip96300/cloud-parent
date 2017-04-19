package org.cloud.product.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.cloud.product.client.model.Attribute;
import org.cloud.product.client.service.AttributeService;
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

	@ApiOperation(value="添加属性")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "catId", value = "类目编号", required = true, dataType = "long"),
        @ApiImplicitParam(name = "name", value = "属性名称", required = true, dataType = "String"),
        @ApiImplicitParam(name = "isOpt", value = "是否可选", required = true, dataType = "int")
    })
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public void add(@ModelAttribute Attribute attribute){
    	attributeService.add(attribute);
    }
}
