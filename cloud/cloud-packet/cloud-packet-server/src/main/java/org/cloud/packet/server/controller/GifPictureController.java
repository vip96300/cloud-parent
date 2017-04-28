package org.cloud.packet.server.controller;

import org.cloud.packet.server.model.GifPicture;
import org.cloud.packet.server.service.GifPictureService;
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
@RequestMapping(value="/packet/gift/picture")
public class GifPictureController {
	
	@Autowired
	private GifPictureService gifPictureService;
	@Async
	@RequestMapping(value="/packet/gift/picture/add",method=RequestMethod.POST)
	public void add(@RequestBody GifPicture gifPicture) {
		gifPictureService.add(gifPicture);
	}
	@Async
	@RequestMapping(value="/packet/gift/picture/del_picid",method=RequestMethod.DELETE)
	public void delByPicid(@RequestParam(value="picid",required=true)long picid) {
		gifPictureService.delByPicid(picid);
	}
}
