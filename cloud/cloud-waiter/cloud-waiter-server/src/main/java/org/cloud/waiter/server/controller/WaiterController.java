package org.cloud.waiter.server.controller;

import java.util.List;

import org.cloud.waiter.server.model.Waiter;
import org.cloud.waiter.server.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/waiter/waiter")
public class WaiterController {

	@Autowired
	private WaiterService waiterService;
	
	@Async
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@RequestBody Waiter waiter) {
		waiterService.add(waiter);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Waiter> list(@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size) {
		List<Waiter> waiters=waiterService.list(page, size);
		return waiters;
	}
}
