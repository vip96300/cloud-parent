package org.cloud.product.server.repository;

import java.util.List;

import org.cloud.product.server.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	/**
	 * 根据pid获取类目列表
	 * @param pid
	 * @return
	 */
	public List<Category> findByPid(long pid);
}
