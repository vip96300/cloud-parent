package org.cloud.user.server.dao;

import org.cloud.user.server.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao{

	User getById(String id);

}
