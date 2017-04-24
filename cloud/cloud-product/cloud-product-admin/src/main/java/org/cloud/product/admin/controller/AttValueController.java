package org.cloud.product.admin.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.admin.model.AttValue;
import org.cloud.product.admin.model.Attribute;
import org.cloud.product.admin.service.AttValueService;
import org.cloud.product.admin.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/attribute/attValue")
public class AttValueController {
	
	@Autowired
	private AttValueService attValueService;
	@Autowired
	private AttributeService attributeService;
	
	@ApiOperation(value="添加属性值")
	@ApiImplicitParams({@ApiImplicitParam(name="attid",value="属性编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="属性值名称",required=true,dataType="String")})
	@RequestMapping(value="/add",method={RequestMethod.GET})
	public void add(@RequestParam(value="attid",required=true)long attid,@RequestParam(value="name",required=true)String name){
		Attribute attribute=attributeService.getByAttid(attid);
		if(!ValidUtil.isValid(attribute)||attribute.getType()==Attribute.T0){
			return;
		}
		AttValue attValue=new AttValue();
		attValue.setAttid(attid);
		attValue.setCatid(attribute.getCatid());
		attValue.setName(name);
		attValueService.add(attValue);
	}
	
	@ApiOperation(value="根据属性值编号删除属性值")
	@ApiImplicitParams({@ApiImplicitParam(name="valid",value="属性值编号",required=true,dataType="long")})
	@RequestMapping(value="/del_valid",method={RequestMethod.GET})
	public void del_valid(@RequestParam(value="valid",required=true)long valid){
		attValueService.delByValid(valid);
	}
	
	@ApiOperation(value="修改属性值")
	@ApiImplicitParams({@ApiImplicitParam(name="valid",value="属性值编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="属性值名称",required=true,dataType="long")})
	@RequestMapping(value="/upd_valid",method={RequestMethod.GET})
	public void upd_valid(@RequestParam(value="valid",required=true)long valid,@RequestParam(value="name",required=true)String name){
		AttValue attValue=attValueService.getByValid(valid);
		if(!ValidUtil.isValid(attValue)){
			return;
		}
		attValueService.updByValid(attValue);
	}
}
