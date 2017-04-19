package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.Attribute;

public interface AttributeService {
	/**
	 * 根据类目编号获取
	 * @param attId
	 * @return
	 */
	public List<Attribute> listByCatId(long catId);
	/**
	 * 添加属性
	 * @param attribute
	 */
	public void add(Attribute attribute);
}
