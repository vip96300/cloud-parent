package org.cloud.product.server.repository;

import java.util.List;

import org.cloud.product.server.model.AttGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttGroupRepository extends JpaRepository<AttGroup, Long>{
	/**
	 * 根据类目编号查询属性组列表
	 * @param catId
	 * @return
	 */
	public List<AttGroup> findByCatid(long catid);
	/**
	 * 根据产品编号获取属性组集合
	 * @param proid
	 * @return
	 */
	@Query(value="select * from product_category_attgroup o where o.catid=(select catid from product_product p where p.proid=?1)",nativeQuery=true)
	public List<AttGroup> findByProid(long proid);
	

}
