package org.cloud.user.server.dao.impl;

import java.lang.reflect.ParameterizedType;

import org.cloud.user.server.dao.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl<T> implements BaseDao<T>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	public BaseDaoImpl(){
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class<T>) type.getActualTypeArguments()[0];
	}
	
	@Override
	public T getById(String id) {
		T entity=(T) this.sessionFactory.getCurrentSession().get(clazz,id);
		return entity;
	}

	@Override
	public void del(T entity) {
		this.sessionFactory.getCurrentSession().delete(entity);
	}
	
}
