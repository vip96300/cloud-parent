package org.cloud.product.client.service;

import org.cloud.product.client.service.breaker.PropertyServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-product-server",fallback=PropertyServiceBreaker.class)
public interface PropertyService {

}
