package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.product.server.model.Brand;
import org.cloud.product.server.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/list_catid",method=RequestMethod.GET)
    public List<Brand> list_catId(@RequestParam(value="catid",required=true) long catid,@RequestParam(value="page",required=true) int page,@RequestParam(value="size",required=true) int size){
		Sort sort=new Sort(Direction.ASC,"braid");
    	List<Brand> brands=brandService.listByCatid(catid,new PageRequest(page, size,sort));
    	return brands;
    }
	@Async
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@RequestBody Brand brand){
		brandService.add(brand);
	}

	@RequestMapping(value="/get_braid",method=RequestMethod.GET)
	public Brand get_braid(@RequestParam(value="braid",required=true)long braid){
		Brand brand=brandService.getByBraid(braid);
		return brand;
	}
	@Async
	@RequestMapping(value="/del_braid",method={RequestMethod.DELETE})
	public void del_braid(@RequestParam(value="braid",required=true)long braid){
		brandService.delByBraid(braid);
	}
	@Async
	@RequestMapping(value="/upd_braid",method=RequestMethod.PUT)
	public void upd_braid(@RequestBody Brand brand){
		brandService.updByBraid(brand);
	}
}
