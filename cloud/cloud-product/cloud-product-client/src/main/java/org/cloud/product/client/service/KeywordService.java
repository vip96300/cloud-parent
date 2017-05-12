package org.cloud.product.client.service;

import java.util.List;

import org.cloud.product.client.model.Keyword;
import org.cloud.product.client.service.breaker.KeywordServiceBreaker;
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
	 * 根据搜索编号获取关键字集合
	 * @param seaid
	 * @return
	 */
	@RequestMapping(value="/product/category/search/keyword/list_seaid",method=RequestMethod.GET)
	public List<Keyword> listBySeaid(@RequestParam(value="seaid",required=true)long seaid);
	/**
	 * 根据类目编号获取关键字集合
	 * @param seaid
	 * @return
	 */
	@RequestMapping(value="/product/category/search/keyword/list_catid",method=RequestMethod.GET)
	public List<Keyword> listByCatid(@RequestParam(value="catid",required=true)long catid);
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
