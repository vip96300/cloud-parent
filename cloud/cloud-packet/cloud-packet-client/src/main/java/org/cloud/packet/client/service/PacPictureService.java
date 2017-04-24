package org.cloud.packet.client.service;

import org.cloud.packet.client.service.breaker.PacPictureServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-packet-server",fallback=PacPictureServiceBreaker.class)
public interface PacPictureService {

}
