package org.cloud.product.client.controller;

import java.util.List;

import org.cloud.product.client.model.Brand;
import org.cloud.product.client.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(value="/list_catId",method=RequestMethod.GET)
    public List<Brand> list_catId(@RequestParam(value="catId") Long catId){
    	List<Brand> brands=brandService.listByCatId(catId);
    	return brands;
    }
	
	public void add(Brand brand){
		
	}
}
