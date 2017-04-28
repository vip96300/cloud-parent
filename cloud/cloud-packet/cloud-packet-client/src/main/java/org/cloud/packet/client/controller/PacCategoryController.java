package org.cloud.packet.client.controller;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.packet.client.controller.dto.Result;
import org.cloud.packet.client.model.PacCategory;
import org.cloud.packet.client.service.PacCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/category")
public class PacCategoryController {
	
	
	@Autowired
	private PacCategoryService pacCategoryService;
	
	@ApiOperation(value="添加类目至优选包")
	@ApiImplicitParams({@ApiImplicitParam(name="pacid",value="优选包编号",required=true,dataType="long"),
		@ApiImplicitParam(name="categoryid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="ismust",value="是否必须",required=true,dataType="int")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(@RequestParam(value="pacid",required=true)long pacid,@RequestParam(value="categoryid",required=true)long categoryid,@RequestParam(value="ismust",required=true)int ismust){
		PacCategory pacCategory=new PacCategory();
		pacCategory.setPacid(pacid);
		pacCategory.setCategoryid(categoryid);
		pacCategoryService.add(pacCategory);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="删除优选包中的类目")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="有选报类目编号",required=true,dataType="long")})
	@RequestMapping(value="/del_catid",method=RequestMethod.POST)
	public Result<Object> del_catid(@RequestParam(value="catid",required=true)long catid){
		pacCategoryService.delByCatid(catid);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="优选包类目列表")
	@ApiImplicitParams({@ApiImplicitParam(name="pacid",value="优选包编号",required=true,dataType="long")})
	@RequestMapping(value="/list_pacid",method=RequestMethod.POST)
	public Result<List<PacCategory>> list_pacid(@RequestParam(value="pacid",required=true)long pacid){
		List<PacCategory> pacCategorys=pacCategoryService.listByPacid(pacid);
		return new Result<List<PacCategory>>(200,null,pacCategorys);
	}
	
}
