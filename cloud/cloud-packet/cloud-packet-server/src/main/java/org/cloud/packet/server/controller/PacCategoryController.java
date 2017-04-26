package org.cloud.packet.server.controller;

import java.util.List;

import org.cloud.packet.server.model.PacCategory;
import org.cloud.packet.server.service.PacCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/packet/category/add",method=RequestMethod.POST)
	public void add(@RequestBody PacCategory pacCategory) {
		pacCategoryService.add(pacCategory);
	}
	
	@RequestMapping(value="/packet/category/del_catid",method=RequestMethod.DELETE)
	public void del_catid(@RequestParam(value="catid",required=true)long catid) {
		pacCategoryService.delByCatid(catid);
	}
	
	@RequestMapping(value="/packet/category/list_pacid",method=RequestMethod.GET)
	public List<PacCategory> list_pacid(@RequestParam(value="pacid",required=true)long pacid) {
		List<PacCategory> pacCategory=pacCategoryService.listByPacid(pacid);
		return pacCategory;
	}
}
