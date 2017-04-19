package org.cloud.user.server.service;

import org.cloud.user.server.model.User;

public interface UserService {
	/**
	 * 通过编号获取
	 * @param id
	 * @return
	 */
	User getByUseId(long useId);
}
