package org.cloud.user.server.service.impl;

import org.cloud.user.server.dao.UserDao;
import org.cloud.user.server.model.User;
import org.cloud.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getById(String id) {
		User user=userDao.getById(id);
		return user;
	}

}
