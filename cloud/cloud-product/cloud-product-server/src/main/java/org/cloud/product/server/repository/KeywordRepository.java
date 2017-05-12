package org.cloud.product.server.repository;

import java.util.List;

import org.cloud.product.server.model.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long>{
	
	/**
	 * 根据类目编号获取该类目下所有关键字
	 * @param catid
	 * @return
	 */
	List<Keyword> findByCatid(long catid);
	
	List<Keyword> findBySeaid(long seaid);
}
