package org.cloud.packet.client.service;

import org.cloud.packet.client.model.Product;
import org.cloud.packet.client.service.breaker.ProductServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-packet-server",fallback=ProductServiceBreaker.class)
public interface ProductService {
	
	public Product getByProid(long proid);
}
