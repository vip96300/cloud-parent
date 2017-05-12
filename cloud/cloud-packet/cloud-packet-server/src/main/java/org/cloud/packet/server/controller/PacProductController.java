package org.cloud.packet.server.controller;

import java.util.List;

import org.cloud.packet.server.model.PacProduct;
import org.cloud.packet.server.service.PacProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/category/product")
public class PacProductController {
	
	@Autowired
	private PacProductService pacProductService;
	@Async
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@RequestBody PacProduct pacProduct) {
		pacProductService.add(pacProduct);
	}
	@Async
	@RequestMapping(value="/del_productid",method=RequestMethod.DELETE)
	public void delByProductid(@RequestParam(value="productid",required=true)long productid) {
		pacProductService.delByProductid(productid);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<PacProduct> list(@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size) {
		List<PacProduct> pacProducts=pacProductService.list(page, size);
		return pacProducts;
	}
	@RequestMapping(value="/list_catid",method=RequestMethod.GET)
	public List<PacProduct> list_catid(@RequestParam(value="catid",required=true)long catid,
			@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size) {
		List<PacProduct> pacProducts=pacProductService.listByCatid(catid,page,size);
		return pacProducts;
	}
}
