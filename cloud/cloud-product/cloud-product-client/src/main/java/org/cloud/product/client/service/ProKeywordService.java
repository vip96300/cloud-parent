package org.cloud.product.client.service;

import java.util.List;

import org.cloud.product.client.model.ProKeyword;
import org.cloud.product.client.service.breaker.ProKeywordServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value="cloud-product-server",fallback=ProKeywordServiceBreaker.class)
public interface ProKeywordService {

	/**
	 * 批量添加
	 * @param proKeywords
	 */
	@RequestMapping(value="/product/category/product/keyword/add",method=RequestMethod.POST)
	public void add(@RequestParam(value="proKeywords",required=true)List<ProKeyword> proKeywords);
	
	/**
	 * 根据编号批量删除
	 * @param keyid
	 */
	@RequestMapping(value="/del_keyids",method=RequestMethod.DELETE)
	public void delByKeyids(@RequestParam(value="keyids",required=true)List<Long> keyids);
}
