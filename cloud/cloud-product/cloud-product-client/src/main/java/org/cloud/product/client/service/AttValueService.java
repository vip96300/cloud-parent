package org.cloud.product.client.service;

import org.cloud.product.client.service.breaker.AttValueServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-product-server",fallback=AttValueServiceBreaker.class)
public interface AttValueService {

}
