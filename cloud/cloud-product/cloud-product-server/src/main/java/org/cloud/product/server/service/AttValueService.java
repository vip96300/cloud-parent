package org.cloud.product.server.service;

import org.cloud.product.server.model.AttValue;

public interface AttValueService {
	
	/**
	 * 添加属性值
	 * @param attValue
	 */
	public void add(AttValue attValue);
	
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
