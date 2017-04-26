package org.cloud.packet.client.service;

import org.cloud.packet.client.model.PacProduct;
import org.cloud.packet.client.service.breaker.PacProductServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-packet-server",fallback=PacProductServiceBreaker.class)
public interface PacProductService {
	
	@RequestMapping(value="/packet/category/product",method=RequestMethod.POST)
	public void add(@RequestBody PacProduct pacProduct);
	
	@RequestMapping(value="/packet/category/product",method=RequestMethod.DELETE)
	public void delByProductid(@RequestParam(value="productid",required=true)long productid);
}
