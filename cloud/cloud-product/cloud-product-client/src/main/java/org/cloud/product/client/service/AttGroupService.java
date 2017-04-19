package org.cloud.product.client.service;

import org.cloud.product.client.service.breaker.AttGroupServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-product-server",fallback=AttGroupServiceBreaker.class)
public interface AttGroupService {

}
