package org.cloud.waiter.server.service;

import java.util.List;

import org.cloud.waiter.server.model.Waiter;

public interface WaiterService {
	
	/**
	 * 添加
	 * @param waiter
	 */
	public void add(Waiter waiter);
	
	public List<Waiter> list(int page,int size);
}
