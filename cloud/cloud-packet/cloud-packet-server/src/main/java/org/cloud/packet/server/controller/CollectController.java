package org.cloud.packet.server.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.cloud.packet.server.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;


@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/collect")
public class CollectController {

	
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> add(@RequestParam(value="userid",required=true)String userid,
			@RequestParam(value="pacid",required=true)long pacid,
			@RequestParam(value="name",required=true)String name,
			@RequestParam(value="packetKV",required=true) String packetKV) throws Exception {
		Map<String,String> params=new Gson().fromJson(new String(Base64.getDecoder().decode(packetKV.getBytes())),HashMap.class);
		Map<String,Object> result=collectService.add(userid, pacid, name, params);
		return result;
	}
	
	@RequestMapping(value="/list_pacCategorys_products_userid",method=RequestMethod.GET)
	public Map<String,Object> list_pacCategorys_products_userid(@RequestParam(value="userid",required=true)String userid,
			@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size) throws Exception{
		Map<String,Object> map=collectService.listPacCategorysProductsByUserid(userid,page,size);
		return map;
	}
	
	@Async
	@RequestMapping(value="/del_colid",method=RequestMethod.DELETE)
	public void del_colid(@RequestParam(value="colid",required=true)long colid) {
		collectService.delByColid(colid);
	}
}
