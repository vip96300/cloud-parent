package org.cloud.packet.server.controller;

import java.util.List;

import org.cloud.packet.server.model.Gift;
import org.cloud.packet.server.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/gift")
public class GiftController {
	
	
	@Autowired
	private GiftService giftService;
	
	/**
	 * 添加
	 * @param gift
	 */
	@Async
	@RequestMapping(value="/packet/gift/add",method=RequestMethod.POST)
	public void add(@RequestBody Gift gift) {
		giftService.add(gift);
	}
	
	/**
	 * 礼物列表
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/packet/gift/list",method=RequestMethod.GET)
	public List<Gift> list(@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size) {
		List<Gift> gifts=giftService.list(new PageRequest(page, size));
		return gifts;
	}
	
	/**
	 * 修改
	 * @param gifid
	 */
	@Async
	@RequestMapping(value="/packet/gift/upd_gifid",method=RequestMethod.PUT)
	public void upd_gifid(@RequestBody Gift gift) {
		giftService.updByGifid(gift);
	}
	
	/**
	 * 获取
	 * @param gifid
	 * @return
	 */
	@RequestMapping(value="/packet/gift/get_gifid",method=RequestMethod.GET)
	public Gift getByGifid(@RequestParam(value="gifid",required=true)long gifid) {
		Gift gift=giftService.getByGifid(gifid);
		return gift;
	}
	
	/**
	 * 删除
	 * @param gifid
	 */
	@Async
	@RequestMapping(value="/packet/gift/del_gifid",method=RequestMethod.DELETE)
	public void delByGifid(@RequestParam(value="gifid",required=true)long gifid) {
	}
}
