package org.cloud.user.server.repository;

import java.io.Serializable;

import org.cloud.user.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Serializable>{

	User findByUseId(long useId);

}
