package org.cloud.packet.server.controller;

import org.cloud.packet.server.service.ColPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/collect/packet")
public class ColPacketController {

	@Autowired
	private ColPacketService colPacketService;

	@Async
	@RequestMapping(value="/upd_colid",method=RequestMethod.PUT)
	public void upd_colid(@RequestParam(value="colid",required=true)long colid,
			@RequestParam(value="catid",required=true)long catid,
			@RequestParam(value="proid",required=true)long proid){
		colPacketService.updByColid(colid, catid, proid);
	}
}
