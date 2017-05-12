package org.cloud.product.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.cloud.common.util.HttpStatusCodes;
import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.Picture;
import org.cloud.product.client.model.Product;
import org.cloud.product.client.model.ProductDTO;
import org.cloud.product.client.service.AttributeService;
import org.cloud.product.client.service.KeywordService;
import org.cloud.product.client.service.PictureService;
import org.cloud.product.client.service.ProductService;
import org.springframework.beans.BeanUtils;
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
	@Autowired
	private AttributeService attributeService;
	@Autowired
	private KeywordService keywordService;
	@Autowired
	private PictureService pictureService;

	@ApiOperation(value="根据类目编号获取产品列表")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="page",value="当前页",required=true,dataType="int"),
		@ApiImplicitParam(name="size",value="每页数",required=true,dataType="int")})
	@RequestMapping(value="/list_catid",method=RequestMethod.POST)
	public Result<List<Product>> list_catid(@RequestParam(value="catid",required=true)long catid,
			@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size){
		List<Product> products=productService.listByCatid(catid,page,size);
		return new Result<List<Product>>(HttpStatusCodes.OK,null,products);
	}
	
	@ApiOperation(value="添加产品")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="braid",value="品牌编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="产品名称",required=true,dataType="String"),
		@ApiImplicitParam(name="discprice",value="折扣价",required=true,dataType="double"),
		@ApiImplicitParam(name="sellprice",value="销售价",required=true,dataType="double"),
		@ApiImplicitParam(name="keyword",value="关键字，例：红色,高大上（字符串形式，英文字符分割）",required=true,dataType="String")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(HttpServletRequest request,
			@RequestParam(value="catid",required=true)long catid,
			@RequestParam(value="braid",required=true)long braid,
			@RequestParam(value="name",required=true)String name,
			@RequestParam(value="discprice",required=true)double discprice,
			@RequestParam(value="sellprice",required=true)double sellprice,
			@RequestParam(value="keyword",required=true)String keyword){
		Product product=new Product();
		product.setCatid(catid);
		product.setBraid(braid);
		product.setName(name);
		product.setDiscprice(discprice);
		product.setSellprice(sellprice);
		product.setKeyword(keyword);
		productService.add(product);
		return new Result<Object>(HttpStatusCodes.OK,null,null);
	}
	
	@ApiOperation(value="修改产品")
	@ApiImplicitParams({@ApiImplicitParam(name="proid",value="产品编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="产品名称",required=true,dataType="String"),
		@ApiImplicitParam(name="discprice",value="折扣价",required=true,dataType="double"),
		@ApiImplicitParam(name="sellprice",value="销售价",required=true,dataType="double"),
		@ApiImplicitParam(name="keyword",value="关键字，例：红色,高大上（字符串形式，英文字符分割）",required=true,dataType="String")})
	@RequestMapping(value="/upd_proid",method=RequestMethod.POST)
	public Result<Object> upd_proid(@RequestParam(value="proid",required=true)long proid,
			@RequestParam(value="name",required=true)String name,
			@RequestParam(value="discprice",required=true)double discprice,
			@RequestParam(value="sellprice",required=true)double sellprice,
			@RequestParam(value="keyword",required=true)String keyword){
		Product product=productService.getByProid(proid);
		if(!ValidUtil.isValid(product)){
			return null;
		}
		product.setName(name);
		product.setDiscprice(discprice);
		product.setSellprice(sellprice);
		product.setKeyword(keyword);
		productService.updByProid(product);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="删除产品")
	@ApiImplicitParams({@ApiImplicitParam(name="proid",value="产品编号",required=true,dataType="long")})
	@RequestMapping(value="/del_proid",method=RequestMethod.POST)
	public Result<Object> del_proid(@RequestParam(value="proid",required=true)long proid){
		productService.delByProid(proid);
		return new Result<Object>(200,null,null);
		
	}
	
	@ApiOperation(value="根据编号获取产品")
	@ApiImplicitParams({@ApiImplicitParam(name="proid",value="产品编号",required=true,dataType="long")})
	@RequestMapping(value="/get_proid",method=RequestMethod.POST)
	public Result<ProductDTO> get_proid(@RequestParam(value="proid",required=true)long proid){
		Product product=productService.getByProid(proid);
		ProductDTO productDTO=new ProductDTO();
		BeanUtils.copyProperties(product,productDTO);
		List<Picture> pictures=pictureService.listByProid(proid);
		productDTO.setPictures(pictures);
		return new Result<ProductDTO>(200,null,productDTO);
	}
	
}
