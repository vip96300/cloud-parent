package org.cloud.product.admin.service;

import java.util.List;

import org.cloud.product.admin.model.Category;
import org.cloud.product.admin.service.breaker.CategoryServiceBreaker;
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
	
	/**
	 * 添加类目
	 * @param category
	 */
	@RequestMapping(value="/product/category/add",method=RequestMethod.POST)
	public void add(@RequestBody Category category);

	/**
	 * 根据编号获取类目
	 * @param catid
	 * @return
	 */
	@RequestMapping(value="/product/category/get_catid",method=RequestMethod.GET)
	public Category getByCatid(@RequestParam(value="catid",required=true)long catid);
	
	/**
	 * 根据类目编号删除类目
	 * @param catid
	 */
	@RequestMapping(value="/product/category/del_catid",method=RequestMethod.DELETE)
	public void delByCatid(@RequestParam(value="catid",required=true)long catid);
	
	/**
	 * 修改类目
	 * @param category
	 */
	@RequestMapping(value="/product/category/upd_catid",method=RequestMethod.PUT)
	public void updByCatid(@RequestBody Category category);
}
