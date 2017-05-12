package org.cloud.product.client.service;

import java.util.List;

import org.cloud.product.client.model.AttValue;
import org.cloud.product.client.service.breaker.AttValueServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-product-server",fallback=AttValueServiceBreaker.class)
public interface AttValueService {
	
	/**
	 * 添加属性值
	 * @param attValue
	 */
	@RequestMapping(value="/product/category/attribute/attValue/add",method=RequestMethod.POST)
	public void add(@RequestBody AttValue attValue);
	
	/**
	 * 根据属性编号获取属性值列表
	 * @param attid
	 * @return
	 */
	@RequestMapping(value="/product/category/attribute/attValue/list_attid",method=RequestMethod.GET)
	public List<AttValue> listByAttid(@RequestParam(value="attid",required=true)long attid);
	
	/**
	 * 根据属性值编号获取属性值
	 * @param valid
	 * @return
	 */
	@RequestMapping(value="/product/category/attribute/attValue/get_valid",method=RequestMethod.GET)
	public AttValue getByValid(@RequestParam(value="valid",required=true)long valid);
	
	/**
	 * 根据属性值编号删除属性值
	 * @param valid
	 */
	@RequestMapping(value="/product/category/attribute/attValue/del_valid",method=RequestMethod.DELETE)
	public void delByValid(@RequestParam(value="valid",required=true)long valid);
	
	/**
	 * 修改属性值
	 * @param attValue
	 */
	@RequestMapping(value="/product/category/attribute/attValue/upd_valid",method=RequestMethod.PUT)
	public void updByValid(@RequestBody AttValue attValue);
}
