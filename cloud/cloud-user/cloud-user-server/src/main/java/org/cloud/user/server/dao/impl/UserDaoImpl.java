package org.cloud.user.server.dao.impl;

import org.cloud.user.server.dao.BaseDao;
import org.cloud.user.server.dao.UserDao;
import org.cloud.user.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private BaseDao<User> baseDao;
	
	@Override
	public User getById(String id) {
		User user=baseDao.getById(id);
		return user;
	}

}
