package org.cloud.product.client.service;

import java.util.List;

import org.cloud.product.client.model.Category;
import org.cloud.product.client.service.breaker.CategoryServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value="cloud-product-server",fallback=CategoryServiceBreaker.class)
public interface CategoryService {
	/**
	 * 根据pid获取类目列表
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/product/category/list_pid",method=RequestMethod.GET)
	public List<Category> listByPid(@RequestParam(value="pid",required=true)long pid);
	
	@RequestMapping(value="/product/category/add",method=RequestMethod.POST)
	public void add(@RequestBody Category category);

	@RequestMapping(value="/product/category/get_catid",method=RequestMethod.GET)
	public Category getByCatid(@RequestParam(value="catid",required=true)long catid);
}
