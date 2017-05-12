package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.AttValue;

public interface AttValueService {
	
	/**
	 * 添加属性值
	 * @param attValue
	 */
	public void add(AttValue attValue);
	/**
	 * 根据属性编号获取属性值列表
	 * @param attid
	 * @return
	 */
	public List<AttValue> listByAttid(long attid);
	
	/**
	 * 根据编号获取属性值
	 * @param valid
	 * @return
	 */
	public AttValue getByValid(long valid);
	
	/**
	 * 根据属性值编号删除属性值
	 * @param valid
	 */
	public void delByValid(long valid);
	
	/**
	 * 根据属性值编号修改属性值
	 * @param attValue
	 */
	public void updByValid(AttValue attValue);
}
