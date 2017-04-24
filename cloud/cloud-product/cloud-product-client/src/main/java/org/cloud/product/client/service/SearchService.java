package org.cloud.product.client.service;

import java.util.List;
import java.util.Map;

import org.cloud.product.client.model.Keyword;
import org.cloud.product.client.model.Search;
import org.cloud.product.client.service.breaker.SearchServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value="cloud-product-server",fallback=SearchServiceBreaker.class)
public interface SearchService {
	
	/**
	 * 添加
	 * @param catid
	 * @param name
	 */
	@RequestMapping(value="/product/category/search/add",method=RequestMethod.POST)
	public void add(@RequestBody Search search);
	
	/**
	 * 获取列表及以下关键字
	 * @param catid
	 * @return
	 */
	@RequestMapping(value="/product/category/search/list_keywords_catid",method=RequestMethod.GET)
	public List<Map<Search,List<Keyword>>> listKeywordsByCatid(@RequestParam(value="catid",required=true)long catid);
	
	/**
	 * 根据编号获取
	 * @param catid
	 * @return
	 */
	@RequestMapping(value="/product/category/search/get_seaid",method=RequestMethod.GET)
	public Search getBySeaid(@RequestParam(value="seaid",required=true)long seaid);
	
	/**
	 * 修改
	 * @param seaid
	 * @param name
	 */
	@RequestMapping(value="/product/category/search/upd_seaid",method=RequestMethod.PUT)
	public void updBySeaid(@RequestBody Search search);
	
	/**
	 * 删除
	 * @param seaid
	 */
	@RequestMapping(value="/product/category/search/del_seaid",method=RequestMethod.DELETE)
	public void delBySeaid(@RequestParam(value="seaid",required=true)long seaid);
}
