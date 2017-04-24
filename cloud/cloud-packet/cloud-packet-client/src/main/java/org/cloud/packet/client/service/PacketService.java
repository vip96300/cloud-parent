package org.cloud.packet.client.service;

import org.cloud.packet.client.service.breaker.PacketServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-packet-server",fallback=PacketServiceBreaker.class)
public interface PacketService {

}
