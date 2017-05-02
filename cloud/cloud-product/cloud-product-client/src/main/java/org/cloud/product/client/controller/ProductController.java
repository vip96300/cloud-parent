package org.cloud.product.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.cloud.common.util.HttpStatusCodes;
import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.Category;
import org.cloud.product.client.model.Product;
import org.cloud.product.client.service.CategoryService;
import org.cloud.product.client.service.ProductService;
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
	@RequestMapping(value="/list_catid",method=RequestMethod.POST)
	public Result<List<Product>> list_catid(@RequestParam(value="catid",required=true)long catid,@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size){
		List<Product> products=productService.listByCatid(catid,page,size);
		return new Result<List<Product>>(HttpStatusCodes.OK,null,products);
	}
	
	@ApiOperation(value="添加产品")
	@ApiImplicitParams({@ApiImplicitParam(name="braid",value="品牌编号",required=true,dataType="long"),
		@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="产品名称",required=true,dataType="String"),
		@ApiImplicitParam(name="discprice",value="折扣价",required=true,dataType="double"),
		@ApiImplicitParam(name="sellprice",value="销售价",required=true,dataType="double")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(@RequestParam(value="braid",required=true)long braid,
			@RequestParam(value="catid",required=true)long catid,
			@RequestParam(value="name",required=true)String name,
			@RequestParam(value="discprice",required=true)double discprice,
			@RequestParam(value="sellprice",required=true)double sellprice){
		Product product=new Product();
		product.setBraid(braid);
		product.setCatid(catid);
		product.setName(name);
		product.setDiscprice(discprice);
		product.setSellprice(sellprice);
		productService.add(product);
		return new Result<Object>(HttpStatusCodes.OK,null,null);
	}
	
}
