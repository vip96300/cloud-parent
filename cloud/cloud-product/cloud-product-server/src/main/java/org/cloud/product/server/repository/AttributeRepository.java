package org.cloud.product.server.repository;

import java.util.List;

import org.cloud.product.server.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AttributeRepository extends JpaRepository<Attribute, Long>{

	/**
	 * 根据类目编号获取属性列表
	 * @param catId
	 * @return
	 */
	List<Attribute> findByCatid(long catid);
	
	/**
	 * 根据属性组编号获取属性集合
	 * @param groid
	 * @return
	 */
	List<Attribute> findByGroid(long groid);
	
	/**
	 * 根据属性组编号删除该属性组下所有属性
	 * @param groid
	 */
	@Transactional
	@Modifying
	@Query(value="delete from product_category_attribute where attid in(select attid from product_category_attribute where groid=?1)",nativeQuery=true)
	void deleteByGroid(long groid);
}
