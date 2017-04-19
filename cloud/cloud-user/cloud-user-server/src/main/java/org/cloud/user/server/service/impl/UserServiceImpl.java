package org.cloud.user.server.service.impl;

import org.cloud.user.server.model.User;
import org.cloud.user.server.repository.UserRepository;
import org.cloud.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getByUseId(long useId) {
		User user=userRepository.findByUseId(useId);
		return user;
	}

}
