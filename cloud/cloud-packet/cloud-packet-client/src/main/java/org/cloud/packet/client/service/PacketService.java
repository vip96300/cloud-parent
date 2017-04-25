package org.cloud.packet.client.service;

import java.util.List;

import org.cloud.packet.client.controller.model.Packet;
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
	
	@RequestMapping(value="/packet/packet/del_pacid",method=RequestMethod.DELETE)
	public void delByPacid(@RequestParam(value="pacid",required=true)long pacid);
	
	@RequestMapping(value="/packet/packet/list",method=RequestMethod.GET)
	public List<Packet> list(@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size);
}
