package org.cloud.product.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.Category;
import org.cloud.product.client.service.CategoryService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category")
public class CategoryController {
	
	private final org.slf4j.Logger logger=LoggerFactory.getLogger(getClass());
	@Autowired
	private CategoryService categoryService;
	@ApiOperation(value="根据类目编号获取子类目列表，顶级类目请传0")
	@ApiImplicitParams({@ApiImplicitParam(name="pid",value="类目父编号",required=true,dataType="long")})
	@RequestMapping(value="/list_pid",method=RequestMethod.POST)
	public Result<List<Category>> list_pid(@RequestParam(value="pid",required=true) long pid){
		List<Category> categorys=categoryService.listByPid(pid);
		return new Result<List<Category>>(200,null,categorys);
	}
	
	@ApiOperation(value="添加类目")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pid",value="父类目编号，顶级类目传0",required=true,dataType="long"),
		@ApiImplicitParam(name="issku",value="是否是最小级类目",required=true,dataType="int"),
		@ApiImplicitParam(name="name",value="类目名称",required=true,dataType="String")
	})
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public Result<Object> add(@RequestParam(value="pid",required=true)long pid, @RequestParam(value="issku",required=true)int issku, @RequestParam(value="name",required=true)String name){
		Category category=null;
		if(pid!=0){//如果不是顶层类目
			category=categoryService.getByCatid(pid);
			if(ValidUtil.isValid(category)){
				return null;
			}
		}
		category=new Category();
		category.setPid(pid);
		category.setIssku(issku);
		category.setName(name);
		categoryService.add(category);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="根据类目编号删除类目，若该类目以下有子类目，不可删除")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long")})
	@RequestMapping(value="/del_catid",method=RequestMethod.POST)
	public Result<Object> del_catid(@RequestParam(value="catid",required=true)long catid){
		List<Category> categorys=categoryService.listByPid(catid);
		if(!categorys.isEmpty()){
			logger.info("有子集，不能删除");
			return null;
		}
		categoryService.delByCatid(catid);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="根据类目编号修改类目")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="类目名称",required=true,dataType="String")})
	@RequestMapping(value="/upd_catid",method=RequestMethod.POST)
	public Result<Object> upd_catid(@RequestParam(value="catid",required=true)long catid,@RequestParam(value="name",required=true)String name){
		Category category=categoryService.getByCatid(catid);
		if(!ValidUtil.isValid(category)){
			return null;
		}
		category.setName(name);
		categoryService.updByCatid(category);
		return new Result<Object>(200,null,null);
	}
}
