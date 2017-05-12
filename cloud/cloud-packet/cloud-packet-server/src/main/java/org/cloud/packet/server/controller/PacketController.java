package org.cloud.packet.server.controller;

import java.util.List;
import java.util.Map;

import org.cloud.packet.server.model.PacCategory;
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
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@RequestBody Packet packet) {
		packetService.add(packet);
	}
	
	@RequestMapping(value="/get_pacid",method=RequestMethod.GET)
	public Packet get_pacid(@RequestParam(value="pacid",required=true)long pacid){
		Packet packet=packetService.getByPacid(pacid);
		return packet;
	}
	
	@Async
	@RequestMapping(value="/upd_pacid",method=RequestMethod.PUT)
	public void upd_pacid(@RequestBody Packet packet) {
		packetService.updByPacid(packet);
	}
	
	@Async
	@RequestMapping(value="/del_pacid",method=RequestMethod.DELETE)
	public void del_pacid(@RequestParam(value="pacid",required=true)long pacid) {
		packetService.delByPacid(pacid);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Packet> list(@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size) {
		List<Packet> packets=packetService.list(new PageRequest(page, size));
		return packets;
	}
	@RequestMapping(value="/list_some",method=RequestMethod.GET)
	public List<Packet> listBySome() {
		List<Packet> packets=packetService.listBySome();
		return packets;
	}
	

	@RequestMapping(value="/packet_pacCategorys",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,List<PacCategory>> packet_pacCategorys() {
		Map<String,List<PacCategory>> packetPacCategorys=packetService.packetPacCategorys();
		return packetPacCategorys;
	}
	
	@RequestMapping(value="/packet_pacCategorys_pacid",method=RequestMethod.GET)
	public Map<String,List<PacCategory>> packet_pacCategorys_pacid(@RequestParam(value="pacid",required=true)long pacid) {
		Map<String,List<PacCategory>> packetPacCategory=packetService.packetPacCategorysByPacid(pacid);
		return packetPacCategory;
	}
	
	@RequestMapping(value="/list_objs",method=RequestMethod.GET)
	public List<Map<String,Object>> list_objs(@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size) {
		List<Map<String,Object>> map=packetService.listByObjs(page, size);
		return map;
	}
}
