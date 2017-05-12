package org.cloud.packet.client.service;

import org.cloud.packet.client.model.Category;
import org.cloud.packet.client.service.breaker.CategoryServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-product-server",fallback=CategoryServiceBreaker.class)
public interface CategoryService {
	
	@RequestMapping(value="/product/category/get_catid",method=RequestMethod.GET)
	public Category getByCatid(@RequestParam(value="catid",required=true)long catid);

}
