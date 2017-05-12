package org.cloud.waiter.client.service;

import java.util.List;

import org.cloud.waiter.client.model.Waiter;
import org.cloud.waiter.client.service.breaker.WaiterServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-waiter-server",fallback=WaiterServiceBreaker.class)
public interface WaiterService {
	
	@RequestMapping(value="/waiter/waiter/add",method=RequestMethod.POST)
	public void add(@RequestBody Waiter waiter);
	
	@RequestMapping(value="/waiter/waiter/list",method=RequestMethod.GET)
	public List<Waiter> list(@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size);
}
