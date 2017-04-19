package org.cloud.product.client.service;

import java.util.List;

import org.cloud.product.client.model.Category;
import org.cloud.product.client.service.breaker.AttributeServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(value="cloud-product-server")
public interface CategoryService {
	/**
	 * 根据pid获取类目列表
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/product/category/list_pid",method=RequestMethod.GET)
	public List<Category> listByPid(long pid);
}
