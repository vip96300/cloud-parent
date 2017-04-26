package org.cloud.packet.client.service;

import java.util.List;
import java.util.Map;

import org.cloud.packet.client.model.PacUser;
import org.cloud.packet.client.model.Packet;
import org.cloud.packet.client.service.breaker.PacUserServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-packet-server",fallback=PacUserServiceBreaker.class)
public interface PacUserService {
	
	@RequestMapping(value="/packet/packet/user/list_userid",method=RequestMethod.GET)
	public List<Map<Packet,List<Object>>> listByUserid(@RequestParam(value="userid",required=true)String userid,@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size);
	
	@RequestMapping(value="/packet/packet/user/add",method=RequestMethod.POST)
	public void add(@RequestBody List<PacUser> pacUsers);
	
	@RequestMapping(value="/packet/packet/user/del_useid",method=RequestMethod.DELETE)
	public void delByUseid(@RequestParam(value="useid",required=true)long useid);
	
	@RequestMapping(value="/packet/packet/user/upd_useid",method=RequestMethod.PUT)
	public void updByUseid(@RequestBody PacUser pacUser);
}
