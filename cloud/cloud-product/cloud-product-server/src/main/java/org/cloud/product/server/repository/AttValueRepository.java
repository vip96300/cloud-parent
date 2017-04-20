package org.cloud.product.server.repository;

import java.io.Serializable;
import java.util.List;

import org.cloud.product.server.model.AttValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttValueRepository extends JpaRepository<AttValue, Serializable>{
	
	/**
	 * 根据类目编号获取属性值列表
	 * @param catid
	 * @return
	 */
	public List<AttValue> findByCatid(long catid);
	
	/**
	 * 根据属性编号删除属性值
	 * @param attid
	 */
	public void deleteByAttid(long attid);
	

}
