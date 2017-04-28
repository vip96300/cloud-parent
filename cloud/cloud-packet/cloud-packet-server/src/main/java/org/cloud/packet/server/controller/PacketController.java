package org.cloud.packet.server.controller;

import java.util.List;

import org.cloud.packet.server.model.Packet;
import org.cloud.packet.server.service.PacketService;
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
@RequestMapping(value="/packet/packet")
public class PacketController {

	@Autowired
	private PacketService packetService;
	@Async
	@RequestMapping(value="/packet/packet/add",method=RequestMethod.POST)
	public void add(@RequestBody Packet packet) {
		packetService.add(packet);
	}
	@Async
	@RequestMapping(value="/packet/packet/del_pacid",method=RequestMethod.DELETE)
	public void del_pacid(@RequestParam(value="pacid",required=true)long pacid) {
		packetService.delByPacid(pacid);
	}
	
	@RequestMapping(value="/packet/packet/list",method=RequestMethod.GET)
	public List<Packet> list(@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size) {
		List<Packet> packets=packetService.list(new PageRequest(page, size));
		return packets;
	}
}
