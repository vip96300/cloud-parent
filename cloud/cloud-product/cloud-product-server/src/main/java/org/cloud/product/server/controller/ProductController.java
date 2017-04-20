package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.product.server.model.Product;
import org.cloud.product.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
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
	
	/**
	 * 根据类目编号获取产品列表
	 * @param catid
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="list_catid",method=RequestMethod.GET)
	public List<Product> list_catid(@RequestParam(value="catid",required=true)long catid,@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size){
		List<Product> products=productService.listByCatid(catid,new PageRequest(page, size));
		return products;
	}
}
