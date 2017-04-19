package org.cloud.user.server.controller;

import org.cloud.user.server.model.User;
import org.cloud.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(path="/getByUseId",method=RequestMethod.GET)
    public User getByUseId(@RequestParam(value="useId") long useId){
    	User user=userService.getByUseId(useId);
    	return user;
    }
}
