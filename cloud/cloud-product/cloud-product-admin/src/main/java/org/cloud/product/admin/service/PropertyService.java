package org.cloud.product.admin.service;

import org.cloud.product.admin.service.breaker.PropertyServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-product-server",fallback=PropertyServiceBreaker.class)
public interface PropertyService {

}
