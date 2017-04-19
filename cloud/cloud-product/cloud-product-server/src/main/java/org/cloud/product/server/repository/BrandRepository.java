package org.cloud.product.server.repository;

import java.io.Serializable;
import java.util.List;

import org.cloud.product.server.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Serializable>{
	/**
	 * 根据类目编号获取品牌列表
	 * @param catId
	 * @return
	 */
	public List<Brand> findByCatId(long catId);
}
