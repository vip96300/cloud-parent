package org.cloud.product.server.repository;

import java.io.Serializable;

import org.cloud.product.server.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Serializable>{
	
	/**
	 * 根据类目编号获取产品列表
	 * @return
	 */
	public Page<Product> findByCatid(long catid,Pageable pageable);
}
