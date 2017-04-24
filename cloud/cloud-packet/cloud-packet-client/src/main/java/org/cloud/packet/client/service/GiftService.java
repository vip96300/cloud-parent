package org.cloud.packet.client.service;

import org.cloud.packet.client.service.breaker.GiftServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;


@FeignClient(value="cloud-packet-server",fallback=GiftServiceBreaker.class)
public interface GiftService {

}
