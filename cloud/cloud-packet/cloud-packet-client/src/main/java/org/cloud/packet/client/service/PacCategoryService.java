package org.cloud.packet.client.service;

import org.cloud.packet.client.service.breaker.PacCategoryServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-packet-server",fallback=PacCategoryServiceBreaker.class)
public interface PacCategoryService {

}
