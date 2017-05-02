package org.cloud.user.client.controller;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.user.client.controller.dto.Result;
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
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="get user detail info")
	@ApiImplicitParams(value = { @ApiImplicitParam })
	@RequestMapping(path="/get_useId",method=RequestMethod.POST)
	public Result<Object> get_useId(@RequestParam(value="useId") long useId){
		User user=userService.getByUseId(useId);
		return new Result<Object>(200,null,user);
	}
}
