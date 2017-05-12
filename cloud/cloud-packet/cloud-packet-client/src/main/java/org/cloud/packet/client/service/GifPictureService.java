package org.cloud.packet.client.service;

import java.util.List;

import org.cloud.packet.client.model.GifPicture;
import org.cloud.packet.client.service.breaker.GifPictureServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-packet-server",fallback=GifPictureServiceBreaker.class)
public interface GifPictureService {
	
	@RequestMapping(value="/packet/gift/picture/add",method=RequestMethod.POST)
	public void add(@RequestBody GifPicture gifPicture);
	
	@RequestMapping(value="/packet/gift/picture/del_picid",method=RequestMethod.DELETE)
	public void delByPicid(@RequestParam(value="picid",required=true)long picid);
	/**
	 * 根据礼物编号获取图片集合
	 * @param gifid
	 * @return
	 */
	@RequestMapping(value="/packet/gift/picture/list_gifid",method=RequestMethod.GET)
	public List<GifPicture> listByGifid(@RequestParam(value="gifid",required=true)long gifid);
}
