package org.cloud.product.server.repository;

import java.util.List;

import org.cloud.product.server.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	/**
	 * 根据pid获取类目列表
	 * @param pid
	 * @return
	 */
	public List<Category> findByPidAndIsdel(long pid,int isdel);
	/**
	 * 根据类目编号集合获取类目集合
	 * @param catids
	 * @return
	 */
	@Query(value="select * from product_category o where o.catid in(?1) and o.isdel=?2",nativeQuery=true)
	public List<Category> findByCatids(List<Long> catids,int isdel);
}
