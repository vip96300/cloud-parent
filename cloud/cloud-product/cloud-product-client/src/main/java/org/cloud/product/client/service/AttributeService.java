package org.cloud.product.client.service;

import org.cloud.product.client.model.Attribute;
import org.cloud.product.client.service.breaker.AttributeServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="cloud-product-server",fallback=AttributeServiceBreaker.class)
public interface AttributeService {

	/**
	 * 添加属性
	 * @param attribute
	 */
	@RequestMapping(value = "/product/category/attribute/add")
	public void add(@RequestBody Attribute attribute);
}
