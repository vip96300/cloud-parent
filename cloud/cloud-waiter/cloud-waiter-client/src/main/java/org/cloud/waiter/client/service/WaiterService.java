package org.cloud.waiter.client.service;

import org.cloud.waiter.client.service.breaker.WaiterServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-product-server",fallback=WaiterServiceBreaker.class)
public interface WaiterService {
	
}
