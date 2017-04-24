package org.cloud.product.admin.service;

import org.cloud.product.admin.model.Keyword;
import org.cloud.product.admin.service.breaker.KeywordServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value="cloud-product-server",fallback=KeywordServiceBreaker.class)
public interface KeywordService {
	
	/**
	 * 添加
	 * @param keyword
	 */
	@RequestMapping(value="/product/category/search/keyword/add",method=RequestMethod.POST)
	public void add(@RequestBody Keyword keyword);
	
	/**
	 * 根据编号获取
	 * @param keyid
	 * @return
	 */
	@RequestMapping(value="/product/category/search/keyword/get_keyid",method=RequestMethod.GET)
	public Keyword getByKeyid(@RequestParam(value="keyid",required=true)long keyid);
	
	/**
	 * 修改
	 * @param keyword
	 */
	@RequestMapping(value="/product/category/search/keyword/upd_keyid",method=RequestMethod.PUT)
	public void updByKeyid(@RequestBody Keyword keyword);
	
	/**
	 * 根据编号删除
	 * @param keyid
	 */
	@RequestMapping(value="/product/category/search/keyword/del_keyid",method=RequestMethod.DELETE)
	public void delByKeyid(@RequestParam(value="keyid",required=true)long keyid);
}
