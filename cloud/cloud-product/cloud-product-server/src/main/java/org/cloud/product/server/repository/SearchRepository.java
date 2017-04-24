package org.cloud.product.server.repository;

import java.io.Serializable;
import java.util.List;

import org.cloud.product.server.model.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Search, Serializable>{
	
	/**
	 * 根据类目编号获取搜索标头集合
	 * @param catid
	 * @return
	 */
	List<Search> findByCatid(long catid);
}
