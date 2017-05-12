package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.Attribute;
import org.springframework.transaction.annotation.Transactional;

public interface AttributeService {
	/**
	 * 根据属性组编号获取属性集合
	 * @param groid
	 * @return
	 */
	public List<Attribute> listByGroid(long groid);
	/**
	 * 根据类目编号获取属性集合
	 * @param catid
	 * @return
	 */
	public List<Attribute> listByCatid(long catid);
	/**
	 * 添加属性
	 * @param attribute
	 */
	public void add(Attribute attribute);
	
	/**
	 * 根据属性编号获取属性
	 * @param attid
	 * @return
	 */
	public Attribute getByAttid(long attid);
	
	/**
	 * 修改属性
	 * @param attribute
	 */
	public void updByAttid(Attribute attribute);
	
	/**
	 * 根据编号删除属性及以下属性值和产品属性
	 * @param attid
	 */
	@Transactional(rollbackFor=Exception.class)
	public void delByAttid(long attid);
}
