package org.cloud.packet.client.service;

import java.util.List;

import org.cloud.packet.client.model.PacProduct;
import org.cloud.packet.client.service.breaker.PacProductServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-packet-server",fallback=PacProductServiceBreaker.class)
public interface PacProductService {
	
	@RequestMapping(value="/packet/category/product/add",method=RequestMethod.POST)
	public void add(@RequestBody PacProduct pacProduct);
	
	@RequestMapping(value="/packet/category/product/del_productid",method=RequestMethod.DELETE)
	public void delByProductid(@RequestParam(value="productid",required=true)long productid);
	
	@RequestMapping(value="/packet/category/product/list",method=RequestMethod.GET)
	public List<PacProduct> list(@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size);
	
	@RequestMapping(value="/packet/category/product/list_catid",method=RequestMethod.GET)
	public List<PacProduct> listByCatid(@RequestParam(value="catid",required=true)long catid,@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size);
}
