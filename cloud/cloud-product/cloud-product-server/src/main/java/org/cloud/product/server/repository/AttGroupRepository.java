package org.cloud.product.server.repository;

import java.io.Serializable;
import java.util.List;

import org.cloud.product.server.model.AttGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttGroupRepository extends JpaRepository<AttGroup, Serializable>{
	/**
	 * 根据类目编号查询属性组列表
	 * @param catId
	 * @return
	 */
	public List<AttGroup> findByCatid(long catid);
}
