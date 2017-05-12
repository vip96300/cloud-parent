package org.cloud.product.server.service;

import java.util.List;
import java.util.Map;

import org.cloud.product.server.model.AttGroup;
import org.cloud.product.server.model.Property;
import org.springframework.transaction.annotation.Transactional;

public interface AttGroupService {
	/**
	 * 根据类目编号获取属性组集合
	 * @param catid
	 * @return
	 */
	public List<AttGroup> listByCatid(long catid);
	/**
	 * 根据类目编号获取属性组和属性列表和属性值列表
	 * @param catId
	 * @return
	 */
	public List<Map<String,List<Object>>> listAttributesAttValuesByCatid(long catid);
	/**
	 * 根据产品编号获取属性组：产品属性集合
	 * @param proid
	 * @return
	 */
	public Map<String,List<Property>> listPropertysByProid(long proid);
	
	/**
	 * 添加属性组
	 * @param attGroup
	 */
	public void add(AttGroup attGroup);
	
	/**
	 * 根据属性组编号获取属性组
	 * @param groid
	 * @return
	 */
	public AttGroup getByGroid(long groid);
	
	/**
	 * 删除属性组，级联删除以下所有属性列表
	 * @param groid
	 */
	@Transactional(rollbackFor=Exception.class)
	public void delByGroid(long groid);
	
	/**
	 * 修改属性组
	 * @param attGroup
	 */
	public void updByGroid(AttGroup attGroup);
}
