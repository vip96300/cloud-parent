package org.cloud.packet.client.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.packet.client.controller.dto.Result;
import org.cloud.packet.client.model.PacUser;
import org.cloud.packet.client.service.PacUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
	
	@ApiOperation(value="我的优选包列表")
	@ApiImplicitParams({@ApiImplicitParam(name="userid",value="用户编号",required=true,dataType="String"),
		@ApiImplicitParam(name="page",value="当前页",required=true,dataType="int"),
		@ApiImplicitParam(name="size",value="每页显示数",required=true,dataType="int")})
	@RequestMapping(value="/list_userid",method=RequestMethod.GET)
	public Result<List<Map<String,List<Object>>>> list_userid(@RequestParam(value="userid",required=true)String userid,
			@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size){
		List<Map<String,List<Object>>> packets=pacUserService.listByUserid(userid,page,size);
		return new Result<List<Map<String,List<Object>>>>(200,null,packets);
	}
	
	@ApiOperation(value="用户收藏优选包")
	@ApiImplicitParams({@ApiImplicitParam(name="userid",value="用户编号",required=true,dataType="String"),
		@ApiImplicitParam(name="pacid",value="优选包编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="自定义优选包名称",required=true,dataType="String"),
		@ApiImplicitParam(name="packetMap",value="类目编号：产品编号",required=true,dataType="Map")})
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public Result<Object> add(@RequestParam(value="userid",required=true)String userid,
			@RequestParam(value="pacid",required=true)long pacid,
			@RequestParam(value="name",required=true)String name,
			@RequestBody Map<Long,Long> packetMap){
		List<PacUser> pacUsers=new ArrayList<PacUser>();
		for(Map.Entry<Long, Long> map:packetMap.entrySet()){
			PacUser pacUser=new PacUser();
			pacUser.setPacid(pacid);
			pacUser.setUserid(userid);
			pacUser.setCatid(map.getKey());
			pacUser.setProid(map.getValue());
			pacUser.setName(name);
			pacUsers.add(pacUser);
		}
		pacUserService.add(pacUsers);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="根据收藏编号删除收藏")
	@ApiImplicitParams({@ApiImplicitParam(name="useid",value="收藏编号",required=true,dataType="long")})
	@RequestMapping(value="/del_useid",method=RequestMethod.GET)
	public Result<Object> del_useid(@RequestParam(value="useid",required=true)long useid){
		pacUserService.delByUseid(useid);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="用户编辑优选包")
	@ApiImplicitParams({
		@ApiImplicitParam(name="useid",value="收藏编号",required=true,dataType="long"),
		@ApiImplicitParam(name="userid",value="用户编号",required=true,dataType="String"),
		@ApiImplicitParam(name="pacid",value="优选包编号",required=true,dataType="long"),
		@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="proid",value="产品编号",required=true,dataType="long")})
	@RequestMapping(value="/upd_useid",method=RequestMethod.GET)
	public Result<Object> upd_useid(@RequestParam(value="useid",required=true)long useid,
			@RequestParam(value="userid",required=true)String userid,
			@RequestParam(value="pacid",required=true)long pacid,
			@RequestParam(value="catid",required=true)long catid,
			@RequestParam(value="proid",required=true)long proid){
		PacUser pacUser=new PacUser();
		pacUser.setUseid(useid);
		pacUser.setUserid(userid);
		pacUser.setPacid(pacid);
		pacUser.setCatid(catid);
		pacUser.setProid(proid);
		pacUserService.updByUseid(pacUser);
		return new Result<Object>(200,null,null);
	}
}
