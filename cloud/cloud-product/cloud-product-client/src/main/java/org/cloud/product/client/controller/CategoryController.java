package org.cloud.product.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.Category;
import org.cloud.product.client.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.util.ValidationUtils;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	@ApiOperation(value="根据类目编号获取子类目列表，顶级类目请传0")
	@ApiImplicitParams({@ApiImplicitParam(name="pid",value="类目父编号",required=true,dataType="long")})
	@RequestMapping(value="/list_pid",method=RequestMethod.GET)
	public Result<List> list_pid(@RequestParam(value="pid",required=true) long pid){
		List<Category> categorys=categoryService.listByPid(pid);
		return new Result<List>(200,null,categorys);
	}
	
	@ApiOperation(value="添加类目")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pid",value="父类目编号，顶级类目传0",required=true,dataType="long"),
		@ApiImplicitParam(name="issku",value="是否是最小级类目",required=true,dataType="int"),
		@ApiImplicitParam(name="name",value="类目名称",required=true,dataType="String")
	})
	@RequestMapping(value="add",method={RequestMethod.POST,RequestMethod.GET})
	public void add(@RequestParam(value="pid",required=true)long pid, @RequestParam(value="issku",required=true)int issku, @RequestParam(value="name",required=true)String name){
		Category category=null;
		if(pid!=0){//如果不是顶层类目
			category=categoryService.getByCatid(pid);
			if(ValidUtil.isValid(category)){
				return;
			}
		}
		category=new Category();
		category.setPid(pid);
		category.setIssku(issku);
		category.setName(name);
		categoryService.add(category);
	}
}
