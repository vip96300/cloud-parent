package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.product.server.model.Category;
import org.cloud.product.server.service.CategoryService;
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
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/list_pid",method=RequestMethod.GET)
	public List<Category> list_pid(@RequestParam(value="pid") long pid){
		List<Category> categorys=categoryService.listByPid(pid);
		return categorys;
		
	}
}
