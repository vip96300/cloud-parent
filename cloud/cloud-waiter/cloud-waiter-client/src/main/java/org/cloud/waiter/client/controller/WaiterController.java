package org.cloud.waiter.client.controller;

import org.cloud.waiter.client.controller.dto.Result;
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
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(){
		return new Result<Object>(200,null,null);
	}
}
