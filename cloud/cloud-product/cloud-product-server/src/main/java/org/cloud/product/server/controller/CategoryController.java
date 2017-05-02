package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.server.model.Category;
import org.cloud.product.server.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category")
public class CategoryController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/list_pid",method=RequestMethod.GET)
	public List<Category> list_pid(@RequestParam(value="pid",required=true) long pid){
		List<Category> categorys=categoryService.listByPid(pid);
		return categorys;
		
	}
	@Async
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@RequestBody Category category){
		if(category.getPid()!=0){
			//如果不是一级类目需要验证上层类目
			Category hasCategory=categoryService.getByCatid(category.getPid());
			if(!ValidUtil.isValid(hasCategory)){
				return;
			}
		}
		categoryService.add(category);
	}
	
	@RequestMapping(value="/get_catid",method=RequestMethod.GET)
	public Category get_catid(@RequestParam(value="catid",required=true)long catid){
		Category category=categoryService.getByCatid(catid);
		return category;
	}
	@Async
	@RequestMapping(value="/del_catid",method=RequestMethod.DELETE)
	public void del_catid(@RequestParam(value="catid",required=true)long catid){
		Category category=categoryService.getByCatid(catid);
		if(!ValidUtil.isValid(category)){
			return;
		}
		if(category.getIssku()==0){
			//如果不是最小单元
			return;
		}
		categoryService.delByCatid(catid);
	}
	@Async
	@RequestMapping(value="/upd_catid",method=RequestMethod.PUT)
	public void upd_catid(@RequestBody Category category){
		Category hasCategory=categoryService.getByCatid(category.getCatid());
		if(!ValidUtil.isValid(hasCategory)){
			return;
		}
		categoryService.updByCatid(category);
	}

}
