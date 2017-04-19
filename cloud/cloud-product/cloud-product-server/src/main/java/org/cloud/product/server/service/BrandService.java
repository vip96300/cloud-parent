package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.Brand;

public interface BrandService {
	/**
	 * 根据类目编号获取品牌列表
	 * @param catId
	 * @return
	 */
	public List<Brand> listByCatId(long catId);
	/**
	 * 添加品牌
	 * @param brand
	 */
	public void add(Brand brand);
}
