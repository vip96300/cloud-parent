package org.cloud.packet.client.service;

import org.cloud.packet.client.service.breaker.GifPictureServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-packet-server",fallback=GifPictureServiceBreaker.class)
public interface GifPictureService {

}
