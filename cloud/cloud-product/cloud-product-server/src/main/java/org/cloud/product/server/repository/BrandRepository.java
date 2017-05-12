package org.cloud.product.server.repository;


import org.cloud.product.server.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long>{
	/**
	 * 根据编号获取
	 * @param braid
	 * @return
	 */
	public Brand findByBraid(long braid);
	/**
	 * 根据类目编号获取品牌列表
	 * @param catId
	 * @return
	 */
	public Page<Brand> findByCatid(long catid,Pageable pageable);
	
}
