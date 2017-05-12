package org.cloud.product.client.controller;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.AttValue;
import org.cloud.product.client.service.AttValueService;
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
	
	@ApiOperation(value="添加属性值")
	@ApiImplicitParams({@ApiImplicitParam(name="attid",value="属性编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="属性值名称",required=true,dataType="String")})
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public Result<Object> add(@RequestParam(value="attid",required=true)long attid,@RequestParam(value="name",required=true)String name){
		AttValue attValue=new AttValue();
		attValue.setAttid(attid);
		attValue.setName(name);
		attValueService.add(attValue);
		return new Result<Object>(200,null,null);
	}
	@ApiOperation(value="根据属性编号获取属性值列表")
	@ApiImplicitParams({@ApiImplicitParam(name="attid",value="属性编号",required=true,dataType="long")})
	@RequestMapping(value="list_attid",method=RequestMethod.POST)
	public Result<List<AttValue>> list_attid(@RequestParam(value="attid",required=true)long attid){
		List<AttValue> attValues=attValueService.listByAttid(attid);
		return new Result<List<AttValue>>(200,null,attValues);
	}
	@ApiOperation(value="根据属性值编号删除属性值")
	@ApiImplicitParams({@ApiImplicitParam(name="valid",value="属性值编号",required=true,dataType="long")})
	@RequestMapping(value="/del_valid",method={RequestMethod.POST})
	public Result<Object> del_valid(@RequestParam(value="valid",required=true)long valid){
		attValueService.delByValid(valid);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="修改属性值")
	@ApiImplicitParams({@ApiImplicitParam(name="valid",value="属性值编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="属性值名称",required=true,dataType="long")})
	@RequestMapping(value="/upd_valid",method={RequestMethod.POST})
	public Result<Object> upd_valid(@RequestParam(value="valid",required=true)long valid,@RequestParam(value="name",required=true)String name){
		AttValue attValue=attValueService.getByValid(valid);
		if(!ValidUtil.isValid(attValue)){
			return null;
		}
		attValue.setName(name);
		attValueService.updByValid(attValue);
		return new Result<Object>(200,null,null);
	}
}
