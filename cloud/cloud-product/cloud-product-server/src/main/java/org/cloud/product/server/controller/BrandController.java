package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.product.server.model.Brand;
import org.cloud.product.server.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/brand")
public class BrandController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(value="list_catid",method=RequestMethod.GET)
    public List<Brand> list_catId(@RequestParam(value="catid",required=true) long catid,@RequestParam(value="page",required=true) int page,@RequestParam(value="size",required=true) int size){
		logger.debug(this.getClass().getName());
    	List<Brand> brands=brandService.listByCatid(catid,new PageRequest(page, size));
    	return brands;
    }
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@ModelAttribute Brand brand){
		logger.debug(this.getClass().getName());
		brandService.add(brand);
	}
}
