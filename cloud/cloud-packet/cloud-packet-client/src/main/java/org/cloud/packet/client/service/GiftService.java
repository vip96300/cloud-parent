package org.cloud.packet.client.service;

import java.util.List;

import org.cloud.packet.client.model.Gift;
import org.cloud.packet.client.service.breaker.GiftServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value="cloud-packet-server",fallback=GiftServiceBreaker.class)
public interface GiftService {
	
	/**
	 * 添加
	 * @param gift
	 */
	@RequestMapping(value="/packet/gift/add",method=RequestMethod.POST)
	public void add(@RequestBody Gift gift);
	
	/**
	 * 礼物列表
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/packet/gift/list",method=RequestMethod.GET)
	public List<Gift> list(@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size);
	
	/**
	 * 修改
	 * @param gifid
	 */
	@RequestMapping(value="/packet/gift/upd_gifid",method=RequestMethod.PUT)
	public void upd_gifid(@RequestParam(value="gifid",required=true)long gifid);
	
	/**
	 * 获取
	 * @param gifid
	 * @return
	 */
	@RequestMapping(value="/packet/gift/get_gifid",method=RequestMethod.GET)
	public Gift getByGifid(@RequestParam(value="gifid",required=true)long gifid);
	
	/**
	 * 删除
	 * @param gifid
	 */
	@RequestMapping(value="/packet/gift/del_gifid",method=RequestMethod.DELETE)
	public void delByGifid(@RequestParam(value="gifid",required=true)long gifid);
}
