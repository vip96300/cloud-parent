package org.cloud.product.admin.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.cloud.product.admin.controller.dto.Result;
import org.cloud.product.admin.model.Product;
import org.cloud.product.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="根据类目编号获取产品列表")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="page",value="当前页",required=true,dataType="int"),
		@ApiImplicitParam(name="size",value="每页数",required=true,dataType="int")})
	@RequestMapping(value="/list_catid",method=RequestMethod.GET)
	public Result<List> list_catid(@RequestParam(value="catid",required=true)long catid,@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size){
		List<Product> products=productService.listByCatid(catid,page,size);
		return new Result<List>(200,null,products);
	}
}
