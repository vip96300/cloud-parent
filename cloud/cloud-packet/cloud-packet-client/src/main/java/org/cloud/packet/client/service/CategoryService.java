package org.cloud.packet.client.service;

import org.cloud.packet.client.service.breaker.CategoryServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-packet-server",fallback=CategoryServiceBreaker.class)
public interface CategoryService {

}
