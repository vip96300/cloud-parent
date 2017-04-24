package org.cloud.packet.client.service;

import org.cloud.packet.client.service.breaker.PacProductServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-packet-server",fallback=PacProductServiceBreaker.class)
public interface PacProductService {

}
