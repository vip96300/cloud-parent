package org.cloud.product.client.service;

import java.util.List;

import org.cloud.product.client.model.Product;
import org.cloud.product.client.service.breaker.ProductServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-product-server",fallback=ProductServiceBreaker.class)
public interface ProductService {
	
	/**
	 * 根据类目编号获取产品列表
	 * @param catid
	 * @return
	 */
	@RequestMapping(value="/product/product/list_catid",method=RequestMethod.GET)
	public List<Product> listByCatid(@RequestParam(value="catid",required=true)long catid,@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size);
}
