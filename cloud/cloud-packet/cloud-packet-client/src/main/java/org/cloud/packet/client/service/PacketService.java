package org.cloud.packet.client.service;

import java.util.List;
import java.util.Map;

import org.cloud.packet.client.model.PacCategory;
import org.cloud.packet.client.model.Packet;
import org.cloud.packet.client.service.breaker.PacketServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-packet-server",fallback=PacketServiceBreaker.class)
public interface PacketService {
	
	@RequestMapping(value="/packet/packet/add",method=RequestMethod.POST)
	public void add(@RequestBody Packet packet);
	
	@RequestMapping(value="/packet/packet/get_pacid",method=RequestMethod.GET)
	public Packet getByPacid(@RequestParam(value="pacid",required=true)long pacid);
	
	@RequestMapping(value="/packet/packet/upd_pacid",method=RequestMethod.PUT)
	public void updByPacid(@RequestBody Packet packet);
	
	@RequestMapping(value="/packet/packet/del_pacid",method=RequestMethod.DELETE)
	public void delByPacid(@RequestParam(value="pacid",required=true)long pacid);
	
	@RequestMapping(value="/packet/packet/list",method=RequestMethod.GET)
	public List<Packet> list(@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size);
	
	@RequestMapping(value="/packet/packet/list_some",method=RequestMethod.GET)
	public List<Packet> listBySome();
	
	@RequestMapping(value="/packet/packet/packet_pacCategorys",method=RequestMethod.GET)
	public Map<String,List<PacCategory>> packetPacCategorys();
	/**
	 * 根据优选包编号获取优选包及类目集合及产品及产品图片效果图
	 * @return
	 */
	@RequestMapping(value="/packet/packet/packet_pacCategorys_pacid",method=RequestMethod.GET)
	public Map<String,List<PacCategory>> packetPacCategorysByPacid(@RequestParam(value="pacid",required=true)long pacid);
	/**
	 * 获取优选包列表及每个优选包固定商品总价格
	 */
	@RequestMapping(value="/packet/packet/list_objs",method=RequestMethod.GET)
	public List<Map<String,Object>> listByObjs(@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size);
	
}
