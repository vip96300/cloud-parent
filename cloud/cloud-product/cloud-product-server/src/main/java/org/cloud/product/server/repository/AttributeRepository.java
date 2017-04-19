package org.cloud.product.server.repository;

import java.io.Serializable;
import java.util.List;

import org.cloud.product.server.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeRepository extends JpaRepository<Attribute, Serializable>{

	/**
	 * 根据类目编号获取属性列表
	 * @param catId
	 * @return
	 */
	List<Attribute> findByCatId(long catId);
}
