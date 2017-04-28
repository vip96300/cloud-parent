package org.cloud.packet.client.controller;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.packet.client.controller.dto.Result;
import org.cloud.packet.client.model.Packet;
import org.cloud.packet.client.service.PacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
	
	@ApiOperation(value="添加优选包")
	@ApiImplicitParams({@ApiImplicitParam(name="name",value="优选包名称",required=true,dataType="String"),
		@ApiImplicitParam(name="depict",value="优选包描述",required=true,dataType="String")})
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public Result<Object> add(@RequestParam(value="name",required=true)String name,@RequestParam(value="depict",required=true)String depict){
		Packet packet=new Packet();
		packet.setName(name);
		packet.setDepict(depict);
		packetService.add(packet);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="根据编号删除优选包，级联删除该优选包图片列表，及该优选包下所有类目")
	@ApiImplicitParams({@ApiImplicitParam(name="pacid",value="优选包编号",required=true,dataType="long")})
	@RequestMapping(value="pacid",method=RequestMethod.GET)
	public Result<Object> del_pacid(@RequestParam(value="pacid",required=true)long pacid){
		packetService.delByPacid(pacid);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="优选包列表")
	@ApiImplicitParams({@ApiImplicitParam(name="page",value="当前页",required=true,dataType="int"),
		@ApiImplicitParam(name="size",value="每页显示数",required=true,dataType="int")})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result<List<Packet>> list(@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size){
		List<Packet> packets=packetService.list(page,size);
		return new Result<List<Packet>>(200,null,packets);
	}
}
