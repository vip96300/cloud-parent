package org.cloud.user.client.controller;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.user.client.model.User;
import org.cloud.user.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="get user detail info")
	@ApiImplicitParams(value = { @ApiImplicitParam })
	@RequestMapping(path="/getById",method=RequestMethod.GET)
	public User getById(@RequestParam(value="id",required=true) String id){
		User user=userService.getById(id);
		return user;
	}
}
