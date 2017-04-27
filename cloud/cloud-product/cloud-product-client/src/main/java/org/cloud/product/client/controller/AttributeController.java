package org.cloud.product.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.model.AttGroup;
import org.cloud.product.client.model.Attribute;
import org.cloud.product.client.service.AttGroupService;
import org.cloud.product.client.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
	@Autowired
	private AttGroupService attGroupService;

	@ApiOperation(value="添加属性")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "groid", value = "属性组编号", required = true, dataType = "long"),
        @ApiImplicitParam(name = "name", value = "属性名称", required = true, dataType = "String"),
        @ApiImplicitParam(name = "type", value = "属性类型，0输入，1单选，2多选", required = true, dataType = "int")
    })
    @RequestMapping(value="/add",method={RequestMethod.GET})
    public void add(@RequestParam(value="groid",required=true)long groid,@RequestParam(value="name",required=true)String name,@RequestParam(value="type",required=true)int type){
		AttGroup attGroup=attGroupService.getByGroid(groid);
		if(!ValidUtil.isValid(attGroup)){
			return;
		}
		Attribute attribute=new Attribute();
		attribute.setGroid(groid);
		attribute.setCatid(attGroup.getCatid());
		attribute.setName(name);
		attribute.setType(type);
    	attributeService.add(attribute);
    }
	
	@ApiOperation(value="修改属性名称")
	@ApiImplicitParams({@ApiImplicitParam(name="attid",value="属性编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="属性名称",required=true,dataType="String")})
	@RequestMapping(value="/upd_attid",method={RequestMethod.GET})
	public void upd_attid(@RequestParam(value="attid",required=true)long attid,@RequestParam(value="name",required=true)String name){
		Attribute attribute=attributeService.getByAttid(attid);
		if(!ValidUtil.isValid(attribute)){
			return;
		}
		attribute.setName(name);
		attributeService.updByAttid(attribute);
	}
	
	@ApiOperation(value="删除属性，并删除属性及属性值和产品属性")
	@ApiImplicitParams({@ApiImplicitParam(name="attid",value="属性编号",required=true,dataType="long")})
	@RequestMapping(value="/del_attid",method={RequestMethod.GET})
	public void del_attid(@RequestParam(value="attid")long attid){
		Attribute attribute=attributeService.getByAttid(attid);
		if(!ValidUtil.isValid(attribute)){
			return;
		}
		attributeService.delByAttid(attid);
	}
}
