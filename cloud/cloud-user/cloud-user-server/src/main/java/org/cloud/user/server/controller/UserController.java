package org.cloud.user.server.controller;

import org.cloud.user.server.model.User;
import org.cloud.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(path="/getById")
    public User getById(@RequestParam(value="id") String id){
    	User user=userService.getById(id);
    	return user;
    }
}
