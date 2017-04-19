package org.cloud.product.server.repository;

import java.io.Serializable;

import org.cloud.product.server.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Serializable>{
	/**
	 * 根据类目编号获取品牌列表
	 * @param catId
	 * @return
	 */
	public Page<Brand> findByCatId(long catId,Pageable pageable);
}
