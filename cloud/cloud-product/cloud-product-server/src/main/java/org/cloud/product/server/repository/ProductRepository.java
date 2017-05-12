package org.cloud.product.server.repository;


import java.util.List;

import org.cloud.product.server.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	/**
	 * 根据类目编号获取产品列表
	 * @return
	 */
	public Page<Product> findByCatidAndIsdel(long catid,int isdel,Pageable pageable);
	
	@Query(value="select * from product_product o where o.proid in(?1) and o.isdel=?2",nativeQuery=true)
	public List<Product> findByProids(List<Long> proids,int isdel);
	
}
