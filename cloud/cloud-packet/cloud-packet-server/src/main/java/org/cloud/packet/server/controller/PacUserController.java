package org.cloud.packet.server.controller;

import java.util.List;
import java.util.Map;

import org.cloud.packet.server.model.PacUser;
import org.cloud.packet.server.service.PacUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/packet/user")
public class PacUserController {

	@Autowired
	private PacUserService pacUserService;
	
	@RequestMapping(value="/list_userid",method=RequestMethod.GET)
	public List<Map<String,List<Object>>> list_userid(@RequestParam(value="userid",required=true)String userid,@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size) {
		List<Map<String,List<Object>>> pacUsers=pacUserService.listByUserid(userid,new PageRequest(page, size));
		return pacUsers;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@RequestBody List<PacUser> pacUsers) {
		pacUserService.add(pacUsers);
	}
	
	@RequestMapping(value="/del_useid",method=RequestMethod.DELETE)
	public void del_useid(@RequestParam(value="useid",required=true)long useid) {
		pacUserService.delByUseid(useid);
	}
	
	@RequestMapping(value="/upd_useid",method=RequestMethod.PUT)
	public void upd_useid(@RequestBody PacUser pacUser) {
		pacUserService.updByUseid(pacUser);
	}
}
