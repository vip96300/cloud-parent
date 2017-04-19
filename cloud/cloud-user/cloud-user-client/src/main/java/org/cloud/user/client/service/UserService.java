package org.cloud.user.client.service;

import org.cloud.user.client.model.User;
import org.cloud.user.client.service.breaker.UserServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-user-server",fallback=UserServiceBreaker.class)
public interface UserService {
	/**
	 * 通过编号获取
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/getById")
	User getById(@RequestParam(value="id") String id);
}
