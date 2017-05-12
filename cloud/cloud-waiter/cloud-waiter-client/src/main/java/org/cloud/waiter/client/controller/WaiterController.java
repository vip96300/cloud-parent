package org.cloud.waiter.client.controller;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.waiter.client.controller.dto.Result;
import org.cloud.waiter.client.model.Waiter;
import org.cloud.waiter.client.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/waiter/waiter")
public class WaiterController {
	
	@Autowired
	private WaiterService waiterService;
	
	@ApiOperation(value="添加申请")
	@ApiImplicitParams({@ApiImplicitParam(name="userid",value="用户编号",required=true,dataType="String"),
		@ApiImplicitParam(name="username",value="用户名",required=true,dataType="String"),
		@ApiImplicitParam(name="telephone",value="手机号",required=true,dataType="String")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(@RequestParam(value="userid",required=true)String userid,
			@RequestParam(value="username",required=true)String username,
			@RequestParam(value="telephone",required=true)String telephone){
		Waiter waiter=new Waiter();
		waiter.setUserid(userid);
		waiter.setUsername(username);
		waiter.setTelephone(telephone);
		System.out.println(username);
		waiterService.add(waiter);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="获取申请列表")
	@ApiImplicitParams({@ApiImplicitParam(name="page",value="当前页",required=true,dataType="int"),
		@ApiImplicitParam(name="size",value="每页数",required=true,dataType="int")})
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Result<List<Waiter>> list(@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size){
		List<Waiter> waters=waiterService.list(page,size);
		return new Result<List<Waiter>>(200,null,waters);
	}
}
