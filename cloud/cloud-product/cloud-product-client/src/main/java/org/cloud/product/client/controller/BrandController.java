package org.cloud.product.client.controller;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.Brand;
import org.cloud.product.client.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
	
	@ApiOperation(value="根据类目编号获取品牌列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "catid", value = "类目编号", required = true, dataType = "long"),
        @ApiImplicitParam(name = "page", value = "当前页码", required = true, dataType = "int"),
        @ApiImplicitParam(name = "size", value = "每页数量", required = true, dataType = "int")
    })
	@RequestMapping(value="/list_catid",method=RequestMethod.GET)
    public Result<List> list_catid(@RequestParam(value="catid",required=true) long catid,@RequestParam(value="page",required=true) int page,@RequestParam(value="size",required=true) int size){
    	List<Brand> brands=brandService.listByCatid(catid,page, size);
    	return new Result<List>(200,null,brands);
    }
	
	@ApiOperation(value="添加品牌")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "catid", value = "类目编号", required = true, dataType = "long"),
        @ApiImplicitParam(name = "name", value = "属性名称", required = true, dataType = "String"),
        @ApiImplicitParam(name = "logo", value = "logo地址", required = true, dataType = "String")
    })
	@RequestMapping(value="/add",method={RequestMethod.GET,RequestMethod.POST})
	public void add(@RequestParam(value="catid",required=true)long catid,@RequestParam(value="name",required=true)String name,@RequestParam(value="logo",required=true)String logo){
		Brand brand=new Brand();
		brand.setCatid(catid);
		brand.setName(name);
		brand.setLogo(logo);
		brandService.add(brand);
	}
}
