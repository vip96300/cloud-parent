package org.cloud.product.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.AttGroup;
import org.cloud.product.client.model.Category;
import org.cloud.product.client.service.AttGroupService;
import org.cloud.product.client.service.CategoryService;
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
	@Autowired
	private CategoryService categoryService;
	
	@ApiOperation(value="根据类目编号获取属性组及属性组以下的属性列表及属性值列表")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long")})
	@RequestMapping(value="/list_attributes_attValues_catid",method=RequestMethod.GET)
	public Result<List> list_attributes_attValues_catid(@RequestParam(value="catid",required=true) long catid){
		List<Map<String,List<Object>>> attGroupsAttibutesAttValues=attGroupService.listAttributesAttValuesByCatid(catid);
		return new Result<List>(200,null,attGroupsAttibutesAttValues);
	}
	
	@ApiOperation(value="添加属性组")
	@ApiImplicitParams({
		@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="属性组名称",required=true,dataType="String")
	})
	@RequestMapping(value="/add",method={RequestMethod.POST,RequestMethod.GET})
	public void add(@RequestParam(value="catid",required=true)long catid,@RequestParam(value="name",required=true)String name){
		Category category=categoryService.getByCatid(catid);
		if(!ValidUtil.isValid(category)){
			//如果类目不存在
			return;
		}
		if(category.getIssku()==0){
			//不是最小单元
			return;
		}
		AttGroup attGroup=new AttGroup();
		attGroup.setCatid(catid);
		attGroup.setName(name);
		attGroupService.add(attGroup);
	}
	
	@ApiOperation(value="根据属性组编号修改属性组名称")
	@ApiImplicitParams({@ApiImplicitParam(name="groid",value="属性组编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="属性组名称",required=true,dataType="String")})
	@RequestMapping(value="/upd_groid",method={RequestMethod.GET})
	public void upd_groid(@RequestParam(value="groid",required=true)long groid,@RequestParam(value="name",required=true)String name){
		AttGroup attGroup=attGroupService.getByGroid(groid);
		if(!ValidUtil.isValid(attGroup)){
			return;
		}
		attGroup.setName(name);
		attGroupService.updByGroid(attGroup);
	}
	
	@ApiOperation(value="删除属性组，并且级联删除以下所有属性")
	@ApiImplicitParams({@ApiImplicitParam(name="groid",value="属性组编号",required=true,dataType="long")})
	@RequestMapping(value="/del_groid",method={RequestMethod.GET})
	public void del_groid(@RequestParam(value="groid")long groid){
		attGroupService.delByGroid(groid);
	}
}
