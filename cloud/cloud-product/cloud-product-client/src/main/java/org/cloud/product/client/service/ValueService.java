package org.cloud.product.client.service;

import org.cloud.product.client.service.breaker.AttributeServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-product-server")
public interface ValueService {

}
