package org.cloud.product.client.service;


import java.util.List;

import org.cloud.product.client.model.Brand;
import org.cloud.product.client.service.breaker.BrandServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-product-server",fallback=BrandServiceBreaker.class)
public interface BrandService {
	/**
	 * 根据类目编号获取品牌列表
	 * @param catId
	 * @return
	 */
	@RequestMapping(value = "/product/category/brand/list_catid",method=RequestMethod.GET)
	public List<Brand> listByCatid(@RequestParam(value="catid",required=true) long catid,@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size);
	/**
	 * 添加品牌
	 * @param brand
	 */
	@RequestMapping(value = "/product/category/brand/add",method=RequestMethod.POST)
	public void add(@RequestBody Brand brand);
	
	/**
	 * 根据品牌编号获取品牌信息
	 * @param braid
	 * @return
	 */
	@RequestMapping(value="/product/category/brand/get_braid",method=RequestMethod.GET)
	public Brand getByBraid(@RequestParam(value="braid",required=true)long braid);
	
	/**
	 * 根据品牌编号删除品牌
	 * @param braid
	 */
	@RequestMapping(value="/product/category/brand/del_braid",method=RequestMethod.DELETE)
	public void delByBraid(@RequestParam(value="braid",required=true)long braid);
	
	/**
	 * 根据品牌编号修改品牌
	 * @param brand
	 */
	@RequestMapping(value="/product/category/brand/upd_braid",method=RequestMethod.PUT)
	public void updByBraid(@RequestBody Brand brand);
}
