package org.cloud.product.client.service;

import java.util.List;
import java.util.Map;

import org.cloud.product.client.service.breaker.AttGroupServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-product-server",fallback=AttGroupServiceBreaker.class)
public interface AttGroupService {
	
	/**
	 * 根据类目编号获取属性组和属性列表和属性值列表
	 * @param catId
	 * @return
	 */
	@RequestMapping(value="/product/category/attribute/attGroup/list_attributes_attValues",method=RequestMethod.GET)
	public List<Map<String,List<Object>>> listAttributesAttValuesByCatId(@RequestParam(value="catId")long catId);
}
