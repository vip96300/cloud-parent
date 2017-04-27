package org.cloud.packet.server.controller;

import org.cloud.packet.server.model.Product;
import org.cloud.packet.server.service.ProductService;
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
	
	@RequestMapping(value="/get_proid",method=RequestMethod.GET)
	public Product get_proid(@RequestParam(value="proid",required=true)long proid) {
		Product product=productService.getByProid(proid);
		return product;
	}
}
