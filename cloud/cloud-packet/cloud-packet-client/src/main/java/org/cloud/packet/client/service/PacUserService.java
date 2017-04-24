package org.cloud.packet.client.service;

import org.cloud.packet.client.service.breaker.PacUserServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-packet-server",fallback=PacUserServiceBreaker.class)
public interface PacUserService {

}
