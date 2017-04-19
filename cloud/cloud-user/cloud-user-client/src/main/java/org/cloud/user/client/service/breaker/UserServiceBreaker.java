package org.cloud.user.client.service.breaker;

import org.cloud.user.client.model.User;
import org.cloud.user.client.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceBreaker implements UserService{

	@Override
	public User getByUseId(long useId) {
		System.out.println("service error");
		return null;
	}

}
