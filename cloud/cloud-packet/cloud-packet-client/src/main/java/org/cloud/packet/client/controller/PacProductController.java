package org.cloud.packet.client.controller;

import org.cloud.packet.client.service.PacProductService;
import org.cloud.packet.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/category/product")
public class PacProductController {
	
	@Autowired
	private PacProductService pacProductService;
	@Autowired
	private ProductService productService;

}
