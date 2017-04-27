package org.cloud.packet.server.service;

import org.cloud.packet.server.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


public interface ProductService {
	
	@RequestMapping(value="/product/product/get_proid",method=RequestMethod.GET)
	public Product getByProid(@RequestParam(value="proid",required=true)long proid);
}
