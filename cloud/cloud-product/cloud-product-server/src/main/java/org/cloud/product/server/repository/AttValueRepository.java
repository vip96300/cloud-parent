package org.cloud.product.server.repository;

import java.util.List;

import org.cloud.product.server.model.AttValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttValueRepository extends JpaRepository<AttValue, Long>{
	
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
	
	/**
	 * 根据属性编号获取属性值
	 * @param attid
	 * @return
	 */
	public List<AttValue> findByAttid(long attid);
	/**
	 * 根据产品编号获取属性值选项集合
	 * @param proid
	 * @return
	 */
	@Query(value="select * from product_category_attribute_attvalue o where o.attid in (select attid from product_product_property p where p.productid=?1)",nativeQuery=true)
	public List<AttValue> findByProid(long proid);

}
