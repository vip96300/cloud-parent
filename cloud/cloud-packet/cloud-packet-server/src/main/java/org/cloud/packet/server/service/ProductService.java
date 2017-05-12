package org.cloud.packet.server.service;

import java.util.List;

import org.cloud.packet.server.model.ProductDTO;
import org.cloud.packet.server.service.breaker.ProductServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-product-server",fallback=ProductServiceBreaker.class)
public interface ProductService {
	
	@RequestMapping(value="/product/product/get_proid",method=RequestMethod.GET)
	public ProductDTO getByProid(@RequestParam(value="proid",required=true)long proid);
	
	@RequestMapping(value="/product/product/list_proids",method=RequestMethod.GET)
	public List<ProductDTO> listByProids(@RequestParam(value="proids",required=true)List<Long> proids);
}
