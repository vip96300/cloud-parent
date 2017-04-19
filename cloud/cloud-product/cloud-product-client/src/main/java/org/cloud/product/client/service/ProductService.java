package org.cloud.product.client.service;

import org.cloud.product.client.service.breaker.ProductServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="cloud-product-server",fallback=ProductServiceBreaker.class)
public interface ProductService {

}
