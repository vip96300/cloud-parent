package org.cloud.product.server.repository;

import java.util.List;

import org.cloud.product.server.model.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KeywordRepository extends JpaRepository<Keyword, Long>{
	
	/**
	 * 根据类目编号获取该类目下所有关键字
	 * @param catid
	 * @return
	 */
	
	@Query(value="select * from product_category_search_keyword o where o.seaid in(select seaid from product_category_search s where s.catid=?1)",nativeQuery=true)
	List<Keyword> findByCatid(long catid);
	
	List<Keyword> findBySeaid(long seaid);
}
