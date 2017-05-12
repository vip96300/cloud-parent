package org.cloud.packet.client.service;

import java.util.Map;

import org.cloud.packet.client.service.breaker.CollectServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-packet-server",fallback=CollectServiceBreaker.class)
public interface CollectService {
	
	/**
	 * 收藏优选包
	 * @param userid 用户编号
	 * @param pacid 优选包编号
	 * @param name 收藏名称
	 * @param packetKV 类目编号:产品编号
	 */
	@RequestMapping(value="/packet/collect/add",method=RequestMethod.POST)
	public Map<String,Object> add(@RequestParam(value="userid",required=true)String userid,
			@RequestParam(value="pacid",required=true)long pacid,
			@RequestParam(value="name",required=true)String name,
			@RequestParam(value="packetKV",required=true) String packetKV);
	
	/**
	 * 用户收藏的优选包集合
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/packet/collect/list_pacCategorys_products_userid",method=RequestMethod.GET)
	public Map<String,Object> listPacCategorysProductsByUserid(@RequestParam(value="userid",required=true)String userid,
			@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size);
	
	/**
	 * 根据编号删除收藏
	 * @param colid
	 * @return
	 */
	@RequestMapping(value="/packet/collect/del_colid",method=RequestMethod.DELETE)
	public void delByColid(@RequestParam(value="colid",required=true)long colid);
}
