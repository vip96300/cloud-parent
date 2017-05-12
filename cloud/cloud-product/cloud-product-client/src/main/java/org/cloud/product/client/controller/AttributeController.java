package org.cloud.product.client.controller;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.Attribute;
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
	
	@ApiOperation(value="根据属性组编号获取属性集合")
	@ApiImplicitParams({@ApiImplicitParam(name="groid",value="属性组编号",required=true,dataType="long")})
	@RequestMapping(value="list_groid",method=RequestMethod.POST)
	public Result<List<Attribute>> list_groid(@RequestParam(value="groid",required=true)long groid){
		List<Attribute> attributes=attributeService.listByGroid(groid);
		return new Result<List<Attribute>>(200,null,attributes);
	}

	@ApiOperation(value="添加属性")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "groid", value = "属性组编号", required = true, dataType = "long"),
        @ApiImplicitParam(name = "name", value = "属性名称", required = true, dataType = "String"),
        @ApiImplicitParam(name = "type", value = "属性类型，0输入，1单选，2多选", required = true, dataType = "int")
    })
    @RequestMapping(value="/add",method={RequestMethod.POST})
    public Result<Object> add(@RequestParam(value="groid",required=true)long groid,@RequestParam(value="name",required=true)String name,@RequestParam(value="type",required=true)int type){
		Attribute attribute=new Attribute();
		attribute.setGroid(groid);
		attribute.setName(name);
		attribute.setType(type);
    	attributeService.add(attribute);
    	return new Result<Object>(200,null,null);
    }
	
	@ApiOperation(value="修改属性名称")
	@ApiImplicitParams({@ApiImplicitParam(name="attid",value="属性编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="属性名称",required=true,dataType="String")})
	@RequestMapping(value="/upd_attid",method={RequestMethod.POST})
	public Result<Object> upd_attid(@RequestParam(value="attid",required=true)long attid,@RequestParam(value="name",required=true)String name){
		Attribute attribute=attributeService.getByAttid(attid);
		if(!ValidUtil.isValid(attribute)){
			return null;
		}
		attribute.setName(name);
		attributeService.updByAttid(attribute);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="删除属性，并删除属性及属性值和产品属性")
	@ApiImplicitParams({@ApiImplicitParam(name="attid",value="属性编号",required=true,dataType="long")})
	@RequestMapping(value="/del_attid",method={RequestMethod.POST})
	public Result<Object> del_attid(@RequestParam(value="attid")long attid){
		Attribute attribute=attributeService.getByAttid(attid);
		if(!ValidUtil.isValid(attribute)){
			return null;
		}
		attributeService.delByAttid(attid);
		return new Result<Object>(200,null,null);
	}
}
