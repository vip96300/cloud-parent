package org.cloud.product.client.service;

import java.util.List;
import java.util.Map;

import org.cloud.product.client.model.AttValue;
import org.cloud.product.client.model.Property;
import org.cloud.product.client.service.breaker.PropertyServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-product-server",fallback=PropertyServiceBreaker.class)
public interface PropertyService {
	
	
	@RequestMapping(value="/product/product/property/list_attValues_productid",method=RequestMethod.GET)
	public Map<String,List<AttValue>> listAttValuesByProductid(@RequestParam(value="productid",required=true)long productid);
	
	/**
	 * 根据产品属性编号获取产品属性
	 * @param proid
	 * @return
	 */
	@RequestMapping(value="/product/product/property/get_proid",method=RequestMethod.GET)
	public Property getByProid(@RequestParam(value="proid",required=true)long proid);
	
	/**
	 * 修改
	 * @param property
	 */
	@RequestMapping(value="/product/product/property/upd_proid",method=RequestMethod.PUT)
	public void updByProid(@RequestBody Property property);
	
}
