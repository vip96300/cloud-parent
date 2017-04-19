package org.cloud.user.server.dao;

public interface BaseDao<T>{
	
	public T getById(String id);
	
	public void del(T entity);
}
