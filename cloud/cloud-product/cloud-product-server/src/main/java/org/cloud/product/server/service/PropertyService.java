package org.cloud.product.server.service;

import java.util.List;
import java.util.Map;

import org.cloud.product.server.model.AttValue;
import org.cloud.product.server.model.Property;

public interface PropertyService {
	
	/**
	 * 根据产品编号获取产品属性及属性选项
	 * @param productid
	 * @return
	 */
	public Map<String,List<AttValue>> listAttValuesByProductid(long productid);
	
	/**
	 * 根据编号获取
	 * @param proid
	 * @return
	 */
	public Property getByProid(long proid);
	
	/**
	 * 修改
	 * @param property
	 */
	public void updByProid(Property property);
}
