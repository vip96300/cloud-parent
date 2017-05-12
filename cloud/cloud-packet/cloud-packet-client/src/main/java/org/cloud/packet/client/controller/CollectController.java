package org.cloud.packet.client.controller;

import java.util.Base64;
import java.util.Map;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.packet.client.controller.dto.Result;
import org.cloud.packet.client.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/collect")
public class CollectController {
	
	@Autowired
	private CollectService collectService;
	
	@ApiOperation(value="收藏优选包")
	@ApiImplicitParams({@ApiImplicitParam(name="userid",value="用户编号",required=true,dataType="String"),
		@ApiImplicitParam(name="pacid",value="优选包编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="优选包别名",required=true,dataType="String"),
		@ApiImplicitParam(name="packetKV",value="类目编号:产品编号的json字符串",required=true,dataType="String")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Map<String,Object>> add(@RequestParam(value="userid",required=true)String userid,
			@RequestParam(value="pacid",required=true)long pacid,
			@RequestParam(value="name",required=true)String name,
			@RequestParam(value="packetKV",required=true)String packetKV){
		Map<String,Object> result=collectService.add(userid, pacid, name,Base64.getEncoder().encodeToString(packetKV.getBytes()));
		return new Result<Map<String,Object>>(200,null,result);
	}
	
	@ApiOperation(value="我的优选包")
	@ApiImplicitParams({@ApiImplicitParam(name="userid",value="用户编号",required=true,dataType="String"),
		@ApiImplicitParam(name="page",value="当前页",required=true,dataType="int"),
		@ApiImplicitParam(name="size",value="每页数",required=true,dataType="int")})
	@RequestMapping(value="/list_pacCategorys_products_userid",method=RequestMethod.POST)
	public Result<Map<String,Object>> list_pacCategorys_products_userid(@RequestParam(value="userid",required=true)String userid,
			@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size){
		Map<String,Object> map=collectService.listPacCategorysProductsByUserid(userid,page,size);
		return new Result<Map<String,Object>>(200,null,map);
	}
	
	@ApiOperation(value="删除收藏")
	@ApiImplicitParams({@ApiImplicitParam(name="colid",value="收藏编号",required=true,dataType="long")})
	@RequestMapping(value="/del_colid",method=RequestMethod.POST)
	public Result<Object> del_colid(@RequestParam(value="colid",required=true)long colid){
		collectService.delByColid(colid);
		return new Result<Object>(200,null,null);
	}
}
