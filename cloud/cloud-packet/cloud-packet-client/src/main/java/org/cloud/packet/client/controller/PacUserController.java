package org.cloud.packet.client.controller;

import java.util.Map;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.packet.client.service.PacUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
	
	@ApiOperation(value="用户收藏优选包")
	@ApiImplicitParams({@ApiImplicitParam(name="userid",value="用户编号",required=true,dataType="String"),
		@ApiImplicitParam(name="pacid",value="优选包编号",required=true,dataType="long"),
		@ApiImplicitParam(name="packetMap",value="类目编号：产品编号",required=true,dataType="Map")})
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public void add(@RequestParam(value="userid",required=true)String userid,@RequestParam(value="pacid",required=true)long pacid,@RequestParam(value="packetMap")Map<Long,Long> packetMap){
		
	}
}
