package org.cloud.product.server.repository;

import java.io.Serializable;

import org.cloud.product.server.model.ProKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProKeywordRepository extends JpaRepository<ProKeyword, Serializable>{
	/**
	 * 根据搜索删除产品关键字集合
	 * @param seaid
	 */
	@Transactional
	@Modifying
	@Query(value="delete from product_category_product_keyword where seaid=?1",nativeQuery=true)
	void deleteBySeaid(long seaid);
	
	void deleteByKeywordid(long keywordid);
}
