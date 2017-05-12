package org.cloud.packet.server.controller;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.packet.server.model.PacCategory;
import org.cloud.packet.server.model.Packet;
import org.cloud.packet.server.service.PacCategoryService;
import org.cloud.packet.server.service.PacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/category")
public class PacCategoryController {
	
	
	@Autowired
	private PacCategoryService pacCategoryService;
	@Autowired
	private PacketService packetService;
	@Async
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@RequestBody PacCategory pacCategory) {
		Packet packet=packetService.getByPacid(pacCategory.getPacid());
		if(!ValidUtil.isValid(packet)){
			return;
		}
		pacCategoryService.add(pacCategory);
	}
	@Async
	@RequestMapping(value="/del_catid",method=RequestMethod.DELETE)
	public void del_catid(@RequestParam(value="catid",required=true)long catid) {
		pacCategoryService.delByCatid(catid);
	}
	
	@RequestMapping(value="/list_pacid",method=RequestMethod.GET)
	public List<PacCategory> list_pacid(@RequestParam(value="pacid",required=true)long pacid) {
		List<PacCategory> pacCategory=pacCategoryService.listByPacid(pacid);
		return pacCategory;
	}
	@RequestMapping(value="/get_categoryid",method=RequestMethod.GET)
	public PacCategory get_categoryid(@RequestParam(value="categoryid",required=true)long categoryid) {
		PacCategory pacCategory=pacCategoryService.getByCategoryid(categoryid);
		return pacCategory;
	}
	
	@RequestMapping(value="/get_catid",method=RequestMethod.GET)
	public PacCategory get_catid(@RequestParam(value="catid",required=true)long catid) {
		PacCategory pacCategory=pacCategoryService.getByCatid(catid);
		return pacCategory;
	}
	
	@Async
	@RequestMapping(value="/upd_catid",method=RequestMethod.PUT)
	public void upd_catid(@RequestBody PacCategory pacCategory) {
		pacCategoryService.updByCatid(pacCategory);
	}
}
