package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.server.model.Brand;
import org.cloud.product.server.model.Category;
import org.cloud.product.server.model.Product;
import org.cloud.product.server.service.BrandService;
import org.cloud.product.server.service.CategoryService;
import org.cloud.product.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
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
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	
	@Async
	@RequestMapping(value="/product/product/add",method=RequestMethod.POST)
	public void add(@RequestBody Product product) {
		Category category=categoryService.getByCatid(product.getCatid());
		if(!ValidUtil.isValid(category)){
			return;
		}
		if(category.getIssku()!=0){
			return;
		}
		Brand brand=brandService.getByBraid(product.getBraid());
		if(!ValidUtil.isValid(brand)){
			return;
		}
		product.setBraname(brand.getName());
		productService.add(product);
	}
	
	@RequestMapping(value="/list_proids",method=RequestMethod.GET)
	public List<Product> list_proids(@RequestParam(value="proids",required=true)List<Long> proids){
		List<Product> products=productService.listByProids(proids);
		return products;
	}
	
	@RequestMapping(value="/list_catid",method=RequestMethod.GET)
	public List<Product> list_catid(@RequestParam(value="catid",required=true)long catid,@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size){
		List<Product> products=productService.listByCatid(catid,new PageRequest(page, size));
		return products;
	}
	
	@RequestMapping(value="/get_proid",method=RequestMethod.GET)
	public Product get_proid(@RequestParam(value="proid")long proid){
		Product product=productService.getByProid(proid);
		return product;
	}
}
