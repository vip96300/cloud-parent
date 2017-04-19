package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.Brand;
import org.springframework.data.domain.Pageable;

public interface BrandService {
	/**
	 * 根据类目编号获取品牌列表
	 * @param catId
	 * @return
	 */
	public List<Brand> listByCatid(long catid,Pageable pageable);
	/**
	 * 添加品牌
	 * @param brand
	 */
	public void add(Brand brand);
}
