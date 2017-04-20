package org.cloud.product.client.service;

import org.cloud.product.client.model.Attribute;
import org.cloud.product.client.service.breaker.AttributeServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-product-server",fallback=AttributeServiceBreaker.class)
public interface AttributeService {

	/**
	 * 添加属性
	 * @param attribute
	 */
	@RequestMapping(value = "/product/category/attribute/add",method=RequestMethod.POST)
	public void add(@RequestBody Attribute attribute);
	
	/**
	 * 根据属性编号获取属性
	 * @param attid
	 * @return
	 */
	@RequestMapping(value="/product/category/attribute/get_attid",method=RequestMethod.GET)
	public Attribute getByAttid(@RequestParam(value="attid",required=true)long attid);
	
	/**
	 * 修改属性
	 * @param attribute
	 */
	@RequestMapping(value="/product/category/attribute/upd_attid",method=RequestMethod.PUT)
	public void updByAttid(@RequestBody Attribute attribute);
	
	/**
	 * 删除属性及属性值集合和产品属性
	 * @param attid
	 */
	@RequestMapping(value="/product/category/attribute/del_attid",method=RequestMethod.DELETE)
	public void delByAttid(@RequestParam(value="attid",required=true)long attid);
}
