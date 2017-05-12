package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.Category;

public interface CategoryService {
	/**
	 * 根据pid获取类目列表
	 * @param pid
	 * @return
	 */
	public List<Category> listByPid(long pid);
	/**
	 * 根据类目编号集合获取类目集合
	 * @param catids
	 * @return
	 */
	public List<Category> listByCatids(List<Long> catids);
	
	/**
	 * 添加类目
	 * @param category
	 */
	public void add(Category category);
	
	/**
	 * 验证类目是否存在
	 * @param catid
	 * @return
	 */
	public Category getByCatid(long catid);
	
	/**
	 * 根据类目编号删除类目
	 * @param catid
	 */
	public void delByCatid(long catid);
	
	/**
	 * 修改类目
	 * @param category
	 */
	public void updByCatid(Category category);
}
