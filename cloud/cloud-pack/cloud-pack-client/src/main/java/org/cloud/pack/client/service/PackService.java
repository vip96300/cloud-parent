package org.cloud.pack.client.service;

import org.cloud.pack.client.service.breaker.PackServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-pack-server",fallback=PackServiceBreaker.class)
public interface PackService {

}
