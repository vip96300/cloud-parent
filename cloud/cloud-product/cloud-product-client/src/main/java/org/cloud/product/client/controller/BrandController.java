package org.cloud.product.client.controller;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.product.client.model.Brand;
import org.cloud.product.client.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BrandService brandService;
	
	@ApiOperation(value="根据类目编号获取品牌列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "catid", value = "类目编号", required = true, dataType = "long"),
        @ApiImplicitParam(name = "page", value = "当前页码", required = true, dataType = "int"),
        @ApiImplicitParam(name = "size", value = "每页数量", required = true, dataType = "int")
    })
	@RequestMapping(value="/list_catid",method=RequestMethod.GET)
    public List<Brand> list_catid(@RequestParam(value="catid",required=true) long catid,@RequestParam(value="page") int page,@RequestParam(value="size") int size){
    	List<Brand> brands=brandService.listByCatid(catid,page, size);
    	return brands;
    }
	
	@ApiOperation(value="添加品牌")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "catid", value = "类目编号", required = true, dataType = "long"),
        @ApiImplicitParam(name = "name", value = "属性名称", required = true, dataType = "String"),
        @ApiImplicitParam(name = "isopt", value = "是否可选", required = true, dataType = "int")
    })
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(Brand brand){
		brandService.add(brand);
	}
}
